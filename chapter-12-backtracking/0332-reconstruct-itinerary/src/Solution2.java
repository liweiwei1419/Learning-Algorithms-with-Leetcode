import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution2 {

    public List<String> findItinerary(List<List<String>> tickets) {
        // 建图
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for (List<String> ticket : tickets) {
            // 源点
            String src = ticket.get(0);
            // 目的地
            String dst = ticket.get(1);
            if (!map.containsKey(src)) {
                map.put(src, new PriorityQueue<>());
            }
            map.get(src).offer(dst);
        }

        List<String> itinerary = new ArrayList<>();
        dfs("JFK", map, itinerary);

        // 逆序输出
        Collections.reverse(itinerary);
        return itinerary;
    }

    public void dfs(String curr, Map<String, PriorityQueue<String>> map, List<String> itinerary) {
        while (map.containsKey(curr) && map.get(curr).size() > 0) {
            String tmp = map.get(curr).poll();
            dfs(tmp, map, itinerary);
        }
        itinerary.add(curr);
    }
}
