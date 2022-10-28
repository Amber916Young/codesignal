package Tree_Advance;

import java.util.*;

/**
 * @ClassName:mostFrequentSum
 * @Auther: yyj
 * @Description: https://app.codesignal.com/interview-practice/question/9i2KvkNRzncy7Bzia/description
 * and https://leetcode.com/problems/most-frequent-subtree-sum/
 * @Date: 28/10/2022 13:25
 * @Version: v1.0
 */

// Binary trees are already defined with this interface:
class Tree<T> {
   Tree(T x) {
     value = x;
   }
   T value;
   Tree<T> left;
   Tree<T> right;
 }
public class mostFrequentSum {

    public static void main(String[] args) {
        mostFrequentSum test = new mostFrequentSum();
        Tree tree = new Tree(5);
        tree.left = new Tree(2);
        tree.right = new Tree(-3);
        tree.right.left = new Tree(10);
        tree.right.right = new Tree(4);
        test.solution(tree );

    }
    HashMap<Integer,Integer> map = new HashMap<>();
    int max = 0;
    int[] solution(Tree<Integer> node) {
        mostFrequentSum_DFS(node);
        List<Integer> ans = new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            int key = entry.getKey();
            int val = entry.getValue();
            if(val == max) ans.add(key);
        }
        //利用 Java8 的 stream()
        int[] res = ans.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(res);
        return res;
    }

    private int mostFrequentSum_DFS(Tree<Integer> node) {
        if(node == null) return 0 ;
        int num=0;
        num += mostFrequentSum_DFS(node.left) + mostFrequentSum_DFS(node.right) + node.value ;
        System.out.println(num);
        int times = map.getOrDefault(num,0)+1;
        map.put(num,times);
        max = Math.max(times,max);
        return num;
    }


}
