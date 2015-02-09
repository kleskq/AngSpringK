package pl.lodz.uni.math.api.persistence.dao.pojo;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class User implements Serializable {

	private static final long serialVersionUID = 3904900191776469823L;

	@Id
	@GeneratedValue
	@Column(name = "UserId")
	private int id;
	@Column(name = "userName")
	private String userName;
	@Column(name = "Password")
	private String password;
	@Column(name = "Enabled")
	private int enabled;
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<UserRole> userRoles;
	@OneToMany(mappedBy = "author", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<News> news;
	@OneToMany(mappedBy = "evaluator", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Rate> rates;

	public User() {
		super();
	}

	public User(int id, String userName, String password, int enabled, Set<UserRole> userRoles, Set<News> news, Set<Rate> rates) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.enabled = enabled;
		this.userRoles = userRoles;
		this.news = news;
		this.rates = rates;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	public Set<UserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

	public Set<News> getNews() {
		return news;
	}

	public void setNews(Set<News> news) {
		this.news = news;
	}

	public Set<Rate> getRates() {
		return rates;
	}

	public void setRates(Set<Rate> rates) {
		this.rates = rates;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + enabled;
		result = prime * result + id;
		result = prime * result + ((news == null) ? 0 : news.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (enabled != other.enabled)
			return false;
		if (id != other.id)
			return false;
		if (news == null) {
			if (other.news != null)
				return false;
		} else if (!news.equals(other.news))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", password=" + password + ", enabled=" + enabled + ", userRoles="
				+ userRoles + ", news=" + news + ", rates=" + rates + "]";
	}

}
