package Shanhl;

public class Shanhl {
	public static void main(String[] args) {
		Shanhl shanhl1=new Shanhl(47,"female",6666,99);
}
}
public class Shanhl {
	private int age;
	private String sex;
	private long id;
	private int level;

	public Shanhl() {};
	public Shanhl(int age, String sex, long id,int level)
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

}
//创建红蕾1号
