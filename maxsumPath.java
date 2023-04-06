import java.util.*;

public class maxsumPath {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static int maxsumpath(Node root) {
        if (root == null) {
            return 0;
        }

        int maxPath = Integer.MIN_VALUE;

        int leftSum = maxsumpath(root.left);
        int rightSum = maxsumpath(root.right);
        if (leftSum > 0 && rightSum > 0) {
            maxPath = root.data + leftSum + rightSum;
        } else if (leftSum > 0) {
            maxPath = root.data + leftSum;
        } else if (rightSum > 0) {
            maxPath = root.data + rightSum;
        } else {
            maxPath = root.data;
        }
        int maxSum = Math.max(maxPath, Math.max(leftSum, rightSum));
        return maxSum;

    }

    public static void main(String[] args) {
        Node root = new Node(-10);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);
        System.out.println(maxsumpath(root));
    }
}
