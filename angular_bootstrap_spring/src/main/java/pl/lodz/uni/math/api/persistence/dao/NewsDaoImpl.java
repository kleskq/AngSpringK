package pl.lodz.uni.math.api.persistence.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.lodz.uni.math.api.persistence.dao.pojo.News;

@Repository
public class NewsDaoImpl implements NewsDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional 
	@SuppressWarnings("unchecked")
	@Override
	public List<News> getAll() {
		return sessionFactory.getCurrentSession().createCriteria(News.class).list();
	}

	@Override
	public boolean saveNews(News news) {
		// TODO Auto-generated method stub
		return false;
	}

}
