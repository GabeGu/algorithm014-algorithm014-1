public class FindCircleNum {
    public static int solution(int[][] M) {
        if (M == null) return 0;
        DisJiontSet disJiontSet = new DisJiontSet(M.length);

        for (int i = 0; i < M.length; i++) {
            for (int j = i + 1; j < M[i].length; j++) {
                if (M[i][j] == 1) {
                    disJiontSet.union(i, j);
                }
            }
        }
        return disJiontSet.numOfDisJointSet();
    }
}
