func isInterleave(s1 string, s2 string, s3 string) bool {
    n, m, t := len(s1), len(s2), len(s3)
    if (n + m) != t {
        return false             //判断s1+s2是否等于s3
    }
    dp := make([]bool, m + 1)
    dp[0] = true               //考虑起点即为终点
    for i := 0; i <= n; i++ {
        for j := 0; j <= m; j++ {
            if i > 0 {
                dp[j] = dp[j] && s1[i-1] == s3[i+j-1]  //判断i=0时 的边界状况
            }
            if j > 0 {
                dp[j] = dp[j] || dp[j-1] && s2[j-1] == s3[i+j-1]  //计算一般情况下
            }
        }
    }
    return dp[m]    
}
