import java.io.*;
import java.util.*;

public class Day11Pt2 {
    
    static ArrayList<Monkey> monkeys = new ArrayList<Monkey>();
    static long worryLevel = 0;

    static long LCM;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw  = new PrintWriter(new OutputStreamWriter(System.out));
        int n = 8; // numMonkeys

        ArrayList<Long> forLCM = new ArrayList<>();
        
        for(int i = 0; i < n; i ++) { //making monkeys
            
            ArrayList<Long> passedList = new ArrayList<>();
            String multiplier = "";
            int operator = 0;
            int divisor = 0;

            int monkeyFalseCase = 0;
            int monkeyTrueCase = 0;
            for(int j = 0 ; j < 6; j ++) {
                if(j == 0){
                    br.readLine();
                    continue;
                }

                if(j == 1) {
                    String line = br.readLine();
                    line = line.replace(" ", "");
                    line = line.replace("Startingitems:", "");
                    String[] numsForList = line.split(",");

                    for(int k = 0; k < numsForList.length; k ++) {
                        passedList.add(Long.parseLong(numsForList[k]));
                    }

                }   

                if(j == 2) {
                    String line = br.readLine();
                    line = line.replace("  Operation: ", "");
                    String[] changedLine = line.split(" ");
                    multiplier = changedLine[4];
                    
                    String search = changedLine[3];

                    if(search.equals("+")) {
                        operator = 1;
                    }
                    else if (search.equals("*")){
                        operator = 3;
                    }
                    
                }

                if(j == 3) {
                    String[] line = br.readLine().split(" ");
                    divisor = Integer.parseInt(line[5]);
                    forLCM.add(Long.parseLong(line[5]));

                }

                if(j == 4) {
                    String[] line = br.readLine().split(" ");
                    monkeyTrueCase = Integer.parseInt(line[9]);
                }

                if(j == 5) {
                    String[] line = br.readLine().split(" ");
                    monkeyFalseCase = Integer.parseInt(line[9]);
                }
            }
            br.readLine();

            monkeys.add(new Monkey(passedList, operator, multiplier, divisor, monkeyFalseCase, monkeyTrueCase));
        }




        System.out.println("------");
        LCM = lcm(forLCM);
        System.out.println(LCM);

        // see monkey info

        // printInfo();

        for(int i = 1; i < 10001; i ++) {
            for(int j = 0; j < monkeys.size(); j ++) {
                Monkey.monkeyRound(monkeys.get(j));
                // System.out.println("----------");
            }

            // if(i % 20 == 0 & i == 20) {
            //     System.out.println("Round: " + (i - 0));
            //     for(int j = 0; j < monkeys.size(); j ++) {
            //         System.out.println(monkeys.get(j).numItemsInspected);
            //     }
            //     System.out.println("------");
            // }
            // if(i%1000 == 0) {
            //     System.out.println("Round: " + (i - 0));
            //     for(int j = 0; j < monkeys.size(); j ++) {
            //         System.out.println(monkeys.get(j).numItemsInspected);
            //     }
            //     System.out.println("-----");
            // }
            
        }




        for(int i = 0; i < monkeys.size(); i ++) {
            System.out.println(monkeys.get(i).numItemsInspected);
        }




    }

    public static void printInfo() {
        for(int i = 0 ; i < monkeys.size(); i++) {
            System.out.println("Monkey Number: " + i);
            System.out.print("Items: ");
            for(int j = 0; j < monkeys.get(i).items.size(); j ++) {
                System.out.print(" " + monkeys.get(i).items.get(j));
            }
            System.out.println();
            System.out.println("Operation = " + monkeys.get(i).operator + " " + " Multiplier: " + monkeys.get(i).multiplier);
            System.out.println("Divisor: " + monkeys.get(i).divisor);
            System.out.println("True case, throw to: " + monkeys.get(i).monkeyTrueCase);
            System.out.println("False Case, throw to: " + monkeys.get(i).monkeyFalseCase);
            System.out.println("------");
        }
    }

    private static long gcd(long a, long b) {
        while (b > 0)
        {
            long temp = b;
            b = a % b; 
            
            a = temp;
        }
        return a;
    }

    private static long lcm(long a, long b) {
        return a * (b / gcd(a, b));
    }

    private static long lcm(ArrayList<Long> input) {
        long result = input.get(0);

        for(int i = 1; i < input.size(); i++) result = lcm(result, input.get(i));

        return result;
    }

    static class Monkey {
        int numItemsInspected = 0;

        ArrayList<Long> items = new ArrayList<Long>();

        int operator = 0; // 1 = add, 2 = sub, 3 = multiply, 4 = divide

        String multiplier = "";
        int divisor = 0;

        int monkeyFalseCase = 0;
        int monkeyTrueCase = 0;

        public Monkey(ArrayList<Long> items, int operator, String multipler, int divisor, int monkeyFalseCase, int monkeyTrueCase) {
            this.items = items;
            this.operator = operator;
            this.multiplier = multipler;
            this.divisor = divisor;
            this.monkeyFalseCase = monkeyFalseCase;
            this.monkeyTrueCase = monkeyTrueCase;

        }

        public static void monkeyRound(Monkey monkey) {
            for(int i = 0; i < monkey.items.size(); i ++) {
                
                monkey.numItemsInspected++;

                worryLevel = monkey.items.remove(0);
                i--;
                
                

                if(monkey.operator == 1) {
                    if(monkey.multiplier.equals("old")) {
                        
                        worryLevel += worryLevel;
                    }
                    else {
                        worryLevel += Long.parseLong(monkey.multiplier);
                    }
                }
                else if(monkey.operator == 3) {
                    if(monkey.multiplier.equals("old")) {
                        worryLevel *= worryLevel;
                    }
                    else {
                        worryLevel *= Long.parseLong(monkey.multiplier);
                    }
                }
                
                worryLevel = worryLevel % LCM;

                
                if(worryLevel % monkey.divisor == 0) {    
                    monkeys.get(monkey.monkeyTrueCase).items.add(worryLevel);
                }
                else {
                    monkeys.get(monkey.monkeyFalseCase).items.add(worryLevel);
                }

            }
        }
    }
}
