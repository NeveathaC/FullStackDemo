package com.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Query;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.hibernate.Session;

@Entity
@Table(name="UserTable")
@XmlRootElement
@XmlType(propOrder ={"userId","userName","password"})
public class User implements Serializable {
	//Serialize is to maintain state of the object
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="userId",length=5)
	private int userId;
	@Column(name="userName")
	private String userName;
	@Column(name="password",length=5)
	private String password;

	public User() {
		super();
		
	}

	

	public User(int userId, String userName, String password) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
/*Session session = this.sessionFactory.openSession();
//Transaction tx=session.beginTransaction();
// HQl(based on java file
System.out.println("i am in dao readbyid");
//	String hqlRead = "from User alais where alais.userId=userId";
String hqlRead = "from User where userId=:userId";
List<User> users = session.createQuery(hqlRead).setParameter(userId, userId).list();
 //users.setInt(userId,userId);
 return users.get(0);
Query query = session.createQuery(hqlRead);
query.setParameter("userId",userId);
@SuppressWarnings("unchecked")
Query query = session.createQuery(hqlRead);
query.setParameter("userId", userId);
List<User> users=((org.hibernate.query.Query) query).list();

//    return users.get(0);
int r=query.executeUpdate();
System.out.println(r);
//tx.commit();
session.close();
int r=query.executeUpdate();
System.out.println(r);
return null;
*/