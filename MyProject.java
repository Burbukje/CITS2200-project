// Full Name (StudentNum)
import java.util.*;

public class MyProject implements Project {
    int n; //no of vertices

    public boolean allDevicesConnected(int[][] adjlist) {
        // TODO
        //Return: boolean indicating whether all of the devices in the network are connected to the network
        for(int i = 0; i<adjlist.length; i++){
            for(int j = 0; j <adjlist.length; j++){
                if(i!=j && adjlist[i][j]==0){ 
                    return false;
                }
            
        }
        return true;
    }

    public int numPaths(int[][] adjlist, int src, int dst) {
        // TODO
        return 0;
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