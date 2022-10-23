package LinkList;

/**
 * @ClassName:mergeTwoLinkedLists
 * @Auther: yyj
 * @Description:
 * @Date: 23/10/2022 12:14
 * @Version: v1.0
 */
public class mergeTwoLinkedLists {
    static class ListNode<T> {
        ListNode(T x) {
            value = x;
        }
        T value;
        ListNode<T> next;
    }


    /**
     * For l1 = [1, 2, 3] and l2 = [4, 5, 6], the output should be
     * solution(l1, l2) = [1, 2, 3, 4, 5, 6];
     * For l1 = [1, 1, 2, 4] and l2 = [0, 3, 5], the output should be
     * solution(l1, l2) = [0, 1, 1, 2, 3, 4, 5].
     * */

    public static void main(String[] args) {
        mergeTwoLinkedLists test = new mergeTwoLinkedLists();
        ListNode<Integer> node = new ListNode<>(1);
        node.next = new ListNode<>(1);
        node.next.next = new ListNode<>(2);
        node.next.next.next = new ListNode<>(4);

        ListNode<Integer> node2 = new ListNode<>(0);
        node2.next = new ListNode<>(3);
        node2.next.next = new ListNode<>(5);
        test.solution(node,node2);
    }

    /**
     *
     * same question in leetcode
     * https://leetcode.com/problems/merge-two-sorted-lists/
     * */

    ListNode<Integer> solution(ListNode<Integer> l1, ListNode<Integer> l2) {
        if (l1 == null && l2 == null) return null;
        ListNode<Integer> mergeList = new ListNode<Integer>(-1);
        ListNode<Integer> head = mergeList;
        while (l1 != null && l2 != null) {
            if (l1.value < l2.value) {
                mergeList.next = l1;
                l1 = l1.next;
            } else {
                mergeList.next = l2;
                l2 = l2.next;
            }
            mergeList = mergeList.next;
        }
        if (l1 != null) {
            mergeList.next = l1;
        }
        if (l2 != null) {
            mergeList.next = l2;
        }
        return head.next;
    }

}
