public class Test1{
	public static void main(String[] args) {
		Animal a = new Animal(); // ���������Animal�����ñ���a
		a= new Cat(); // ����һ��Cat��Ķ��󸳸�a
		a.cry();  // ����a��cry����
		a.eat();  //����a��eat����
		a= new Dog();  // ����һ��Dog��Ķ��󸳸�a
		a.cry();  ;// ����a��cry����
		a.eat();  //����a��eat����
	}
}
	class Animal { //������
	 void cry(){
		 System.out.println("yayaya");
	 } // ����public�����޷���ֵ�ĳ��󷽷�cry()
	 void eat(){
		 System.out.println("meat"); 
	 } // ����public�����޷���ֵ�ĳ��󷽷�eat()
}

class Cat extends Animal{
	public void cry(){
		System.out.println("������");
	}
	public void eat(){
		System.out.println("è����");
	}
}
class Dog extends Animal{
	public void cry(){
		System.out.println("������");
	}
	public void eat(){
		System.out.println("���Թ�ͷ");
	}
}
