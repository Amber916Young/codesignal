package LinkList;

import java.math.BigInteger;
import java.util.Stack;

/**
 * @ClassName:addTwoHugeNumbers
 * @Auther: yyj
 * @Description:
 * @Date: 19/10/2022 17:58
 * @Version: v1.0
 */
public class addTwoHugeNumbers {
    static class ListNode<T> {
        ListNode(T x) {
            value = x;
        }
        T value;
        ListNode<T> next;
    }

    public static void main(String[] args) {
        addTwoHugeNumbers hugeNumbers = new addTwoHugeNumbers();
        ListNode<Integer> node = new ListNode<>(1);
//        node.next = new ListNode<>(4);
//        node.next.next = new ListNode<>(5);
//9998, 9999, 9999, 9999, 9999, 9999
        ListNode<Integer> node2 = new ListNode<>(9998);
        node2.next = new ListNode<>(9999);
        node2.next.next = new ListNode<>(9999);
        node2.next.next .next = new ListNode<>(9999);
        node2.next.next .next .next = new ListNode<>(9999);
        node2.next.next .next .next .next = new ListNode<>(9999);
        hugeNumbers. solution(node,node2);
    }

    /**
     * For a = [9876, 5432, 1999] and b = [1, 8001], the output should be
     * solution(a, b) = [9876, 5434, 0].
     * **/




    /**
     * method 1 complexity
     *
     * **/
    ListNode<Integer> solution(ListNode<Integer> a, ListNode<Integer> b) {
        ListNode<Integer> reverseA = null;
        ListNode<Integer> reverseB = null;

        //reverse node
        while (a != null){
            ListNode<Integer> next = a.next;
            a.next = reverseA;
            reverseA = a;
            a = next;
        }
        while (b != null){
            ListNode<Integer> next = b.next;
            b.next = reverseB;
            reverseB = b;
            b = next;
        }
        ListNode<Integer> ans = new ListNode<>(0);
        ListNode<Integer> cur = ans;
        int count = 0;

        //carry
        while (reverseA != null && reverseB != null){
            int sum = reverseA.value + reverseB.value + count;
            count = String.valueOf(sum).length() >=4 ? String.valueOf(sum).length()  % 4 : 0;
            ListNode<Integer> node ;
            if(count ==0 ){
                node = new ListNode<>(sum);
            }else {
                node = new ListNode<>(sum-10000);
            }
            cur.next = node;
            cur = cur.next;
            reverseA = reverseA.next;
            reverseB = reverseB.next;
        }
        while (reverseA != null){
            int sum = reverseA.value + count;
            count = String.valueOf(sum).length() >=4 ? String.valueOf(sum).length()  % 4 : 0;
            ListNode<Integer> node ;
            if(count ==0 ){
                node = new ListNode<>(sum);
            }else {
                node = new ListNode<>(sum-10000);
            }
            cur.next = node;
            cur = cur.next;
            reverseA = reverseA.next;
        }
        while (reverseB != null){
            int sum = reverseB.value + count;
            count = String.valueOf(sum).length() >=4 ? String.valueOf(sum).length()  % 4 : 0;
            ListNode<Integer> node ;
            if(count ==0 ){
                node = new ListNode<>(sum);
            }else {
                node = new ListNode<>(sum-10000);
            }
            cur.next = node;
            cur = cur.next;
            reverseB = reverseB.next;
        }

        if (count == 1){
            cur.next =  new ListNode<>(1);;
        }
        ListNode<Integer> prev = null;
        ans = ans.next;
        while (ans != null){
            ListNode<Integer> next = ans.next;
            ans.next = prev;
            prev = ans;
            ans = next;
        }
        return prev;
    }


    ListNode<Integer> solution2(ListNode<Integer> a, ListNode<Integer> b) {
        Stack<Integer> sa = new Stack<>();
        Stack<Integer> sb = new Stack<>();
        for (ListNode<Integer> n = a; n != null; n = n.next) sa.push(n.value);
        for (ListNode<Integer> n = b; n != null; n = n.next) sb.push(n.value);
        ListNode<Integer> r = null;
        int carry = 0;
        while (!sa.isEmpty() || !sb.isEmpty() || carry > 0) {
            int s = (sa.isEmpty() ? 0 : sa.pop()) + (sb.isEmpty() ? 0 : sb.pop()) + carry;
            ListNode<Integer> n = new ListNode<>(s % 10000);
            n.next = r;
            r = n;
            carry = s / 10000;
        }
        return r;
    }


}
