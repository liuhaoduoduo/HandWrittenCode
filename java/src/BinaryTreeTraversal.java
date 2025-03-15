/**
 * 二叉树构造及三种遍历
 */
class BinaryTreeTraversal {
    // 树节点上的数值
    private static int value = 0;

    public static void main(String[] args) {
        // 构建一颗4层的满二叉树
        TreeNode rootTreeNode = buildTree(1, 4);
        System.out.print("先序遍历：");
        preorder(rootTreeNode);
        System.out.println();
        System.out.print("中序遍历：");
        middle(rootTreeNode);
        System.out.println();
        System.out.print("后序遍历：");
        last(rootTreeNode);
        
    }

    // 前序遍历
    // 先读取根节点值，然后是左子树，最后是右子树
    private static void preorder(TreeNode rooTreeNode) {
        if (rooTreeNode == null) {
            return;
        }

        System.out.print(rooTreeNode.data+",");
        preorder(rooTreeNode.left);
        preorder(rooTreeNode.right);

    }

    // 中序遍历
    // 先读取左子树值，然后是根节点，最后是右子树
    private static void middle(TreeNode rooTreeNode) {
        if (rooTreeNode == null) {
            return;
        }

        middle(rooTreeNode.left);
        System.out.print(rooTreeNode.data+",");
        middle(rooTreeNode.right);
    }

    // 后续遍历
    // 先读取左子树，然后是右子树，最后是根节点
    private static void last(TreeNode rooTreeNode) {
        if (rooTreeNode == null) {
            return;
        }

        last(rooTreeNode.left);
        last(rooTreeNode.right);
        System.out.print(rooTreeNode.data+",");
    }

    /**
     * 构建树
     * @param currentLayer 当前层级
     * @param maxLayer 树的最大层级
     * @return 树节点
     */
    private static TreeNode buildTree(int currentLayer, int maxLayer) {
        if (currentLayer > maxLayer) {
            return null;
        }
        // 构建节点本身
        TreeNode node = new TreeNode(value++);
        // 构建左子树
        node.left = buildTree(currentLayer + 1, maxLayer);
        // 构建右子树
        node.right = buildTree(currentLayer + 1, maxLayer);
        // 返回节点本身
        return node;
    }

}

/**
 * 树节点
 */
class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int data) {
        this.data = data;
    }
}