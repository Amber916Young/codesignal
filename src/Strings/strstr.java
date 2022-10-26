package Strings;

/**
 * @ClassName:strstr
 * @Auther: yyj
 * @Description:
 * @Date: 25/10/2022 19:52
 * @Version: v1.0
 */
public class strstr {

    public static void main(String[] args) {
        strstr test = new strstr();
        test.solution("CodefightsIsAwesome","IsA");
    }
    //CodefightsIsAwesome
    //
    // KMP (Knuth-Morris-Pratt) Pattern Matching START
    int solution_KMP(String s, String x) {
        if (s.equals("")) return 0;
        char[] text = s.toCharArray();
        char[] pattern = x.toCharArray();
        int[] table = computeTemporaryArray(pattern);
        int i = 0;
        int j = 0;
        while (i < text.length && j < pattern.length) {
            if (text[i] == pattern[j]) {
                i++;
                j++;
            } else if (j > 0) {
                j = table[j - 1];
            } else {
                i++;
            }
        }
        return j == pattern.length ? i - j : -1;
    }
    private int[] computeTemporaryArray(char[] pattern){
        int [] table = new int[pattern.length];
        int index =0;
        for(int i=1; i < pattern.length;){
            if(pattern[i] == pattern[index]){
                table[i] = index + 1;
                index++;
                i++;
            }else{
                if(index != 0){
                    index = table[index-1];
                }else{
                    table[i] =0;
                    i++;
                }
            }
        }
        return table;
    }





    // KMP (Knuth-Morris-Pratt) Pattern Matching END



    // slow methhod
    int solution(String s, String x) {
        String substring = "";
        if (s.length() < x.length()) return -1;
        for (int i = 0; i < s.length(); i++) {
            if ((i + x.length() - 1) >= s.length()) return -1;
            // check the first  char && last char
            if (s.charAt(i) == x.charAt(0) && s.charAt(i + x.length() - 1) == x.charAt(x.length() - 1)) {
                substring = s.substring(i, i + x.length());
                if (substring.equals(x)) return i;
            }
        }
        return -1;
    }

}
