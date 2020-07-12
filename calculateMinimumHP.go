func calculateMinimumHP(dungeon [][]int) int {

	n := len(dungeon)
	m := len(dungeon[0])    //读取网格数
	dp := make([][]int, n)  //创建动态存储空间，即勇士健康点
	for i := 0; i < n; i++ {
		dp[i] = make([]int, m)
	}
	if dungeon[n-1][m-1] > 0 {
	dp[n-1][m-1] = 1//判断最后一格即公主所在格数的上面和左边两格数值是否大于0，若是则勇士健康点为1
	} else {
		dp[n-1][m-1] = 1 - dungeon[n-1][m-1] //不是，则上一步dp-当前格数值
	}
	for i := n - 1; i >= 0; i-- {
		for j := m - 1; j >= 0; j-- {
			if i == n-1 && j == m-1 {
				continue      //判断健康点是否大于0，不是则死亡
			} else if j == m-1 {
				dp[i][j]=Max(1,(dp[i+1][j]-dungeon[i][j]))
			} else if i == n-1 {
				dp[i][j]=Max(1, (dp[i][j+1]-dungeon[i][j]))
			}else {
                t1 :=Max(1,dp[i+1][j]-dungeon[i][j])
                t2 :=Max(1,dp[i][j+1]-dungeon[i][j])
				dp[i][j]=Min(t1,t2)
			}                    //两次循环判断一般情况，获得最小值
		}
	}                         
	return dp[0][0]
}
func Min(x, y int) int {
    if x < y {
        return x
    }
    return y
}

func Max(x, y int) int {
    if x > y {
        return x
    }
    return y
}