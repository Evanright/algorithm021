//105. 从前序与中序遍历序列构造二叉树
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}


public class ConsturctBinary {

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0) return null;
        return buildTreeSub(preorder, inorder, 0, preorder.length-1, 0 ,inorder.length-1);
    }
    public static TreeNode buildTreeSub(int[] preorder, int[] inorder, int pStart, int pEnd, int iStart, int iEnd){
        if(pStart > pEnd) return null;
        TreeNode root = new TreeNode(preorder[pStart]);

        int rootIndex;
        for(rootIndex = iStart; rootIndex < iEnd;rootIndex++){
            if(inorder[rootIndex]==preorder[pStart])
                break;
        }
        int leftNodeNum = rootIndex - iStart;
        root.left = buildTreeSub(preorder, inorder, pStart+1, pStart+leftNodeNum, iStart, rootIndex-1);
        root.right = buildTreeSub(preorder, inorder, pStart+leftNodeNum+1, pEnd, rootIndex+1, iEnd);
        return root;
    }

    public static void main(String[] args) {
//        int[] preorder = new int[]{3,9,20,15,7};
//        int[] inorder = new int[]{9,3,15,20,7};
        int[] preorder = new int[]{1,2};
        int[] inorder = new int[]{2,1};
        TreeNode treeNode = buildTree(preorder, inorder);
        System.out.println(treeNode);
    }

}
