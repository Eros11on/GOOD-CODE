public class RunTest{
	public static void main(String[] args){
		Runable r; // ����Runable�ӿڱ���r
		r= new Cat(); // �ӿڱ���r�д��һ��Cat���������
        r.run();// ����Cat�����run()����
		System.out.println("-----------");
		r=new Dog(); // �ӿڱ���r�д��һ��Dog���������
      r.run();  // ����Dog�����run()����
	}
}

interface Runable{
	void run();
}
class Cat implements Runable{
	public void run(){
		System.out.println("è������..");
	}
}
class Dog implements Runable{// ����Cat�࣬����Dog�ಢʵ��Runable�ӿ�
	public void run(){
		System.out.println("������ǽ..");
	}
}
