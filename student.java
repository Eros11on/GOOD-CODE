
public class student{
    public static void main(String[] args){
    while(true){
       System.out.println("---------------------------------------");
       System.out.println("*                                     *");
       System.out.println("*      欢迎进入学生成绩管理系统       *");
       System.out.println("*                                     *");
       System.out.println("---------------------------------------");
  System.out.println("请选择您的操作：");
  System.out.println("               1、录入学生成绩信息");
  System.out.println("               2、显示学生成绩信息");
  System.out.println("               0、退出");
  System.out.println("请选择按键（0-2）");
  Scanner sc = new Scanner(System.in);
  int num = sc.nextInt();
  switch(num){   
      case 1:
      System.out.println("请输入录入信息！");break;
      case 2:
      System.out.println("请输入您要查询的学生姓名及学号");break;
      case 0:
      System.out.println("您已安全退出！");break;
      default:
      System.out.println("输入错误，请重新输入！"); break;
             }
         }
  
}
}
