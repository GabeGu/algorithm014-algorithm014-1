/* 第一种解法：非原地处理
 * 思路：
 *     移动k个位置后数组的长度不变，那么可以新建一个与原数组相同维度的数组用于存放移动后的元素。
 * 数组每向右移动一步那么数组元素的位置发生变化，即移动前的最后一个元素处于第一个位置，其余依此向后
 * 一个位置移动。如果把数组的元素连成一个环的话，它们各自的相对顺序是没有变化的。所以只需计算出第一个
 * 元素移动k个位置后的新位置，然后从原数组分两次拷贝到新数组即可。
 * 
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */
void rotate(int* nums, int numsSize, int k) {
    // 合法性及特殊值检查
    if (nums == NULL || numsSize <= 1 || k <= 0 || (k % numsSize) == 0x00) return;

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
 * 时间复杂度：O(n*k)
 * 空间复杂度：O(1)
 */
void rotate(int* nums, int numsSize, int k) {
    // 合法性及特殊值检查
    if (nums == NULL || numsSize <= 1 || k <= 0) return;

    int tmp;
    // 循环k次移动
    for (int i = 0x00; i < k; i++) {
        tmp = nums[numsSize - 1];           // 先空出最后一个元素
        // 从倒数第2个元素开始群移之前所有的元素
        memmove(nums + 1, nums, (numsSize - 1) * sizeof(int));
        nums[0] = tmp;
    }
    return;
}

/* 第三种解法：原地暴力k次移动优化版
 * 思路：
 *     在第二种解法的基础上对移动的次数进行优化，当移动的k次大于等于数组的长度时，即每移动nunsSize次数组的元素又回到了原始的位置，
 * 所以可以省去这些numsSize的倍数次的移动，最终移动k对numsSize的余数次即可
 * 
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(1)
 */
void rotate(int* nums, int numsSize, int k) {
    // 合法性及特殊值检查
    if (nums == NULL || numsSize <= 1 || k <= 0 || (k % numsSize) == 0) return;

    int tmp;
    // 循环k对numsSize的余数次移动
    k %= numsSize;
    for (int i = 0; i < k; i++) {
        tmp = nums[numsSize - 1];           // 先空出最后一个元素
        // 从倒数第2个元素开始群移之前所有的元素
        memmove(nums + 1, nums, (numsSize - 1) * sizeof(int));
        nums[0] = tmp;
    }
    return;
}

/* 第四种解法：反转
 * 思路：
 *     原数组：  1 2 3 4 | 5 6
 *     整体反转: 6 5 | 4 3 2 1
 *     局部反转: 5 6 | 1 2 3 4
 * 
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
void num_reverse(int *start, int *end) {
    while (start < end) {
        int tmp = *end;
        *end = *start;
        *start = tmp;
        start++;
        end--;
    }
}
void rotate(int* nums, int numsSize, int k) {
    // 合法性及特殊值检查
    if (nums == NULL || numsSize <= 1 || k <= 0 || (k % numsSize) == 0) return;

    k %= numsSize;
    num_reverse(nums, nums + numsSize - 1);
    num_reverse(nums, nums + k - 1);
    num_reverse(nums + k, nums + numsSize - 1);

    return;
}