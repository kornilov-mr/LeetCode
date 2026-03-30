package normal;

import java.util.*;

/**
 * K-th Largest Perfect Subtree Size in Binary Tree
 * <a href="https://leetcode.com/problems/k-th-largest-perfect-subtree-size-in-binary-tree/description/">...</a>
 *
 */
public class KthLargestPerfectSubtreeSizeInBinaryTree {
    public static final Map<TreeNode,Integer> nodeToLeafDepth = new HashMap<>();
    public static final Map<TreeNode,Boolean> isPerfect = new HashMap<>();
    public static final Map<TreeNode, Integer> nodeToSize = new HashMap<>();
    public static int kthLargestPerfectSubtree(TreeNode root, int k) {
        if(root ==null)
            return 0;
        DFS(root,0);
        ArrayList<Map.Entry<TreeNode,Integer>> entries =new ArrayList<>(nodeToSize.entrySet());
        entries.sort((a, b) -> b.getValue().compareTo(a.getValue()));
        if(k>entries.size())
            return -1;
        return entries.get(k-1).getValue();
    }
    public static void DFS(TreeNode node,int depth){
        if(node==null)
            return;
        if(node.left == null && node.right == null){
            isPerfect.put(node,true);
            nodeToLeafDepth.put(node,depth);
            nodeToSize.put(node,1);
            return;
        }
        if(node.right == null || node.left ==null){
            isPerfect.put(node,false);
        }
        DFS(node.right,depth+1);
        DFS(node.left, depth+1);
        if(isPerfect.getOrDefault(node.right,false) && isPerfect.getOrDefault(node.left,false)){
            if(Objects.equals(nodeToLeafDepth.getOrDefault(node.right, Integer.MIN_VALUE), nodeToLeafDepth.getOrDefault(node.left, Integer.MAX_VALUE))){
                isPerfect.put(node,true);
                int leafDepth = nodeToLeafDepth.get(node.right);
                nodeToLeafDepth.put(node,leafDepth);
                nodeToSize.put(node,(int)Math.pow(2,leafDepth-depth+1)-1);
            }
        }
    }
    public static void main(String[] args) {
//        TreeNode node1 = new TreeNode(1);
//        TreeNode node2 = new TreeNode(2);
//        TreeNode node3 = new TreeNode(3);
//        TreeNode node4 = new TreeNode(4);
//        TreeNode node5 = new TreeNode(5);
//        TreeNode node5A = new TreeNode(5);
//        TreeNode node5B = new TreeNode(5);
//        TreeNode node6 = new TreeNode(6);
//        TreeNode node6A = new TreeNode(6);
//        TreeNode node7 = new TreeNode(7);
//        TreeNode node8 = new TreeNode(8);
//        TreeNode node8A = new TreeNode(8);
//
//        node5.left = node1;
//        node5.right = node8;
//
//        node3.left= node5;
//        node3.right= node2;
//
//        node5A.left = node6;
//        node5A.right= node8A;
//
//        node6A.left= node5A;
//        node6A.right = node7;
//
//        node5B.left = node3;
//        node5B.right = node6A;
//
//        System.out.println(kthLargestPerfectSubtree(node5B,2));
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);

        node2.right = node4;
        node2.left = node5;

        node3.right = node6;
        node3.left = node7;

        node1.right = node2;
        node1.left = node2;

        System.out.println(kthLargestPerfectSubtree(node1,1));
    }
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
