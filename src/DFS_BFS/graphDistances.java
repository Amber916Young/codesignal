package DFS_BFS;

import java.util.*;

/**
 * @ClassName:graphDistances
 * @Auther: yyj
 * @Description:
 * @Date: 22/10/2022 12:57
 * @Version: v1.0
 */
public class graphDistances {


    /*
    *
    * For
        g = [[-1, 3, 2],
             [2, -1, 0],
             [-1, 0, -1]]
        and s = 0, the output should be
        solution(g, s) = [0, 2, 2].
    **/



    public static void main(String[] args) {
        graphDistances test = new graphDistances();
        int[][] mat = new int[][]{
                {-1, 0, 0, 0},
                {-1, -1, -1, 30},
                {1, 1, -1, 1},
                {2, 2, 0, -1}
        };
        test.solution(mat, 3);
    }
//    Dijkstra's algorithm
    int[] solution(int[][] g, int s) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for(int i = 0 ; i< g.length;i++){
            for(int j = 0 ; j< g[0].length;j++){
                if( g[i][j] == -1) continue;
                if (!graph.containsKey(i)) {
                    graph.put(i, new LinkedList<int[]>());
                }
                graph.get(i).add(new int[]{j, g[i][j]});

            }
        }
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        queue.add(new int[]{s, 0});

        Map<Integer, Integer> res = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int source = cur[0];
            int w = cur[1];
            if(visited.contains(source)) continue;
            if(!graph.containsKey(source)) continue;

            int min = Integer.MAX_VALUE;
            if(res.containsKey(source)){
                min = Math.min(res.get(source),w);
                res.put(source,min);
            }else {
                res.put(source,w);
            }
            visited.add(source);
            for(int[] i : graph.get(source)){
                queue.add(new int[]{i[0],w+i[1]});
            }
        }
        int[] ans = new int[res.size()];
        for(Map.Entry<Integer, Integer>  keyS : res.entrySet()){
            int key = keyS.getKey();
            int w = keyS.getValue();
            ans[key] = w;
        }

        return ans;


    }
}
