import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {

    private int len;
    private List<String> res;

    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> adj = new HashMap<>();
        for (List<String> ticket : tickets) {
            if (!adj.containsKey(ticket.get(0))) {
                PriorityQueue<String> minHeap = new PriorityQueue<>();
                minHeap.add(ticket.get(1));
                adj.put(ticket.get(0), minHeap);
            } else {
                adj.get(ticket.get(0)).add(ticket.get(1));
            }
        }

        this.len = tickets.size();
        res = new ArrayList<>();
        res.add("JFK");
        dfs(adj, "JFK", 0);
        return res;
    }

    private boolean dfs(Map<String, PriorityQueue<String>> adj, String currentCity, int count) {

        if (count == len) {
            return true;
        }

        PriorityQueue<String> nextCities = adj.get(currentCity);
        if (nextCities == null || nextCities.size() == 0) {
            return false;
        }

        for (int i = 0; i < nextCities.size(); i++) {
            String nextCity = nextCities.poll();
            res.add(nextCity);

            if (dfs(adj, nextCity, count + 1)) {
                return true;
            } else {
                nextCities.add(nextCity);
                res.remove(res.size() - 1);
            }
        }
        return false;
    }
}
