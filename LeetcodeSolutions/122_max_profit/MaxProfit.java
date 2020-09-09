public class MaxProfit {
    /** 
     * 解法：峰谷差值
     * 思路：1. 每一天的价格均已知，所以可以全盘考虑。
     *      2. 一开始没有股票且再次购买之前必须出掉之前的股票，所以只能通过卖出价格高于买入价格来赚取利润，并且保证
     *         每次的买卖操作均能赚取利润。
     *      3. 将每天的价格在以横坐标为天，纵坐标为价格的坐标轴中画出，为了利润的最大化需要获取所有处于上升区间的利润
     *         即每次买入的起点为由跌转涨的“V”型谷点，而相对应的卖出点为由涨转跌的“^”型顶点。
     *  
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public static int solution(final int[] prices) {
        if (prices.length <= 1) return 0;
        int buyPrice = 0, profit = 0;
        boolean findBuyPrice = true; // 用于跳过连续的上升或者连续的下降的中间点，初始先找买入点
       
        for (int i = 0; i < prices.length; i++) {
            if (findBuyPrice) {
                if (i != prices.length - 1 && prices[i + 1] > prices[i]) {  // 最后一天肯定不是买入点
                    buyPrice = prices[i];               // 找到买入点
                    findBuyPrice = false;
                }
            }
            else {
                if (i == prices.length - 1 || prices[i + 1] < prices[i]) {  // 最后一天肯定是卖出点
                    profit += prices[i] - buyPrice;     // 找到卖出点
                    findBuyPrice = true;
                }
            }
        }
        return profit;
    }
}
