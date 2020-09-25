public class Solution {

    private TreeNode parent;

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        flatten(root.right);
        flatten(root.left);

        root.right = parent;
        root.left = null;

        // 暂存父亲节点
        parent = root;
    }
}
