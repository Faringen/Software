import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MaxProduct {
    public static void main(String[] args) {
        String fileName = "D:\\Code\\IDEA Project\\Software\\src\\resource\\numbers.txt";

        int n = 1000;
        int[] arr = new int[n];

        try (Scanner scanner = new Scanner(new File(fileName))) {
            for (int i = 0; i < n; i++) {
                if (scanner.hasNextInt()) {
                    arr[i] = scanner.nextInt();
                } else {
                    System.err.println("Предупреждение: В файле меньше 1000 чисел!");
                    break;
                }
            }

            long maxR = -1;

            for (int i = 0; i < n; i++) {
                for (int j = i+1; j < n; j++) {
                    long result = (long) arr[i] * arr[j];
                    if(result % 14 == 0 && result > maxR){
                        maxR = result;
                    }

                }
            }

            System.out.println(maxR);

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}