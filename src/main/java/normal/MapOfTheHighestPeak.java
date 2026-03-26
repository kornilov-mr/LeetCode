package normal;

import java.security.KeyPair;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Map of Highest Peak
 * <a href="https://leetcode.com/problems/map-of-highest-peak/description/">...</a>
 */
public class MapOfTheHighestPeak {
    public static final Queue<Pair> BFSQueue = new LinkedList<>();
    public static boolean[][] visited ;
    public static int[][] peaks;
    public static int[][] highestPeak(int[][] isWater) {
        peaks = new int[isWater.length][isWater[0].length];
        visited = new boolean[isWater.length][isWater[0].length];
        for(int i =0; i<isWater.length; i++){
            for(int j =0; j<isWater[0].length; j++){
                if(isWater[i][j] == 1){
                    BFSQueue.add(new Pair(i,j,0));
                }
            }
        }
        BFS(isWater,BFSQueue);
        return peaks;
    }
    public static void BFS(int[][] isWater, Queue<Pair> startQueue){
        while(!startQueue.isEmpty()){
            Pair current = BFSQueue.poll();
            int xCurrent = current.x;
            int yCurrent = current.y;
            int depthCurrent = current.depth;
            if(visited[xCurrent][yCurrent])
                continue;

            if(depthCurrent !=0 && peaks[xCurrent][yCurrent]!=0 && depthCurrent >= peaks[xCurrent][yCurrent])
                continue;
            if(peaks[xCurrent][yCurrent] == 0){
                peaks[xCurrent][yCurrent] =depthCurrent;
            }else{
                peaks[xCurrent][yCurrent] =Math.min(depthCurrent,peaks[xCurrent][yCurrent]);

            }
            visited[xCurrent][yCurrent] = true;
            if(isInsideTheGrid(xCurrent+1, yCurrent, isWater) && isWater[xCurrent+1][yCurrent] != 1 && !visited[xCurrent+1][yCurrent])
                startQueue.add(new Pair(xCurrent+1, yCurrent,depthCurrent+1));
            if(isInsideTheGrid(xCurrent, yCurrent+1, isWater) && isWater[xCurrent][yCurrent+1] != 1  && !visited[xCurrent][yCurrent+1])
                startQueue.add(new Pair(xCurrent, yCurrent+1,depthCurrent+1));
            if(isInsideTheGrid(xCurrent-1, yCurrent, isWater) && isWater[xCurrent-1][yCurrent] != 1  && !visited[xCurrent-1][yCurrent])
                startQueue.add(new Pair(xCurrent-1, yCurrent,depthCurrent+1));
            if(isInsideTheGrid(xCurrent, yCurrent-1, isWater) && isWater[xCurrent][yCurrent-1] != 1  && !visited[xCurrent][yCurrent-1])
                startQueue.add(new Pair(xCurrent, yCurrent-1,depthCurrent+1));
        }
    }
    public static boolean isInsideTheGrid(int x, int y, int[][] isWater){
        return x>=0 && x<isWater.length && y>=0 && y<isWater[0].length;
    }
    public static void main(String[] args) {
        int[][] isWater = {{0,0,1},{1,0,0},{0,0,0}};
        int[][] result = highestPeak(isWater);
    }
    public static class Pair{
        public int x,y,depth;
        Pair(int x, int y,int depth){
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    }
}
