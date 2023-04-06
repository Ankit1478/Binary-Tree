import java.util.ArrayList;
import java.util.HashMap;

public class duplicate {
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

    public static ArrayList<Node> duplicates(Node root) {
        HashMap<String, Integer> map = new HashMap<>();
        ArrayList<Node> duplicate = new ArrayList<>();
        duplicatehelper(root, map, duplicate);
        return duplicate;
    }

    public static String duplicatehelper(Node root, HashMap<String, Integer> map, ArrayList<Node> duplicate) {
        // root ==null return empty string
        if (root == null) {
            return " ";
        }
        // left aur right pure binary tree ma search krna hai
        String left = duplicatehelper(root.left, map, duplicate);
        String right = duplicatehelper(root.right, map, duplicate);

        // preorder ma subtree ko arrange kr dena hai
        String structure = root.data + " " + left + " " + right;

        // update the frequency of this subtree structure in the hashmap
        // agar ek baar aya to 0+1 = 1, 2 baar aya to 1+1 =2
        map.put(structure, map.getOrDefault(structure, 0) + 1);

        // agar 2 baar aa gya to duplicate naam ka arraylist ma put kr den hai
        if (map.get(structure) == 2) {
            duplicate.add(root);
        }
        // return krna hai jo 2 element aye
        return structure;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(2);
        root.right.right = new Node(4);
        root.right.left.left = new Node(4);

        ArrayList<Node> duplicates = duplicates(root);
        for (Node node : duplicates) {
            System.out.println(node.data);
        }
    }
}
