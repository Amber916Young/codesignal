package Backtracking;

import java.util.*;

/**
 * @ClassName:wordBoggle
 * @Auther: yyj
 * @Description:
 * @Date: 23/10/2022 16:36
 * @Version: v1.0
 */
public class wordBoggle {

    public static void main(String[] args) {
        wordBoggle test = new wordBoggle();
        char[][] chars = new char[][]{
                 {'A', 'X', 'V','W'}
                ,{'A', 'L', 'T','I'}
                ,{'T', 'T', 'J','R'}};
        test.solution(chars,new String[]{"TALA"});
    }

    /*

    [["A","X","V","W"],
     ["A","L","T","I"],
     ["T","T","J","R"]]
     * For
     * board = [
     *     ['R', 'L', 'D'],
     *     ['U', 'O', 'E'],
     *     ['C', 'S', 'O']
     * ]
     * and words = ["CODE", "SOLO", "RULES", "COOL"], the output should be
     * solution(board, words) = ["CODE", "RULES"]
     * **/
    String[] solution(char[][] board, String[] words) {
        Set<String> set = new TreeSet<>();
        int col = board[0].length;
        int row = board.length;
        for(String s : words){
            char c = s.charAt(0);
            boolean visited = false;
            for(int i = 0;i<row;i++){
                for(int j = 0;j<col;j++){
                    if(board[i][j] == c){
                        HashMap<Integer, Character> map = new HashMap<>();
                        wordBoggle_DFS(board,s,i,j,0,map );
                        if(map.size() == s.length()){
                            set.add(s);
                            visited = true;
                        }
                        if(visited)break;
                    }
                }
                if(visited)break;
            }
        }
        String[] ans =new String[set.size()];
        int i = 0;
        for(String s : set){
            ans[i++] = s;
        }
        return ans;
    }

    private void wordBoggle_DFS(char[][] board, String s, int i, int j, int index,  HashMap<Integer, Character> map ) {
        int col = board[0].length;
        int row = board.length;
        if(index >= s.length()) return;
        if( i >= row || j >= col || i<0|| j<0 ||  board[i][j] == '*' ||  board[i][j] != s.charAt(index)) return;
        char c =  board[i][j];
        if(  board[i][j]  == s.charAt(index)){
            map.put(index,c);
        }
        board[i][j]  = '*';

        wordBoggle_DFS(board,s,i-1,j,index+1,map);
        wordBoggle_DFS(board,s,i+1,j,index+1,map);
        wordBoggle_DFS(board,s,i,j-1,index+1,map);
        wordBoggle_DFS(board,s,i,j+1,index+1,map);
        wordBoggle_DFS(board,s,i-1,j-1,index+1,map);
        wordBoggle_DFS(board,s,i+1,j+1,index+1,map);
        wordBoggle_DFS(board,s,i-1,j+1,index+1,map);
        wordBoggle_DFS(board,s,i+1,j-1,index+1,map);
        board[i][j] = c;


    }






}
