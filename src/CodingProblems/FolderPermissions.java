package CodingProblems;

import java.util.*;

/**
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

        /*
        A <- B <- C
          <- D
          <- E <- F <- G
         */
        List<String[]> directories =  new LinkedList<>();
        directories.add (new String[]{"A", null}); // root
        directories.add (new String[]{"B", "A"});
        directories.add (new String[]{"C", "B"});
        directories.add (new String[]{"D", "A"});
        directories.add (new String[]{"E", "A"});
        directories.add (new String[]{"F", "E"});
        directories.add (new String[]{"G", "F"});

        Set<String> access = new HashSet<>();
//        access.add("B");
        access.add("E");

        Set<String> noInheritance = new HashSet<>();
        access.add("F");

        Tree treeFolder = new Tree(access, directories, noInheritance);
        treeFolder.printAccessAndInheritanceSets();

        System.out.println(treeFolder.hasAccess("B"));
        System.out.println(treeFolder.hasAccess("C"));
        System.out.println(treeFolder.hasAccess("A"));
        System.out.println(treeFolder.hasAccess("G"));

    }

    /**
     * Class to represente each node in a Tree structure
     * this representation has a special field called access
     * to indicate if has whether or not access
     */
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

    /**
     * Class to represent a Tree structure
     */
    static class Tree {
        Node root;
        Map<String, Node> dMap = new HashMap<>();
        Set<String> noInheritance;
        Set<String> access;

        /**
         * Main constructor
         * First populate a Hashmap containing all the nodes of the directory
         * Then check if any node has a parent with access, if true then the node
         * is added to the list of its parent node
         * Also in the second for loop we found the root node
         * At the end we update the children of parent nodes with access flag true
         * to set true their flags, we use the update(method)
         *
         * Then we call the removeConcurrentAccess method to remove concurrent accesses i.e. if C is son of B, and
         * both of them are in the access set, C is a redundant access and needs to be removed
         *
         * Also we have NoInheritance access Set to special designated access, we also check if any Folder Key is
         * inside this set to avoid in the redundant access removal.
         *
         * At the end we clean the access set checking if we have redundant access, keeping in mind that
         * can be noInheritance access and those access must be kept.
         *
         * @param access the Set of accesses
         * @param directory the folder directory
         */
        public Tree(Set<String> access, List<String[]> directory, Set<String> noInheritance){
            this.noInheritance = new HashSet<>(noInheritance);
            this.access = new HashSet<>(access);

            for(String[] link: directory) {
                for(int i = 0; i < 2; i++) {
                    if(link[i] == null)
                        continue;
                    if(dMap.containsKey(link[i]))
                        continue;
                    dMap.put(link[i], new Node(link[i], this.access.contains(link[i])));
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

            cleanRedundantAccess(root, false);

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

        /**
         * Method to update permissions on children folders
         * @param node the node to check it's children permissions
         * @param pAcc previous access boolean flag
         */
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

        /*
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
         */
        void cleanRedundantAccess(Node node, boolean ancestorState) {
            if(node == null)
                return;

            for(Node child : node.children) {
                boolean ancState = ancestorState && noInheritance.contains(child) ? false : ancestorState;
                if (!noInheritance.contains(child)) {
                    cleanRedundantAccess(child, ancState && access.contains(child.val));
                    access.remove(child.val);
                }
            }
        }

        void printAccessAndInheritanceSets() {
            System.out.println("NoInheritance");
            System.out.println(Arrays.toString(noInheritance.toArray()));
            System.out.println("Access");
            System.out.println(Arrays.toString(access.toArray()));
        }

        // Binary Tree
        // void update(Node node) {
        //   if(node==null){
        //     return;
        //   }
        //   update(node.left);
        //   update(node.right);
        // }

        /**
         * Method to check if given a String directory key we have access to this.
         * @param directory the directory string
         * @return true if we have access, if not return false
         */
        boolean hasAccess(String directory){
            return dMap.get(directory).access;
        }
    }
}
