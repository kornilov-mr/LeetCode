package normal;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Count Pairs of Connectable Servers in a Weighted Tree Network
 * <a href="https://leetcode.com/problems/count-pairs-of-connectable-servers-in-a-weighted-tree-network/description/">...</a>
 */
public class CountPairsOfConnectableServersIAWeightedTreeNetwork {

    private ArrayList<ArrayList<Pair>> edges = new ArrayList<>();

    public int[] countPairsOfConnectableServers(int[][] edges, int signalSpeed) {
        int nodeNumber = 0;
        for (int[] edge : edges) {
            nodeNumber = Math.max(nodeNumber, edge[0]);
            nodeNumber = Math.max(nodeNumber, edge[1]);
        }
        nodeNumber++;
        for (int i = 0; i < nodeNumber; i++) {
            this.edges.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            this.edges.get(edge[0]).add(new Pair(edge[1], edge[2]));
            this.edges.get(edge[1]).add(new Pair(edge[0], edge[2]));
        }
        int[] paths = new int[nodeNumber];
        for (int i = 0; i < nodeNumber; i++) {
            paths[i] = DFS(i, i, 0, signalSpeed);
        }
        return paths;
    }

    public int DFS(int currNodeIndex, int prevNodeIndex, int length, int signalSpeed) {
        int count = length % signalSpeed == 0 && length > 0 ? 1 : 0;
        int pairs = 1;
        int neighborCount = 0;
        for (Pair nextNode : this.edges.get(currNodeIndex)) {
            int nextNodeIndex = nextNode.x;
            int edgeWeight = nextNode.y;
            if (nextNodeIndex == prevNodeIndex)
                continue;
            if (edgeWeight == 0)
                continue;
            int nextCount = DFS(nextNodeIndex, currNodeIndex, length + edgeWeight, signalSpeed);
            pairs *= nextCount;
            neighborCount += 1;
            count += nextCount;
        }
        if (neighborCount == 1 && currNodeIndex == prevNodeIndex)
            return 0;
        return currNodeIndex == prevNodeIndex ? pairs : count;
    }

    public class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        CountPairsOfConnectableServersIAWeightedTreeNetwork cl = new CountPairsOfConnectableServersIAWeightedTreeNetwork();
        int[][] edges = {{0, 1, 1}, {1, 2, 5}, {2, 3, 13}, {3, 4, 9}, {4, 5, 2}};
        System.out.println(Arrays.toString(cl.countPairsOfConnectableServers(edges, 1)));
    }
}
