import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * <트리의 조건>
 *     1. 루트 노드가 1개이다.
 *     2. 루트 노드에서 다른 모든 노드로 이동이 가능해야 한다.
 *     3. 루트 노드를 제외한 노드는 들어오는 간선이 1개이다.
 *     4. 노드끼리 이동할 때는 사이클이 만들어지지 않는다.
 */

public class Main {
    static HashMap<Integer, ArrayList<Integer>> tree;  // 트리 정보
    static HashSet<Integer> check;  // 들어오는 간선이 존재하는 노드
    static HashMap<Integer, Boolean> visited;  // BFS 탐색으로 방문하는 노드 확인
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int index = 1;

        while (true) {
            String str = br.readLine();
            if (str.equals("-1 -1")) break;  // 테스트 종료
            else if (str.equals("")) continue;  // 다음 테스트 케이스로 이동
            else if (str.equals("0 0")) {  // 비어있는 트리인 경우
                sb.append("Case ").append(index).append(" is a tree.\n");
                index++;
                continue;
            }
            boolean treeCheck = true;
            tree = new HashMap<>();
            check = new HashSet<>();

            while (true) {
                boolean caseCheck = false;
                st = new StringTokenizer(str, " ");
                while (st.hasMoreTokens()) {
                    int u = Integer.parseInt(st.nextToken());
                    int v = Integer.parseInt(st.nextToken());
                    if (u == 0 && v == 0) {
                        caseCheck = true;
                        break;
                    }

                    // 들어오는 간선이 2개 이상인 경우? 3번 조건 성립 x
                    if (check.contains(v)) {
                        treeCheck = false;
                    }

                    check.add(v);
                    treeAdd(v);
                    treeAdd(u);
                    tree.get(u).add(v);
                }
                if (caseCheck) {
                    break;
                }
                str = br.readLine();
            }
            // 트리의 조건 확인
            if (treeCheck) {
                int root = rootSearch();
                if (root == -1 || !bfs(root) || !visitedCheck()) {
                    sb.append("Case ").append(index).append(" is not a tree.\n");
                } else {
                    sb.append("Case ").append(index).append(" is a tree.\n");
                }
            } else {
                sb.append("Case ").append(index).append(" is not a tree.\n");
            }
            index++;
        }
        System.out.println(sb);
    }

    private static void treeAdd(int key) {
        if (!tree.containsKey(key)) tree.put(key, new ArrayList<>());
    }

    private static int rootSearch() {
        int root = -1;
        for (int key : tree.keySet()) {
            if (!check.contains(key)) {
                if (root != -1) return -1;  // 루트 노드의 형태가 2개 이상일 때
                root = key;
            }
        }
        return root;
    }

    private static boolean bfs(int root) {
        Queue<Integer> queue = new LinkedList<>();
        setVisitedHash();
        visited.put(root, true);
        queue.add(root);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int next : tree.get(cur)) {
                if (visited.get(next)) return false;  // 트리 중복 방문인 경우
                visited.put(next, true);
                queue.add(next);
            }
        }
        return true;
    }

    private static void setVisitedHash() {
        visited = new HashMap<>();
        for (int key : tree.keySet()) {
            visited.put(key, false);
        }
    }

    // 모든 노드를 방문했는지 확인
    private static boolean visitedCheck() {
        for (int key : visited.keySet()) {
            if (!visited.get(key)) return false;  // 방문하지 못한 노드가 존재할 때
        }
        return true;
    }
}