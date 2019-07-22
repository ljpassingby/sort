import org.junit.Test;

import java.util.ArrayList;

public class TestTreeOrLink {
    @Test
    public void testTreeNode() {
        //二叉树输入比如是以数组第二位开始，也就是索引1
        String[] strings = {"null", "1", "2", "null", "null", "5", "6", "7"};
        TreeNode root = constructTreeNode(strings, 1);
        printTreeNode(root, 0);
        System.out.print(lls);
    }

    @Test
    public void testListNode() {
        ListNode listNode = constructListNode("4213");
        printListNode(listNode);
    }

    //模拟链表
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode constructListNode(String num) {
        ListNode head = null;
        ListNode current = null;
        char[] chs = num.toCharArray();
        for (int i = 0; i < chs.length; ++i) {
            if (head == null) {
                head = new ListNode(chs[i] - 48);
                current = head;
            }else {
                ListNode node = new ListNode(chs[i] - 48);
                current.next = node;
                current = current.next;
            }
        }
        return head;
    }

    public void printListNode(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    //模拟二叉树
    public class TreeNode {
        String val;
        TreeNode left;
        TreeNode right;
        TreeNode(String x) {this.val = x;}
    }

    public TreeNode constructTreeNode(String[] strs, int index) {
        if (index >= strs.length)
            return null;
        TreeNode root = new TreeNode(strs[index]);
        root.left = constructTreeNode(strs, 2 * index);
        root.right = constructTreeNode(strs, 2 * index + 1);
        return root;
    }

    ArrayList<ArrayList<String>> lls = new ArrayList();
    public void printTreeNode(TreeNode root, int index) {
        //层序遍历
        if (lls.size() == index)
            lls.add(new ArrayList());

        lls.get(index).add(root.val);
        if (root.left != null || root.right != null) {
            printTreeNode(root.left, index + 1);
            printTreeNode(root.right, index + 1);
        }

//        先序遍历
//        if (root == null)
//            return;
//        System.out.print(root.val + " ");
//        if (root.left != null && root.right != null) {
//            printTreeNode(root.left);
//            printTreeNode(root.right);
//        }else if (root.left != null) {
//            printTreeNode(root.left);
//            System.out.print("null ");
//        }else if (root.right != null) {
//            System.out.print("null ");
//            printTreeNode(root.right);
//        }
    }
}
