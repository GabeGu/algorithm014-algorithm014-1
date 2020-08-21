import java.util.Arrays;

public class IsAnagram {
    public IsAnagram() {}
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false; // 长度不相等肯定不是

        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }
}