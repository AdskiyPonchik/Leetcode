package NeedCode.Tree;

public class IsBalanced {
    public boolean isBalanced(TreeNode root) {
        return getHeight(root)!= -1;
    }

    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getHeight(root.left);
        int right = getHeight(root.right);

        if (left==-1) {
            return -1;
        }
        if (right == -1) {
            return -1;
        }

        if (Math.abs(left-right) > 1){
            return -1;
        }
        return Math.max(left, right) + 1;
    }
}
