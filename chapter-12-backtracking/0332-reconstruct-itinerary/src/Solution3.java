import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution3 {

    public List<String> findItinerary(List<List<String>> tickets) {
        // 因为逆序插入，所以用链表
        List<String> res = new LinkedList<>();
        if (tickets == null || tickets.size() == 0) {
            return res;
        }

        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        for (List<String> ticket : tickets) {
            // 因为涉及删除操作，我们用链表
            PriorityQueue<String> minHeap = graph.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>());
            minHeap.add(ticket.get(1));
        }

        dfs(graph, "JFK", res);
        return res;
    }

    /**
     * DFS 方式遍历图，当走到不能走为止，再将节点加入到答案
     *
     * @param graph
     * @param src
     * @param res
     */
    private void dfs(Map<String, PriorityQueue<String>> graph, String src, List<String> res) {
        // 于是我们希望能够遍历完当前节点所连接的其他节点后再进入「死胡同」。
        PriorityQueue<String> minHeap = graph.get(src);
        while (minHeap != null && minHeap.size() > 0) {
            String next = minHeap.poll();
            dfs(graph, next, res);
        }

        // 逆序插入
        res.add(0, src);
    }
}
