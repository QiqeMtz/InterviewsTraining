package CodingProblems;

import java.util.*;
/*

    A <-> B <-> C
          D <-> F <-> G
          E <-> H <-> I <-> J


             A
           / | \
          /  |  \
         /   |   \
        /    |    \
       B     D     E
      /     /     /
     C     F     H
          /     /
         G     I
              /
             J


         func(C, D)
            result: A
 */

class ShortestParent {

    public static void main(String[] args) {

    }

    static class Node<T> {
        private T val;
        private Node<T> parent;
        private List<Node<T>> children;
        private int level;
        public Node(T val) {
            this.val = val;
            this.children = new ArrayList<>();
        }

        List<Node<T>> getChildren(){
            return children;
        }

        T getVal(){
            return val;
        }
    }

    interface Ancestor<T> {
        Node<T> getAncestor(Node<T> a, Node<T> b);
    }

    class AncestorImpl<T> implements Ancestor<T> {
        public Node<T> getAncestor(Node<T> a, Node<T> b) {
            Node<T> root = getRoot(a);
            updateLevels(root, -1);

            updateLevels(a);
            updateLevels(b);

            return commonAncestor(a, b);
        }


        Node<T> commonAncestor(Node<T> a, Node<T> b) {
            Node<T> cursorA = a;
            Node<T> cursorB = b;

            while(!cursorA.val.equals(cursorB.val)) {

                if(cursorA.level > cursorB.level){
                    cursorA = cursorA.parent;
                } else if(cursorA.level < cursorB.level) {
                    cursorB = cursorB.parent;
                } else {
                    cursorA = cursorA.parent;
                    cursorB = cursorB.parent;
                }
            }
            return cursorA;
        }

        int updateLevels(Node<T> node) {
            if(node == null) {
                return -1;
            }

            int level = updateLevels(node.parent) + 1;

            return node.level = level;
        }

        Node<T> getRoot(Node<T> node){
            Node<T> cursor = node;
            while(cursor.parent!=null){
                cursor = cursor.parent;
            }
            return cursor;
        }

        void updateLevels(Node<T> node, int level) {
            if(node == null) {
                return;
            }

            node.level = ++level;

            for(Node<T> child: node.children) {
                updateLevels(child, level);
            }
        }
    }
}



