public class DisJiontSet {
    private int count;

    private int[] parant;

    public DisJiontSet(int n) {
        count = n;
        parant = new int[n];
        for (int i = 0; i < n; i++) {
            parant[i] = i;
        }
    }

    public int findParant(int e) {
        while(e != parant[e]) {
            parant[e] = parant[parant[e]];// 路径压缩
            e = parant[e];                // 往上继续找parant
        }
        return e;
    }

    public void union(int e1, int e2) {
        int p_e1 = findParant(e1);
        int p_e2 = findParant(e2);
        if (p_e1 == p_e2) return;
        parant[p_e2] = p_e1;
        count--;
    }

    public int numOfDisJointSet() {
        return count;
    }
}
