package Graphs;

import Strings.strstr;

import java.util.*;

/**
 * @ClassName:hasDeadlock
 * @Auther: yyj
 * @Description:
 * @Date: 25/10/2022 23:46
 * @Version: v1.0
 */
public class hasDeadlock {

    public static void main(String[] args) {
        hasDeadlock test = new hasDeadlock();
         int[][]  nn =  new int[][] {{1},{2},{3,4},{4},{0}};
        test.solution(nn);
    }

    boolean solution(int[][] connections) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] inDegree = new int[connections.length];

        for(int i = 0 ; i < connections.length;i++){
            List<Integer> res = graph.getOrDefault(i, new ArrayList<>());
            for (int k=0;k < connections[i].length;k++){
                res.add(connections[i][k]);
                inDegree[connections[i][k]]++;

            }
            graph.put(i,res);
        }
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < connections.length; i++) {
            if (inDegree[i] == 0) queue.add(i);
        }
        int count = 0;
        while (!queue.isEmpty()){
            int cur = queue.poll();
            if(graph.get(cur) != null) {
                for(int i : graph.get(cur)){
                    inDegree[i]--;
                    if(inDegree[i]==0)queue.add(i);
                }
            }
            count++;
        }

        return count !=connections.length;





    }

}
