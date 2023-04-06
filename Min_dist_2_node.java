public class Min_dist_2_node {
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

    public static Node lca(Node root, int n1, int n2) {
        if (root == null || root.data == n1 || root.data == n2) {
            return root;
        }
        Node leftlca = lca(root.left, n1, n2);
        Node rightlca = lca(root.right, n1, n2);

        if (rightlca == null) {
            return leftlca;
        }
        if (leftlca == null) {
            return rightlca;
        }
        return root;
    }

    public static int minDist(Node root, int n1, int n2) {
        Node LCA = lca(root, n1, n2);
        int dist1 = lcadist(LCA, n1);
        int dist2 = lcadist(LCA, n2);

        return dist1 + dist2;
    }

    public static int lcadist(Node root, int n) {
        if (root == null) {
            return -1;
        }
        if (root.data == n) {
            return 0;
        }
        int leftlca = lcadist(root.left, n);
        int rightlca = lcadist(root.right, n);

        if (leftlca == -1 && rightlca == -1) {
            return -1;
        } else if (leftlca == -1) {
            return rightlca + 1;
        } else {
            return leftlca + 1;
        }

        /*
         * if(leftdist >= 0){
         * return leftdist+1;
         * }
         * if (rightdist >= 0) {
         * return rightdist + 1;
         * }
         */
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println(minDist(root, 4, 6));
    }
}
