/*  Anthony Bryant
 *  Dec. 5, 2015
 *  Class to run all projects with same compile/run command
 */

public class RunProject {
    public static void main(String[] args) {
        
        String fileName;
        NodeDegrees answer;
        
        try {
            // Set text file for argument given
            fileName = args[0];
            
        } catch(Exception e) {
            // If no filename given, will continue as normal
            fileName = "NULL";
        }
        
        // Counting time it takes to execute
        // this is beginning time
        //long time = System.nanoTime();
        
        // Replace these two lines to swap problem being solved
        
        answer = new NodeDegrees(fileName);
        answer.printAnswer();  
        
        
        
        // Countng time it takes to execute
        // Print time elapsed
        /*
		time = System.nanoTime() - time;		 
        System.out.println("Time: " + time);
        System.out.println("In Scientific Notation: " + (time/1.0e9));
        */
    }
}

