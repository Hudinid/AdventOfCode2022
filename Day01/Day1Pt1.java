package Day01;
import java.io.*;
import java.util.*;
public class Day1Pt1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        long max = 0;
        
        long tempSum = 0;
        
        for(int i = 0; i < 2243; i ++) { //2243 lines
            String line = br.readLine();
            if(line.equals("")) {
                max = Math.max(max, tempSum);
                tempSum = 0;
            }
            else { 
                tempSum += Long.parseLong(line);
            }
        }

        pw.println(max);
        pw.close(); 
    }
}
