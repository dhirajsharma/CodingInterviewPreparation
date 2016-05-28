/*
 * print a binary tree in level order using DFS & BFS
 */
//package Chapter4;

import java.util.Queue;
import java.util.LinkedList;

public class PrintLevelOrder {
    public static void main(String args[]){
        TreeNode n1 = new TreeNode(1, null, null);
        TreeNode n2 = new TreeNode(2, n1, null);
        TreeNode n4 = new TreeNode(4, null, null);
        TreeNode n6 = new TreeNode(6, null, null);
        TreeNode n5 = new TreeNode(5, n4, n6);
        TreeNode n3 = new TreeNode(3, n2, n5);
        TreeNode n10 = new TreeNode(10, null, null);
        TreeNode n11 = new TreeNode(11, n10, null);
        TreeNode n9 = new TreeNode(9, null, n11);
        TreeNode n8 = new TreeNode(8, null, n9);
        TreeNode n7 = new TreeNode(7, n3, n8);
        
        printLevelOrderDFS(n7);
        printLevelOrderBFS(n7);
    }
    
    public static void printLevelOrderBFS(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int currentLevelCount = 1;
        int nextLevelCount = 0;
        
        while(!queue.isEmpty()){
            TreeNode n = queue.remove();
            System.out.print(n.data + " ");
            if(n.left != null){
                queue.add(n.left);
                nextLevelCount++;
            }
            if(n.right != null){
                queue.add(n.right);
                nextLevelCount++;
            }
            currentLevelCount--;
            if(currentLevelCount == 0){
                System.out.println("");
                currentLevelCount = nextLevelCount;
                nextLevelCount = 0;
            }
        }
    }
    
    public static void printLevelOrderDFS(TreeNode root){
        int height = maxHeight(root);
        for( int  i = 0; i < height; i++){
            printLevel(root, i);
            System.out.println();
        }
    }
    
    public static void printLevel(TreeNode node, int level){
        if(node == null)
            return;
        if(level == 0){
            System.out.print(node.data+" ");
        }else{
            printLevel(node.left, level - 1);
            printLevel(node.right, level - 1);
        }
        
        
    }
    
    public static int maxHeight(TreeNode root){
        if (root == null)
            return 0;
        return 1 + Math.max(maxHeight(root.left), maxHeight(root.right));
    }
}
