public class MirrorImage{
  
  public static void main(String[] args) {

    int[] nodeValues = new int[]{6,4,2,1,8,9,7,5,3};
    int[] mirrorNodeValues = new int[]{6,4,2,1,9,8,7,5,3};
    
    MirrorImage mi = new MirrorImage();
    //MirrorImage mmi = new MirrorImage();
    //MirrorImage mmi = new MirrorImage();
    
    mi.createTree(nodeValues);

    mi.createMirrorTree(mirrorNodeValues);
    
    /*mi.addNode(6);
    mi.addNode(4);
    mi.addNode(2);
    mi.addNode(1);
    mi.addNode(8);
    mi.addNode(9);
    mi.addNode(7);
    mi.addNode(5);
    mi.addNode(3);
    */
    mi.inOrder(mi.root);

    System.out.println();

    mi.inOrder(mi.mirrorRoot);
    
    System.out.println();

    System.out.println(mi.height(mi.root));

    mi.printLevel();

    System.out.println();
    System.out.println(mi.checkMirror(mi.root, mi.mirrorRoot));

    System.out.println();
  }

  Node root;
  Node mirrorRoot;

  public void addNode(int value){
    Node newNode = new Node(value);
      if (root == null) {
        root = newNode;
      }else{
        Node focusNode = root;
        Node parent;
        while(true){
          parent = focusNode;
          if (value < focusNode.value) {
            focusNode = focusNode.left;
            if (focusNode == null) {
              parent.left = newNode;
              return;
            }
          }else{
            focusNode = focusNode.right;
            if (focusNode == null) {
              parent.right = newNode;
              return;
            }
          }
        }
      }
  }

  public void createTree(int[] nodeValues){
    for (int value : nodeValues) {
      Node newNode = new Node(value);
      if (root == null) {
        root = newNode;
      }else{
        Node focusNode = root;
        Node parent;
        while(true){
          parent = focusNode;
          if (value < focusNode.value) {
            focusNode = focusNode.left;
            if (focusNode == null) {
              parent.left = newNode;
              break;
            }
          }else{
            focusNode = focusNode.right;
            if (focusNode == null) {
              parent.right = newNode;
              break;
            }
          }
        }
      }
    }
  }

  public void createMirrorTree(int[] nodeValues){
    for (int value : nodeValues) {
      Node newNode = new Node(value);
      if (mirrorRoot == null) {
        mirrorRoot = newNode;
      }else{
        Node focusNode = mirrorRoot;
        Node parent;
        while(true){
          parent = focusNode;
          if (value < focusNode.value) {
            focusNode = focusNode.right;
            if (focusNode == null) {
              parent.right = newNode;
              break;
            }
          }else{
            focusNode = focusNode.left;
            if (focusNode == null) {
              parent.left = newNode;
              break;
            }
          }
        }
      }
    }
  }

  public boolean checkMirror(Node root, Node mirrorRoot){
    if (root == null && mirrorRoot == null) {
      return true;
    }
    if (root != null && mirrorRoot != null && root.value == mirrorRoot.value) {
      return (checkMirror(root.left, mirrorRoot.right) && checkMirror(root.right, mirrorRoot.left));
    }
    return false;
  }

  public void inOrder(Node focusNode){
    if (focusNode != null) {
      inOrder(focusNode.left);
      System.out.print(focusNode);
      inOrder(focusNode.right);
    }
  }

  public void preOrder(Node focusNode){
    if (focusNode != null) {
      System.out.println(focusNode);
      preOrder(focusNode.left);
      preOrder(focusNode.right);
    }
  }

  public void postOrder(Node focusNode){
    if (focusNode != null) {
      preOrder(focusNode.left);
      preOrder(focusNode.right);
      System.out.println(focusNode);
    }
  }

  public int height(Node focusNode){
    if (focusNode != null) {
      int leftHeigth = height(focusNode.left);
      int rightHeigth = height(focusNode.right);
      if (leftHeigth > rightHeigth) {
        return leftHeigth+1;
      }else{
        return rightHeigth+1;
      }
    }else{
      return 0;
    }
  }

  public void printLevel(){
    int height = height(root);
    for (int i=1; i<height; i++) {
      printLevel(root, i);
    }
  }

  public void printLevel(Node focusNode, int level){
    if (focusNode == null) {
      return;
    }
    if (level == 1) {
      System.out.print(focusNode.value + " | ");
    }else if (level > 1) {
      System.out.println("\n");
      
      printLevel(focusNode.left, level-1);
      printLevel(focusNode.right, level-1);
    }
  }

}

class Node{
  Node left, right;
  int value;

  public Node(int value){
    this.value = value;
  }

  public String toString(){
    return " | "+value;
  }
}
