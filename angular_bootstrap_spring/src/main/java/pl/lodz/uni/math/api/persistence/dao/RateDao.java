package pl.lodz.uni.math.api.persistence.dao;

import pl.lodz.uni.math.api.persistence.dao.pojo.News;
import pl.lodz.uni.math.api.persistence.dao.pojo.Rate;
import pl.lodz.uni.math.api.persistence.dao.pojo.User;


public interface RateDao {

	public Rate getRateByUserAndNews(int userId, int newsId);

	public boolean saveRating(Rate rate);
}
