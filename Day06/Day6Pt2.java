package Day06;
import java.io.*;
import java.util.*;
public class Day6Pt2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        String line = br.readLine();

        
        for(int i = 0; i < line.length()-14; i ++) {
            String checkedLine = line.substring(i, i+14);
            // System.out.println(checkedLine);
            HashMap<Character, Integer> map = new HashMap<>();
            for(int j = 0; j < checkedLine.length(); j ++) {
                if(map.containsKey(checkedLine.charAt(j))) {
                    // System.out.println(checkedLine.charAt(j));
                    break;
                }
                else {
                    map.put(checkedLine.charAt(j), 1);
                }
            }

            if(map.size() == 14) {
                pw.println(i+14);
                break;
            }

        }

        pw.close();
    }
}
