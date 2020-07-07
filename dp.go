package main
func uniquePathsWithObstacles(obstacleGrid [][]int) int {
	n := len(obstacleGrid)
	m := len(obstacleGrid[0])//网格数
	dp :=make([]int, m) 
	if obstacleGrid [0][0]==0{
		dp[0] =1//坐标（0,0）即为终点，路径数为1
	}
	for i=0;i<=m;i++{
		for j=0;j<=n;j++{
			if obstacleGrid[i][j]==1{
				dp[j] =0//坐标（0,0）本身有障碍，路径数为0
			} 
			if j - 1 >= 0 {
				dp[j] = dp[j]+dp[j-1]//当向下移动时没有障碍，即得到总路径数
			}
	      }
		}
		return dp[len(dp)-1]//输出路径数
	}
