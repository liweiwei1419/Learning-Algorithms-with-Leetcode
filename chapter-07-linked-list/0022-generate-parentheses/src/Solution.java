import java.util.ArrayList;
import java.util.List;

public class Solution {

    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        if (n == 0) return res;
        StringBuilder tmp = new StringBuilder();
        //String tmp = new String();
        dfs(n, 0, 0, tmp);
        return res;

    }

    private void dfs(int n, int left, int right, StringBuilder tmp) {
        if (left == n && right == n) {
            res.add(tmp.toString());
            return;
        }
        if (right > left) {
            return;
        }
        if (left < n) {
            // ① StringBuilder 变量全局只有一份，递归完成以后需要重置
            tmp.append('(');
            dfs(n, left + 1, right, tmp);
            tmp.deleteCharAt(tmp.length() - 1);
        }
        if (right < n) {
            // StringBuilder 变量全局只有一份，递归完成以后需要重置
            tmp.append(')');
            dfs(n, left, right + 1, tmp);
            tmp.deleteCharAt(tmp.length() - 1);
        }
    }
}
