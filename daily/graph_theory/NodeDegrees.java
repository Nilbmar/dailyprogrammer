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
    
    static int nodeCount = 0;
    static int selectedNode = 0;
    static int selectedConnect = 0;
    static Scanner scan = new Scanner(System.in);
    static int[] arrOfConnects;
    
    static NodeConnections nCons;
    
    private static void solve() {
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
    
    private static void setNodeCount() {
        System.out.print("How many nodes are there?  ");
        nodeCount = scan.nextInt();
        arrOfConnects = new int[nodeCount];
    }
    
    private static int getNodePairs() {
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
        }
        
        return selectedNode;
    }
    
        public static void printAnswer() {
        
        solve();
        System.out.print("\n------****------\n");
        System.out.println("Node count: " + nodeCount);
        
        for (int x = 0, label = 0; x < nodeCount; x++) {
            label = x + 1;
            System.out.println("Node " + label + " has a degree of " + nCons.count(x, nodeCount));
        }
    }
}