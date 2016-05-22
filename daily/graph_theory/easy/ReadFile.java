

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {
 
    char type;
    String file;
    List<Object> arrOfNodes = new ArrayList<Object>();
    File input = null;
    Scanner scan = null;
    
    public ReadFile(String f) {
        file = f;
    }
    
    
    // Used in read(), makes sure theres something to add()
    private Boolean hasNext() {
        boolean t = false;
        if (type == 'i') {
            t = scan.hasNextInt();
        } else if (type == 's') {
            t = scan.hasNextLine();
        }
        
        return t;
    }
    
    // Used in read(), adds content from file
    private void add() {
        // returning an int[]
        if (type == 'i') {
            arrOfNodes.add(scan.nextInt());
        } 
        // returning a String[]
        else if (type == 's') {
            arrOfNodes.add(scan.nextLine());
        }
    }
    
    // Sets a file, checks that it exists
    // Checks that it has content to add
    // Adds content to list to be converted to array
    private void read() {
        try {
            input = new File(file);
            if (input.exists()) {
                scan = new Scanner(input);
               
               // Uses helper functions above for Factory Method
                while(hasNext()) {
                    add();
                }   
            }
        } catch(Exception e) {
            System.out.println("Exception Handled: " + e);    
        } finally {
           
        }
    }
    
    public int[] getInt() {
        type = 'i';
        System.out.println("Reading file: " + file);
        read();
        
        // Convert List<Object> to int[]
        int arrSize = arrOfNodes.size();
        int[] array = new int[arrSize];
        for (int x = 0; x < array.length; x++) {
            array[x] = Integer.parseInt(arrOfNodes.get(x).toString());
        }
        
        return array;
    }
    
    public String[] getString() {
        type = 's';
        System.out.println("Reading file: " + file);
        read();
        
        // Convert List<Object> to String[]
        int arrSize = arrOfNodes.size();
        String[] array = new String[arrSize];
        for (int x = 0; x < array.length; x++) {
            array[x] = arrOfNodes.get(x).toString();
        }
        
        return array;
    }
    

}