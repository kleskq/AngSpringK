package pl.lodz.uni.math.api.persistence.dao;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.lodz.uni.math.api.persistence.dao.pojo.Category;

import java.util.List;

@Repository
public class CategoryDaoImpl implements CategoryDao {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public Category getCategory(String categoryName) {
		List<Category> category = sessionFactory.getCurrentSession().createCriteria(Category.class)
				.add(Restrictions.eq("categoryName", categoryName)).list();
		if (category.isEmpty()) {
			return null;
		} else {
			return category.get(0);
		}
	}

}
