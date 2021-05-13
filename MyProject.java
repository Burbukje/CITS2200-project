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
        int n = adjlist.length-1;
        boolean[] visited = new boolean[n];
        int start = 0;
        Queue<Integer> q = new LinkedList<>();
       // visited[n-1]=false;
        int[] key = new int[n];
        int [] source = new int[n];
      //  int [] dest = new int[n];
        for (int i = 0; i < n; i++) {
            for(int j = i+1; j<n; j++){
            visited[i] = true;
            key[i] = -1;
            
        
         q.add(source[0]);
       while(!q.isEmpty()){
           int m = q.remove();
           for (int x: adjlist[m]){
               if(visited[x]){
                   key[x] = m;
                   if(visited[source[i]]){
                   q.add(i);}
               }}
                 }
                }}
      //       }


       //     visited[source] = true;
      //    for(int j = 0; j<n; j++){
      //     for(int i : adjlist[v.getVertex()]){
      //       if(visited[v]==false){
      //           //perform dfs from j 
      //       }
            
      //     }}
        boolean connected = false;

      
       int count = 0;
        for(int c=0; c<q.size(); c++){
            if(visited[c]){
                count++;
            }
        }
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
         return null;
     }

     public int maxDownloadSpeed(int[][] adjlist, int[][] speeds, int src, int dst) {
    //     // TODO
         return 0;
     }
}