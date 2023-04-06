import java.util.*;

public class practise {
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

    static class Info {
        Node node;

        Info(Node node) {
            this.node = node;

        }
    }

    public static boolean univalue(Node root) {
        if (root == null) {
            return false;
        }
        if (root.left != null && root.left.data == root.data) {
            return true;
        }
        if (root.right != null && root.right.data == root.data) {
            return true;
        }
        return univalue(root.left) && univalue(root.right);
    }

    public static boolean mirror(Node root1, Node root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.data != root2.data) {
            return false;
        }
        return mirror(root1.left, root2.right) && mirror(root1.right, root2.left);
    }

    // delete leaf Node
    public static Node delteleafNode(Node root, int x) {
        if (root == null) {
            return null;
        }

        root.right = delteleafNode(root.right, x);
        root.left = delteleafNode(root.left, x);

        if (root.left == null && root.right == null && root.data == x) {
            return null;
        }

        return root;
    }

    // preorder
    public static void preorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.left = new Node(5);
        root1.left.right = new Node(5);

        preorder(root1);
        delteleafNode(root1, 5);
        System.out.println();
        preorder(root1);
    }
}
