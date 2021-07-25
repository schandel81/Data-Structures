import java.util.ArrayList;
//1,2,3,4,5 k = 4 5-4
public class BinarySearchTree {
    class Node {
        int val;
        Node left;
        Node right;
    }
    //min = Integer.MIN_VALUE max = Integer.MAX_VALUE
    boolean checkBST(Node root, int min, int max) {
        if(root == null)
            return true;
        if(root.val < min || root.val > max)
            return false;
        return checkBST(root.left, min, root.val - 1) && checkBST(root.right, root.val + 1, max);
    }
    void inorderTraversalArray(Node root, ArrayList<Integer> in) {
        if(root == null)
            return;
        inorderTraversalArray(root.left, in);
        in.add(root.val);
        inorderTraversalArray(root.left, in);
    }
    void kLargestElement(Node root, int k) {
        ArrayList<Integer> in = new ArrayList<Integer>();
        inorderTraversalArray(root, in);
        System.out.println(in.get(in.size() - k));
    }
    Node removeElementsOutsideGivenRange(Node root, int min, int max) {
        if(root == null)
            return null;
        root.left = removeElementsOutsideGivenRange(root.left, min, max);
        root.right = removeElementsOutsideGivenRange(root.right, min, max);
        if(root.val < min) {
            Node rchild = root.right;
            root = null;
            return rchild;
        }
        if(root.val > max) {
            Node lchild = root.left;
            root = null;
            return lchild;
        }
        return root; // root in range
    }
    void pairWithGivenTargetSumInBst(Node root, int sum) {
        ArrayList<Integer> in = new ArrayList<Integer>();
        inorderTraversalArray(root, in);
        int i = 0, j = in.size() - 1;
        while(i < j) {
            if(in.get(i) + in.get(j) == sum) {
                System.out.println("Element 1 : " + in.get(i) + " Element 2 : " + in.get(j));
                break;
            }
            if(in.get(i) + in.get(j) > sum)
                j--;
            else
                i++;
        }
        if(i == j) {
           System.out.println("Not found");
        }
    }


}
