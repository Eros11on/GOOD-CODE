public class CryTest{
	public static void main(String[] agrs){
		Animal  a =new Dog(); //ʹ��new ���������Dog����a������aָ��ΪAnimal����
		a.cry(); //����a��cry()����
		a=new Cat(); //��aָ��ΪCat����
		a.cry(); //����a��cry()����
	}
}

class Animal {
     void cry(){}
}
class Dog extends Animal{
	void cry(){
		System.out.println("����");
	}
}
class Cat extends Animal{
	void cry(){
		System.out.println("����");
	}
}
