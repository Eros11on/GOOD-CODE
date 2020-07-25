func search(nums []int, target int) int {
	left := 0
	right := len(nums) - 1 
	for left <= right {
		mid := (left + right) / 2        //find the median
		if nums[mid] == target {
			return mid         //determine whether to look in the first half
		}
		if (nums[left] <= target && target <= nums[mid]) || (nums[mid] <= nums[right] && (target < nums[mid] || target > nums[right]))  {       //determine which part the target is
			right = mid - 1
		} else {
			left = mid + 1
		}
	}
    return -1
}
