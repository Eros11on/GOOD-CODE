func canJump(nums []int) bool {
n =len(nums)            define the length of the array
max =nums[0]            assume nums[0] is the maximum length for the first jump
 for i = 0; i  n; i++ {
        if nums[i] + i  max && max = i {      determine whether the current position plus i is greater than max
            max = nums[i] + i                 update jumps to the farthest position
        } 
        if max = n-1{               
            return true
        }
    }
    return false
}

