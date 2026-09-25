package labs.LabWork2;

public class AnimalThread extends Thread {

    private final String animalName;
    private int moveCount = 0;

    public int getMoveCount() {
        return moveCount;
    }

    public static volatile boolean winnerDeclared = false;

    public AnimalThread(String name, int priority) {
        this.animalName = name;
        this.setName(name);
        this.setPriority(priority);
    }

    @Override
    public void run() {
        System.out.println("Поток " + animalName + " запущен");
        while (moveCount < 1000) {
            moveCount += 10;
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
                return;
            }
        }
        synchronized (AnimalThread.class){
            if (!winnerDeclared) {
                winnerDeclared = true;
                System.out.println("\n🏆 " + animalName + " ПОБЕДИЛ в первом забеге!");
            }
        }
    }
}
