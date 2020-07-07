public class Example {
   public static void main(String args[]) {
      ChinaPeople chinaPeople=new ChinaPeople();
      AmericanPeople americanPeople=new AmericanPeople();
      BeijingPeople beijingPeople=new BeijingPeople();
      chinaPeople.speakHello();
      americanPeople.speakHello();
      beijingPeople.speakHello();
      chinaPeople.averageHeight();
      americanPeople.averageHeight();
      beijingPeople.averageHeight();
      chinaPeople.averageWeight();
      americanPeople.averageWeight();
      beijingPeople.averageWeight();
      chinaPeople.chinaGongfu();
      americanPeople.americanBoxing();
      beijingPeople.beijingOpera() ;
      beijingPeople.chinaGongfu();
   }  
}


class People {
   protected double weight,height;
   public void speakHello() {
      System.out.println("yayayaya");
   }  
   public void averageHeight() {
       height=173;
       System.out.println("average height:"+height);
   }
   public void averageWeight() {
      weight=70;
      System.out.println("average weight:"+weight);
   }
}

class ChinaPeople extends People {
     public void speakHello() {   
        System.out.println("您好");
     }    
     public void averageHeight() { 
        height = 168.78;  
        System.out.println("中国人的平均身高:"+height+" 厘米");   
     }
     public void averageWeight(){
    	 weight=65;
    	 System.out.println("中国人的平均体重:"+weight+"公斤");
     } //重写public void averageWeight()方法，输出:"中国人的平均体重：65公斤"
     public void chinaGongfu() {
        System.out.println("坐如钟,站如松,睡如弓");
     }
}

class AmericanPeople extends People {
    public void speakHello(){
    	System.out.println("How do you do");
    }//重写public void speakHello()方法，输出"How do you do"
    public void averageHeight() { 
        height = 176;  
        System.out.println("American's average height:"+height+" 厘米");   
     }//重写public void averageHeight()方法，输出"American's average height:176 cm"
     public void averageWeight() { 
        weight = 75;  
        System.out.println("American's average weight:"+weight+" kg");   
     }
     public void americanBoxing() {
        System.out.println("直拳、钩拳、组合拳");
     }
}
class BeijingPeople extends ChinaPeople {
	 public void averageHeight() { 
	        height = 172.5;  
	        System.out.println("北京人的平均身高:"+height+" 厘米");   
	     } //重写public void averageHeight()方法,输出:"北京人的平均身高: 172.5厘米"
	 public void averageWeight() { 
	        weight = 70;  
	        System.out.println("北京人的平均体重:"+weight+" kg");   
	     }//重写public void averageWeight()方法,输出:"北京人的平均体重：70公斤"
   public void beijingOpera() { 
       System.out.println("花脸、青衣、花旦和老生");
   }
}
