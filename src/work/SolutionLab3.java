package work;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SolutionLab3 {
    static void main(String[] args) {
        String file = "/home/faringen/IdeaProjects/Software/src/resource/numbersForSolutionLab3.txt";
        List<Integer> numList = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null){
                if(!line.trim().isEmpty()) numList.add(Integer.parseInt(line));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        int min37 = Integer.MAX_VALUE;
        int max73 = Integer.MIN_VALUE;

        for (int num : numList){
            if(num % 37 == 0) min37 = Math.min(min37, num);
            if(num % 73 == 0) max73 = Math.max(max73, num);
        }
        int lowerBound = Math.min(min37, max73);
        int upperBound = Math.max(min37, max73);

        int count = 0;
        int minSum = Integer.MAX_VALUE;

        for (int i = 0; i < numList.size() - 1; i++) {
            int a = numList.get(i);
            int b = numList.get(i + 1);

            boolean aInRange = a > lowerBound && a < upperBound;
            boolean bInRange = b > lowerBound && b < upperBound;

            if (aInRange ^ bInRange) {
                count++;
                int currentSum = a + b;
                if (currentSum < minSum) {
                    minSum = currentSum;
                }
            }
        }
        System.out.println(count + " " + minSum);
    }
}
