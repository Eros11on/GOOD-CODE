public class Exp3 {
	   public static void main(String args[]) {
	      Vehicle car1;    
	      car1 = new Vehicle(); 
	      car1.setPower(128);
	      Vehicle car2 = new Vehicle();
	      car2.power=76;
	      Vehicle car3 = new Vehicle();
	      car3.speed=40.5;
	      car3.power=85;
	      System.out.println("car1�Ĺ����ǣ�"+car1.getPower());
	      System.out.println("car2�Ĺ����ǣ�"+car2.getPower());
	      System.out.println("car3�Ĺ����ǣ�"+car3.getPower());
	      car1.speedUp(80); 
	      car2.speedUp(100);
	      car3.speedUp(30);
	      System.out.println("car1Ŀǰ���ٶȣ�"+car1.getSpeed());
	      System.out.println("car2Ŀǰ���ٶȣ�"+car2.getSpeed());
	      System.out.println("car3Ŀǰ���ٶȣ�"+car3.getSpeed());
	      car1.speedDown(10);
	      car2.speedDown(20);
	      car3.speedDown(30);
	      System.out.println("car1Ŀǰ���ٶȣ�"+car1.getSpeed());
	      System.out.println("car2Ŀǰ���ٶȣ�"+car2.getSpeed());
	      System.out.println("car3Ŀǰ���ٶȣ�"+car3.getSpeed());
	   }


	}
class Vehicle {
    double speed;//����double�ͱ���speed,�̻��ٶ�
    int power;//����int�ͱ���power,�̻����� 
    Vehicle() {
    }// ΪVehicle�ඨ��һ���յĹ��캯��
   
    Vehicle(int power){
	     this.power=power;//������power��ֵ��ֵ����Ա����power;
	}
    Vehicle(double speed, int power){
    	this.power=power;//������speed��ֵ��ֵ����Ա����speed;
	    this.speed=speed;//������power��ֵ��ֵ����Ա����power;
	}
    void speedUp(int s) {      
         this.speed=s+this.speed;//������s��ֵ���Ա����speed�ĺ͸�ֵ����Ա����speed
    } 
    void speedDown(int d) {   
         this.speed=this.speed-d;//����Ա����speed�����d�Ĳֵ����Ա����speed
    } 
    void setPower(int p) {
          power=p;//������p��ֵ��ֵ����Ա����power
    }
    int getPower() {
          return power;//���س�Ա����power��ֵ
    }
    double getSpeed() {
          return speed;
    }
}
