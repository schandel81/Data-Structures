import java.util.*;
import java.util.stream.Collectors;

class Node {
    int val;
    Node left;
    Node right;

    Node(int val) {
        this.val = val;
        left = null;
        right = null;
    }
}
class QueueNode {
    Node node;
    int hd;
    QueueNode(Node node, int hd) {
        this.node = node;
        this.hd = hd;
    }
}
public class BinaryTree {
    void inorderTraversal(Node root) {
        if (root == null)
            return;
        inorderTraversal(root.left);
        System.out.println(root.val);
        inorderTraversal(root.right);
    }

    void preorderTraversal(Node root) {
        if (root == null)
            return;
        System.out.println(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }

    void postorderTraversal(Node root) {
        if (root == null)
            return;
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        System.out.println(root.val);
    }
void postorderTraversal1(Node root) {
        if(root == null)
            return;
        postorderTraversal1(root.left);
        postorderTraversal1(root.right);

}
    void levelOrderTraversal(Node root) {
        if (root == null)
            return;
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        while (!q.isEmpty()) {
            Node temp = q.remove();
            System.out.println(temp.val);
            if (temp.left != null)
                q.add(temp.left);
            if (temp.right != null)
                q.add(temp.right);
        }
    }
    void zigzagTraversal(Node root) {
        if (root == null)
            return;
        boolean leftToRight = true;
        Queue<Node> q = new LinkedList<Node>();
        Stack<Node> s = new Stack<Node>();
        q.add(root);
        while (!q.isEmpty() || !s.isEmpty()) {
            while (!q.isEmpty()) {
                Node temp = q.remove();
                System.out.println(temp.val);
                if (temp.left != null)
                    s.push(temp.left);
                if (temp.right != null)
                    s.push(temp.right);
            }
            while (!s.isEmpty()) {
                Node temp = s.pop();
                System.out.println(temp.val);
                if (temp.left != null)
                    q.add(temp.left);
                if (temp.right != null)
                    q.add(temp.right);
            }
        }
    }
    void topView(Node root, boolean isBottonView) {
        if(root == null)
            return;
        Queue<QueueNode> q = new LinkedList<QueueNode>();
        HashMap<Integer, Node> hashmap = new HashMap<Integer, Node>();
        q.add(new QueueNode(root, 0));
        while (!q.isEmpty()) {
            QueueNode temp = q.remove();
            if(isBottonView)
                hashmap.put(temp.hd, temp.node);
            else {
                if (!hashmap.containsKey(temp.hd))
                    hashmap.put(temp.hd, temp.node);
            }
            if(temp.node.left != null)
                q.add(new QueueNode(temp.node.left, temp.hd - 1));
            if(temp.node.right != null)
                q.add(new QueueNode(temp.node.right, temp.hd + 1));
        }
        List<Integer> hdSet = hashmap.keySet().stream().collect(Collectors.toList());
        Collections.sort(hdSet);
        for(int x: hdSet) {
            System.out.println(hashmap.get(x).val);
        }
    }
    void leftView(Node root, boolean isRightView) {
        if(root == null)
            return;
        Queue<QueueNode> q = new LinkedList<QueueNode>();
        HashMap<Integer, Node> hashmap = new HashMap<Integer, Node>();
        q.add(new QueueNode(root, 0));
        while (!q.isEmpty()) {
            QueueNode temp = q.remove();
            if(isRightView)
                hashmap.put(temp.hd, temp.node);
            else {
                if (!hashmap.containsKey(temp.hd))
                    hashmap.put(temp.hd, temp.node);
            }
            if(temp.node.left != null)
                q.add(new QueueNode(temp.node.left, temp.hd + 1));
            if(temp.node.right != null)
                q.add(new QueueNode(temp.node.right, temp.hd + 1));
        }
        List<Integer> hdSet = hashmap.keySet().stream().collect(Collectors.toList());
        Collections.sort(hdSet);
        for(int x: hdSet) {
            System.out.println(hashmap.get(x).val);
        }
    }
    int height(Node root)
    {
        if(root == null)
            return 0;
        return (1 + Math.max(height(root.left),height(root.right)));
    }
    int diameter(Node root) {
        if(root == null)
            return 0;
        int lheight = height(root.left);
        int rheight = height(root.right);
        int ldiameter = diameter(root.left);
        int rdiameter = diameter(root.right);
        return Math.max((lheight + rheight + 1), Math.max(ldiameter, rdiameter));
    }
    boolean areIdentical(Node root1, Node root2) {
        if(root1 == null && root2 == null)
            return true;
        if(root1 != null && root2 != null) {
            areIdentical(root1.left, root2.left);
            areIdentical(root1.right, root2.right);
        }
        return false;
    }
    void printLeft(Node root) {
        if(root == null)
            return;
        if(root.left != null) {
            System.out.println(root.val);
            printLeft(root.left);
        }
        else if(root.right != null)
        {
            System.out.println(root.val);
            printLeft(root.right);
        }
    }
    void printRight(Node root) {
        if(root == null)
            return;
        if(root.left != null) {
            printRight(root.left);
            System.out.println(root.val);
        }
        else if(root.right != null)
        {
            printRight(root.right);
            System.out.println(root.val);
        }
    }
    void printLeaves(Node root) {
        if(root == null)
            return;
        printLeaves(root.left);
        if(root.left == null && root.right == null)
            System.out.println(root.val);
        printLeaves(root.right);
    }
    void boundaryTraversal(Node root) {
        if(root == null)
            return;
        System.out.println(root.val);
        printLeft(root.left);
        printLeaves(root);
        printRight(root.right);
    }
    //Minimum depth can be solved by Level order traversal
    //Connect nodes at same level -- Can be solved by Level order traversal
    //Sum Tree
    boolean findPath(Node root, ArrayList<Integer> path, int n) {
        if(root == null)
            return false;
        path.add(root.val);
        if(root.val == n)
            return true;
        if(root.left != null && findPath(root.left, path, n))
            return true;
        if(root.right != null && findPath(root.left, path, n))
            return true;
        path.remove(path.size()-1);
        return false;
    }
    void lcaBinaryTree(Node root, int a, int b) {
        ArrayList<Integer> la = new ArrayList<Integer>();
        if(!findPath(root, la, a)) {
            System.out.println("No Path Found");
            return;
        }
        ArrayList<Integer> lb = new ArrayList<Integer>();
        if(!findPath(root, lb, b)) {
            System.out.println("No Path Found");
            return;
        }
        int i = 0;
        while(i < la.size() && i < lb.size())
        {
            if(la.get(i) != lb.get(i))
                break;
        }
        System.out.println("LCA : "+ la.get(i-1));
    }

}
