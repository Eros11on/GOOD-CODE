func maxArea(height []int) int {
	maxArea := 0
	for i, j := 0, len(height)-1; i < j; {
		lower := Min(height[i], height[j])           //find a smaller coordinate
		maxArea = Max((j-i)*lower, maxArea)          //calculate water load
		for height[i] <= lower && i < j {
			i++
		}                //if the current i ordinate is less than the smaller ordinate, the left pointer moves right
		for height[j] <= lower && i < j {
			j--
		}                //if the current j ordinate is less than the smaller ordinate, the right pointer moves left
	}
	return maxArea
}
func Max(a int, b int) int {
	if a > b {
		return a
	}
	return b
}
func Min(a int, b int) int {
	if a > b {
		return b
	}
	return a
}
