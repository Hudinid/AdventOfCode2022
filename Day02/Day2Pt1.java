package Day02;
import java.io.*;
import java.util.*;
public class Day2Pt1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        long totalScore = 0;

        for(int i = 0; i < 2500; i ++) {
            String[] inputs = br.readLine().split(" ");

            // a = 1, rock // x
            // b = paper, 2 // y
            // c = scissors, 3 // z
            if(inputs[0].equals("A") && inputs[1].equals("Y")) { // rock and paper
                totalScore += 8;
                // continue;
            }
            else if(inputs[0].equals("A") && inputs[1].equals("Z")) { // rock and scissors
                totalScore += 3;
                // continue;
            }
            else if(inputs[0].equals("A")){ // rock and rock
                totalScore += 4;
                // continue;
            }

            if(inputs[0].equals("B") && inputs[1].equals("Y")) { //paper and paper
                totalScore += 5;
                // continue;

            }
            else if(inputs[0].equals("B") && inputs[1].equals("X")) { // paper and rock
                totalScore += 1;
                // continue;

            }
            else if( inputs[0].equals("B" )){ // paper and scissors
                totalScore += 9;
                // continue;

            }

            if(inputs[0].equals("C") && inputs[1].equals("X")) { // scissors and rock
                totalScore += 7;
                // continue;

            }
            else if (inputs[0].equals("C") && inputs[1].equals("Y")) { // scissors and paper
                totalScore += 2;
                // continue;

            }
            else if(inputs[0].equals("C")){ // scissors and scissors 
                totalScore += 6;
                // continue;
            }

        }
        pw.println(totalScore);
        pw.close();
    }
}
