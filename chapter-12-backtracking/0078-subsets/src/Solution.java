import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        Deque<Integer> path = new ArrayDeque<>(len);
        dfs(nums, 0, len, path, res);
        return res;
    }

    private void dfs(int[] nums, int index, int len, Deque<Integer> path, List<List<Integer>> res) {
        if (index == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        dfs(nums, index + 1, len, path, res);

        path.add(nums[index]);
        dfs(nums, index + 1, len, path, res);
        // 很不好理解，需要从 深度优先遍历 的角度，动态去理解
        path.removeLast();
    }
}
