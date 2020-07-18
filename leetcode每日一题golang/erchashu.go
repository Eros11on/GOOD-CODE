/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
type TreeNode struct {
   Val   int
   Left  *TreeNode
   Right *TreeNode
}
func hasPathSum(root *TreeNode, sum int) bool {
   if root == nil { 
      return false 
   }//判断是否为空树，若是返回false
   if root.Left == nil && root.Right == nil {// 判断当前根节点是否已经是叶节点
      return root.Val == sum // 判断节点上的值是否为给定sum
   }
   // 若都不是
   return hasPathSum(root.Left, sum-root.Val) || hasPathSum(root.Right, sum-root.Val)// 左右子树只要能找到一个满足条件的路径即可
}
