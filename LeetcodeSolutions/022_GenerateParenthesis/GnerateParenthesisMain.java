import java.util.ArrayList;
import java.util.List;

public class GnerateParenthesisMain {
    public static void main(String[] args) {
        int n = 3;
        List<String> result = new ArrayList<>();
        String str = new String();

        GenerateParenthesis generateParenthesis = new GenerateParenthesis(result, str);
        generateParenthesis.solution(n);
        for (String each: result) {
            System.out.println(each);
        }
    }
}