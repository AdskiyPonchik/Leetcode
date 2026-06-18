package NeedCode.Tree;

import java.util.LinkedList;
import java.util.Queue;

// task name: Serialize and Deserialize Binary Tree
public class Codec {
    private final String marker = "#";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode curNode = queue.poll();

            if (curNode != null) {
                sb.append(curNode.val).append(",");
                queue.add(curNode.left);
                queue.add(curNode.right);
            } else {
                sb.append("#").append(",");
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.equals("#") || data.equals("#,")) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        String[] arr = data.split(",");
        int i = 0;
        TreeNode root = new TreeNode(Integer.parseInt(arr[i]));
        queue.add(root);
        i++;
        while (!queue.isEmpty()) {
            TreeNode parent = queue.poll();
            if (!arr[i].equals("#")) {
                parent.left = new TreeNode(Integer.parseInt(arr[i]));
                queue.add(parent.left);
            }
            i++;
            if (i < arr.length && !arr[i].equals("#")) {
                parent.right = new TreeNode(Integer.parseInt(arr[i]));
                queue.add(parent.right);
            }
            i++;
        }
        return root;
    }
}

