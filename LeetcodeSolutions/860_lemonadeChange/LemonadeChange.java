public class LemonadeChange {
    /** 
     * 解法：贪心算法
     * 思路：支付的金额面值为5，10，20，那么记x=5，y=10，z=20；则y=2x，z=4x。
     *      一杯柠檬水的价格为5，那么记a=5，则a=x。
     *      那么找零情况如下：
     *      1. Change(x, a) = x-a = x-x  = 0；
     *      2. Change(y, a) = y-a = 2x-x = x；
     *      3. Change(z, a) = z-a = 4x-x = 3x = y + x;
     *  那么可以得出：
     *      第1种情况无需找零；
     *      第2种情况需要找零x的等值面额；
     *      第3种情况有两种找零的方法即3张x的等值面额或者1张y和1张x的等值面额；
     *      从可以看出，只有第3种情况有2种找零的方式选择，在顾客排队购买的顺序一定的情况下，那么当手上的零钱同时满足这2种找零方式的时候，
     *  那么是否存在一种方式比另外一种方式优先使用的情况使得能够给后续的顾客继续找零？
     *      上述的3种找零情况中可以看出，找零需要用到x和y两种等值面额，而x面额在第2和第3种情况均需要用到，而y面额只在第3种情况用到，所以
     *  那么当手上的零钱同时满足第3种情况的这2种找零方式的时候，优先使用y+x的找零方式，假如优先使用掉3张x面额可能使手上没有了x面额而导致
     *  后面的顾客无法找零。
     *      最后按照优先y+x的方式在后续的找零种还是找不出，那么说明就无法完成所有顾客找零。
     */
    public static boolean solution(int[] bills) {
        int nChange_5 = 0;
        int nChange_10 = 0;
        //int nChange_20 = 0;

        for (int bill: bills) {
            if (bill == 5) {        // 情况1:收入5美元不用找零
                nChange_5++;
            }
            else if (bill == 10) {  // 情况2:收入10美元，找零5美元
                if (nChange_5 >= 1) {
                    nChange_5--;
                    nChange_10++;
                }
                else {
                    return false;
                }
            }
            else if (bill == 20) {
                if (nChange_5 >= 1 && nChange_10 >= 1) {    // 情况3:优先找10+5的方式
                    nChange_5--;
                    nChange_10--;
                    //nChange_20++;
                }
                else if (nChange_5 >= 3) {
                    nChange_5 -= 3;
                    //nChange_20++;
                }
                else {
                    return false;
                }
            }
            else {
                return false;
            }
        }
        return true;
    }
}