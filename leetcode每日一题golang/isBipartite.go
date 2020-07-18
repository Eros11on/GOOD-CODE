func isBipartite(graph [][]int) bool {
    type color int
	const (
		blue = 1
		red  = 2
	)                     //设置染色的颜色
	getColor := func(c color) color {
		if c == blue {
			return red
		}
		return blue
	}                   //设置染色规则
	m := map[int]color{}
	res := true
	var dfs func(v int, c color)
	dfs = func(v int, c color) {
		if !res {
			return
		}                	// 保存已访问过的顶点，以及它们的颜色
		if m[v] != 0 {
			if m[v] != c {
				res = false
			}
			return
		}   // 如果一个顶点已经被访问过，则需要跳过，而跳过前需要判断它的颜色有没有冲突，若有则返回false
		m[v] = c
		for _, w := range graph[v] {
			dfs(w, getColor(c))
		}
	}
	for v := range graph {
		if m[v] == 0 {
			dfs(v, blue)
		}
		if !res {
			break
		}
	}  
 // 用例中的图不一定是连通的，因此需要对每个子图进行判断;直接循环所有顶点
 //   如果某个顶点所在子图已经执行过，则跳过
	return res
}
