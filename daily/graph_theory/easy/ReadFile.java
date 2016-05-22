

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {
 
    char type;
    String file;
    List<Object> listOfNodes = new ArrayList<Object>();
    File input = null;
    Scanner scan = null;
    
    public ReadFile(String f) {
        file = f;
    }
    
    
    // Used in read(), makes sure theres something to add()
    private Boolean hasNext() {
        boolean t = false;
        
        // Checking for int
        if (type == 'i') {
            t = scan.hasNextInt();
        } 
        // Checking for string
        else if (type == 's') {
            t = scan.hasNextLine();
        }
        
        return t;
    }
    
    // Used in read(), adds content from file
    private void addNext() {
        
        // Adding an int to list
        if (type == 'i') {
            listOfNodes.add(scan.nextInt());
        } 
        // Adding a string to list
        else if (type == 's') {
            listOfNodes.add(scan.nextLine());
        }
    }
    
    // Sets a file, checks that it exists
    // Checks that it has content to add
    // Adds content to list to be converted to array
    private void read() {
        try {
            // Set up and check for file existence
            input = new File(file);
            if (input.exists()) {
                scan = new Scanner(input);
               
               // Uses helper functions above for Factory Method
                while(hasNext()) {
                    addNext();
                }   
            }
        } catch(Exception e) {
            System.out.println("Exception Handled: " + e);    
        } finally {
           
        }
    }
    
    public int[] getInt() {
        System.out.println("Reading file: " + file);
        
        type = 'i';
        read();
        
        // Convert List<Object> to int[]
        int arrSize = listOfNodes.size();
        int[] array = new int[arrSize];
        for (int x = 0; x < array.length; x++) {
            array[x] = Integer.parseInt(listOfNodes.get(x).toString());
        }
        
        return array;
    }
    
    public String[] getString() {
        System.out.println("Reading file: " + file);
        
        type = 's';
        read();
        
        // Convert List<Object> to String[]
        int arrSize = listOfNodes.size();
        String[] array = new String[arrSize];
        for (int x = 0; x < array.length; x++) {
            array[x] = listOfNodes.get(x).toString();
        }
        
        return array;
    }
    

}