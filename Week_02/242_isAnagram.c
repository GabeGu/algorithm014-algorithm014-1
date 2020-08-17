/* 第一种解法：暴力循环碰撞法
 *     两个字符串的所有字母出现相同的次数，那么循环取出一个字符串的字母与另外一个字符串的每一个字母相比较
 * 如果相等则将比较的两个字母替换为数字‘1’，结束之后比较两个字符串如果相等则为字母异位词。
 * 
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(1)
 */
bool isAnagram(char * s, char * t){
    if (strlen(s) != strlen(t)) return false;

    int i_s = 0x00, i_t = 0x00;
    while (s[i_s] != '\0') {
        i_t = 0x00;                     // 字符串t从头开始
        while (t[i_t] != '\0')
        {
            if (s[i_s] == t[i_t]) {
                s[i_s] = t[i_t] = '1';
                break;
            }
            i_t++;                      // 字符串t的下一个字母
        }
        i_s++;                          // 字符串s的下一个字母
    }
    for (int i = 0x00; i < strlen(s); i++) {
        if (s[i] != t[i]) return false;
    }
    return true;
}

/* 第二种解法：排序比较法
 *     先对两个字符串进行排序，排好序后再进行比较，如果相等则为字母异位词。
 * 
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(1)
 */
bool isAnagram(char * s, char * t){

}