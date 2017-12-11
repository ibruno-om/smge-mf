package br.ufg.smge.domain.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @author ibruno
 *
 */
@Entity
@Table(name = "user", schema = "app")
public class User extends PersistenceModel {

	private static final long serialVersionUID = -6266790100180643052L;

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	@Transient
	private String passwordConfirm;

	@ManyToMany(cascade = { CascadeType.PERSIST })
	@JoinTable(schema = "app", name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles;

	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String username, String password, Set<Role> roles) {
		super();
		this.username = username;
		this.password = password;
		this.roles = roles;
	}

	/**
	 * @return
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return
	 */
	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	/**
	 * @param passwordConfirm
	 */
	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	/**
	 * @return
	 */
	public Set<Role> getRoles() {
		return roles;
	}

	/**
	 * @param roles
	 */
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

}
