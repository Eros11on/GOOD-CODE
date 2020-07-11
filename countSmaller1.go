package main
import "fmt"
func countSmaller(nums []int) []int {
    counts:=[]int{}  //创建空数组counts
  for i, num := range nums{
    count :=0      //先循环遍历num数组，定义一个计数变量count为0
    for j := i + 1; j < len(nums); j++{
      if nums[j] < num {
        count++      //进行内循环，找出右侧小于当前元素的个数
      }
    }
      counts = append(counts,count)  //将count计数合并到count数组中
  }
  return counts
}
func main(){
	var a =[]int{5,2,6,1}
	arr :=countSmaller(a)
	fmt.Println(arr)
}