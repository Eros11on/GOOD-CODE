func isValid(s string) bool {
	if s == "" {
		return true
	}                      // Empty strings are valid by default
	if len(s)%2 == 1 {
		return false
	}                     // An odd number of parentheses will not match
	keyMap := map[string]string{
		"}": "{",
		"]": "[",
		")": "(",
	}                     //Establish correspondence
	var stack []string
	for i := 0; i < len(s); i++ {
		if len(stack) > 0 {
			tmp, ok := keyMap[string(s[i])]       // The stack is not empty
		 		if ok {
				top := stack[len(stack)-1]      // The current element is the right half bracket
	// If the mapping to the element currently traversed is the same as the bracket at the top of the stack
				if top == tmp {
					// pop
					stack = stack[:len(table)-1]
					// skip this loop
					continue
				}
			} 
		}
		// Empty stack or no match, add stack
		stack = append(stack, string(s[i]))
	}
	// If the last stack is empty, it all matches, and returns true
	return len(stack) == 0
}
