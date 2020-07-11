package main
import "fmt"
type TreeNode struct {
	Val   int
	leftcount int // 左子树的个数
	Left  *TreeNode
	Right *TreeNode
}

func BST_insert(node *TreeNode, insert_node *TreeNode, small_count *int) {
	if insert_node.Val <= node.Val {    //插入数小于节点数，则继续寻找插入位置，节点数量+1
		node.leftcount++
		if node.Left != nil {
			BST_insert(node.Left, insert_node, small_count)
		} else {
			node.Left = insert_node
		}
	}
	if insert_node.Val > node.Val {
		*small_count = *small_count + node.leftcount + 1  //在右子树查找，计算小于当前元素的个数
		if node.Right != nil {
			BST_insert(node.Right, insert_node, small_count)
		} else {
			node.Right = insert_node
		}
	}
}

func countSmaller(nums []int) []int {
	length := len(nums)
	counts := make([]int, length)
	if length <= 1 {
		return counts     //判断nums数组是否为空
	}
	node := TreeNode{Val: nums[length-1]}
	counts[length-1] = 0
    for i := length - 2; i >= 0; i-- {   //从右到左进行遍历
		var data int
		BST_insert(&node, &TreeNode{Val: nums[i]}, &data)
		counts[i] = data
	}
	return counts
}
func main(){
	var a =[]int{5,2,6,1}
	arr :=countSmaller(a)
	fmt.Println(arr)
}