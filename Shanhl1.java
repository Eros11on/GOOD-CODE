public class Shanhl1 {
	private int age;
	private String sex;
	private long id;
	private int level;

	public Shanhl1(int age, String sex, long id,int level)
	{
		this.age=age;
		this.sex=sex;
		this.id=id;
		this.level=level;
	}
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		if(id<=0) id=1;
		else
		this.id = id;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		if(level<1||level>999) {
			this.level=1;//如果级别超限，设为默认
					}
		
	else {
		this.level = level;
	}
	}
               public void itroduce(){
                      System.out.println("红蕾一号创建成功"+"单红蕾"+age+sex+id+level);
}
//创建红蕾1号
	public static void main(String[] args) {
                Shanhl1 shanhl1=new Shanhl1(47,"female",6666,99);
                
}
}
