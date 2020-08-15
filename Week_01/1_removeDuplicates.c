/* 第一种解法：非原地处理
 * 思路：
 *     原数组为已排序，那么重复的元素肯定是连续排列的且去重后新数组也是有序的，那么只需将重复元素的第一
 * 个做拷贝至新数组即可。是否拷贝只需将原数组的值与新数组的当前值比较即可。
 * 
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */
int removeDuplicates(int* nums, int numsSize) {
    // 数组指针为空，数组长度小于2即返回
    if (nums == NULL || numsSize <= 0) return 0;
    if (numsSize == 1) return 1;

    // 开辟与原数组对等的新数组，初始取原素组的第一个元素
    int j = 0x00;
    int *newNums = malloc(numsSize * sizeof(int));
    newNums[0] = nums[0];

    // 原数组从索引1开始遍历，新数组从索引0开始，假如当前值与新数组的不相等则拷贝否则不拷贝
    for (int i = 0x01; i < numsSize; i++) {
        if (nums[i] != newNums[j]) {
            newNums[++j] = nums[i];
        }
    }

    // 拷贝回原数组，释放内存
    memcpy(nums, newNums, (j + 1) * sizeof(int));
    free(newNums);
    return j + 1;
}

/* 第二种解法：双指针原地处理
 * 思路：
 *     去重后的新数组一定是比原数组短的，所以可以在原数组上进行操作，即新数组元素可以按顺序从原数组第一个
 * 元素位置开始排列，所以使用一个指针用于原数组的元素遍历，另一个指针用于新数组的排列。
 * 
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 * 与第一种解法相比：省去了新数组的空间开辟，省去了新老数组之间的数据拷贝操作
 */
int removeDuplicates(int* nums, int numsSize) {
    // 数组指针为空，数组长度小于2即返回
    if (nums == NULL || numsSize <= 0) return 0;
    if (numsSize == 1) return 1;

    // 原数组从索引1开始遍历，新数组从索引0开始，假如当前值与新数组的不相等则拷贝否则不拷贝
    int i_old = 0x01, i_new = 0x00;
    for (; i_old < numsSize; i_old++) {
        if (nums[i_old] != nums[i_new]) {
            nums[++i_new] = nums[i_old];
        }
    }
    return i_new + 1;
}