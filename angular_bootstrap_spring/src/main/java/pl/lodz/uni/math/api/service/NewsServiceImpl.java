package pl.lodz.uni.math.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.lodz.uni.math.api.persistence.dao.NewsDao;
import pl.lodz.uni.math.api.persistence.dao.pojo.News;
import pl.lodz.uni.math.dto.NewsDto;

@Service
public class NewsServiceImpl implements NewsService {

	@Autowired
	private NewsDao newsDao;

	@Override
	public List<NewsDto> getAll() {
		List<News> newsList = newsDao.getAll();
		List<NewsDto> newsDtos = new ArrayList<NewsDto>();
		for (News news : newsList) {
			newsDtos.add(new NewsDto(news.getNewsTitle(), news.getNewsText(), news.getAuthor().getUserName(), news.getLink(),
					news.getPlusRating(), news.getMinusRating(), news.getCreateDate(), news.getNewsImageUrl(), news.getCategory()
							.getCategoryName()));
			
		}
		return newsDtos;
	}
}
