package pl.lodz.uni.math.api.persistence.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.lodz.uni.math.api.persistence.dao.pojo.News;
import pl.lodz.uni.math.api.persistence.dao.pojo.Rate;
import pl.lodz.uni.math.api.persistence.dao.pojo.User;

@Repository
public class RateDaoImpl implements RateDao {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public Rate getRateByUserAndNews(int userId, int newsId) {

		/*
		 * List<Rate> rate = sessionFactory.getCurrentSession().createQuery(
		 * "SELECT c FROM Rate c WHERE c.evaluator = :user AND c.news = :news")
		 * .setParameter("user", user).setParameter("news",
		 * news).setMaxResults(1).list();
		 */

		List<Rate> rate = sessionFactory.getCurrentSession().createCriteria(Rate.class, "rate")
				.createAlias("rate.evaluator", "user").createAlias("rate.news", "news")
				.add(Restrictions.eq("news.newsId", newsId)).add(Restrictions.eq("user.id", userId)).list();
		if (rate.isEmpty()) {
			return null;
		} else {
			return rate.get(0);
		}
	}

	@Override
	public boolean saveRating(Rate rate) {
		sessionFactory.getCurrentSession().save(rate);
		return true;
	}

}
