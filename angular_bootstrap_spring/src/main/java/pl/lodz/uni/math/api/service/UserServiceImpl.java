package pl.lodz.uni.math.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.lodz.uni.math.api.persistence.dao.UserDao;
import pl.lodz.uni.math.api.persistence.dao.pojo.User;
import pl.lodz.uni.math.dto.UserDto;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	@Override
	public List<UserDto> getUsers() {
		List<User> users = userDao.getUsers();
		List<UserDto> resoult = new ArrayList<>();
		for (User user : users) {
			UserDto userTmp = new UserDto();
			if (user.getEnabled() == 1) {
				userTmp.setIsEnabled("User Account Enabled");
			} else {
				userTmp.setIsEnabled("User Account Disabled");
			}
			userTmp.setUserName(user.getUserName());
			resoult.add(userTmp);
		}
		return resoult;
	}

}
