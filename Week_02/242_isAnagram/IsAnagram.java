import java.util.Arrays;

public class IsAnagram {
    public IsAnagram() {}

    /**
     *  解法1： 排序法
     *  思路：根据异位词的定义，其长度必定相等，且每个字母出现的次数相等。那么两个词进行排序后肯定相等
     * 
     *  时间复杂度：O(nlongn)(主要以排序的时间复杂度为主) 
     *  空间复杂度：O(n)(这里的实现需要额外的空间来存放用于排序的字符串转换而来的字符数组)
     */
    public boolean solution1(String s, String t) {
        if (s.length() != t.length()) return false;

        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);

        return Arrays.equals(str1, str2);
    }

    /**
     * 解法2：字符抵消
     * 思路：题目假设只包含小写字母，那么可以建立一张与字母对应的计数表，当某个字母在s词中出现时则在对应的表中记+1，在t词中则记-1
     *      如果最终所有的字母计数均为零则说明是字母异位词，否则不是
     * 
     *  时间复杂度：O(n)
     *  空间复杂度：O(1)
     */
    public boolean solution2(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] count = new int[26];
        for (int i = 0x00; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        for (int c : count) {
            if (c != 0x00) return false;
        }
        return true;
    }
}