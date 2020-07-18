package main



func divingBoard(shorter int, longer int, k int) []int {
	length :=make([]int,k+1) 
	if k==0{
	return nil
	}
	if shorter == longer{
		return []int{shorter*k}
	}
		for i:=0;i<=k;i++{
			length[i]=shorter*i+longer*(k-i)
		}
	return length
	}
	func main(){
		divingBoard(2,1,5)
		
	}