/* 第一种解法：非原地处理
 * 思路：
 *     移动k个位置后数组的长度不变，那么可以新建一个与原数组相同维度的数组用于存放移动后的元素。
 * 数组每向右移动一步那么数组元素的位置发生变化，即移动前的最后一个元素处于第一个位置，其余依此向后
 * 一个位置移动。如果把数组的元素连成一个环的话，它们各自的相对顺序是没有变化的。所以只需计算出第一个
 * 元素移动k个位置后的新位置，然后从原数组分两次拷贝到新数组即可。
 * 
 * 时间复杂度：O(n)(拷贝操作)
 * 空间复杂度：O(n)
 */
void rotate(int* nums, int numsSize, int k) {
    // 合法性及特殊值检查
    if (nums == NULL || numsSize <= 1 || k <= 0 || k == numsSize) return;

    // 开辟与原数组对等的新数组，初始取原素组的第一个元素
    int *newNums = malloc(numsSize * sizeof(int));

    // 计算新位置，对数组的维度取余数操作
    int newIndex = k % numsSize;

    // 拷贝第一部分的元素
    int j = numsSize - newIndex;
    memcpy(newNums + newIndex, nums, j * sizeof(int));

    // 拷贝剩余部分的元素(在特殊指检查时已经将余数为0的情况直接返回，这里肯定存在剩余部分)
    memcpy(newNums, nums + j, newIndex * sizeof(int));
    memcpy(nums, newNums, numsSize * sizeof(int));
    free(newNums);
    return;
}

/* 第二种解法：原地暴力k次移动
 * 思路：
 *     数组每向右移动一步，即移动前的最后一个元素处于第一个位置，其余依次向后一个位置移动，依次循环k次进行处理。
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