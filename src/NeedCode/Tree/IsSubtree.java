package NeedCode.Tree;

public class IsSubtree {
    public boolean isSubtree(TreeNode root, TreeNode subroot) {
        if (root == null) {
            return false;
        }
        if(isSametree(root, subroot)) return true;
        return isSubtree(root.left,subroot) || isSubtree(root.right, subroot);
    }

    public boolean isSametree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (s.val != t.val) {
            return false;
        }
        return isSametree(s.left, t.left) &&
                isSametree(s.right, t.right);
    }
}
