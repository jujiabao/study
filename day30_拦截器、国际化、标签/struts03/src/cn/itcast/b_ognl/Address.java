package cn.itcast.b_ognl;

public class Address {

	private String province;
	private String city;
	
	
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Address(String province, String city) {
		super();
		this.province = province;
		this.city = city;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
}
