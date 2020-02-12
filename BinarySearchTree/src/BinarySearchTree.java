import java.util.Stack;
public class BinarySearchTree<E extends Comparable<E>> {
    private class Node {
        public E e;
        public Node left,right;
        public Node(E e) {
            this.e = e;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;
    private int size;

    public BinarySearchTree() {
        this.root = null;
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E e) {
        root = this.add(root, e);
    }

    private Node add(Node node, E e) {
        if (node == null) 
            return new Node(e);

        if (e.compareTo(node.e) < 0)
            node.left = this.add(node.left, e);
        else if (e.compareTo(node.e) > 0)
            node.right = this.add(node.right, e);
        return node;
    }

    public boolean contains(E e) {
        return contains(root, e);
    }

    private boolean contains(Node node, E e) {
        if (node == null)
            return false;

        if (e.compareTo(node.e) == 0) {
            return true;
        }  else if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else {
            return contains(node.right, e);
        }
    }

    // 前序遍历
    public void preOrder() {
        preOrder(root);
    } 

    private void preOrder(Node node) {
        if (node == null)
            return;

        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    // 非递归前序遍历
    public void preOrderNR() {
        if (root == null)
            return;
        
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.println(cur.e);
            if (cur.right != null)
                stack.push(cur.right);
            if (cur.left != null)
                stack.push(cur.left);
        }
    }

    // 中序遍历
    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null) 
            return;
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    // 后序遍历 
    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node == null)
            return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    // 获取最小值
    public E min() {
        return min(root).e;
    }

    private Node min(Node node) {
        if (node.left == null) 
            return node;

        return min(node.left);
    }

    // 获取最大值
    public E max() {
        return max(root).e;
    }

    private Node max(Node node) {
        if (node.left == null) 
            return node;
        return max(node.right);
    }

    // // 删除最小值 
    // public E delMin() {
    //     Node node = delMin(root);
    //     return node.e;
    // }


    

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        // str.append("null");
        
        generaTreeStr(root, 0, str);
        return str.toString();
    }
    private void generaTreeStr(Node node, int depth, StringBuilder str) {
        if (node == null) {
            str.append(generaString(depth)+"null\n");
            return;
        }
        str.append(generaString(depth) + node.e + "\n");
        generaTreeStr(node.left, depth++, str);
        generaTreeStr(node.right, depth++, str);
    }
    private String generaString(int depth) {
        StringBuilder str = new StringBuilder();
        for (int i=0; i<depth; i++) {
            str.append("--");
        }
        return str.toString();
    }


    public static void main(String[] argv) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        int[] tree = {3,4,5,12,343,8,10,22};
        for (int i=0; i<tree.length; i++) {
            bst.add(tree[i]);
        }

        bst.preOrder();
        System.out.println();
        bst.preOrderNR();

       // System.out.println(bst);
    }
}