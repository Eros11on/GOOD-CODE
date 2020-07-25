func twoSum(numbers []int, target int) []int {
    i,j := 0, len(numbers) - 1            //set the left and right Pointers
    for i < j {
        sum := numbers[i] + numbers[j]    //calculates the sum of the elements to which the two Pointers point
        if sum == target {                
         return []int{i + 1, j + 1}  //if equal to the target value, returns the index indicated by the pointer
        } else if sum < target {
            i++                      //the left pointer moves left
        } else {
            j--                     //the right pointer moves right
 
        }
    }
    return []int{-1, -1}
}
