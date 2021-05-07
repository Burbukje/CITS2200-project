// Tristan Ward (22756187)

import java.util.*;

public class MyProject implements Project {

    ///////////// Private Methods implemented for modular use ///////////////

    private int[][] calculateTranspose(int[][] adjlist) {
        /**
         * Vector<Vector<Integer>? Vector<Vector<Integer>> adjtranspose = new
         * Vector<Vector<Integer>>(); ; // Max number of edges is equal to (vertices -
         * 1)
         * 
         * for (int i = 0; i < adjlist.length; i++) { adjtranspose.add(i, new
         * Vector<Integer>()); }
         * 
         * for (int i = 0; i < adjlist.length; i++) { for (int c : adjlist[i]) { // rws
         * in adjlist become columns in adjtranspose /** Vector<Integer> rowVector =
         * adjtranspose.get(c); rowVector.add(i);
         */
        /**
         * adjtranspose.get(c).add(i); } }
         */
        int[][] adjtranspose = new int[adjlist.length][adjlist.length];
        ; // Max number of edges is equal to (vertices - 1)

        for (int i = 0; i < adjlist.length; i++) {
            for (int j = 0; j < adjlist.length; j++) {
                adjtranspose[i][j] = 0;
            }
        }

        for (int i = 0; i < adjlist.length; i++) {
            for (int c : adjlist[i]) { // rws in adjlist become columns in adjtranspose
                /**
                 * Vector<Integer> rowVector = adjtranspose.get(c); rowVector.add(i);
                 */

                adjtranspose[c][i] = 1;
            }
        }
        return adjtranspose;
    }

    private class Edge implements Comparable<Edge> {
        private int vertex;
        private int weight;

        public Edge(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;

        }

        public int getVertex() {
            return vertex;
        }

        public void setVertex(int vertex) {
            this.vertex = vertex;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            Edge edge = (Edge) o;
            return Integer.compare(weight, edge.weight) == 0 && Integer.compare(this.vertex, edge.getVertex()) == 0;
        }

        @Override
        public int hashCode() {
            return Objects.hash(vertex, weight);
        }

        @Override
        public String toString() {
            return "Edge{" + "vertex='" + vertex + '\'' + ", weight=" + weight + '}';
        }

        // Compare two edge objects by their weight
        @Override
        public int compareTo(Edge edge) {
            if (this.getWeight() > edge.getWeight()) {
                return 1;
            } else if (this.getWeight() < edge.getWeight()) {
                return -1;
            } else {
                return 0;
            }
        }
    }

    ///////////// Public methods of Project ////////////////////////////////////

    public boolean allDevicesConnected(int[][] adjlist) {
        // TODO
        // Return: boolean indicating whether all of the devices in the network are
        // connected to the network
        /**
         * for (int i = 0; i < adjlist.length; i++) { for (int j = 0; j <
         * adjlist.length; j++) { if (i != j && adjlist[i][j] == 0) { // Hi return
         * false; } } }
         */
        return true;
    }

    public int numPaths(int[][] adjlist, int src, int dst) {
        if (src == dst) {
            return 1;
        } // to simply solve when src is = to dst.

        // get distances from lab 6 to achieve minimun spaning tree from dst

        // Need to use the transpose of the adjlist as we want the tree that leads to
        // dst.
        int[][] gtranspose = calculateTranspose(adjlist);
        /**
         * // BFS implementation LinkedList<Integer> q = new LinkedList<Integer>();
         * int[] distances = new int[v]; char[] colour = new char[v];
         * 
         * for(int c = 0; c < v ; c++){ colour[c] = 'w'; distances[c] = -1; }
         * 
         * distances[dst] = 0; colour[dst] = 'g'; q.add( dst );
         * 
         * while (!q.isEmpty()){ int w = q.removeFirst(); for (int x : gtranspose[w]){
         * // might not work as getVerticesConectedTo returns a list and not an array
         * if(colour[x]== 'w'){ distances[x] = distances[w] +1; //CHECK IF CORRECT. w is
         * the parent of x so I think it is correct. colour[x] = 'g'; q.addLast(x); } }
         * colour[w] = 'b'; }
         */

        boolean[] inMST = new boolean[gtranspose.length];
        int[] key = new int[gtranspose.length];
        int pathWeight;

        for (int c = 0; c < gtranspose.length; c++) {
            inMST[c] = false;
            key[c] = -1;
        }

        PriorityQueue<Edge> edgePQ = new PriorityQueue<>();
        edgePQ.add(new Edge(dst, 0));

        while (!edgePQ.isEmpty()) {
            Edge u = edgePQ.poll();
            if (inMST[u.getVertex()] == false) {
                inMST[u.getVertex()] = true;
                key[u.getVertex()] = u.getWeight();

                for (int v = 0; v < gtranspose.length; v++) {
                    // Vector<Integer> rowVector = gtranspose.get(u).get(v) ;

                    if (inMST[v] == false && gtranspose[u.getVertex()][v] > 0) {
                        pathWeight = u.getWeight() + gtranspose[u.getVertex()][v];
                        edgePQ.add(new Edge(v, pathWeight));
                    }

                }
            }
        }

        // distances stores the shortest distance from all vertices to dst

        // BFS but only add vertices that have a shorter distance to dst than current
        // vertex.
        // the queue "q" is empty so we can reuse it
        int[] colour = new int[adjlist.length];
        int paths = 0;
        LinkedList<Integer> q = new LinkedList<Integer>();
        // colour can also be reused if we set all values to white

        for (int c = 0; c < adjlist.length; c++) {
            colour[c] = 'w';
        }

        colour[src] = 'g';
        q.add(src);

        while (!q.isEmpty()) {
            int w = q.removeFirst();
            for (int x : adjlist[w]) {
                if (x == dst) {
                    paths++;
                }
                if (colour[x] == 'w') {
                    colour[x] = 'g';
                    if (key[w] >= key[x]) {
                        q.addLast(x);
                    }
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