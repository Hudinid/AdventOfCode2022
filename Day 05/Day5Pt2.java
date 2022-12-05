package Day5;
import java.io.*;
import java.util.*;

public class Day5Pt2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        // ArrayList<ArrayList<Character>> allLists = new ArrayList<>();

        ArrayList<String>[] allLists = new ArrayList[9];

        for(int i = 0 ; i < 9; i ++) {
            ArrayList<String> arrayList = new ArrayList<>();
            allLists[i] = arrayList;
        }

        //reading stupid input
        for(int i = 0; i < 8; i ++) { // will be 8 in og run, 3 for testing 
            String readLine = br.readLine();
            readLine += " ";
            
            for(int j = 1; j < readLine.length() + 1; j ++) {
                
                if(j%4 == 0 && j != 0) {
                    String phrase = readLine.substring(j-4, j);
                    // System.out.println(phrase);
                    phrase = phrase.replace("[", "");
                    phrase = phrase.replace("]", "");
                    phrase = phrase.replace(" ", "");
                    if(!phrase.equals("")) {
                        allLists[j/4 - 1].add(phrase);
                    }
                }
                
            }
        }

        br.readLine();
        br.readLine();

        // String[] line = br.readLine().split(" ");
/*
    [D]    
[N] [C]    
[Z] [M] [P]
 1   2   3 

move 1 from 2 to 1
move 3 from 1 to 3
move 2 from 2 to 1
move 1 from 1 to 2
 */        
      
 
        
        for(int i = 0; i < 502; i ++) { // 4 for testing, 502 for real
            
            String[] inputStuff = br.readLine().split(" ");
            int amountMoved = Integer.parseInt(inputStuff[1]);
            int location1 = Integer.parseInt(inputStuff[3]) - 1;
            int location2 = Integer.parseInt(inputStuff[5]) - 1;

            int limit = Math.min(amountMoved, allLists[location1].size());

            for(int j = 0; j < limit; j ++) { 
                String movedChar = allLists[location1].remove(limit - j - 1); //allLists[location1].size()-1
                allLists[location2].add(0, movedChar);
            }

            // for(int j = 0; j < 9; j ++) {
            //     System.out.print(j + ": ");
            //     for(int k = 0; k < allLists[j].size(); k++) {
            //         System.out.print(   allLists[j].get(k));
            //     }
            //     System.out.println();
            // }
            // System.out.println("-----------");
            
        }

        for(int i = 0; i < 9; i ++) {
            if(allLists[i].size() > 0) {
                System.out.print(allLists[i].get(0));
            }
        }


        // String[] line = br.readLine().split(" ");
        // for(int i = 0; i < 9; i ++) {
        //     for(int j = 0; j < allLists[i].size(); j ++) {
        //         System.out.println(i + ": " + allLists[i].get(j));
        //     }
        // }
        // for(int i = 0; i < 9; i ++) {
        //     for(int j = 0; j < 1; j ++) {
        //         System.out.println(i + ": " + allLists[i].get(j));
        //     }
        // }
    }
}
