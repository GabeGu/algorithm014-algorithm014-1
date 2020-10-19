public class ReverseStr {
    public static String solution(String s, int k) {
        if (k <= 0 || s.length() <= 1) return s;
        int sIndex = 0;
        // 1. s转字符数组
        char[] charSet = s.toCharArray();
        // 2. 每2k个字符处理一次
        while (sIndex + 2 * k <= s.length()) {
            reverseKchar(charSet, sIndex, sIndex + k - 1);
            sIndex += 2 * k;
        }
        // 3. 剩余字符处理
        k = s.length() - sIndex < k ? s.length() - sIndex : k;
        reverseKchar(charSet, sIndex, sIndex + k - 1);
        return new String(charSet);
    }

    public static void reverseKchar(char[] charSet, int start, int end) {
        while (start < end) {
            char tmp = charSet[start];
            charSet[start] = charSet[end];
            charSet[end] = tmp;
            start++;
            end--;
        }
    }
}
