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
    
    int nodeCount = 0;
    int selectedNode = 0;
    int selectedConnect = 0;
    String fileName;
    Scanner scan = new Scanner(System.in);
    int[] arrOfConnects;
    int[] arrFromList;
    
    NodeConnections nCons;
    ReadFile rFile;
    
    public NodeDegrees(String file) {
        fileName = file;
    }
    
    private void solve() {
        // No file provided, CLI interaction
        if (fileName == "NULL") {
            // No file provided, interactive terminal
            cliInput();
        } else {
            // File Input
            System.out.println("Reading from file:");
            rFile = new ReadFile(fileName);
            
            // Grabs an int[], index 0 is number of nodes
            arrFromList = rFile.get();
            
            // Prints out array contents for testing
            int arrLen = arrFromList.length;
            for (int x = 0; x < arrLen; x++) {
                System.out.println("From arrFromList " + arrFromList[x]);
            }
        }
    }
    
    private void fileInput() {
        
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
        System.out.print("\n------****------\n");
        System.out.println("Node count: " + nodeCount);
        
        for (int x = 0, label = 0; x < nodeCount; x++) {
            label = x + 1;
            System.out.println("Node " + label + " has a degree of " + nCons.count(x, nodeCount));
        }
    }
}