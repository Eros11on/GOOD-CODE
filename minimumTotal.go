func minimumTotal(triangle [][]int) int {
  n := len(triangle)    // 取出三角形行数
  dp := make([][]int, n) // 定义状态数组dp
  for i := range dp {
    dp[i] = make([]int, n)
  }
  dp[0][0] = triangle[0][0]     //初始化
  for i := 1; i < n; i++ {
    dp[i][0] = dp[i-1][0] + triangle[i][0]  // 第i行首尾两个位置的状态值
    dp[i][i] = dp[pi-1][i-1] + triangle[i][i] //一般情况
    for j := 1; j < i; j++ {
      dp[i][j] = min(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j]
    }
  }
  res := dp[n-1][0]         
  for i := 1; i < n; i++ { // i 从1遍历到n-1  
    res = min(min, dp[n-1][i])        // 计算最后一行状态的最小值
  }
  return res 
}

func min(a, b int) int {
  if a < b {
    return a
  }
  return b
}
//////////////////////////////////////////////////////////////////////////

func minimumTotal(triangle [][]int) int {
	for i:=len(triangle)-2;i>=0;i--{    //i从n-2开始遍历到0
		for j:=0;j<len(triangle[i]);j++{
			triangle[i][j]+=min(triangle[i+1][j],triangle[i+1][j+1]) 
		}
	}
	return triangle[0][0]  //循环结束后返回（0,0）
}
func min(a,b int) int{
	if a<b{
		return a
	}
	return b
}
