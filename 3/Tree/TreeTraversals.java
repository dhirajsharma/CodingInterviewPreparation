import java.util.*;
/**
 * Examples of various kinds of tree traversals and searches.
 * 
 * @author Dave Matuszek
 * @version 3/31/2003
 */
public class TreeTraversals {
    
    public static void main(String[] args) {
        Tree tree = createTree();
        
        System.out.println("\nPreorder print of tree:");
        preorderPrint(tree);
        
        System.out.println("\n\nIndented preorder print of tree:");
        preorderPrint(tree, "");
        
        System.out.println("\nPostorder print of tree:");
        postorderPrint(tree);
        
        System.out.println("\n\nIndented postorder print of tree:");
        postorderPrint(tree, "");
        
        System.out.println("\n\nDepth-first search:");
        dfs(tree);

        System.out.println("\nBreadth-first search:");
        bfs(tree);
        
        System.out.println("\nRecursive depth-first search:");
        recursiveDfs(tree);
    }
    
    /** Creates and returns a tree for use in testing the other methods. */
    static Tree createTree() {
        Tree root = new Tree("A");
            Tree temp = root.add("B");
                temp.add("F");
                temp.add("G");
                temp = temp.add("H");
                    temp.add("L");
                    temp.add("M");
            root.add("C");
            temp = root.add("D");
                temp.add("I");
            temp = root.add("E");
                Tree temp2 = temp.add("J");
                    temp2.add("N");
                temp.add("K");
        return root;
    }
    
    /**
     * Traverses the given tree in preorder, printing node values
     * on a single line.
     */
    static void preorderPrint(Tree node) {
        System.out.print(" " + node.value);
        Iterator iter = node.children.iterator();
        while (iter.hasNext()) {
            preorderPrint((Tree) iter.next());
        }
    }
    
    /**
     * Traverses the given tree in preorder, printing node values
     * indented and on multiple lines.
     */
    static void preorderPrint(Tree node, String indent) {
        System.out.println(" " + indent + node.value);
        Iterator iter = node.children.iterator();
        while (iter.hasNext()) {
            preorderPrint((Tree) iter.next(), indent + "|  ");
        }
    }
    
    /**
     * Traverses the given tree in postorder, printing node values
     * on a single line.
     */
    static void postorderPrint(Tree node) {
        Iterator iter = node.children.iterator();
        while (iter.hasNext()) {
            postorderPrint((Tree)iter.next());
        }
        System.out.print(" " + node.value);
    }
    
    /**
     * Traverses the given tree in postorder, printing node values
     * indented and on multiple lines. I did this out of curiosity,
     * and find the resultant output very difficult to read.
     */
    static void postorderPrint(Tree node, String indent) {
        Iterator iter = node.children.iterator();
        while (iter.hasNext()) {
            postorderPrint((Tree)iter.next(), indent + "|  ");
        }
        System.out.println(" " + indent + node.value);
    }
    
    /**
     * Performs a depth-first search, starting from the given node,
     * for any node that satisfies the condition isGoal(node).
     * 
     * @param root The root of the tree or subtree to be searched.
     * @return True if a goal node could be found.
     */
    static boolean dfs(Tree root) {
        Stack stack = new Stack();
        stack.push(root);
        while (!stack.isEmpty()) {
            Tree node = (Tree) stack.pop();
            System.out.print("Checking node " + node.value);
            if (isGoal(node)) {
                System.out.println("\nFound goal node " + node.value);
                return true;
            }
            stack.addAll(node.children);
            dump(stack);
        }
        return false;
    }

    /**
     * Performs a depth-first search, starting from the given node,
     * for any node that satisfies the condition isGoal(node), and
     * prints the path from the goal back to the root.
     * 
     * @param root The root of the tree or subtree to be searched.
     * @return True if a goal node could be found.
     */
    static boolean recursiveDfs(Tree node) {
        if (isGoal(node)) {
            System.out.println("Found goal node: " + node.value);
            return true;
        }
        Iterator children = node.children.iterator();
        while (children.hasNext()) {
            Tree child = (Tree)children.next();
            if (recursiveDfs(child)) {
                System.out.println("Path contains node " + node.value);
                return true;
            }
        }
        return false;
    }
    /**
     * Performs a breadth-first search, starting from the given node,
     * for any node that satisfies the condition isGoal(node).
     * 
     * @param root The root of the tree or subtree to be searched.
     * @return True if a goal node could be found.
     */
    static boolean bfs(Tree root) {
        Queue queue = new Queue();
        queue.add(root);
        while (!queue.isEmpty()) {
            Tree node = (Tree) queue.get();
            System.out.print("Checking node " + node.value);
            if (isGoal(node)) {
                System.out.println("\nFound goal node " + node.value);
                return true;
            }
            queue.addAll(node.children);
            dump(queue);
        }
        return false;
    }

    /**
     * Defines a couple of nodes in the tree to be goal nodes. There is
     * no "deeper meaning" to these nodes; it's just a hack to test out
     * the search methods.
     */
    static boolean isGoal(Tree node) {
        return "N".equals(node.value) || "G".equals(node.value);
    }
    
    /** Prints the contents of the stack (top to the left). */
    static void dump(Stack stack) {
        String temp = "  stack = ";
        for (int i = stack.size() - 1; i >= 0; i--) {
            temp = temp + ((Tree)(stack.elementAt(i))).value + " ";
        }
        System.out.println(temp);
    }

    /** Prints the contents of the queue (front to the left). */
    static void dump(Queue queue) {
        String temp = "  queue = ";
        for (int i = 0; i < queue.queue.size(); i++) {
            temp = temp + ((Tree)(queue.queue.elementAt(i))).value + " ";
        }
        System.out.println(temp);
    }
}
