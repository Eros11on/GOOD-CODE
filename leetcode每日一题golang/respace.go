package main
import "fmt"
func respace(dictionary[]string, sentence string) int {
	dic := make(map[string]bool, len(dictionary)) 
	// dp[i]代表sentence[:i]中未识别的字符数,用map类型更加方便查找
	for _, v := range dictionary {
		dic[v] = true    //循环遍历输入的字典
	}
	dp := make([]int, len(sentence)+1)// 定义dp[i]为sentence[:i]在字典中未识别的单词
	for i := 1; i <= len(sentence); i++ {
		dp[i] = dp[i-1] + 1      //先假定新加这个字符之后没有匹配到任何单词
		for j := 0; j < i; j++ {
			if dic[sentence[j:i]] && dp[j] < dp[i] {
				dp[i] = dp[j]    
		//遍历从j到i,不包括索引i组成的子字符串是否能匹配上字典里的单词，
			}
		}
	}
	return dp[len(sentence)] //返回未识别的字符数
}
func main(){
	var dictionaryA =[]string{"looked","just","like","her","brother"}
	var sentenceB ="jesslookedjustliketimherbrother"
	arr :=respace(dictionaryA, sentenceB)
	fmt.Println(arr)
}