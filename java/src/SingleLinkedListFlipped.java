/**
 * 单链表翻转
 */
class SingleLinkedListFlipped {
    public static void main(String[] args) {
        // 初始化测试链表
        // 链表头指针
        Node head = new Node(0);
        // 链表的当前指针，指向链表的最后一个节点
        Node cur = head;
        for (int i = 1; i < 10; i++) {
            cur.next = new Node(i);
            cur = cur.next;
        }
        head = flipped(head);
        while (head != null) {
            System.out.println(head.data);
            head = head.next;
        }
    }

    /**
     * 翻转
     */
    private static Node flipped(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        //指向第2个节点
        Node nextNode = head.next;
        //执行翻转时需要将第1个节点的后项指针清空，否则会形成环路
        head.next = null;
        //无后续节点时说明当前head已经是链表的最后一个节点，不需要在循环了
        while (nextNode != null) {
            //第3个节点指针
            Node tempNode = nextNode.next;
            //将2指向1，实现翻转的关键一步
            nextNode.next = head;
            //指针依次后移，此时1号节点已经有2号节点的后项指针指向，所以1不会形成悬空节点，先移动原来指向1号节点的指针。
            head = nextNode;
            //将原来指向2号节点的指针指向第3节点
            nextNode = tempNode;
        }
        return head;
    }
}

// 节点
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}