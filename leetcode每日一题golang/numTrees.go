func numTrees(n int) int {
	g := make([]int, n+1)   //定义大小为n+1的数组
	g[0] = 1
	g[1] = 1               //初始化
	for i := 2; i <= n; i++ {      //从i遍历到n
		for j := 1; j <= i; j++ {     //j从1遍历到i
			g[i] += g[j-1] * g[i-j]
		}
	}
	return g[n]
}
