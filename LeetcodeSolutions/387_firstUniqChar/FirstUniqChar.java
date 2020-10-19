public class FirstUniqChar {
    public static int solution(String s) {
        if (s.length() == 0) return -1;

        int[] charNum = new int[26];
        char[] charSet = s.toCharArray();
        int i;
        for (i = 0; i < charSet.length; i++) {
            if (charNum[charSet[i] - 'a'] != 0) {
                charNum[charSet[i] - 'a']++;
                charSet[i] = 0;
            }
            else {
                charNum[charSet[i] - 'a']++;
            }
        }
        for (i = 0; i < charSet.length; i++) {
            if (charSet[i] != 0 && charNum[charSet[i] - 'a'] == 1) return i;
        }
        return -1;
    }
}
