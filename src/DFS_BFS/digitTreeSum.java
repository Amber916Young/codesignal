package DFS_BFS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName:digitTreeSum
 * @Auther: yyj
 * @Description:
 * @Date: 22/10/2022 11:21
 * @Version: v1.0
 */
public class digitTreeSum {


    public static void main(String[] args) {
        digitTreeSum test = new digitTreeSum();
        Tree<Integer> node = new Tree<>(1);
        node.left =  new Tree<>(0);
        node.left.right =  new Tree<>(1);
        node.left.left =  new Tree<>(3);

        node.right =  new Tree<>(4);


//        Tree<Integer> node = new Tree<>(0);
//        node.left =  new Tree<>(1);
        test.solution(node);
    }
    /**
     * For
     * t = {
     *     "value": 1,
     *     "left": {
     *         "value": 0,
     *         "left": {
     *             "value": 3,
     *             "left": null,
     *             "right": null
     *         },
     *         "right": {
     *             "value": 1,
     *             "left": null,
     *             "right": null
     *         }
     *     },
     *     "right": {
     *         "value": 4,
     *         "left": null,
     *         "right": null
     *     }
     * }
     * the output should be
     * solution(t) = 218.
     * There are 3 numbers encoded in this tree:
     *
     * Path 1->0->3 encodes 103
     * Path 1->0->1 encodes 101
     * Path 1->4 encodes 14
     * and their sum is 103 + 101 + 14 = 218.
     * **/
    List<List<Integer>> list =new ArrayList<>();
    long solution(Tree<Integer> t) {
        List<Integer> res = new ArrayList<>();

        if (t == null) return 0;
        digitTreeSum_DFS(t,res);
        long ans = 0;
        for(List<Integer> s  : list){
            StringBuilder number= new StringBuilder();
            for(int i: s){
                number.append(i+"");
            }
            ans += Long.parseLong(number.toString());
        }
        return ans;


    }

    private void digitTreeSum_DFS(Tree<Integer> node, List<Integer> res ) {
        if (node == null) return;
        res.add(node.value);
        if (node.left == null && node.right == null) {
            list.add( new ArrayList<>(res));
        }
        digitTreeSum_DFS(node.left,res);
        digitTreeSum_DFS(node.right,res);
        res.remove(res.size() - 1);
    }

}
