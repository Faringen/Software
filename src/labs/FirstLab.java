package labs;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Logger;

public class FirstLab {
    private final static Logger log = Logger.getLogger(FirstLab.class.getName());
    static String[] programs = {"notepad.exe", "calc.exe"};
    static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        for(String program : programs){
            try {
                log.info("=== Process Control: " + program + " ===");

                ProcessBuilder pb = new ProcessBuilder(program);
                Process process = pb.start();
                log.fine("Process working");

                log.info("==== Process info ====");
                log.info("Process ID: " + process.pid());
                log.info("Status: " + (process.isAlive() ? "Working": "Execute"));
                log.info("=======================");

                while (true){
                    log.info("Execute process? (y/N): ");
                    String ans = in.nextLine().trim().toLowerCase();

                    if(ans.equals("y")){
                        process.destroy();
                        log.fine("Process " + program + "successful executed");
                    }
                    else{
                       log.fine("Process continues to run. You can closed him manually.");
                       break;
                    }
                }
            } catch (IOException e) {
                log.info("error: " + e.getMessage());

            }
        }
    }
}
