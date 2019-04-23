package Special;

public class BinarySearchTrees {

    /*
     * N = num de nodes
     *            tree     O(Log2N)
     *            ----
     *             10    <-- root
     *         /       \
     *        5         30
     *      /   \     /   \
     *     2     7   20    40    <-- leaves
     *             \
     *              11
     *
     *
     *  1-2-4-5-7-9-10-20-30-40  O(N)
     */

    static class Node {
        int val;
        Node left, right;
        Node (int val) {
            this.val = val;
        }
    }

    static class BinarySearchTree {

    }
}
