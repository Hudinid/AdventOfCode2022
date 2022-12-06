package Day04;

import java.io.*;
import java.util.*;

public class Day4Pt1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        long count = 0;
        for(int i = 0; i < 1000; i ++) {
            String line = br.readLine();
            String[] pair = line.split(",");

            int elf1Start = Integer.parseInt(pair[0].substring(0,pair[0].indexOf("-")));
            int elf1End = Integer.parseInt(pair[0].substring(pair[0].indexOf("-") + 1));

            // System.out.println(elf1Start);
            // System.out.println(elf1End);
            
            int elf2Start = Integer.parseInt(pair[1].substring(0,pair[1].indexOf("-")));
            int elf2End = Integer.parseInt(pair[1].substring(pair[1].indexOf("-") + 1));

            
            if(elf1Start <= elf2Start && elf1End >= elf2End) {
                count ++;
            }
            else if(elf2Start <= elf1Start && elf2End >= elf1End) {
                count ++;
            }

        }

        pw.println(count);
        pw.close();
    }
}
