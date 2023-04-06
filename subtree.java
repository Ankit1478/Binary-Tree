import java.util.*;

public class subtree {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static boolean isSubtree(Node root, Node subroot) {
        if (root == null) {
            return false;
        }
        if (root.data == subroot.data) {
            if (isIdentical(root, subroot)) {
                return true;
            }
        }
        boolean leftans = isSubtree(root.left, subroot);
        boolean rightans = isSubtree(root.right, subroot);
        // agar nhi krti hai to issubtrre ke left ma aur right ma check krnge
        return leftans || rightans;
    }

    public static boolean isIdentical(Node node, Node subroot) {
        if (node == null && subroot == null) {
            return true;
        }
        if (node == null || subroot == null || node.data != subroot.data) {
            return false;
        }
        if (!isIdentical(node.left, subroot.left)) {
            return false;
        }
        if (!isIdentical(node.right, subroot.right)) {
            return false;
        }
        return true;
    }

    // public static void LevelOrder(Node root) {
    // if (root == null) {
    // return;
    // }
    // Queue<Node> q = new LinkedList<>();
    // q.add(root);
    // q.add(null);

    // while (!q.isEmpty()) {
    // Node curr = q.remove();
    // if (curr == null) {
    // System.out.println();
    // if (q.isEmpty()) {
    // break;
    // } else {
    // q.add(null);
    // }
    // } else {
    // System.out.print(curr.data + " ");
    // if (curr.left != null) {
    // q.add(curr.left);
    // }
    // if (curr.right != null) {
    // q.add(curr.right);
    // }
    // }

    // }
    // }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        Node subroot = new Node(2);
        subroot.left = new Node(4);
        subroot.right = new Node(5);
        System.out.println(isSubtree(root, subroot));
    }
}
