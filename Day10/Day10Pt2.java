package Day10;
import java.io.*;
import java.util.*;

public class Day10Pt2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw  = new PrintWriter(new OutputStreamWriter(System.out));

        int n = 139; // num of Lines;

        int cyclesCompleted = 1;
        int value = 1;
        ArrayList<Integer> numbers = new ArrayList<>();
        int modCheck = 20;

        String[] printedGrid = new String[240];
        
        int modifier = 0;
        for(int i = 0; i < n; i ++) {
            String[] line = br.readLine().split(" "); 
            
            
            // System.out.println();
            // System.out.println("------");
            // System.out.println("CurrCycle Diff: " + Math.abs((cyclesCompleted-1) - value));
            // System.out.println("Pixel Spot:" + (cyclesCompleted-1));
            // System.out.println("CurrValue: " + value);

            if(line[0].equals("noop")) {
                // if(cyclesCompleted % modCheck == 0) {
                //     numbers.add(value * cyclesCompleted);
                //     modCheck += 40;
                // }
                if(cyclesCompleted%40 == 0) {
                    modifier += 40;
                }
                if(Math.abs((cyclesCompleted-1) - value - modifier) < 2) {
                    printedGrid[cyclesCompleted-1] = "#";
                }
                else {
                    printedGrid[cyclesCompleted-1] = ".";
                }
                cyclesCompleted ++;
                continue;
            }

            int numAdded = Integer.parseInt(line[1]);
            for(int j = 0; j < 2; j ++) {
                // if(cyclesCompleted % modCheck == 0) {
                //     // System.out.println("CurrMod: " + modCheck + " | " + "" + value * cyclesCompleted);
                //     numbers.add(value * cyclesCompleted);
                    // modCheck += 40;
                // }
                if(cyclesCompleted%40 == 0) {
                    modifier += 40;
                }
                if(Math.abs((cyclesCompleted-1) - value - modifier) < 2) {
                    printedGrid[cyclesCompleted-1] = "#";
                }
                else {
                    printedGrid[cyclesCompleted-1] = ".";
                }

                cyclesCompleted++;
            }

            value += numAdded;
            
        }
        
        for(int i = 0; i < printedGrid.length; i ++) {
            if(i % 40 == 0 && i != 0) {
                System.out.println();
            }
            System.out.print(printedGrid[i]);
        }
        // int sum = 0;
        // for(int i = 0; i < numbers.size(); i ++) {
        //     System.out.println(numbers.get(i));
        //     sum += numbers.get(i);
        // }

        // pw.println(sum);
        pw.close();
    }
}
