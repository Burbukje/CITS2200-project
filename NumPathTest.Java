import java.util.*;

public class NumPathTest {  
    ///////////// Private Methods implemented for modular use ///////////////
 private static int[][] calculateTranspose(int[][] adjlist, int v){
        int[][] adjtranspose = new int[v][]; //Max number of edges is equal to vertices - 1
        for (int i=0; i < v; i++)
        {
            for (int c : adjlist[i])
            {
                int[] temp = Arrays.copyOf(adjtranspose[c], adjtranspose[c].length + 1); //create new array from old array and allocate one more element
                temp[adjtranspose.length - 1] = i;
                adjtranspose[c] = temp; // I am expecting this will brake at runtime. array of lists instead. 
            }
        }
        return adjtranspose;
    }


    public static int numPaths(int[][] adjlist, int src, int dst) {
        int v = adjlist.length;

       // get distances from lab 6 to achieve minimun spaning tree from dst

       // Need to use the transpose of the adjlist as we want the tree that leads to dst. 
       int[][] gtranspose = calculateTranspose(adjlist , v);

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
			for (int x : gtranspose[w]){ // might not work as getVerticesConectedTo returns a list and not an array
				if(colour[x]== 'w'){
					distances[x] = distances[w] +1; //CHECK IF CORRECT. w is the parent of x so I think it is correct. 
					colour[x] = 'g';
					q.addLast(x);
				}				
			}
			colour[w] = 'b';
		}

        // distances stores the shortest distance from all vertices to dst
        
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
                if(x == dst) { paths++;}
				if(colour[x]== 'w'){
					colour[x] = 'g';
					if(distances[w] >= distances[x]){ 
                        q.addLast(x);
                    }
				}				
			}
			colour[w] = 'b';
		}

        return paths;
    }

    public static void main(String[] args) {
        int[][] adjlist = new int[][] {
            { 1 },
            { 0 },
        };

        int numpaths = numPaths(adjlist, 0 ,1);

        System.out.print("Expected 1 got = \n");
        System.out.print(numpaths);

    }
}