import java.util.*;

public class TREE {
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

    static class BinaryTree {
        static int idx = -1;

        public static Node buildtree(int node[]) {
            idx++;
            if (node[idx] == -1) {
                return null;
            }
            Node newNode = new Node(node[idx]);
            newNode.left = buildtree(node);
            newNode.right = buildtree(node);
            return newNode;
        }

        // PreOrder
        public static void preorder(Node root) {
            if (root == null) {
                return;
            }
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }

        // Inorder
        public static void inorder(Node root) {
            if (root == null) {
                return;
            }
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }

        // PostOrder
        public static void postorder(Node root) {
            if (root == null) {
                return;
            }
            inorder(root.left);
            inorder(root.right);
            System.out.print(root.data + " ");
        }

        // LevelOrder
        public static void LevelOrder(Node root) {
            if (root == null) {
                return;
            }
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);
            while (!q.isEmpty()) {
                Node currNode = q.remove();
                if (currNode == null) {
                    System.out.println();
                    if (q.isEmpty()) {
                        break;
                    } else {
                        q.add(null);
                    }
                } else {
                    System.out.print(currNode.data + " ");
                    if (currNode.left != null) {
                        q.add(currNode.left);
                    }
                    if (currNode.right != null) {
                        q.add(currNode.right);
                    }
                }
            }

        }

        // Height of tree
        public static int height(Node root) {
            if (root == null) {
                return 0;
            }
            int leftheight = height(root.left);
            int rightheight = height(root.right);
            return leftheight + rightheight + 1;
        }

        // count Node
        public static int CountNode(Node root) {
            if (root == null) {
                return 0;
            }
            int leftheight = CountNode(root.left);
            int rightheight = CountNode(root.right);
            return leftheight + rightheight + 1;
        }

        // sum of nodes
        public static int sumNode(Node root) {
            if (root == null) {
                return 0;
            }
            int leftsum = sumNode(root.left);
            int rightsum = sumNode(root.right);
            return leftsum + rightsum + root.data;
        }

        // Dimater of Tree
        public static int Dimater(Node root) {
            if (root == null) {
                return 0;
            }
            int leftD = Dimater(root.left);
            int leftH = height(root.left);
            int rightD = Dimater(root.right);
            int rightH = height(root.right);

            int selfDia = leftH + rightH + 1;
            return Math.max(selfDia, Math.max(leftD, rightD));
        }
    }

    public static void main(String[] args) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildtree(nodes);
        // tree.preorder(root);
        // tree.inorder(root);
        tree.LevelOrder(root);

        System.out.println(tree.Dimater(root));

    }
}
