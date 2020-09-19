public class MinPathSum {
    /** 
     * 时间复杂度：O(mn)
     * 空间复杂度：O(mn)
     */
    public static int solution(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int[][] gridSum = new int[grid.length][grid[0].length];

        gridSum[0][0] = grid[0][0];             // 初始化
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0) continue;
                if (i == 0 && j != 0) {
                    gridSum[i][j] = gridSum[i][j - 1] + grid[i][j];
                }
                else if (i != 0 && j == 0) {
                    gridSum[i][j] = gridSum[i - 1][j] + grid[i][j];
                }
                else {
                    gridSum[i][j] = Math.min(gridSum[i - 1][j], gridSum[i][j - 1]) + grid[i][j];
                }
            }
        }
        return gridSum[grid.length - 1][grid[0].length - 1];
    }


    /** 
     * 时间复杂度：O(mn)
     * 空间复杂度：O(n)
     */
    public static int solution2(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int[] gridSum = new int[grid[0].length];

        gridSum[0] = grid[0][0];             // 初始化
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0) continue;
                if (i == 0 && j != 0) {
                    gridSum[j] = gridSum[j - 1] + grid[i][j];
                }
                else if (i != 0 && j == 0) {
                    gridSum[j] = gridSum[0] + grid[i][j];
                }
                else {
                    gridSum[j] = Math.min(gridSum[j], gridSum[j - 1]) + grid[i][j];
                }
            }
        }
        return gridSum[grid[0].length - 1];
    }
}
