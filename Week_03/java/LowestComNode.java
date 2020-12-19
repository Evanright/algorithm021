
//class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//    TreeNode(int x) { val = x; }
// }

public class LowestComNode {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || root==p || root==q) return root; // 找到目标节点 或 到叶子尽头

        TreeNode left = lowestCommonAncestor(root.left, p, q);  // 现在左子树找
        TreeNode right = lowestCommonAncestor(root.right, p, q); // 找右子树

        if(left==null) return right; // 此子树包含右节点 或 返回null
        if(right==null) return left; // 此子树包含左节点 不包含右节点
        return root;  //此节点为目标值 包含左右节点
    }

}
