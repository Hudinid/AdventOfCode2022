
import java.io.*;
import java.util.*;

public class Day9Pt1 {
    static int headX = 0;
    static int headY = 0;
    static int tailX = 0;
    static int tailY = 0;

    static ArrayList<Coordinate> visitedCoords = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        int n = 2000; //num Lines ; 8 for test, 2000 fr

        Coordinate head = new Coordinate(0, 0);
        Coordinate tail = new Coordinate(0, 0);
        Coordinate start = new Coordinate(0, 0);

        visitedCoords.add(start);
/*
R 4
U 4
L 3
D 1
R 4
D 1
L 5
R 2

 */
        for(int i = 0 ; i < n; i ++) {
            String[] line = br.readLine().split(" ");
            String dir = line[0];
            int numMove = Integer.parseInt(line[1]);

            for(int j = 0; j < numMove; j ++) {
                // System.out.println("HeadX: " + head.x);
                // System.out.println("HeadY: " + head.y);
                // System.out.println("TailX: " + tail.x);
                // System.out.println("TailY: " + tail.y);
                // System.out.println(tail.checkInRange(head));
                // System.out.println("---------");
                if(dir.equals("R")) { // move x + 1
                    head.moveCoord(head.x+1, head.y);
                    if(!tail.checkInRange(head)) {
                        tail.moveCoord(head.prevX, head.prevY);
                        Coordinate.addToList(new Coordinate(tail.x, tail.y));
                    }
                }
                else if(dir.equals("D")) { // move y - 1
                    head.moveCoord(head.x, head.y-1);
                    if(!tail.checkInRange(head)) {
                        tail.moveCoord(head.prevX, head.prevY);
                        Coordinate.addToList(new Coordinate(tail.x, tail.y));
                    }
                }
                else if(dir.equals("U")) { // move y + 1
                    head.moveCoord(head.x, head.y+1);

                    if(!tail.checkInRange(head)) {
                        tail.moveCoord(head.prevX, head.prevY);
                        Coordinate.addToList(new Coordinate(tail.x, tail.y));
                    }
                }
                else if(dir.equals("L")) { // move x - 1
                    head.moveCoord(head.x-1, head.y);
                    if(!tail.checkInRange(head)) {
                        tail.moveCoord(head.prevX, head.prevY);
                        Coordinate.addToList(new Coordinate(tail.x, tail.y));
                    }
                }
            }
        }
        
        // for(int i = 0; i < visitedCoords.size(); i ++) {
        //     Coordinate x = visitedCoords.get(i);
        //     System.out.println("XCoord: " + x.x);
        //     System.out.println("YCoord: " + x.y);
        //     System.out.println("--------");
        // }
        pw.println(visitedCoords.size());


        pw.close();

    }


    static class Coordinate {
        int x;
        int y;
        int prevX;
        int prevY;
        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
            this.prevX = 0;
            this.prevY = 0;
        }

        public boolean equals(Coordinate comparedCoord) {
            return this.x == comparedCoord.x && this.y == comparedCoord.y;
        }
        
        public boolean checkInRange(Coordinate otherCoord) {
            // if(this.x == otherCoord.x && Math.abs(otherCoord.y-this.y) == 1) { // just one apart on y plane
            //     return true;
            // }

            // if(this.y == otherCoord.y && Math.abs(otherCoord.x-this.x) == 1) { // one apart on x plane
            //     return true;
            // }
            if(Math.abs(this.x - otherCoord.x) <= 1 && Math.abs(otherCoord.y - this.y) <= 1) {
                return true;
            }

            return false;
        }

        public void moveCoord(int x, int y) {
            this.prevX = this.x;
            this.prevY = this.y;
            this.x = x; 
            this.y = y;
        }

        public static void addToList(Coordinate x) {
            for(int i = 0; i < visitedCoords.size(); i ++) {
                Coordinate check = visitedCoords.get(i);
                if(check.equals(x)) {
                    return;
                }
            }
            visitedCoords.add(x);
        }
    }
}
