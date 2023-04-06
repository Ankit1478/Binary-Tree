public class deltenode {

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

    public static Node deleteLeafNodes(Node root, int x) {
        // Check if the root node is null
        if (root == null) {
            return null;
        }
        // Recursively call the deleteLeafNodes method on the left and right subtrees of
        // the root node
        root.left = deleteLeafNodes(root.left, x);
        root.right = deleteLeafNodes(root.right, x);
        // Check if the root node is a leaf node with a value of x
        if (root.left == null && root.right == null && root.data == x) {
            return null;
        }
        // Return the modified root node
        return root;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(2);
        root.right.left = new Node(2);
        root.right.right = new Node(4);
        root.left.left.left = new Node(3);
        root.left.left.right = new Node(3);
        root.right.right.left = new Node(2);
        root.right.right.right = new Node(5);

        System.out.println(deleteLeafNodes(root, 2).data);
        /*
         * In the deleteLeafNodes method, the condition root.left == null && root.right
         * == null is used to check if the current node is a leaf node or not. If both
         * the left and right child nodes of the current node are null, then the current
         * node is a leaf node.
         * 
         * The reason we use this condition is that we want to delete only those leaf
         * nodes that have a value of x. If we delete all the leaf nodes, regardless of
         * their value, then we might end up deleting nodes that we don't want to
         * delete.
         * 
         * So, we use the condition root.left == null && root.right == null && root.val
         * == x to check if the current node is a leaf node with a value of x. If it is,
         * then we return null to delete the node. If it is not, then we return the
         * current node to keep it in the binary tree.
         */
    }
}
