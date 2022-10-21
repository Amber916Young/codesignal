package Heaps_Stacks_queues;

/**
 * @ClassName:countClouds
 * @Auther: yyj
 * @Description:
 * @Date: 21/10/2022 22:08
 * @Version: v1.0
 */
public class countClouds {

    /**
     * Given a 2D grid skyMap composed of '1's (clouds) and '0's (clear sky), count the number of clouds. A cloud is surrounded by clear sky, and is formed by connecting adjacent clouds horizontally or vertically.
     * You can assume that all four edges of the skyMap are surrounded by clear sky.
     *For
     *
     * skyMap = [['0', '1', '1', '0', '1'],
     *           ['0', '1', '1', '1', '1'],
     *           ['0', '0', '0', '0', '1'],
     *           ['1', '0', '0', '1', '1']]
     * the output should be
     * solution(skyMap) = 2;
     *
     * For
     *
     * skyMap = [['0', '1', '0', '0', '1'],
     *           ['1', '1', '0', '0', '0'],
     *           ['0', '0', '1', '0', '1'],
     *           ['0', '0', '1', '1', '0'],
     *           ['1', '0', '1', '1', '0']]
     * the output should be
     * solution(skyMap) = 5.
     *
     * */
    int solution(char[][] skyMap) {
        int row = skyMap.length;
        if(row == 0) return 0;

        int col = skyMap[0].length;
        int ans = 0;
        for(int i = 0;i < row ;i++){
            for(int j = 0;j < col ;j++){
                if(skyMap[i][j] == '1'){
                    ans++;
                    countClouds_DFS(skyMap,i,j);
                }
            }
        }

        return ans;

    }


    void countClouds_DFS(char[][] skyMap, int curRow, int curCol){
        int row = skyMap.length;
        int col = skyMap[0].length;
        if(curRow >= row || curRow < 0 ||curCol >= col||curCol<0||skyMap[curRow][curCol] == '0') return;
        skyMap[curRow][curCol] = '0';
        countClouds_DFS(skyMap,curRow+1,curCol);
        countClouds_DFS(skyMap,curRow-1,curCol);
        countClouds_DFS(skyMap,curRow,curCol+1);
        countClouds_DFS(skyMap,curRow,curCol-1);
    }


}
