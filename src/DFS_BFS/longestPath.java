package DFS_BFS;

import GeneralTopic.minSubstringWithAllChars;

import java.util.HashMap;

/**
 * @ClassName:longestPath
 * @Auther: yyj
 * @Description:
 * @Date: 22/10/2022 12:19
 * @Version: v1.0
 */
public class longestPath {

    public static void main(String[] args) {
        longestPath test = new longestPath();
       String s = "user\f\tpictures\f\tdocuments\f\t\tnotes.txt";
        test.solution(s);

    }
    /**
     *https://leetcode.com/problems/longest-absolute-file-path/
     *
     * user\n\tpictures\n\t\tphoto.png\n\t\tcamera\n\tdocuments\n\t\tlectures\n\t\t\tnotes.txt
     * user
     *     pictures
     *         photo.png
     *         camera
     *     documents
     *         lectures
     *             notes.txt
     * */


    int solution(String fileSystem) {
        String[] strs = fileSystem.split("\f");
        if(strs.length == 1 ){
            if( strs[0].contains(".")) return strs[0].length();
            else return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;

        map.put(-1,0);
        for( String str : strs){
            int index = 0;
            int count = 0;
            while((index=str.indexOf("\t",index))!=-1){
                index = index+"\t".length();
                count++;
            }
            map.put(count,str.length() - count +  map.get(count-1));
            if(str.contains(".")){
                max = Math.max(max,map.get(count)+count);
            }
        }
        return max;
    }

}
