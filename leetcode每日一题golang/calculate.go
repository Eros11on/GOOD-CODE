func calculate(s string) int {
    num := 0  // Extract the Numbers in s
	res := 0  // Returns the result of the calculation
	sign := 1 //record operation symbol
	stack := make([]int, 0, len(s))
	for i := 0; i < len(s); i++ {
		switch s[i] {
		case '0', '1', '2', '3', '4', '5', '6', '7', '8', '9':
			num = 0
			for ; i < len(s) && s[i] >= '0' && s[i] <= '9'; i++ {
				// multi-digit Numbers
				num = 10*num + int(s[i]-'0')
			}
			res += sign * num
			i--
		case '+':
			sign = 1
		case '-':
			sign = -1
		case '(':
// When open bracket is encountered, push the current res and sign onto the stack and save the current runtime environment
			stack = append(stack, res, sign)
			res = 0
			sign = 1
		case ')':
			// when  close bracket is encountered,pop the stack
			// sign is the opreation symbol before ')'which matches '('
			sign = stack[len(stack)-1]
			// temp is the result of calculation before the sign
			temp := stack[len(stack)-2]
			stack = stack[:len(stack)-2]
			// '(' and ')' result of the calculation
			//          ↓
			res = sign*res + temp
		}
	}
	return res
}
