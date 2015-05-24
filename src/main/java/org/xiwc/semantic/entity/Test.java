package org.xiwc.semantic.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@NamedQuery(name = "Test.listAll", query = "select t from Test t")
public class Test implements Serializable {

	/** serialVersionUID long */
	private static final long serialVersionUID = -3935713828083820001L;
	@Id
	@GeneratedValue
	public Long id;
	public String firstName;
	public String lastName;
	@NotBlank
	@Column(nullable = false, length = 200)
	public String userName;
	@Length(min = 8, max = 100)
	@Column(nullable = false, length = 100)
	public String password;
	@Enumerated(value = EnumType.ORDINAL)
	public Sex sex;
	@Min(0)
	@Max(200)
	public Double age;

	@OneToMany(mappedBy = "test", cascade = { CascadeType.PERSIST }, fetch = FetchType.LAZY)
	private Set<ChildTest> childTests;

	public Test() {
		super();
	}

	public Test(String firstName, String lastName, String userName, String password, Sex sex, Double age) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.sex = sex;
		this.age = age;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public Double getAge() {
		return age;
	}

	public void setAge(Double age) {
		this.age = age;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<ChildTest> getChildTests() {
		return childTests;
	}

	public void setChildTests(Set<ChildTest> childTests) {
		this.childTests = childTests;
	}

	@Override
	public String toString() {
		return "Test [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", userName=" + userName
				+ ", password=" + password + ", sex=" + sex + ", age=" + age + "]";
	}

}
