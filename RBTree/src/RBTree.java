public class RBTree<K extends Comparable<K>, V> {
    public static final boolean RED = true;
    public static final boolean BLACK = false;

    private class Node {
        private K key;
        private V value;
        private Node left,right;
        private boolean color;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
            this.color = RED;
        }
    }

    private Node root;
    private int size;

    public RBTree() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean empty() {
        return size == 0;
    }

    // 左旋转  
    //   node                     x
    //  /   \     左旋转         /  \
    // T1   x   --------->   node   T3
    //     / \              /   \
    //    T2 T3            T1   T2
    public Node leftRotate(Node node) {
        Node x = node.right;

        node.right = x.left;
        x.left = node;

        x.color = node.color;
        node.color = RED;

        return x;
    }

    // 右旋转
    //     node                   x
    //    /   \     右旋转       /  \
    //   x    T2   ------->   y   node
    //  / \                       /  \
    // y  T1                     T1  T2
    public Node rightRotate(Node node) {
        Node x = node.left;

        node.left = x.right;
        x.right = node;

        x.color = node.color;
        node.color = RED;
        
        return x;
    }

    private Node add(Node node, K key, V value) {
        if (node == null) {
            size++;
            return new Node(key, value);
        }

        if (key.compareTo(node.key) < 0) 
            node.left = add(node.left, key, value);
        else if (key.compareTo(node.key) > 0) 
            node.right = add(node.right, key, value);
        else 
            node.value = value;
        return node;
    }

    private Node remove(Node node, K key) {
        if (node == null)
            return null;
        if (key.compareTo(node.key) < 0) {
            node.left = remove(node.left, key);
            return node;
        } else if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
            return node;
        } else { // node.key.compareTo(key) ==0 的情况
            if (node.left == null) {
                Node tmpNode = node.right;
                node.right = null;
                size--;
                return tmpNode;
            }
            if (node.right == null) {
                Node tmpNode = node.left;
                node.left = null;
                size--;
                return tmpNode;
            }

            // 找右子树的最小节点
            Node min = min(node.right);
            min.right = removeMin(node.right);
            min.left = node.left;

            node.left = node.right = null;
            return min;
        }
    }

    private Node removeMin(Node node) {
        if (node == null)
            return null;
        if (node.left == null) {
            Node tmpNode = node.right;
            node.right = null;
            size--;
            return tmpNode;
        } 
        node.left = removeMin(node.left);
        return node;
    }

    private Node min(Node node) {
        if (node.left == null) 
            return node;
        return min(node.left);
    }

    private Node getNode(Node node,K key) {
        
        if (node == null) 
            return null;
        
        if (key.equals(node.key)) 
            return node;
        else if (key.compareTo(node.key) < 0) 
            return getNode(node.left, key);
        else    
            return getNode(node.right, key);

        // System.out.println("ddd");

        // if (key.compareTo(node.key) < 0) 
        //     return getNode(node.left, key);
        // else if (key.compareTo(node.key) > 0) 
        //     return getNode(node.right, key);
        // else 
        //     return node;

    }
}