package pl.lodz.uni.math.api.persistence.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
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

	@Transactional
	@Override
	public boolean saveNews(News news) {
		sessionFactory.getCurrentSession().save(news);
		return true;
	}

	@SuppressWarnings({ "unchecked" })
	@Transactional
	@Override
	public News getNews(long id) {
		List<News> news = sessionFactory.getCurrentSession().createCriteria(News.class).add(Restrictions.eq("link", id)).list();
		if (news.isEmpty()) {
			return null;
		} else {
			return news.get(0);
		}
	}

	@Transactional
	@Override
	public long getNewsCount() {
		return (long) sessionFactory.getCurrentSession().createCriteria(News.class).list().size();
	}
}
