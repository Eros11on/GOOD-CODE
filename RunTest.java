public class RunTest{
	public static void main(String[] args){
		Runable r; // 声明Runable接口变量r
		r= new Cat(); // 接口变量r中存放一个Cat对象的引用
        r.run();// 调用Cat对象的run()方法
		System.out.println("-----------");
		r=new Dog(); // 接口变量r中存放一个Dog对象的引用
      r.run();  // 调用Dog对象的run()方法
	}
}

interface Runable{
	void run();
}
class Cat implements Runable{
	public void run(){
		System.out.println("猫急上树..");
	}
}
class Dog implements Runable{// 参照Cat类，定义Dog类并实现Runable接口
	public void run(){
		System.out.println("狗急跳墙..");
	}
}
