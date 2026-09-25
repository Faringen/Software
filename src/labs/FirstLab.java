package labs;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Logger;

import static java.lang.System.*;

public class FirstLab {
    static String[] programs = {"notepad.exe", "calc.exe"};
    static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        for(String program : programs){
            try {
                System.out.println("=== Process Control: " + program + " ===");

                ProcessBuilder pb = new ProcessBuilder(program);
                Process process = pb.start();
                System.out.println("Process working");

                System.out.println("==== Process info ====");
                System.out.println("Process ID: " + process.pid());
                System.out.println("Status: " + (process.isAlive() ? "Working": "Execute"));
                System.out.println("=======================");

                while (true){
                    System.out.println("Execute process? (y/N): ");
                    String ans = in.nextLine().trim().toLowerCase();

                    if(ans.equals("y")){
                        process.destroyForcibly();
                        System.out.println("Process " + program + "successful executed");
                    }
                    else{
                        System.out.println("Process continues to run. You can closed him manually.");
                       break;
                    }
                }
            } catch (IOException e) {
                System.out.println("error: " + e.getMessage());

            }
        }
    }
}
