package AdventOfCode2022.Day3;


import java.io.*;
import java.util.*;

public class Day3Pt2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        ArrayList<Character> sameChars = new ArrayList<>();

        for(int i = 0; i < 100; i ++) {
            String itemStuff = br.readLine();
            String itemStuff2 = br.readLine();
            String itemStuff3 = br.readLine();
            
            ArrayList<Character> alrAdded = new ArrayList<>();
            
            for(int j = 0; j < itemStuff.length(); j ++) {
                if(itemStuff2.contains(itemStuff.substring(j, j + 1)) && itemStuff3.contains(itemStuff.substring(j, j+1))) {
                    if(!alrAdded.contains(itemStuff.charAt(j))){
                        sameChars.add(itemStuff.charAt(j));
                        alrAdded.add(itemStuff.charAt(j));
                    }
                }
            }

            
        }
        long sum = 0;
        for(int i = 0; i < sameChars.size(); i ++) {
            Character currentChar = sameChars.get(i);
            
            
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
