package main
import "fmt"
func maxProfit(prices []int) int {
   if len(prices) == 0 {
       return 0
       }                //判断股票价格是否为空
   days :=len(prices)   //定义天数
   dp := make([][3]int,len(prices)) //用make为dp分配内存
   dp[0][0] = 0
   dp[0][1] = -prices[0]
   dp[0][2] = 0        //三种初始状态

   for i:=1;i<len(prices);i++ {
       dp[i][0] = Max(dp[i-1][0],dp[i-1][2])
       dp[i][1] = Max(dp[i-1][0]-prices[i],dp[i-1][1])
       dp[i][2] = dp[i-1][1]+prices[i]
   }     //判断三种一般状态
   return Max(dp[days-1][0],dp[days-1][2])  
}    //对最后一天求利润最大值，因为i从1开始，所以是days-1
func Max(x int,y int) int{
   if x>y {
       return x
   }
   return y
}     //求最大值函数

func main(){
   var a=[]int{1,2,3,0,2}
   b :=maxProfit(a)
   fmt.Println(b)
}