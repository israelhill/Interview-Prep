//Pre-Order:  Root, Left, Right
//Post-Order: Left, Right, Root
//in-order:   Left, Root, Right

public class BST {

  //***************************
  private class TreeNode {
    int value;
    TreeNode leftChild;
    TreeNode rightChild;

    TreeNode(int x) {
      value = x;
    }
  }
  //****************************

  public TreeNode sortedArrayToBST(int[] arr) {
    if (arr.length == 0) {
      return null;
    }
    return sortedArrayToBST(arr, 0, arr.length - 1);
  }

  public TreeNode sortedArrayToBST(int[] arr, int start, int end) {
    if(start > end) {
      return null;
    }

    int middle = (start + end) / 2;
    TreeNode root = new TreeNode(arr[middle]);
    root.leftChild = sortedArrayToBST(arr, start, middle - 1);
    root.rightChild = sortedArrayToBST(arr, middle + 1, end);

    return root;
  }

  public void preOrderTrav(TreeNode node) {
    if(node == null) {
      return;
    }

    System.out.print(node.value + ", ");
    preOrderTrav(node.leftChild);
    preOrderTrav(node.rightChild);
  }

  public static void inOrderTrav(TreeNode node) {
    if(node == null) {
      return;
    }

    inOrderTrav(node.leftChild);
    System.out.print(node.value + ", ");
    inOrderTrav(node.rightChild);
  }

  public static void main(String[] args) {
    BST bst = new BST();
    int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 15, 16, 20};
    TreeNode root = bst.sortedArrayToBST(arr);
    inOrderTrav(root);
  }
}
