import java.util.ArrayList;
import java.util.List;

public class PreOrder {
    public static List<Integer> preOrder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        res.add(root.val);                  // 先添加根节点
        if (root.children != null) {
            for (Node child: root.children) {   // 再添加子节点
                res.addAll(preOrder(child));
            }
        }
        return res;
    }
}