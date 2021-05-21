// Full Name (StudentNum)
import java.util.*;
//import java.util.Graph;

public class MyProject implements Project {

        
    private int[][] calculateTranspose(int[][] adjlist) {

        // the transpose is a square matrix
        int[][] adjtranspose = new int[adjlist.length][adjlist.length];
        ;

        // Initialize all values to 0
        for (int i = 0; i < adjlist.length; i++) {
            for (int j = 0; j < adjlist.length; j++) {
                adjtranspose[i][j] = 0;
            }
        }

        // Add all original edges of the adgacency list but pointing in the oposite
        // direction.
        for (int i = 0; i < adjlist.length; i++) {
            for (int c : adjlist[i]) { // rws in adjlist become columns in adjtranspose
                adjtranspose[c][i] = 1;
            }
        }
        return adjtranspose;
    }

     public boolean isSubnet(short[] queries, short[] addrs){

                  for(short c=0; c < queries.length; c++){
                
                 if (queries[c]!=addrs[c]){
                      return false;}
                  } return true;
                }

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
            for(int j = 0; j< adjlist[i].length; j++){
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
        //loop over the elements of the adjlist
        //get the addrs, assign [i] element of the addrs to every node of adjlist
        //loop through the [j] element of addrs
        //compare the elements of [j] array to queries
        //use hashmaps 
        //store ewvery element according to their power 
        //the method you have so far is shit
        //toooo complex
        int n = adjlist.length;
        boolean[] visited = new boolean[n];
        int[] hops = new int[queries.length];
        int[] distance = new int[n];
       
      
    
        Queue<Integer> q = new LinkedList<>();
        q.offer(src);
        visited[src] = true;
        distance[src] = 0;
       // hops[src] = 0;
         
        for(int i = 0; i < n; i++){
            visited[i]=false;
            hops[i] = Integer.MAX_VALUE;
        }
    
        while(!q.isEmpty()) {
            int current = q.poll();
    
            for (int j = 0; j < queries.length; j++) {
                //System.out.println("j " + j + "current " + current);
                if (hops[j] == Integer.MAX_VALUE && isSubnet(queries[j], addrs[current])) {
                    hops[j] = distance[current];
                }
            }
    
            for (int i = 0; i < adjlist[current].length; i++) {
                int m = adjlist[current][i];
                if (!visited[m]) {
                    visited[m] = true;
                    q.offer(m);
                }
            }
        }
    
               }
     public int maxDownloadSpeed(int[][] adjlist, int[][] speeds, int src, int dst) {
    //     // TODO
         return 0;
     }
}