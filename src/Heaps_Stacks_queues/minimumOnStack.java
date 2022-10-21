package Heaps_Stacks_queues;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName:minimumOnStack
 * @Auther: yyj
 * @Description:
 * @Date: 21/10/2022 20:34
 * @Version: v1.0
 */
public class minimumOnStack {



    /**
     *
     * For operations = ["push 10", "min", "push 5", "min", "push 8", "min", "pop", "min", "pop", "min"], the output should be
     * solution(operations) = [10, 5, 5, 5, 10].
     *
     * The operations array contains 5 instances of the min operation.
     * The results array contains 5 numbers,
     * each representing the minimum element in the stack at the moment when min was called.
     *
     * **/


    public static void main(String[] args) {
        minimumOnStack test = new minimumOnStack();
        test.solution(new String[]{"push 10", "min", "push 5", "min", "push 8", "min", "pop", "min", "pop", "min"});
    }

    public int getMin( List<Integer> data) {
        if(data.size()==1) return data.get(0);
        int min = Integer.MAX_VALUE;
        for(int i=0;i<data.size();i++){
            min=Math.min( data.get(i),min);
        }
        return min;
    }
    int[] solution(String[] operations) {
        List<Integer> res = new ArrayList<>();
        List<Integer> data = new ArrayList<>();
        for (String operation : operations) {
            String[] ins = operation.split(" ");
            if (ins[0].equals("min")) {
                res.add(getMin(data));
            } else if (ins[0].equals("pop")) {
                if (data.isEmpty()) continue;
                data.remove(data.size() - 1);
            } else if (ins[0].equals("push")) {
                int num =Integer.parseInt(ins[1]);
                data.add(num);
            }
        }
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;

    }
}
