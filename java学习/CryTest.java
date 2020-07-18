public class CryTest{
	public static void main(String[] agrs){
		Animal  a =new Dog(); //使用new 运算符创建Dog对象a，并将a指定为Animal类型
		a.cry(); //调用a的cry()方法
		a=new Cat(); //将a指定为Cat类型
		a.cry(); //调用a的cry()方法
	}
}

class Animal {
     void cry(){}
}
class Dog extends Animal{
	void cry(){
		System.out.println("汪汪");
	}
}
class Cat extends Animal{
	void cry(){
		System.out.println("喵喵");
	}
}
