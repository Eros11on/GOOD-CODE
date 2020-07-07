public class BMI{
public static void main(String[] args){
	int a=Integer.parseInt(args[0]);//weight
	int b=Integer.parseInt(args[1]);//heightinitial
	double c=b/100.0;//height
	double d=a/(c*c);//BMI
	System.out.println("Your weight:"+a+"kg\n");
	System.out.println("Your height:"+c+"m\n");
	System.out.println("Your BMI:");
	System.out.printf(".2f",d);//报错
	if(d<18.5)
	System.out.println("\nYou are in the Underweight range.");
	if(d>=18.5&&d<=24.9)
	System.out.println("\nYou are in the Normal range.");
	if(d>=25.0&&d<=29.9)
	System.out.println("\nYou are in the Overweight range.");
	if(d>=30)
	System.out.println("\nYou are in the Obese range.");

}

}