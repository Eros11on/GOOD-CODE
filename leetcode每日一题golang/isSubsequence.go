func isSubsequence(s string, t string) bool {
    n, m := len(s), len(t)  //the length of s and t
    i, j := 0, 0            //define two pointers,i reprents the shorter string , j reprents the longer string
    for i < n && j < m {    
        if s[i] == t[j] {   if the value of s[i] equals t[i],the pointer i moves right ,to the end
            i++
        }
        j++       //if not ,the pointer j moves right
    }
    return i == n
}
