package entity;

/**
 * 
 * @描述 用户实体类
 * @作者 lubiao
 * @时间 2017年8月7日-下午6:30:56
 *
 */
public class User {

	private int id;
	private String name;
	private String password;
	private String sex;
	private String city;
	private String phone;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public User(String name, String password, String sex, String city, String phone) {
		super();
		this.name = name;
		this.password = password;
		this.sex = sex;
		this.city = city;
		this.phone = phone;
	}

	public User() {
		super();
	}

}
