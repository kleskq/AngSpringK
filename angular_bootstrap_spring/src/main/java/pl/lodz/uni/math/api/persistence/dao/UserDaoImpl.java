package pl.lodz.uni.math.api.persistence.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.lodz.uni.math.api.persistence.dao.pojo.User;

@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public User getUser(String userName) {
		List<User> user = sessionFactory.getCurrentSession().createCriteria(User.class).add(Restrictions.eq("UserName", userName)).list();
		if (user.isEmpty()) {
			return null;
		} else {
			return user.get(0);
		}
	}

}
