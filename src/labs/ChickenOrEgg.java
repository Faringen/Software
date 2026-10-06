package labs;

public class ChickenOrEgg {
    private static String endWord = "";

    static void main() throws InterruptedException {
        Thread chicken = new Thread(() ->{
            for (int i = 0; i < 5; i++) {
                System.out.println("Курица");
                endWord = "Курица";
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread egg = new Thread(() ->{
            for (int i = 0; i < 5; i++) {
                System.out.println("Яйцо");
                endWord = "Яйцо";
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        System.out.println("Что было раньше: курица или яйцо?");

        chicken.start();
        egg.start();

        chicken.join();
        egg.join();

        System.out.println("Остановка процессов.");
        System.out.println();
        System.out.println("Процесс chicken живой? " + chicken.isAlive());
        System.out.println("Процесс egg живой? " + egg.isAlive());
        System.out.println("Итог спора: " + endWord);

    }
}
