/*	Anthony Bryant
 * 	May 11, 2016
 *  
 *  Contains connection data between nodes
 *  in an undirected graph
 */
 

public class NodeConnections {
 
 int node1 = 0;
 int node2 = 0;
 int[][] arrOfConnections;
 int[][] sortedConnections;
 
 public NodeConnections(int nodeCount) {
     arrOfConnections = new int[nodeCount][nodeCount];
 }
 
 public void add(int n1, int n2) {
    int duped = checkDupes(n1, n2);

    if (duped == 0) {
        arrOfConnections[n1 - 1][n2 - 1] = 1;
        arrOfConnections[n2 - 1][n1 - 1] = 1;
    }
 }
 
 public int count(int n, int nodeCount) {
     int accum = 0;
     
     for (int x = 0; x < nodeCount; x++) {
         accum = accum + arrOfConnections[n][x];
     }
     
     return accum;
 }
 
 private int checkDupes(int n1, int n2) {
     int duped = 0;
     
     duped = arrOfConnections[n1 - 1][n2 - 1];

    // return existence either 
    return duped;
 }
}