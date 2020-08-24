import java.util.ArrayList;
import java.util.List;

public class PreOrderMain {
    public static void main(String[] args) {
        // 叶子节点
        Node n2 = new Node(2);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);

        // 叶子节点5/6的父节点
        List<Node> n3_children = new ArrayList<>();
        n3_children.add(n5);
        n3_children.add(n6);
        Node n3 = new Node(3, n3_children);

        // 根节点
        List<Node> n1_children = new ArrayList<>();
        n1_children.add(n3);
        n1_children.add(n2);
        n1_children.add(n4);
        Node n1 = new Node(1, n1_children);

        List<Integer> res = new ArrayList<>();
        res = PreOrder.preOrder(n1);
        if (res != null) {
            for(Integer cur : res) {
                System.out.println(cur);
            }
        }
    }
}