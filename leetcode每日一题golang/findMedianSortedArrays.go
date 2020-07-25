func findMedianSortedArrays(nums1 []int, nums2 []int) float64 {
	Length := len(nums1) + len(nums2)    // Calculate the total length of the array
	if Length % 2 == 1 {
		return float64(getKthElement(nums1, nums2, totalLen / 2 + 1))  // Dentermin whether it's odd or even
	}
	return float64(getKthElement(nums1, nums2, totalLen / 2) + getKthElement(nums1, nums2, totalLen / 2 + 1)) / 2.0
}

func getKthElement(nums1 []int, nums2 []int, k int) int {
	index1, index2 := 0, 0
	for {
		// Determine whether the loop has completed
		if index1 == len(nums1) {
			return nums2[index2 + k - 1]
		}                           // take the middle value of nums2
		if index2 == len(nums2) {
			return nums1[index1 + k - 1]
		}
		if k == 1{
			return min(nums1[index1], nums2[index2])  //the length of nums1 equals nums2
		}      //Returns the smallest first element in both arrays,because the purpose of getKthElement is to find the k smallest element

		half := k / 2
		// Determine whether cross the line
		newIndex1 := min(index1 + half, len(nums1)) - 1
		newIndex2 := min(index2 + half, len(nums2)) - 1

		pivot1, pivot2 := nums1[newIndex1], nums2[newIndex2]
		if pivot1<= pivot2 {
			k -= (newIndex1 - index1) + 1
			index1 = newIndex1 + 1
		} else {
			k -= (newIndex2 - index2) + 1
			index2 = newIndex2 + 1
		}
 	}
	return 0
}
func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}
