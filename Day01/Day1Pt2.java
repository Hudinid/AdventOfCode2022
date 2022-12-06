package Day01;
import java.io.*;
import java.util.*;
public class Day1Pt2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        ArrayList<Long> numbers = new ArrayList<>();
        
        long tempSum = 0;
        
        for(int i = 0; i < 2243; i ++) { //2243 lines
            String line = br.readLine();
            if(line.equals("")) {
                numbers.add(tempSum);
                tempSum = 0;
            }
            else { 
                tempSum += Long.parseLong(line);
            }
        }
        numbers.add(tempSum);
        Collections.sort(numbers);
        // pw.println(numbers.get(numbers.size()-1));
        // pw.println(numbers.get(numbers.size()-2));
        // pw.println(numbers.get(numbers.size()-3));

        pw.println(numbers.get(numbers.size()-1) + numbers.get(numbers.size()-2) + numbers.get(numbers.size()-3));
        pw.close(); 
    }
}
