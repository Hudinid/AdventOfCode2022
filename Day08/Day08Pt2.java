package Day08;

import java.io.*;
import java.util.*;
class Day08Pt2 {
    static ArrayList<ArrayList<Integer>> trees = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        int n = 99; //num Lines ; 5 for test, 99 fr

        /*
3037
2551
6533
3354
         */

        for(int i = 0; i < n ; i ++) {
            String[] line = br.readLine().split(""); 

            ArrayList<Integer> listInput = new ArrayList<>();

            for(int j = 0; j < line.length; j ++) {
                listInput.add(Integer.parseInt(line[j]));
            }

            trees.add(listInput);
        }
        System.out.println("---");
        // System.out.println(trees.size());
        long ret = 0;

        // isVisible(2,2);
        // System.out.println("HI: " + trees.get(0).size());
        for(int row = 0; row < trees.size(); row ++) {

            for(int col = 0; col < trees.get(row).size(); col ++) {
                if(numVisible(row, col) > ret) {
                    // System.out.println("R AND C: " + row + " " + col);
                    ret = Math.max(numVisible(row, col), ret);
                    // System.out.println("RET: " + ret);
                }
                // System.out.println("Row: " + row);
                // System.out.println("Col: " + col);
                // System.out.println("---");
            }
            
        }

        pw.println(ret);
        pw.close();
    }

    public static long numVisible(int row, int col) {
        
        if(row == 0 || row == trees.size()-1) {
            // System.out.println("HIT HERE");
            return 0;
        }
        if(col == 0 || col == trees.get(row).size()-1) {
            // System.out.println("HIT HERE 2");
            
            return 0;
        }
        

        int currDigit = trees.get(row).get(col);
        // System.out.println("-----");
        // System.out.println("Checking Row: " + row);
        // System.out.println("Checking Col: " + col);
        // System.out.println("Checking: " + currDigit);
        
        
        int seenLeft = 0;
        
            for(int i = col-1; i >= 0; i --) {
                // System.out.println("L: " + getInt(row, i));
                
                if(getInt(row, i) < currDigit) {
                    seenLeft++;
                }
                else {
                    seenLeft++;

                    break;
                }
            }   
        
        // System.out.println();
        //check right
        int seenRight = 0;
        
            for(int i = col+1; i < trees.get(row).size(); i ++) {
                // System.out.println("R: " + getInt(row, i));
                if(getInt(row, i) < currDigit) {
                    seenRight++;
                }
                else {
                    seenRight++;

                    break;
                }
            }
        
        
        // System.out.println();
        //check above
        int seenAbove = 0;

        
            for(int i = row - 1; i >= 0; i --) {
                // System.out.println("A: " + getInt(i, col) + " ");
                if(getInt(i, col) < currDigit) {
                    seenAbove++;
                }
                else {
                    seenAbove++;

                    break;
                }
            
            }
        

        // System.out.println();
        //check below
        int seenBelow = 0;
        
            for(int i = row+1; i < trees.size(); i ++) {
                // System.out.println("B: " + getInt(i, col));
                if(getInt(i, col) < currDigit) {
                    seenBelow++;
                }
                else {
                    seenBelow++;

                    break;
                }
            }
        
        
        return seenBelow*seenAbove*seenLeft*seenRight;

        
    }


    public static int getInt(int row, int col) {
        return trees.get(row).get(col);
    }

}