import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static Node[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        tree = new Node[N + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            char parentValue = st.nextToken().charAt(0);
            char leftValue = st.nextToken().charAt(0);
            char rightValue = st.nextToken().charAt(0);

            // 부모 노드가 아직 생성되지 않은 경우, 부모 노드를 생성
            if (tree[parentValue - 'A'] == null) {
                tree[parentValue - 'A'] = new Node(parentValue);
            }
            // 왼쪽 자식이 존재할 경우,
            if (leftValue != '.') {
                tree[leftValue - 'A'] = new Node(leftValue);  // 왼쪽 자식 노드를 생성하고,
                tree[parentValue - 'A'].left = tree[leftValue - 'A'];  // 부모 노드와 연결한다.
            }
            // 오른쪽 자식이 존재할 경우,
            if (rightValue != '.') {
                tree[rightValue - 'A'] = new Node(rightValue);  // 오른쪽 자식 노드를 생성하고,
                tree[parentValue - 'A'].right = tree[rightValue - 'A'];  // 부모 노드와 연결한다.
            }
        }

        // 전위 순회
        preorder(tree[0]);
        System.out.println();

        // 중위 순회
        inorder(tree[0]);
        System.out.println();

        // 후위 순회
        postorder(tree[0]);
        System.out.println();
    }

    private static void preorder(Node node) {
        if (node == null) return;
        System.out.print(node.value);
        preorder(node.left);
        preorder(node.right);
    }

    private static void inorder(Node node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.value);
        inorder(node.right);
    }

    private static void postorder(Node node) {
        if (node == null) return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.value);
    }
}

class Node {
    char value;
    Node left;
    Node right;

    public Node(char value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}