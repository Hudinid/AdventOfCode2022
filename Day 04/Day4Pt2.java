package AdventOfCode2022.Day4;

import java.io.*;
import java.util.*;

public class Day4Pt2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        long count = 0;
        for(int i = 0; i < 1000; i ++) {
            String line = br.readLine();
            String[] pair = line.split(",");

            int elf1Start = Integer.parseInt(pair[0].substring(0,pair[0].indexOf("-")));
            int elf1End = Integer.parseInt(pair[0].substring(pair[0].indexOf("-") + 1));

            
            
            int elf2Start = Integer.parseInt(pair[1].substring(0,pair[1].indexOf("-")));
            int elf2End = Integer.parseInt(pair[1].substring(pair[1].indexOf("-") + 1));

            
            
            count += numInRange(elf1Start, elf1End, elf2Start, elf2End);
            
        }

        pw.println(count);
        pw.close();
    }

    public static long numInRange(int elf1Start, int elf1End, int elf2Start, int elf2End) {
        if(elf2End < elf1Start) return 0;
        if(elf1End < elf2Start) return 0;
        return 1;
        // if(elf1Start <= elf2Start && elf1End <= elf2End) {
        //     return elf1End-elf2Start + 1;
        // }
        // else if (elf1Start <= elf2Start && elf1End >= elf2End) {
        //     return elf2End - elf2Start  +1;
        // }

        // else if (elf1Start >= elf2Start && elf1End <= elf2End) {
        //     return elf1End - elf1Start + 1;
        // }


        
        // return 0;
     }
}
