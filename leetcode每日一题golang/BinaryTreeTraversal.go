/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
var res []int
func inorderTraversal(root *TreeNode) []int {
	res = make([]int, 0)
	dfs(root)
	return res
}

func dfs(root *TreeNode) {
	if root != nil {
		dfs(root.Left)
		res = append(res, root.Val)
		dfs(root.Right)
	}
}

/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func inorderTraversal(root *TreeNode) []int {
	var res []int
	var stack []*TreeNode        //make a stack

	for 0 < len(stack) || root != nil { //root != nil is ued to determine for once must be put in the end
		for root != nil {
			stack = append(stack, root) //push
			root = root.Left            // move to the left
		}
		index := len(stack) - 1             //Top
		res = append(res, stack[index].Val) //inorder traversal to pop
		root = stack[index].Right           //right node is continued to be pushed 
		stack = stack[:index]               //pop
	}
	return res
}

########################################################################################################

/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
var res []int

func preorderTraversal(root *TreeNode) []int {
	res = []int{}
	dfs(root)
	return res
}

func dfs(root *TreeNode) {
	if root != nil {
		res = append(res, root.Val)
		dfs(root.Left)
		dfs(root.Right)
	}
}

func preorderTraversal(root *TreeNode) []int {
	var res []int
	var stack []*TreeNode

	for 0 < len(stack) || root != nil { //root != nil in order to determine the fist root must be put in the end
		for root != nil {
			res = append(res, root.Val)       //preorder traversal to pop
			stack = append(stack, root.Right) //ringt node push 
			root = root.Left                  //move to the left
		}
		index := len(stack) - 1 //top
		root = stack[index]     //pop
		stack = stack[:index]
	}
	return res
}
############################################################################################################################
/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
var res []int
func postorderTraversal(root *TreeNode) []int {
    res = []int{}
	dfs(root)
    return res
}

func dfs(root *TreeNode){
   	if root != nil {
		dfs(root.Left)
		dfs(root.Right)
		res = append(res,root.Val)
	} 

func postorderTraversal(root *TreeNode) []int {
	var res []int
	var stack = []*TreeNode{root}
	for 0 < len(stack) {
		if root != nil {
			res = append(res, root.Val)
			stack = append(stack, root.Left)  //left node push
			stack = append(stack, root.Right) //right node push
		}
		index := len(stack) - 1 //top
		root = stack[index]     //pop
		stack = stack[:index]
	}

	//Reverse turns into a post-order traversal
	l, r := 0, len(res)-1
	for l < r {
		res[l], res[r] = res[r], res[l]
		l++
		r--
	}
	return res
}
######################################################################################
/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func levelOrder(root *TreeNode) [][]int {
    return dfs(root, 0, [][]int{})
}

func dfs(root *TreeNode, level int, res [][]int) [][]int {
	if root == nil {
		return res
	}
	if len(res) == level {
		res = append(res, []int{root.Val})
	} else {
		res[level] = append(res[level], root.Val)
	}
	res = dfs(root.Left, level+1, res)
	res = dfs(root.Right, level+1, res)
    return res
}

/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func levelOrder(root *TreeNode) [][]int {
	var result [][]int
	if root == nil {
		return result
	}
    //Define a two-way queue
	queue := list.New()
    // The header inserts the root node
	queue.PushFront(root)
    // BFS
	for queue.Len() > 0 {
		var current []int
		listLength := queue.Len()
		for i := 0; i < listLength; i++ {
		    // Consumption of the tail
            // queue.Remove(queue.Back()).(*TreeNode)：Remove the last element and convert it to the TreeNode type
			node := queue.Remove(queue.Back()).(*TreeNode)
			current = append(current, node.Val)
			if node.Left != nil {
			    //Insert the head
				queue.PushFront(node.Left)
			}
			if node.Right != nil {
				queue.PushFront(node.Right)
			}
		}
		result = append(result, current)
	}
	return result
}

