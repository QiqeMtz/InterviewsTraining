package CodingProblems;

import java.io.*;
import java.util.*;

/*
 *
 *

 O(Log2N)
 [9,10,11,12,1,3,4,5,6,7,8,]

 Cache<>


    Access:         E, F, B, G H K
    Access:         E, F, B,

    NoInheretence:  G,  F J
    Access:         E, F, B, G

    STATIC Set<ACCESS;


    Set<sTRING> f( node, boolean ancestorSTATE){
       for(child: node.children){
          ancestorSTATE = ancestorSTATE  &&  NoInheretence.contains(child) ? false: ancesterSTate;
          boolean state =  ancestorSTATE || access.contains(child.value);
          if(!NoInheretence.contains(child)){
            f(ancester && child, access.contains(child.value)){
              ACCESS.delete();
            }
          }
       }
    }

    Access: B
    NoInheretence G

    access G? f
    access H? f
    accc C? t

      A f  f(B,false)
        B t  <------- f(B,TRUE)
          C f       f(G, true)
            G t     f(H, true)
              H t
                I f
                  J f
                    K t
        D f

        E t
          F t

      List<Node> c = node.children;
        set.contains(node.children)
          set.remove(value)


    Access:  B, E


    Directories:
    A <- B <- C -> G -> H
      <- D
      <- E <- F

      Access fixAccess(access, tree){
        Node root = tree.root;
        if(access.contains(root.value))
          return new set(A);


        dfs(Node node)



      /// 1
      Tree Parents
    A <- B <- C <- G <- H
      <- D
      <- E <- F

      Tree
    A -> B -> C -> G -> H
      -> D
      -> E -> F

      Tree
    A <-> B <-> C <-> G <-> H
      <-> D
      <-> E <-> F
  Set<String> access = new HashSet<>();
  access.add("B");
  access.add("F");

  Map<String, Node> map;
  map.put("A", new Node("A"));
  map.put("B", new Node("B"));
  map.put("C", new Node("C"));
  map.put("D", new Node("D"));
  map.put("E", new Node("E"));
  map.put("F", new Node("F"));

  <"C"-> Node("C")>
  <"E"-> Node("F")>
  <"A"-> Node("A") -> B,D,E>
  <"B"-> Node("B") -> C>
  ...

  List<String[]> directories =  new LinkedList<>();
  directories.add (new String[]{"A", null}); // root
  directories.add (new String[]{"B", "A"});
  directories.add (new String[]{"C", "B"});
  directories.add (new String[]{"D", "A"});
  directories.add (new String[]{"E", "A"});
  directories.add (new String[]{"F", "E"});

  Tree createTree(directories):
  O(N)
    A, false
    B, true
    C, false
    D. false
    E. false
    F. true
    return tree;

  updateTree(tree);
  O(N)
  Tree
    A, false
    B, true
    C, true
    D. false
    E. false
    F. true

    O(N)
    new HashMap<String, Node>(tree);
    return tree;

    // O(N) -> O(1)
  boolean hasAccess(String directory);
     return hasMap.get(directory).status;

 */

class FolderPermissions {
    public static void main(String[] args) {
    }

    static class Node {
        String val;
        List<Node> children;
        boolean access;
        public Node(String val, boolean access) {
            this.val = val;
            this.access = access;
            this.children = new ArrayList<>();
        }
    }

    static class Tree {
        Node root;
        Map<String, Node> dMap = new HashMap<>();

        public Tree(Set<String> access, List<String[]> directory){

            for(String[] link: directory) {
                for(int i = 0; i < 2; i++) {
                    if(link[i] == null)
                        continue;
                    if(dMap.containsKey(link[i]))
                        continue;
                    dMap.put(link[i], new Node(link[i],access.contains(link[i])));
                }
            }

            for(String[] link: directory) {
                if(link[1] == null){
                    root = dMap.get(link[0]);
                    continue;
                }
                dMap.get(link[1]).children.add(dMap.get(link[0]));
            }

            update(root, false);

        }
        /**


         A f
         (A, F)
         B.access, <> F
         _________
         (B, T|F)
         C.access | T, F
         G.access |
         H.access | T
         I.access, |
         J.access, |
         K.access, |
         W.access |
         D f

         E t
         F t

         p a R
         T T T
         T F T
         F F F
         F T T
         */

        // update(root, false);

        // N-Tree
        void update(Node node, boolean pAcc) {
            if(node==null){
                return;
            }

            boolean result = pAcc ? true : node.access;
            node.access = result;

            for(Node child: node.children) {
                update(child, result);
            }
        }

        // Binary Tree
        // void update(Node node) {
        //   if(node==null){
        //     return;
        //   }
        //   update(node.left);
        //   update(node.right);
        // }

        boolean hasAccess(String directory){
            return dMap.get(directory).access;
        }
    }
}
