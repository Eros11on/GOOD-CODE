
public class student{
    public static void main(String[] args){
    while(true){
       System.out.println("---------------------------------------");
       System.out.println("*                                     *");
       System.out.println("*      ��ӭ����ѧ���ɼ�����ϵͳ       *");
       System.out.println("*                                     *");
       System.out.println("---------------------------------------");
  System.out.println("��ѡ�����Ĳ�����");
  System.out.println("               1��¼��ѧ���ɼ���Ϣ");
  System.out.println("               2����ʾѧ���ɼ���Ϣ");
  System.out.println("               0���˳�");
  System.out.println("��ѡ�񰴼���0-2��");
  Scanner sc = new Scanner(System.in);
  int num = sc.nextInt();
  switch(num){   
      case 1:
      System.out.println("������¼����Ϣ��");break;
      case 2:
      System.out.println("��������Ҫ��ѯ��ѧ��������ѧ��");break;
      case 0:
      System.out.println("���Ѱ�ȫ�˳���");break;
      default:
      System.out.println("����������������룡"); break;
             }
         }
  
}
}
