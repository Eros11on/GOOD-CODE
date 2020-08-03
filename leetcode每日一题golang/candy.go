func candy(ratings []int) int {
    l := len(ratings) 
    if l == 0 {
        return 0
    }                    //determine whether the array is empty or only has one num
    if l == 1 {
        return 1
    }
    var res []int
    res = append(res, 1)
    for i := 1; i < l; i++ {
        if ratings[i] > ratings[i - 1] {
            res = append(res, res[i - 1] + 1)      
        } else {
            res = append(res, 1)
        }
    }                                         //from left to right
    var sum = res[l - 1]
    for i := l - 2; i >= 0; i-- {
        if ratings[i] > ratings[i + 1] && res[i] <= res[i + 1] {
            res[i] = res[i + 1] + 1                //from right to left
        }
        sum = sum + res[i]                        //sum
    }
    return sum
}
