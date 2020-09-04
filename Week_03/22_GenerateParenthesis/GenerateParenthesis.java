import java.util.List;

public class GenerateParenthesis {
    /** 
     * 解法：递归剪枝
     * 思路：类似n个不同的数排列组合的情形，比如3个数的排列组合树如下：
     *      level1:            1        2       3           level1共3个分支
     *                        / \      / \     / \
     *      level2:          2   3    1   3   1   2         level2在level1的每个分支上又可以生成2个分支，共3*2=6种可能
     *                       |   |    |   |   |   |
     *      level3:          3   2    3   1   2   1         最后一层在leve2的基础上均只有一种可能即最终有3*2*1=6种可能
     *      所以n个不同的树排列组合数就相相当于求n的阶乘值。有此规律的原因是n个数均不相同，使得针对某个分支每往下一层可选的数就减少1。
     *      
     *      而对于n对括号情况，相当于就只有左括号和右括号两种数，且有重复的数，同时还存在无效性情况，所以不能简单的按照上述公式计算，
     *      但可以使用类似的思路，先不考虑有效性的情况，比如2对括号的排列组合树如下：
     *      level1:             (                        )
     *                         / \                      / \
     *      level2:           (   )                    (   )
     *                        |  / \                  / \  |    
     *      levle3:           ) (   )                (   ) (
     *                        | |   |                |   | |
     *      level4:           ） )  (                )   (  (    
     *                      /   |   \              /    |    \
     *      共有6种组合情况：(()) ()() ())(         )(()  )()(  ))((
     *      而有效的为：(()) ()()2种
     *      可以观察出组合树在level3时由于左括号或者右括号的个数已经用完无法生成部分新的分支，但只要还有就可以生成对应的左右分支。
     *      最后当左右括号均已用完时即得到一种组合。
     * 
     *      再考虑有效性的情况，在level1中直观的可以看出右括号的这颗树生成的所有情况均为非法，因为没有对应的左括号与之配对。
     *      而左括号的这颗树在level3最右侧的右括号这个分支是无效的，因为level2已有右括号和level1的左括号配对。所以在生成右括号
     *      分支时需要判断是否还有剩余的左括号与之配对即此时左括号的数量是否大于右括号的数量，是则生成，否则生成的即为无效的分支。
     */     
    public List<String> result;
    private String str;

    public GenerateParenthesis(List<String> result, String str) {
        this.result = result;
        this.str = str;
    }

    public List<String> solution(int n) {
        if (n == 0) return result;
        int left = n, right = n;                    // 初始左右括号剩余个数

        generateParenthesis(left, right);
        return result;
    }

    private void generateParenthesis(int left, int right) {
        if (left == 0 && right == 0) {              // 左右括号均已用完，添加一种有效组合
            result.add(str);
            return;
        }

        // 左括号还没有用完则先生成左括号分支
        if (left != 0) {                            
            str = str + '(';
            generateParenthesis(left - 1, right);   // 交由下一层
            str = str.substring(0, str.length() - 1);     // 本层左括号分支已处理完，删除
        }

        // 右括号没有用完且此时右括号剩余多余左括号(即已添加的左括号数量多余右括号数量)
        if (right != 0 && right > left) {           
            str = str + ')';
            generateParenthesis(left, right - 1);
            str = str.substring(0, str.length() - 1);     // 本层右括号分支已处理完，删除
        }
        return;
    }
}