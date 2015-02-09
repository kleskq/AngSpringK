package pl.lodz.uni.math.api.persistence.dao;

import java.util.List;

import pl.lodz.uni.math.api.persistence.dao.pojo.News;

public interface NewsDao {

	public List<News> getAll();
	
	public boolean saveNews(News news);

	public News getNews(long id);

	public long getNewsCount();
	
}
