package AdventOfCode2022.Day3;


import java.io.*;
import java.util.*;

public class Day3pt1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        ArrayList<Character> sameChars = new ArrayList<>();

        for(int i = 0; i < 300; i ++) {
            String itemStuff = br.readLine();

            String firstHalf = itemStuff.substring(0, itemStuff.length() / 2);
            String secondHalf = itemStuff.substring(itemStuff.length() / 2);

            ArrayList<Character> alrAdded = new ArrayList<>();
            for(int j = 0; j < firstHalf.length(); j ++) {
                if(secondHalf.contains(firstHalf.substring(j, j+1))) {
                    if(!alrAdded.contains(firstHalf.charAt(j))) {
                        sameChars.add(firstHalf.charAt(j));
                        alrAdded.add(firstHalf.charAt(j));
                    }
                }
            }

            //aabbcc
        }
        long sum = 0;
        for(int i = 0; i < sameChars.size(); i ++) {
            Character currentChar = sameChars.get(i);
            // System.out.println(currentChar);

            
            if(Character.isLowerCase(currentChar)) {
                sum += (int)(currentChar) - 96;
            }
            else {
                sum += (int)(currentChar) - 64 + 26;
            }
        }

        pw.println(sum);
        pw.close();
    }
}
