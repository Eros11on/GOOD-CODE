public class TryCatchFinallyExample{
	public static void main(String[] args)
	{
		//�ܼ��ӵĴ����
		try
		{
			//��������Ϊ4��int������
			int[] a=null;
			System.out.println("�������鴴����ϣ���");
			//Ϊ�������һ��Ԫ�ظ�ֵ
			a[3]=9;
			System.out.println("���������е��ĸ�Ԫ�ص���ֵΪ"+a[3]);
		}
		//�����±�Խ���쳣
		catch(ArrayIndexOutOfBoundsException aiobe)
		{
			//��ӡ��ʾ��Ϣ
			System.out.println("������ֵĴ��������ǣ������±�Խ�磡��");
		}
//����������쳣�����
		catch(NullPointerException npe)
		{
			//��ӡ��ʾ��Ϣ
			System.out.println("������ֵĴ��������ǣ������ã���");
		}
		//finally��
		finally
		{
			//��ӡ��ʾ��Ϣ
			System.out.println("������finally�飬�����Ƿ��׳��쳣����������ִ�У�");
		}
System.out.println("��������������������");		
	}
}
