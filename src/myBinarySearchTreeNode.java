class myBinarySearchTreeNode{
  int myValue;
  myBinarySearchTreeNode left;
  myBinarySearchTreeNode right;
    
  myBinarySearchTreeNode(int inValue){
    // created a new node with empty child pointers
    myValue = inValue;
    right = null;
    left = null;
  }
  
  myBinarySearchTreeNode(int[] A){
    // creates a new Binary Search Tree rooted at the first value in the array
    /// by inserting elements into the tree in the order they are given in A.
    myValue = A[0];
    for(int i = 1; i < A.length; i++) {
      insert(A[i]);
    }
  }
  
  public void insert(int inValue) {
    // This method takes a new integer as input and decides 
    // if it should be place: 
    //    * as the left child,
    //    * as the right child, 
    //    * in the left subtree,
    //    * or in the right subtree.
    // If the value already exists in the tree, no action is taken. 
    if (inValue >= myValue) {
      if (right == null) {
        right = new myBinarySearchTreeNode(inValue);
      }
      else {
        right.insert(inValue);
      }
    }
    else {
      if (left == null) {
        left = new myBinarySearchTreeNode(inValue);
      }
      else {
        left.insert(inValue);
      }
    }
  }
  
  public int height() {
     // This method recursively calculates the height of the entire (sub)tree.
     // This method will take O(n) time
    int leftBro = 0;
    int rightBro = 0;

    if(left != null) {
      leftBro = 1 + left.height();
    }
    if(right != null) {
      rightBro = 1 + right.height();
    }
    if (leftBro < rightBro) {
      return rightBro;
    }
     return leftBro;
  }
  
  public int depth(int search){
     // This method recursively calculates the depth of a given search value. 
     // If the given value is not in the tree, this method returns -1. 
     // Note that if the tree is a proper BST, this method should complete in O(log n) time.
     // Additionally, remember that the depth is the number of nodes on the path from a node to the root 
     // (i.e. the number of the recursie calls).
    if(search < myValue && left != null) {
      return 1 + left.depth(search);
    }
    if(search > myValue && right != null) {
      return 1 + right.depth(search);
    }
    if(search == myValue) {
      return 0;
    }
    return -1;
  }

  //Counts each node in the tree to output size of tree
  public int size() {
    int leftSum = 0;
    int rightSum = 0;

    if (left != null) {
      leftSum = left.size();
    }
    if (right != null) {
      rightSum = right.size();
    }
    return 1 + leftSum + rightSum;
  }

    // Utility function included so you can debug your solution.
  public void print() { print(""); }
  private void print(String prefix) {
    System.out.println(prefix + myValue);
    prefix = prefix.replace('\u251C', '\u2502');
    prefix = prefix.replace('\u2514', ' ');
    if(left != null) left.print(prefix + "\u251C ");
    if(right != null) right.print(prefix + "\u2514 ");
  }
}