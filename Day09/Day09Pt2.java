
import java.io.*;
import java.util.*;
public class Day9Pt2 {
    static int headX = 0;
    static int headY = 0;
    static int tailX = 0;
    static int tailY = 0;

    static ArrayList<Coordinate> visitedCoords = new ArrayList<>();
    static ArrayList<Coordinate> tailParts = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        int n = 2000; //num Lines ; 8 for test, 2000 fr

        Coordinate head = new Coordinate(0, 0);
        Coordinate tail = new Coordinate(0, 0);
        Coordinate start = new Coordinate(0, 0);

        tailParts.add(head);
        for(int i = 0; i < 9; i ++) {
            tailParts.add(new Coordinate(0, 0));
        }
        
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

R 5
U 8
L 8
D 3
R 17
D 10
L 25
U 20
 */
        for(int i = 0 ; i < n; i ++) {
            String[] line = br.readLine().split(" ");
            String dir = line[0];
            int numMove = Integer.parseInt(line[1]);

            for(int j = 0; j < numMove; j ++) {

                
                
                
                if(dir.equals("R")) { // move x + 1
                    tailParts.get(0).moveCoord(tailParts.get(0).x+1, tailParts.get(0).y);
                    for(int k = 1; k < 10; k ++) {
                        // System.out.println(tailParts.get(k).checkInRange(tailParts.get(k-1)));

                        if(!tailParts.get(k).checkInRange(tailParts.get(k-1))) {
                            tailParts.get(k).moveCoordOtherCoord(tailParts.get(k-1));
                        }
                    }
                    Coordinate.addToList(new Coordinate(tailParts.get(9).x, tailParts.get(9).y));
                }

                else if(dir.equals("D")) { // move y - 1
                    tailParts.get(0).moveCoord(tailParts.get(0).x, tailParts.get(0).y - 1);
                    for(int k = 1; k < 10; k ++) {
                        if(!tailParts.get(k).checkInRange(tailParts.get(k-1))) {
                            tailParts.get(k).moveCoordOtherCoord(tailParts.get(k-1));
                        }
                    }
                    Coordinate.addToList(new Coordinate(tailParts.get(9).x, tailParts.get(9).y));
                }

                else if(dir.equals("U")) { // move y + 1
                    tailParts.get(0).moveCoord(tailParts.get(0).x, tailParts.get(0).y + 1);
                    for(int k = 1; k < 10; k ++) {
                        if(!tailParts.get(k).checkInRange(tailParts.get(k-1))) {
                            tailParts.get(k).moveCoordOtherCoord(tailParts.get(k-1));
                        }
                    }
                    Coordinate.addToList(new Coordinate(tailParts.get(9).x, tailParts.get(9).y));
                }

                else if(dir.equals("L")) { // move x - 1
                    tailParts.get(0).moveCoord(tailParts.get(0).x - 1, tailParts.get(0).y);
                    for(int k = 1; k < 10; k ++) {
                        if(!tailParts.get(k).checkInRange(tailParts.get(k-1))) {
                            tailParts.get(k).moveCoordOtherCoord(tailParts.get(k-1));
                        }
                    }
                    Coordinate.addToList(new Coordinate(tailParts.get(9).x, tailParts.get(9).y));
                }

                
            }
            // for(int k = 0; k < 10; k ++) {
            //     System.out.println("Tail #: " + k + " | CoordX: " + tailParts.get(k).x + " | CoordY: " + tailParts.get(k).y);

            // }
            // Coordinate.printGrid();
                // System.out.println("-------");
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
        
        public void moveCoordOtherCoord(Coordinate otherCoord) {
            if(this.x == otherCoord.x && this.y < otherCoord.y) {
                moveCoord(this.x, this.y+1);
            }
            else if(this.x == otherCoord.x && this.y > otherCoord.y) {
                moveCoord(this.x, this.y-1);
            }
            else if(this.x > otherCoord.x && this.y == otherCoord.y) {
                moveCoord(this.x-1, this.y);
            }
            else if(this.x < otherCoord.x && this.y == otherCoord.y) {
                moveCoord(this.x+1, this.y);
            }
            else if(this.x < otherCoord.x && this.y < otherCoord.y) {
                moveCoord(this.x+1, this.y+1);
            }
            else if(this.x < otherCoord.x && this.y > otherCoord.y) {
                moveCoord(this.x+1, this.y-1);
            }
            else if (this.x > otherCoord.x && this.y < otherCoord.y) {
                moveCoord(this.x - 1, this.y + 1);
            }
            else if(this.x > otherCoord.x && this.y > otherCoord.y) {
                moveCoord(this.x - 1, this.y - 1);
            }
            else moveCoord(otherCoord.prevX, otherCoord.prevY);
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

        public static void printGrid() {
            String[][] grid = new String[40][40];
            for(int i = 0; i < 40; i ++) {

                for(int j = 0; j  < 40; j ++) {
                    grid[i][j] = ".";
                }
                
            }
            for(int i = 0; i < tailParts.size(); i ++) {
                Coordinate coord = tailParts.get(i);
                grid[coord.y+15][coord.x+15] = "#";
            }

            
            for(int i = 0; i < 40; i ++) {

                for(int j = 0; j  < 40; j ++) {
                    System.out.print(grid[i][j]);
                }
                System.out.println();
            }
            
        }
    }
}
