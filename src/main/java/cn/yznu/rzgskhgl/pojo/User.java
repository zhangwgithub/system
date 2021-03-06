package cn.yznu.rzgskhgl.pojo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;


import cn.yznu.rzgskhgl.common.BaseEntity;

/**
 * 用户信息表
 * 
 * @author zhangw
 * @version 1.0
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "user")
public class User extends BaseEntity implements Serializable {
	@ManyToMany(targetEntity = Product.class)
	@JoinTable(name = "user_product", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = {
			@JoinColumn(name = "product_id") })
	private Set<Product> products;
	@ManyToMany
	@JoinTable(name = "user_role", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = {
			@JoinColumn(name = "role_id") })
	private List<Role> roles;
	/**
	 * 姓名
	 */
	@Column(length = 50)
	private String userName;
	/**
	 * 密码
	 */
	private String password;

	/**
	 * 电话
	 */
	@Column(length = 20)
	private long tel;
	/**
	 * 地址ַ
	 */
	@Column(length = 50)
	private String address;
	/**
	 * 性别
	 */
	@Column(length = 10)
	private String gender;

	/**
	 * 总资产
	 */
	@Column(name = "total_asset", length = 20)
	private double totalAssets;
	/**
	 * 总负债
	 */
	@Column(name = "total_liability", length = 20)
	private double totalLiability;
	/**
	 * 征信情况
	 */
	@Column(name = "credit_conditions", length = 30)
	private String creditConditions;
	/**
	 * 行业
	 */
	@Column(length = 50)
	private String industry;
	/**
	 * 房产(1:有,0:无)
	 */
	@Column(length = 2)
	private int estate;
	/**
	 * 动产(1:有,0:无)
	 */
	@Column(length = 2)
	private int movable;
	/**
	 * 公司˾(1:有,0:无)
	 */
	@Column(length = 2)
	private int company;
	/**
	 * 实体铺面(1:有,0:无)
	 */
	@Column(name = "solid_surfacing", length = 2)
	private int solidSurfacing;

	

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getTel() {
		return tel;
	}

	public void setTel(long tel) {
		this.tel = tel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public double getTotalAssets() {
		return totalAssets;
	}

	public void setTotalAssets(double totalAssets) {
		this.totalAssets = totalAssets;
	}

	public double getTotalLiability() {
		return totalLiability;
	}

	public void setTotalLiability(double totalLiability) {
		this.totalLiability = totalLiability;
	}

	public String getCreditConditions() {
		return creditConditions;
	}

	public void setCreditConditions(String creditConditions) {
		this.creditConditions = creditConditions;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public int getEstate() {
		return estate;
	}

	public void setEstate(int estate) {
		this.estate = estate;
	}

	public int getMovable() {
		return movable;
	}

	public void setMovable(int movable) {
		this.movable = movable;
	}

	public int getCompany() {
		return company;
	}

	public void setCompany(int company) {
		this.company = company;
	}

	public int getSolidSurfacing() {
		return solidSurfacing;
	}

	public void setSolidSurfacing(int solidSurfacing) {
		this.solidSurfacing = solidSurfacing;
	}

	@Override
	public String toString() {
		return "User [name=" + userName + ", tel=" + tel + ", address=" + address + ", gender=" + gender + ", totalAssets="
				+ totalAssets + ", totalLiability=" + totalLiability + ", creditConditions=" + creditConditions
				+ ", industry=" + industry + ", estate=" + estate + ", movable=" + movable + ", company=" + company
				+ ", solidSurfacing=" + solidSurfacing + "]";
	}

	public User(String name, int tel, String address, String gender, double totalAssets, double totalLiability,
			String creditConditions, String industry, int estate, int movable, int company, int solidSurfacing) {
		super();
		this.userName = name;
		this.tel = tel;
		this.address = address;
		this.gender = gender;
		this.totalAssets = totalAssets;
		this.totalLiability = totalLiability;
		this.creditConditions = creditConditions;
		this.industry = industry;
		this.estate = estate;
		this.movable = movable;
		this.company = company;
		this.solidSurfacing = solidSurfacing;
	}

	public User() {
		super();
	}

	@Transient
	public Set<String> getRolesName() {
		List<Role> roles = getRoles();
		Set<String> set = new HashSet<String>();
		for (Role role : roles) {
			set.add(role.getRoleName());
		}
		return set;
	}

}
