package labs.LabWork2;

public class AnimalThread extends Thread {

    private final String animalName;
    private int distance = 0;

    // Статический флаг, чтобы определить, кто победил первым в первой части задания
    public static volatile boolean winnerDeclared = false;

    public AnimalThread(String name, int priority) {
        this.animalName = name;
        this.setName(name);
        this.setPriority(priority);
    }

    public int getDistance() {
        return distance;
    }

    public String getAnimalName() {
        return animalName;
    }

    @Override
    public void run() {
        while (distance < 1000) {
            distance += 10;
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                System.out.println(animalName + " был прерван!");
                return;
            }
        }

        synchronized (AnimalThread.class) {
            if (!winnerDeclared) {
                winnerDeclared = true;
                System.out.println(animalName + " ПОБЕДИЛ в первом забеге!");
            }
        }
    }
}