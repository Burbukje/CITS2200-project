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
       // boolean connected = new boolean;

    //    //CONVERT to adjacency list
    //    int l = adjlist[0].length;
    //    ArrayList<ArrayList<Integer>> adjListArray = new ArrayList<ArrayList<Integer>>(l);
    //    for (int i = 0; i < l; i++){
    //        adjListArray.add(new ArrayList<Integer>());
    //    }
    //    int i, j;
    //    for (i = 0; i < adjlist[0].length; i++){
    //        for (j = 0; j < adjlist.length; j++){
    //            if  (adjlist[i][j] == 1){
    //                adjListArray.get(i).add(j);
    //            }
    //        }
    //   
     

      

        int n = adjlist.length-1;
       // boolean[] visited = new boolean[n];
        int start = 0;
       
        //ArrayList<ArrayList<Integer[]>> transpose = new ArrayList<ArrayList<Integer>>(n);

        //Integer[][] transpose = new ArrayList<ArrayList<Integer>>(n);
        ArrayList<ArrayList<Integer>> transpose = new ArrayList<ArrayList<Integer>>(n);

       //Integer[] transpose = new Integer [n];
       
        boolean connected = false;

        int count = 0;
    
        for (int i = 0; i < n; i++) {
            for(int j :adjlist[i]){
                n = adjlist[i][j];
                transpose[n].add(i);
            }}
           
 
        if(n==count){
            connected=true;
        }else {
            connected=false;
        }
        return connected;
    }

        
    //     for(int i : adjlist[u.getVertex()]){
        // u represents the neighbor, it points to 
    //         //
    //         if(visited[i]==true){
    //             //perform dfs
    //         }
    //         for(int j = 0; j <adjlist.length; j++){
    //             if(!visited[i]&&!visited[j] && adjlist[i][j] == 0){ 
    //                 connected = false;
    //             } else {
    //                 connected = true;
    //             }         
    //   }
    
    
  //}

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