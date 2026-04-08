package NeedCode.Tree;

public class Diameter {
    private int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        getHeight(root);
        return maxDiameter;
    }

    private int getHeight(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftSize = getHeight(root.left);
        int rightSize = getHeight(root.right);
        maxDiameter = Math.max(maxDiameter, leftSize + rightSize);
        return 1 + Math.max(leftSize, rightSize);
    }
}
