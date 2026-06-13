package NeedCode.Tree;

public class MaxPathSum {

    private int globalMax = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return globalMax;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int getmax_left = Math.max(0, dfs(node.left));
        int getmax_right = Math.max(0, dfs(node.right));
        globalMax = Math.max(globalMax, node.val + getmax_left + getmax_right);
        return node.val + Math.max(getmax_left, getmax_right);
    }
}
