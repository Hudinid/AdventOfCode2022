package Day10;
import java.io.*;
import java.util.*;

public class Day10Pt1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw  = new PrintWriter(new OutputStreamWriter(System.out));

        int n = 139; // num of Lines;

        int cyclesCompleted = 1;
        int value = 1;
        ArrayList<Integer> numbers = new ArrayList<>();
        int modCheck = 20;

        for(int i = 0; i < n; i ++) {

            String[] line = br.readLine().split(" "); 

            // System.out.println("Curr Cycle: " + cyclesCompleted +  "| Value: " + value);
            // System.out.println("----");            
            // System.out.println(cyclesCompleted);
            // System.out.println(modCheck);
            // System.out.println(cyclesCompleted%modCheck);
            if(line[0].equals("noop")) {
                if(cyclesCompleted % modCheck == 0) {
                    numbers.add(value * cyclesCompleted);
                    modCheck += 40;
                }
                cyclesCompleted ++;
                continue;
            }

            int numAdded = Integer.parseInt(line[1]);
            for(int j = 0; j < 2; j ++) {
                if(cyclesCompleted % modCheck == 0) {
                    // System.out.println("CurrMod: " + modCheck + " | " + "" + value * cyclesCompleted);
                    numbers.add(value * cyclesCompleted);
                    modCheck += 40;
                }
                
                cyclesCompleted++;
            }

            value += numAdded;
            
        }
        int sum = 0;
        for(int i = 0; i < numbers.size(); i ++) {
            System.out.println(numbers.get(i));
            sum += numbers.get(i);
        }

        pw.println(sum);
        pw.close();
    }
}
