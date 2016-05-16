

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {
 
 
    String file;
    List<Integer> arrOfNodes = new ArrayList<Integer>();
    File input = null;
    Scanner scan = null;
    
    public ReadFile(String f) {
        file = f;
    }
    
    private void read() {
        try {
            input = new File(file);
            if (input.exists()) {
                scan = new Scanner(input);
               
                while(scan.hasNextInt()) {
                    arrOfNodes.add(scan.nextInt());
                }   
            }
        } catch(Exception e) {
            System.out.println("Exception Handled: " + e);    
        } finally {
           
        }
    }
    
    public int[] get() {
        
        System.out.println("Reading file: " + file);
        read();
        
        // Convert List<Intger> to int[]
        int arrSize = arrOfNodes.size();
        int[] array = new int[arrSize];
        for (int x = 0; x < array.length; x++) {
            array[x] = arrOfNodes.get(x).intValue();
        }
        
        return array;
    }
}