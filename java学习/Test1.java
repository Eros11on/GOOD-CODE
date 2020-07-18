public class Test1{
	public static void main(String[] args) {
		Animal a = new Animal(); // 定义抽象类Animal的引用变量a
		a= new Cat(); // 创建一个Cat类的对象赋给a
		a.cry();  // 调用a的cry方法
		a.eat();  //调用a的eat方法
		a= new Dog();  // 创建一个Dog类的对象赋给a
		a.cry();  ;// 调用a的cry方法
		a.eat();  //调用a的eat方法
	}
}
	class Animal { //抽象类
	 void cry(){
		 System.out.println("yayaya");
	 } // 定义public类型无返回值的抽象方法cry()
	 void eat(){
		 System.out.println("meat"); 
	 } // 定义public类型无返回值的抽象方法eat()
}

class Cat extends Animal{
	public void cry(){
		System.out.println("喵星人");
	}
	public void eat(){
		System.out.println("猫吃鱼");
	}
}
class Dog extends Animal{
	public void cry(){
		System.out.println("汪星人");
	}
	public void eat(){
		System.out.println("狗吃骨头");
	}
}
