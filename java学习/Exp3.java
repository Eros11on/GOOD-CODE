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
	      System.out.println("car1的功率是："+car1.getPower());
	      System.out.println("car2的功率是："+car2.getPower());
	      System.out.println("car3的功率是："+car3.getPower());
	      car1.speedUp(80); 
	      car2.speedUp(100);
	      car3.speedUp(30);
	      System.out.println("car1目前的速度："+car1.getSpeed());
	      System.out.println("car2目前的速度："+car2.getSpeed());
	      System.out.println("car3目前的速度："+car3.getSpeed());
	      car1.speedDown(10);
	      car2.speedDown(20);
	      car3.speedDown(30);
	      System.out.println("car1目前的速度："+car1.getSpeed());
	      System.out.println("car2目前的速度："+car2.getSpeed());
	      System.out.println("car3目前的速度："+car3.getSpeed());
	   }


	}
class Vehicle {
    double speed;//声明double型变量speed,刻画速度
    int power;//声明int型变量power,刻画功率 
    Vehicle() {
    }// 为Vehicle类定义一个空的构造函数
   
    Vehicle(int power){
	     this.power=power;//将参数power的值赋值给成员变量power;
	}
    Vehicle(double speed, int power){
    	this.power=power;//将参数speed的值赋值给成员变量speed;
	    this.speed=speed;//将参数power的值赋值给成员变量power;
	}
    void speedUp(int s) {      
         this.speed=s+this.speed;//将参数s的值与成员变量speed的和赋值给成员变量speed
    } 
    void speedDown(int d) {   
         this.speed=this.speed-d;//将成员变量speed与参数d的差赋值给成员变量speed
    } 
    void setPower(int p) {
          power=p;//将参数p的值赋值给成员变量power
    }
    int getPower() {
          return power;//返回成员变量power的值
    }
    double getSpeed() {
          return speed;
    }
}
