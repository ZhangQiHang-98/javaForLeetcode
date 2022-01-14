package tree;

/**
 * @Description 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * @Author Zhang Qihang
 * @Date 2022/1/14 17:21
 */
public class _108sortedArrayToBST {
    public TreeNode helper(int[] nums, int start, int end) {
        System.out.println(start);
        System.out.println(end);
        // 如果区间内没有值了，说明走到了叶子节点，返回空即可
        if (start > end) {
            return null;
        }
        if (start == end) {
            return new TreeNode(nums[start]);
        }
        // 从上到下构建，因此是先序遍历，先处理当前节点
        int curIndex = (start + end) / 2;
        int curVal = nums[curIndex];
        TreeNode curNode = new TreeNode(curVal);
        //这个地方是start不是0！！！
        curNode.left = helper(nums, start, curIndex - 1);
        curNode.right = helper(nums, curIndex + 1, end);
        return curNode;
    }

    // 先序遍历即可，从上到下进行初始化
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }
}
