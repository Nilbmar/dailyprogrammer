/*	Anthony Bryant
 *  Date: May 09, 2016
 *  Purpose: Count the edges coming from nodes
 *  in an undirected graph
 *
 *  /r/dailyprogrammer - easy challenge
 *  https://www.reddit.com/r/dailyprogrammer/comments/4ijtrt/20160509_challenge_266_easy_basic_graph/
 *  
 *  What is an undirected graph: 
 *  http://mathinsight.org/definition/undirected_graph
*/

import java.util.Scanner;

public class NodeDegrees {
    
    boolean cont = true;
    int nodeCount = 0;
    int selectedNode = 0;
    int selectedConnect = 0;
    String fileName;
    Scanner scan = new Scanner(System.in);
    int[] arrOfConnects;
    int[] arrFromList;
    //String[] arrFromList;
    
    NodeConnections nCons;
    ReadFile rFile;
    
    public NodeDegrees(String file) {
        fileName = file;
    }
    
    private Boolean solve() {
        // No file provided, CLI interaction
        if (fileName == "NULL") {
            // No file provided, interactive terminal
            cliInput();
        } else {
            // File Input
            fileInput();
        }
        
        return cont;
    }
    
    private void fileInput() {
        rFile = new ReadFile(fileName);
            
        // Grabs an int[]
        arrFromList = rFile.getInt();
        //arrFromList = rFile.getString();
        
        // index 0 is the node count
        setNodeCount(arrFromList[0]);
        
        nCons = new NodeConnections(nodeCount);
        
        int listSize = arrFromList.length;
        // Start at 1 to skip 0 index used for nodeCount
        // Skip every other int because its the second in a pair
        for (int x = 1; x < listSize; x = x + 2) {
            selectedNode = arrFromList[x];
            selectedConnect = arrFromList[x + 1];
            
            if (selectedNode <= nodeCount && selectedConnect <= nodeCount) {
                nCons.add(selectedNode, selectedConnect);
            } else {
                System.out.println("Nodes must be within the set amount. Check input file.");
                x = listSize;
                cont = false;
            }
            
        }
        
        
    }
    
    private void cliInput() {
        setNodeCount();
        nCons = new NodeConnections(nodeCount);
    
    
        while (getNodePairs() > 0) {
            if (selectedNode <= nodeCount && selectedConnect <= nodeCount) {
                nCons.add(selectedNode, selectedConnect);
            } else {
                selectedNode = 0;
                selectedConnect = 0;
                System.out.println("Nodes must be within the set amount.");
            }
        }
    }
    
    private void setNodeCount() {
        System.out.print("How many nodes are there?  ");
        nodeCount = scan.nextInt();
        
        if (nodeCount > 0) {
            arrOfConnects = new int[nodeCount];
        } else {
            System.out.println("There must be more than zero nodes.");
            setNodeCount();
        }
    }
    
    private void setNodeCount(int i) {
        nodeCount = i;
        
        if (nodeCount > 0) {
            arrOfConnects = new int[nodeCount];
        } else {
            System.out.println("There must be more than zero nodes. Check first line of input file.");
        }
    }
    
    private int getNodePairs() {
        System.out.print("\nFirst node (-1 to cancel): ");
        selectedNode = scan.nextInt();
        
        if (selectedNode < 0) {
            System.out.println("Exiting node pair entry.");
            
            // setting to defaults before exiting
            selectedNode = 0;
            selectedConnect = 0;
            return -1;
            
        } else {
            System.out.print("Connects to: ");
            selectedConnect = scan.nextInt();
            
            if (selectedConnect < 0) {
                System.out.println("Exiting node pair entry.");
                selectedNode = 0;
                selectedConnect = 0;
                return -1;
            }
        }
        
        return selectedNode;
    }
    
        public void printAnswer() {
        
        solve();
        
        if (cont == true) {
            System.out.print("\n------****------\n");
            System.out.println("Node count: " + nodeCount);
            
            for (int x = 0, label = 0; x < nodeCount; x++) {
                label = x + 1;
                System.out.println("Node " + label + " has a degree of " + nCons.count(x, nodeCount));
            }
        } else {
            System.out.print("\n------ An Error Has Occurred ------\n");
        }
    }
}