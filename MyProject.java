// Tristan Ward (22756187)
import java.util.*;
import java.util.Graph;

public class MyProject implements Project {
    
    ///////////// Private Methods implemented for modular use ///////////////

    /** 
    private int getNumberOfVertices(int[][] adjlist){
        int v = 0;
        for (int c : adjlist.length) {
            v++;
        }
    }
    */

    private Graph calculateTranspose(int[][] adjlist, int v){
        Graph<Integer> adjtranspose = new Graph<Integer>();
        for (int i=0; i < v; i++)
        {
            for (int c : adjlist[i])
            {
                adjtranspose.connect(c,i);
            }
        }
        return adjtranspose;
    }
 

   ///////////// Public methods of Project  ////////////////////////////////////


    public boolean allDevicesConnected(int[][] adjlist) {
        // TODO
        //Return: boolean indicating whether all of the devices in the network are connected to the network
        for(int i = 0; i<adjlist.length; i++){
            for(int j = 0; j <adjlist.length; j++){
                if(i!=j && adjlist[i][j]==0){ 
                    //Hi
                    return false;
                }
            
        }
        return true;
    }
    }

    public int numPaths(int[][] adjlist, int src, int dst) {
        v = adjlist.length;

       // get distances from lab 6 to achieve minimun spaning tree from dst

       // Need to use the transpose of the adjlist as we want the tree that leads to dst. 
       Graph<Integer> gtranspose = calculateTranspose(adjlist , v);

       // BFS implementation
        LinkedList<Integer> q = new LinkedList<Integer>();
		int[] distances = new int[v];
		char[] colour = new char[v];

		for(int c = 0; c < v ; c++){
			colour[c] = 'w';
			distances[c] = -1;
		}
        
		distances[dst] = 0;
		colour[dst] = 'g';
		q.add( dst );
		
		while (!q.isEmpty()){
			int w = q.removeFirst();
			for (int x : gtranspose.getVerticesConectedTo(w)){ // might not work as getVerticesConectedTo returns a list and not an array
				if(colour[x]== 'w'){
					distances[x] = distances[w] +1; //CHECK IF CORRECT. w is the parent of x so I think it is correct. 
					colour[x] = 'g';
					q.addLast(x);
				}				
			}
			colour[w] = 'b';
		}

        // distances stores the shortest distance from dst to all vertices
        
        // BFS but only add vertices that have a shorter distance to dst than current vertex.
        // the queue "q" is empty so we can reuse it 

        int paths = 0;

        // colour can also be reused if we set all values to white
		for(int c = 0; c < v ; c++){
			colour[c] = 'w';
		}
        

		colour[src] = 'g';
		q.add( src );
		
		while (!q.isEmpty()){
			int w = q.removeFirst();
			for (int x : adjlist[w]){ 
                if(x == dst) { path++;}
				if(colour[x]== 'w'){
					colour[x] = 'g';
					if(distances(w) >= distances(x)){ q.addLast(x);}
				}				
			}
			colour[w] = 'b';
		}

        return paths;
    }

    public int[] closestInSubnet(int[][] adjlist, short[][] addrs, int src, short[][] queries) {
        // TODO
        return null;
    }

    public int maxDownloadSpeed(int[][] adjlist, int[][] speeds, int src, int dst) {
        // TODO
        return 0;
    }
}