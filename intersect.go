func intersect(nums1 []int, nums2 []int) []int {
	sort.Ints(nums1)
	sort.Ints(nums2)  //对两数组排序
	res := []int{}    //创建第三个数组
	i,j := 0,0
	for i < len(nums1) && j < len(nums2) {
		if nums1[i] < nums2[j] {      //如果两个元素不相同，对小元素所在数组后一位遍历
				i++
		}else if nums1[i] > nums2[j] {
				j++                     //如果两个元素不相同，对大元素所在数组后一位遍历
		}else {
				res = append(res,nums1[i])    //判断两个数组中的相同元素，将相同元素添加到第三个数组中，并将两个数组向右一位移动
				i++
				j++      
		}
	}
	return res
}


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

func intersect(nums1 []int, nums2 []int) []int {
    if len(nums1) > len(nums2) {
        return intersect(nums2, nums1)  //获取两个数组中的全部记录
    }
    m := map[int]int{}
    for _, num := range nums1 {
        m[num]++               //遍历较长数组，并记录各元素出现次数
    }

    res := []int{}
    for _, num := range nums2 {
        if m[num] > 0 {
            res = append(res, num)    //遍历较短数组，如果出现的元素次数大于0，将其放到第三个数组中
            m[num]--
        }
    }
    return res
}
