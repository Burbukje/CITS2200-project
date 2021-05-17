// Full Name (StudentNum)
import java.util.*;
//import java.util.Graph;

public class MyProject implements Project {

        

    public boolean allDevicesConnected(int[][] adjlist) {
        // TODO
        //Return: boolean indicating whether all of the devices in the network are connected to the network
        ////startVertex = 0;
        //run DFS;
        //graph represented as an array of linked lists
        // 2 pointers: front and rear node
        //list[i].addFirst(j; ?????
        //O(N)
        //a 2d array of 2 elements, start vertex and end vertex
      

        int n = adjlist.length;
       
        ArrayList<ArrayList<Integer>> transpose = new ArrayList<>(n);

        boolean connected = false;

        int count = 0;
    
        for (int i = 0; i < n; i++) {
            for(int j :adjlist[i]){
                n = adjlist[i][j];
                //transpose[n].add(i);
                transpose.get(n).add(i);
                int trcount = transpose.size();
                count = count + trcount;
            }}
           
 
        if(n==count){
            connected=true;
        }else {
            connected=false;
        }
        return connected;
    }

        


    public int numPaths(int[][] adjlist, int src, int dst) {
    //     // TODO
     return 0;
     }

     public int[] closestInSubnet(int[][] adjlist, short[][] addrs, int src, short[][] queries) {
    //     // TODO
    //min span tree??? min shortest path????
    //min number of edges to reach a connected node
    // int n = adjlist.length;
    // int cost = 0;
    // boolean[] visited = new boolean[n];
    // int[] key = new int[n];
    // int source = 0;

    // PriorityQueue<Edge> q  = new PriorityQueue<>();
    // q.add(new Edge(source, 0));

    // for(int i = 0; i < n; i ++){
    //     visited[i] = false;
    //     key[i] = -1;
    //     key[0] = 0;
    // }

    // while (!q.isEmpty()){
    //     Edge u = q.poll();
    //     if (visited[u.vertex]==false){
    //         key[u.vertex] = u.weight;
    //         visited[u.vertex] = true;
    //         cost = cost + u.weight;
    //     }
    // }
         return null;
     }

     public int maxDownloadSpeed(int[][] adjlist, int[][] speeds, int src, int dst) {
    //     // TODO
         return 0;
     }
}