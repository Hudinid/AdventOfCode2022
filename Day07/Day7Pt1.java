package Day07;

import java.util.*;
import java.io.*;

public class Day7Pt1 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        
    static int n = 23; //lines
    // static ArrayList<Directory> otherDirectories = new ArrayList<>();
    // static HashMap<String, Long> fileAndSize = new HashMap<>();
    // static Directory main = new Directory("main", otherDirectories, fileAndSize);
    static ArrayList<Directory> directoryTravel = new ArrayList<>();
    static ArrayList<Long> sums = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        

        boolean done = false;
        String[] line = br.readLine().split(" ");
        while(!done) {
            
            
            if(line[1].equals("cd")) {
                line = cdCommand(line);
            }
            else if (line[1].equals("ls")) {
                line = listCommand(line);
            }

            // for(int i = 0; i < line.length; i ++) {
            //     System.out.println(line[i]);
            // }

            if(!line[0].equals("$")) {
                System.out.println("done: " + line[0]);
                done = true;
            }

        }
        
        long ret = 0;
        
        long sum1 = directoryTravel.get(0).getSum();
        
        long allAdded = 0;
        Collections.sort(sums);

        for(int i = 0; i < sums.size(); i ++) {
            if(sums.get(i) < 100000) { 
                ret += sums.get(i);
            }
        }
        for(int i = 0; i < sums.size(); i ++) {
            allAdded += sums.get(i);
        }


        pw.println(ret);
        pw.close();
    }

    public void commandCheck(String[] line) throws IOException {
        
    }

    public static String[] listCommand(String[] line) throws IOException {
        line = br.readLine().split(" ");
        Directory prevDirectory = new Directory("temp");
        if(directoryTravel.size() >= 2) {
            prevDirectory = directoryTravel.get(directoryTravel.size()-2);
        }
        Directory currentDirectory = directoryTravel.get(directoryTravel.size()-1);

        while(!line[0].equals("$") && !line[0].equals("")) {
            
            if(line[0].equals("dir")) {
                currentDirectory.addDirectory(line[1]);
            }
            else {
                currentDirectory.addFile(Long.parseLong(line[0]), line[1]);
            }

            line = br.readLine().split(" ");
        }

        if(!prevDirectory.name.equals("temp")) {
            prevDirectory.setDirectory(currentDirectory);
        }

        

        // System.out.println("HIT");
        return line;
    }

    public static String[] cdCommand(String[] line) throws IOException {
        if(line[2].equals("..")) {
            // System.out.println("subbed 1"); 
            // printPath();
            directoryTravel.remove(directoryTravel.size()-1);
        }
        else {
            directoryTravel.add(new Directory(line[2]));
            // System.out.println("Added Directory: " + line[2]);
        }

        // printPath();
        line = br.readLine().split(" ");
        // System.out.print("Returned Line: ");

        // for(int i = 0; i < line.length; i ++) {
        //     System.out.print(line[i] + " |");
        // }


        return line;
    }

    
    public static void printPath() {
        String path = "";
        for(int i = 0; i < directoryTravel.size(); i ++) {
            path += directoryTravel.get(i).name + " / ";
        }
        System.out.println("Path: " + path);
    }
}


class Directory {
    String name; 
    ArrayList<Directory> otherDirectories = new ArrayList<>();
    HashMap<String, Long> fileAndSize = new HashMap<>();

    public Directory(String name) {
        this.name = name;
    }

    public Directory(String name, ArrayList<Directory> otherDirectories, HashMap<String, Long> fileAndSize) {
        this.name = name;
        this.otherDirectories = otherDirectories;
        this.fileAndSize = fileAndSize;
    }

    public long getSum() {
        long sum = 0;
        for(int i =0; i < otherDirectories.size(); i ++) {
            sum += otherDirectories.get(i).getSum();
        }

        for(String key : fileAndSize.keySet()) {
            sum += fileAndSize.get(key);
        }

        Day7Pt1.sums.add(sum);
        return sum; 
    }

    public void addDirectory(String newDirectory) {
        
        this.otherDirectories.add(new Directory(newDirectory));
    }

    public void addFile(long size, String fileName) {
        this.fileAndSize.put(fileName, size);
    }

    public void setDirectory(Directory newDirectory) {
        
        for(int i = 0; i < otherDirectories.size(); i ++) {
            if(otherDirectories.get(i).name.equals(newDirectory.name)) {
                otherDirectories.set(i, newDirectory);
            }
        }

        
    }
}
