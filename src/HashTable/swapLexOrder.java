package HashTable;

import java.util.*;

/**
 * @ClassName:swapLexOrder
 * @Auther: yyj
 * @Description:
 * @Date: 17/10/2022 23:08
 * @Version: v1.0
 */
public class swapLexOrder {
    public static void main(String[] args) {
        swapLexOrder swapLexOrder = new swapLexOrder();

        int[][] nn =  new int[][] {{3,23},{13,28},{15,20},{24,29},{6,7},
                {3,4},{21,30},{2,13},{12,15},{19,23}
                ,{10,19},{13,14},{6,16},
                {17,25},{6,21},{17,26},{5,6},{12,24}};
//        nn =  new int[][] {{1,4},{7,8}};
        swapLexOrder.solution("lvvyfrbhgiyexoirhunnuejzhesylojwbyatfkrv",nn);
    }



    /**
     *
     * Given a string str and array of pairs that indicates which indices in the string can be swapped, return the lexicographically largest string that results from doing the allowed swaps. You can swap indices any number of times.
     *
     * Example
     *
     * For str = "abdc" and pairs = [[1, 4], [3, 4]], the output should be
     * solution(str, pairs) = "dbca".
     *
     * By swapping the given indices, you get the strings: "cbda", "cbad", "dbac", "dbca". The lexicographically largest string in this list is "dbca".
     *
     * **/
    //timeout brute force
    String solution1(String str, int[][] pairs) {
        if(pairs.length==0) return str;
        TreeSet<String> set = new TreeSet<>();
        char[] chars = str.toCharArray();
        set.add(str);
        int loop = pairs.length;
        while (loop --> 0){
            List<String> sums = new ArrayList<String>(set);
            for(int i = 0;i<sums.size();i++){
                chars = sums.get(i).toCharArray();
                for(int[]  swap : pairs){
                    char tmp = chars[swap[0] -1 ];
                    chars[swap[0] - 1] = chars[swap[1] -1];
                    chars[swap[1] - 1] = tmp;
                    set.add(String.valueOf(chars));
                }
            }
        }
        return set.last();
    }


    //DFS graph
    String solution(String str, int[][] pairs) {
        if(pairs.length==0) return str;
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for(int[]  swap : pairs){
            int s = swap[0];
            int t = swap[1];
            Set<Integer> set = graph.getOrDefault(s,new HashSet<>());
            set.add(t);
            graph.put(s,set);
            set = graph.getOrDefault(t,new HashSet<>());
            set.add(s);
            graph.put(t,set);
        }
        HashSet<Set<Integer>> Key_Location= new HashSet<>();
        Set<Integer> visit = new HashSet<>();
        for(Map.Entry<Integer,Set<Integer>> entry : graph.entrySet()){
            int key = entry.getKey();
            Set<Integer> val = entry.getValue();
            Set<Integer> set = new TreeSet<Integer>();
            if(visit.contains(key)) continue;
            DFS_find_union(set,key, graph);
            visit.addAll(set);

            if(set.size() > 1) {
                Key_Location.add(set);
            }
        }
        char[] chars = str.toCharArray();
        for(Set<Integer> set  : Key_Location){
            List<Character> res = new ArrayList<>();
            for(int i : set){
                res.add(chars[i-1]);
            }
            Collections.sort(res);
            for(int i : set){
                chars[i-1] = res.get(res.size()-1);
                res.remove(res.size()-1);
            }
        }
        //lyyvurrhgxyzvonohunlfejihesiebjwbyatfkrv
        return String.valueOf(chars);
    }
    private void DFS_find_union( Set<Integer> set,Integer val, Map<Integer, Set<Integer>> graph) {
        if (set.contains(val)) return;
        if (!graph.containsKey(val)) return;
        set.add(val);
        for (int s : graph.get(val)) {
            DFS_find_union(set,s, graph);
        }
    }


}
