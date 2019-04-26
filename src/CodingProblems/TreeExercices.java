package CodingProblems;

import java.util.ArrayList;
import java.util.List;

/*
int getNumNodes(Node root);
int getMaxHeight(Node root); and minHeight
int maxPathSum(Node root);


    -2 -1     0     1
             3
           / | \
          /  |  \
         /   |   \
        /    |    \
       2    *-3     4
      / \   /     / \
B--> C*  X F     4   1000
          /     /
         G     -2
              /
             -1

 */
public class TreeExercices {
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
}
