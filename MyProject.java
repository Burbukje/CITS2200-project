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
    Queue<Integer> q = new LinkedList<>();
    q.offer(src);
      int n = adjlist.length;
      boolean[] visited = new boolean[n];
      for (int i=0; i <n; i++){
          for(int j=0; j< adjlist[i].length; j++){
              n = adjlist[i][j];
          }
      }
      int[] hops = new int[n];
      for(int i = 0; i < n; i++){
          hops[i] = -1;
          visited[i] = false;
        }


      while(!q.isEmpty()){
          int current = q.poll();
          visited[current] = true;
          for(int i = 0; i < n; i++){
              for(int j=0; j < adjlist[i].length; j++){
                  n = adjlist[i][j];
              }
          }
            for (short i =0; i < n; i++){
                for(short j = 0; j < addrs[i].length; j++){
                if((visited[i]==false)&&(queries[j].isSubnet(addrs[j]))){
                    visited[i] = true;
                    if(current == src){
                        hops[src] = 0;
                    }else{
                        hops[i] = hops[current] + 1;
                    }
                   // q.offer(i);
                }else {
                     for(int c = 0; c < adjlist[j].length; c++){
                         if(queries[j].isSubnet(addrs[c])){
                             hops[i] = hops[current] + 1;
                         }
                     }
                   // addrs[i] = addrs[i+1];
                   //use helper function to check the arrays manually 
                }
                
            }}}
            return hops;
           }


        //   for(short c=0; c<n; c++){
        //       for(short k=0; k< addrs[c].length; k++){

        //         if(addrs[k].equals(queries[j])){
        //             //hops[i] = weight of addrs[k] to queries[j]
        //             int edge = 0;
        //             edge = edge + 1;
        //             hops[i] = edge;
                    //OOOORRRRR 
                    //edges = edges + 1??? doesnt rreally make sense
                //}   
                  //if(addrs[j].equals(queries.get(j)))
                  //hops.add edge
             // }
         // }}}
     // }
     public int maxDownloadSpeed(int[][] adjlist, int[][] speeds, int src, int dst) {
    //     // TODO
         return 0;
     }
}