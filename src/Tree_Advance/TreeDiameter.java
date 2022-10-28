package Tree_Advance;

import java.util.*;

/**
 * @ClassName:TreeDiameter
 * @Auther: yyj
 * @Description:
 * @Date: 28/10/2022 11:04
 * @Version: v1.0
 */
public class TreeDiameter {
    public static void main(String[] args) {
        TreeDiameter test = new TreeDiameter();
        //tree = [[2, 5], [5, 7], [5, 1], [1, 9], [1, 0], [7, 6], [6, 3], [3, 8], [8, 4]]
        test.solution(10, new int[][]{{2,5},{5,7},{5,1},{1, 9},{1, 0},{7, 6},{6, 3},{3, 8},{8, 4}} );

    }


    int len = Integer.MIN_VALUE;
    int solution(int n, int[][] tree) {
        if(n == 1 && tree.length == 0) return 0;
        HashSet<Integer> startTree = new HashSet<>();
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] g : tree) {
            int source = g[1];
            int dest = g[0];
            graph[source].add(dest);
            graph[dest].add(source);
        }
        for(int i =0 ;i<graph.length ;i++){
            if(graph[i].size() == 1) startTree.add(i);
        }
        for(int i : startTree){
            int depth = 0;
            int parent = -1;
            TreeDiameter_DFS(i,graph, depth,parent);
        }
        return len;
    }


    private void TreeDiameter_DFS(int start, List<Integer>[] graph, int depth, int parent) {
        for (Integer tree : graph[start]) {
            if (tree == parent) continue; // without this condition will LTE
            len = Math.max(depth + 1, len);
            TreeDiameter_DFS(tree, graph, depth + 1, start);
        }
    }

}
