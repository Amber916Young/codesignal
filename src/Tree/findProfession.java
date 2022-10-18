package Tree;

import java.util.Queue;

/**
 * @ClassName:findProfession
 * @Auther: yyj
 * @Description:
 * @Date: 18/10/2022 17:57
 * @Version: v1.0
 */
public class findProfession {

    /***
     *
     *
     * Consider a special family of Engineers and Doctors.
     * This family has the following rules:
     *
     * Everybody has two children.
     * The first child of an Engineer is an Engineer and the second child is a Doctor.
     * The first child of a Doctor is a Doctor and the second child is an Engineer.
     * All generations of Doctors and Engineers start with an Engineer.
     * We can represent the situation using this diagram:
     *                 E
     *            /         \
     *           E           D
     *         /   \        /  \
     *        E     D      D    E
     *       / \   / \    / \   / \
     *      E   D D   E  D   E E   D
     * */
    String solution(int level, int pos) {
        if (level == 1) return "Engineer";
        if (solution(level - 1, (pos + 1) / 2).equals("Doctor")) {
            if (pos % 2 == 0) return "Engineer";
            else return "Doctor";
        }
        if (pos % 2 == 0) return "Doctor";
        return "Engineer";
    }
}
