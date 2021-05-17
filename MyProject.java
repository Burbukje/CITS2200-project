
/**
 * @author Tristan Ward (22756187)
 * @author Burbukje Shakjiri (22579289)
*/
import java.util.*;

public class MyProject implements Project {

    ///////////// Private Methods implemented for modular use ///////////////

    /**
     * calculateTranspose (int[][] adjlist): is used to calculate the transpose of a
     * directed unweighted adjacency List
     * 
     * @param adjlist is an array of arrays that represents the adjacencies of a
     *                grapgh
     * @return 2D array transpose matrix of a adjacency list
     */
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

    /**
     * Edge class implements and then Overrides the Comparable in the priority
     * queue.
     */
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

        // Requirement: return 1 when src is equal to dst.
        if (src == dst) {
            return 1;
        }

        // Need to calculate the transpose of the adjlist as we want the shortest path
        // tree that leads to dst
        int[][] gtranspose = calculateTranspose(adjlist);
        // Dijktra's algorithm to calculate shortest path

        boolean[] inMST = new boolean[gtranspose.length];
        int[] key = new int[gtranspose.length]; // stores the Shortest path from any vertex to dst
        int pathWeight; // Makes code more readible

        // Specify that there are no vertices in the MST with an undefined shortest path
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

                    if (inMST[v] == false && gtranspose[u.getVertex()][v] > 0) {
                        // pathWeight was added to make code more readeble
                        pathWeight = u.getWeight() + gtranspose[u.getVertex()][v];
                        edgePQ.add(new Edge(v, pathWeight));
                    }
                }
            }
        }

        // BFS to add vertices that have a shorter distance to dst than current vertex.
        // If the vertex reached is the destination, then increment path.
        int[] colour = new int[adjlist.length];
        int paths = 0;
        LinkedList<Integer> q = new LinkedList<Integer>();

        // No vertex has been visited so we mark all values to white
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

        if (src == dst) {
            return -1;
        }
        /*
         * Returns true if there is a path from source 's' to sink 't' in residual
         * graph. Also fills parent[] to store the path
         */
        boolean visited[] = new boolean[adjlist.length];
        int u, v;
        int rGraph[][] = new int[adjlist.length][adjlist.length];
        int parent[] = new int[adjlist.length];
        int max_flow = 0; // There is no flow initially
        boolean dstFound = true;
        int path_flow = Integer.MAX_VALUE;
        LinkedList<Integer> queue = new LinkedList<Integer>();

        // Initialize all values
        for (int i = 0; i < adjlist.length; i++) {

            for (int j = 0; j < adjlist.length; j++) {
                rGraph[i][j] = 0;
            }
            for (int c = 0; c < adjlist[i].length; c++) { // rws in adjlist become columns in adjtranspose
                rGraph[i][adjlist[i][c]] = speeds[i][c];
            }
        }

        while (dstFound) {
            dstFound = false;

            for (int i = 0; i < adjlist.length; ++i) {
                visited[i] = false;
                parent[i] = -1;
            }

            queue.add(src);
            visited[src] = true;
            parent[src] = -1;

            // Standard BFS Loop /////////////////////////////
            while (queue.size() != 0 && !dstFound) {
                u = queue.poll();

                for (v = 0; v < adjlist.length; v++) {
                    if (visited[v] == false && rGraph[u][v] > 0) {
                        // If we find a connection to the sink
                        // node, then there is no point in BFS
                        // anymore We just have to set its parent
                        // and can return true
                        if (v == dst) {
                            parent[v] = u;
                            dstFound = true;
                            queue.clear();
                        } else {
                            queue.add(v);
                            parent[v] = u;
                            visited[v] = true;
                        }
                    }
                }
            }

            // Find minimum residual capacity of the edhes /////
            // along the path filled by BFS. Or we can say
            // find the maximum flow through the path found.
            if (dstFound) {
                for (v = dst; v != src; v = parent[v]) {
                    u = parent[v];
                    path_flow = Math.min(path_flow, rGraph[u][v]);
                }

                // update residual capacities of the edges and
                // reverse edges along the path
                for (v = dst; v != src; v = parent[v]) {
                    u = parent[v];
                    rGraph[u][v] -= path_flow;
                    rGraph[v][u] += path_flow;
                }

                // Add path flow to overall flow
                max_flow += path_flow;
            }
        }
        return max_flow;
    }
}