func searchInsert(nums []int, target int) int {
    for i := 0; i < len(nums); i++ {
        if nums[i] == target || nums[i] > target { // 相等或者不存在时
            return i
        } 
    }
    return len(nums)
}
///////////////////////////////////////////////////////////////////////////
func searchInsert(nums []int, target int) int {
    left :=0
    right := len(nums) - 1
    mid := 0                 //初始化
    for left <= right {      
        mid = (left+right)/2       //确定中间位置
        if nums[mid] == target {
            return mid             
        } else if nums[mid] > target {
            right = mid - 1
        }else {
            left = mid + 1     
        }
    }  //nums[mid] 和 target 之间的大小进行判断，相等则直接返回下标，nums[mid] < target 则 left 右移，nums[mid] > target 则 right 左移
    return left   //查找结束如果没有相等值则返回 left
}
