package Trees;

import java.util.LinkedList;

public class BinaryTrees {

    static class Node {
        char val;
        Node left, right;
        Node(char val) {
            this.val = val;
        }
    }

    static class BinaryTree {
        Node root;
    }

    public static void main(String[] args) {
//        BinaryTree tree = new BinaryTree();
//        tree.root = new Node('a');
//        tree.root.left = new Node('b');
//        tree.root.right = new Node('e');
//        tree.root.left.left = new Node('c');
//        tree.root.left.right = new Node('d');
//        tree.root.right.right = new Node('f');
//
//        dfs(tree.root);

        BinaryTree tree = new BinaryTree();
        tree.root = new Node('j');
        tree.root.left = new Node('f');
        tree.root.right = new Node('k');
        tree.root.left.left = new Node('a');
        tree.root.left.right = new Node('h');
        tree.root.right.right = new Node('z');

//        dfs(tree.root);
        dfs2(tree.root);
//        bfs(tree.root);

    }

    /**
     * N = num de nodes
     *       tree
     *       ----
     *           j    <-- root
     *         /   \
     *        f      k
     *      /   \      \
     *     a     h      z    <-- leaves
     *   /   \     \
     *  1     2     3    <-- leaves
     */

    static void dfs(Node node) {
        if (node == null) {
            return;
        }

        System.out.print(node.val);
        dfs(node.left);
        dfs(node.right);
    }

    /**
     * N = num de nodes
     *       tree
     *       ----
     *           j    <-- root
     *         /   \
     *        f      k
     *      /   \      \
     *     a     h      z    <-- leaves
     *   /   \     \
     *  1     2     3    <-- leaves
     */

    static void dfs2(Node root) {
        if (root == null) {
            return;
        }

        LinkedList<Node> queue = new LinkedList<>();
        queue.addLast(root);

        while (!queue.isEmpty()) {
            Node current = queue.removeFirst();
            if (current == null) {
                continue;
            }

            System.out.print(current.val);
            queue.addFirst(current.right);
            queue.addFirst(current.left);
        }
    }

    /**
     * N = num de nodes
     *       tree
     *       ----
     *        j    <-- root
     *      /   \
     *     f      k
     *   /   \      \
     *  a     h      z    <-- leaves
     *
     *  0,  == j
     *  j,     f,k
     *  f,     k, a, h
     *  k,     a,h,z
     *  a,     h,z
     *  h,     z,
     *  z,
     *
     */

    static void bfs (Node root) {
        if (root == null) {
            return;
        }

        LinkedList<Node> queue = new LinkedList<>();
        queue.addLast(root);

        while (!queue.isEmpty()) {
            Node current = queue.removeFirst();
            if (current == null) {
                continue;
            }
            System.out.println(current.val);
            queue.addLast(current.left);
            queue.addLast(current.right);
        }
    }
}
