package labs;

public class ChickenOrEgg {

    private static final Object lock = new Object();
    private static boolean isChickenTurn = true;
    private static String lastWord = "Спор не начался";

    static void main()  {
        int integration = 10;
        Thread chicken = new Thread(() ->{
            for (int i = 0; i < integration; i++) {
                synchronized (lock){
                    while (!isChickenTurn){
                        try {
                            lock.wait(10);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.println("Chicken");
                    lastWord = "Chicken";

                    isChickenTurn = false;
                    lock.notify();
                }
            }
        });

        Thread egg = new Thread(()->{
            for (int i = 0; i < integration; i++) {
                synchronized (lock){
                    try {
                        lock.wait(10);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    System.out.println("Egg");
                    lastWord = "egg";

                    isChickenTurn = true;
                    lock.notify();
                }
            }
        });

        chicken.start();
        egg.start();

        try {
            chicken.join();
            egg.join();
        }catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Last Word " + lastWord );
    }
}
