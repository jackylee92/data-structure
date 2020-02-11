import java.lang.instrument.IllegalClassFormatException;

public class LinkList<E> {
    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node dummyHead;
    private int size;
    
    public LinkList() {
        dummyHead = new Node();
        size = 0;
    }

    // 返回长度
    public int getSize() {
        return size;
    }

    // 是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    // 添加到指定索引位置 
    public void addByIndex(int index, E e) {
        if (index < 0 || index > size) 
            throw new IllegalArgumentException("Index out of range.");
        Node pre = dummyHead;
        for (int i=0; i<index; i++) 
            pre = pre.next;
    
        Node node = new Node(e);
        node.next = pre.next;
        pre.next = node;
        size++;
    }

     // 添加到头部
     public void addFirst(E e) {
        addByIndex(0, e);
    }

    // 添加到末尾
    public void addLast(E e) {
        addByIndex(size, e);
    }

    // 查找 指定第几个
    public E getByIndex(int index) {
       if (index < 0 || index > size) 
            throw new IllegalArgumentException("Index out of range.");
        Node cur = dummyHead.next;
        for (int i=0; i<index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    // 获取第一个
    public E getFirst() {
        return getByIndex(0);
    }

    // 获取最后一个
    public E getLast() {
        return getByIndex(size-1);
    }

    // 设置
    public void set(int index, E e) {
        if (index < 0 || index > size) 
            throw new IllegalArgumentException("Index out of range.");
        Node cur = dummyHead.next;
        for (int i=0; i<size; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    // 查找元素
    public boolean find(E e) {
        Node cur = dummyHead.next;
        while(cur != null) {
            if (cur.e.equals(e))
                return true;
            cur = cur.next;
        }
        return false;
    }

    // 删除元素
    public E delByIndex(int index) {
        if (index < 0 || index > size) 
            throw new IllegalArgumentException("Index out of range.");
        Node pre = dummyHead;
        for (int i=0; i<index; i++) {
            pre = pre.next;
        }
        Node delNode = pre.next;
        pre.next = delNode.next;
        delNode.next = null;
        return delNode.e;
    }

    // 删除第一个元素
    public E delFirst() {
        return delByIndex(0);
    }

    // 删除最后一个元素
    public E delLast() {
        return delByIndex(size);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        Node cur = dummyHead.next;
        while(cur != null) {
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("NULL");
        return res.toString();
    }

    public static void main(String argv[]) {
        LinkList<Integer> l1 = new LinkList();
        for (int i=0; i< 6; i++) {
            l1.addFirst(i);
            System.out.println(l1);
        }

        l1.addByIndex(3,8888);
        System.out.println(l1);

        System.out.println(l1.find(1));

        l1.delByIndex(3);
        System.out.println(l1);

        l1.delFirst();
        System.out.println(l1);
    }
}