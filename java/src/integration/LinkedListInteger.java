/**
 * 用一个单链表表示一个整数，以199为例：
 * 1->9->9
 * 现在要对这个整数进行加1操作，最后结果应为：
 * 2->0->0
 * 解题思路：
 * 利用递归来遍历单链表，由于加法必须只能在最后一位进行，所以需要一直遍历到最后一个节点。
 * 对最后一个节点进行累加时需要判断是否会发生进位，需要把进位状态返回给调用层。外层的调用层逐层检查处理后续节点时是否发生了进位，若发生自身也需要加1，以此类推。
 * 最后在主函数中，判断头节点是否发生累加进位，如果发生就需要重新拉一个头节点。
 * 解题思路2:
 * 利用循环来查找链表中最后一个不为9的节点
 * 如果找到了，则将其加1，然后将其后的所有节点都置为0。此操作模拟的是进位场景，如19199，此时找到第二个1将其加1并将后面两位置0和在最后1为加1在递推进位的效果是一样的。
 * 如果没有找到，说明整个链表都是9，直接创建一个值为1的头节点，作为新的链表头，然后将链表原有的数都置为0即可。比如链表是999，直接在最后一位相加在进位，和直接挂一个1然后其他置零的效果是一样的。
 */
package integration;

public class LinkedListInteger {
    public static class Node {
        int value;
        Node next;
    }

    public static void main(String[] args) {
        // // 初始化部分，构造一个单链表整数，以199为例
        // Node heatNode = new Node();
        // heatNode.value = 1;
        // Node tempNode = new Node();
        // tempNode.value = 9;
        // heatNode.next = tempNode;
        // tempNode.next = new Node();
        // tempNode.next.value = 9;
        // 初始化部分，构造一个单链表整数，以199为例
        Node heatNode = new Node();
        heatNode.value = 9;
        Node tempNode = new Node();
        tempNode.value = 9;
        heatNode.next = tempNode;

        print("操作前的单链表", heatNode);

        // 计算部分，以累加场景为例
        if (addition(heatNode)) {
            Node newHeatNode = new Node();
            newHeatNode.value = 1;
            newHeatNode.next = heatNode;
            heatNode = newHeatNode;
        }

        print("操作后的单链表", heatNode);
    }

    private static boolean addition(Node node) {
        // 等于null说明是最后一个节点
        if (node.next == null) {
            if (node.value == 9) {
                node.value = 0;
                return true;
            }
            node.value++;
            return false;
        }
        if (addition(node.next)) {
            if (node.value == 9) {
                node.value = 0;
                return true;
            }
            node.value++;
            return false;
        }
        return false;
    }

    private static void print(String title, Node heatNode) {
        if (heatNode == null) {
            return;
        }
        System.out.printf(title);
        do {
            System.out.print(heatNode.value);
            if (heatNode.next == null) {
                break;
            }
            heatNode = heatNode.next;
        } while (true);
        System.out.print("\n");
    }
}