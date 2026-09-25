package labs.LabWork2;

public class RabbitAndTurtle {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== Обычные догонялки ===");

        // Кролик быстрый (высокий приоритет), Черепаха медленная (низкий приоритет)
        AnimalThread rabbit = new AnimalThread("Кролик", Thread.MAX_PRIORITY);
        AnimalThread turtle = new AnimalThread("Черепаха", Thread.MIN_PRIORITY);

        rabbit.start();
        turtle.start();
        rabbit.join();
        turtle.join();

        rabbit.interrupt();
        turtle.interrupt();

        System.out.println("Потоки с более высоким приоритетом (Thread.MAX_PRIORITY) получают " +
                "больше процессорного времени от квантователя ОС, поэтому Кролик побеждает " +
                "в абсолютном большинстве случаев.");


        System.out.println("\n=== Динамическое изменение приоритетов ===");

        AnimalThread.winnerDeclared = false;

        AnimalThread fastRabbit = new AnimalThread("Кролик", Thread.MAX_PRIORITY);
        AnimalThread slowTurtle = new AnimalThread("Черепаха", Thread.MIN_PRIORITY);

        fastRabbit.start();
        slowTurtle.start();

        while (fastRabbit.isAlive() && slowTurtle.isAlive()) {
            int rabbitDist = fastRabbit.getMoveCount();
            int turtleDist = slowTurtle.getMoveCount();

            System.out.printf("Промежуточный итог -> Кролик: %d м (Приоритет: %d) | Черепаха: %d м (Приоритет: %d)%n",
                    rabbitDist, fastRabbit.getPriority(), turtleDist, slowTurtle.getPriority());

            if (rabbitDist - turtleDist > 100) {
                if (slowTurtle.getPriority() != Thread.MAX_PRIORITY) {
                    System.out.println(" Черепаха сильно отстает! Включаем турбо-приоритет для Черепахи и замедляем Кролика.");
                    slowTurtle.setPriority(Thread.MAX_PRIORITY);
                    fastRabbit.setPriority(Thread.MIN_PRIORITY);
                }
            }
            else if (turtleDist > rabbitDist) {
                if (fastRabbit.getPriority() != Thread.MAX_PRIORITY) {
                    System.out.println("⚡ Черепаха вырвалась вперед! Кролик включает максимальную скорость.");
                    fastRabbit.setPriority(Thread.MAX_PRIORITY);
                    slowTurtle.setPriority(Thread.MIN_PRIORITY);
                }
            }

            Thread.sleep(15);
        }

        fastRabbit.join();
        slowTurtle.join();
        System.out.println("Гонка с динамическими приоритетами успешно завершена!");

        fastRabbit.interrupt();
        slowTurtle.interrupt();
    }
}