package pl.lodz.uni.math.api.persistence.dao;

import java.util.List;

import pl.lodz.uni.math.api.persistence.dao.pojo.User;

public interface UserDao {

	public User getUser(String userName);

	public List<User> getUsers();
}
