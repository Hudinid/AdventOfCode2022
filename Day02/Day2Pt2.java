package Day02;
import java.io.*;
import java.util.*;
public class Day2Pt2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        long totalScore = 0;

        for(int i = 0; i < 2500; i ++) {
            String[] inputs = br.readLine().split(" ");

            // a = rock 1// x = lose 
            // b = paper 2 // y = draw
            // c = scissors 3 // z = win

            //rocks
            if(inputs[0].equals("A") && inputs[1].equals("Y")) {
                totalScore += 4; // rock + draw , 1 + 3
            }
            else if(inputs[0].equals("A") && inputs[1].equals("Z")) { 
                totalScore += 8; // win + paper = 2 + 6 = 8
            }
            else if(inputs[0].equals("A")){ // rock and rock
                totalScore += 3; // draw = 0 + 3 = 3
            }

            if(inputs[0].equals("B") && inputs[1].equals("Y")) {
                totalScore += 5; // draw = paper + 3 = 5

            }
            else if(inputs[0].equals("B") && inputs[1].equals("X")) { 
                totalScore += 1; // rock + lose  = 1

            }
            else if( inputs[0].equals("B" )){ 
                totalScore += 9; // scissors + win = 3 + 6 = 9

            }

            if(inputs[0].equals("C") && inputs[1].equals("X")) { 
                totalScore += 2; // paper + lose = 2 + 0 = 2
                // continue;

            }
            else if (inputs[0].equals("C") && inputs[1].equals("Y")) { 
                totalScore += 6; // scissors + draw  = 3 + 3 = 6
                // continue;

            }
            else if(inputs[0].equals("C")){ 
                totalScore += 7; // rock + win = 1 + 6 = 7
                // continue;
            }

        }
        pw.println(totalScore);
        pw.close();
    }
}
