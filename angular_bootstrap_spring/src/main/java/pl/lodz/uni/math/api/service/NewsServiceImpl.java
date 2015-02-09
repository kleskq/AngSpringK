package pl.lodz.uni.math.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.lodz.uni.math.api.persistence.dao.CategoryDao;
import pl.lodz.uni.math.api.persistence.dao.NewsDao;
import pl.lodz.uni.math.api.persistence.dao.RateDao;
import pl.lodz.uni.math.api.persistence.dao.UserDao;
import pl.lodz.uni.math.api.persistence.dao.pojo.News;
import pl.lodz.uni.math.api.persistence.dao.pojo.Rate;
import pl.lodz.uni.math.dto.NewNewsDto;
import pl.lodz.uni.math.dto.NewsDto;
import pl.lodz.uni.math.dto.NewsListDto;
import pl.lodz.uni.math.dto.RateDto;

@Service
public class NewsServiceImpl implements NewsService {

	@Autowired
	private NewsDao newsDao;

	@Autowired
	private UserDao userDao;

	@Autowired
	private CategoryDao categoryDao;

	@Autowired
	private RateDao rateDao;

	@Override
	public List<NewsListDto> getAll() {
		List<News> newsList = newsDao.getAll();
		List<NewsListDto> newsDtos = new ArrayList<NewsListDto>();
		for (News news : newsList) {
			newsDtos.add(new NewsListDto(news.getNewsTitle(), news.getNewsText(), news.getAuthor().getUserName(), news.getLink(),
					news.getNewsImageUrl()));

		}
		return newsDtos;
	}

	@Override
	public NewsDto getNews(long id) {
		News news = newsDao.getNews(id);
		if (news == null) {
			return null;
		} else {
			Rate rate = rateDao.getRateByUserAndNews(news.getAuthor().getId(), news.getNewsId());
			int rating = 0;
			if (rate != null) {
				if (rate.getRating()) {
					rating = 1;
				} else {
					rating = -1;
				}
			}
			System.out.println(news.getRates().size());
			return new NewsDto(news.getNewsTitle(), news.getNewsText(), news.getAuthor().getUserName(), news.getPlusRating(),
					news.getMinusRating(), news.getCategory().getCategoryName(), news.getCreateDate(), news.getLink(),
					news.getNewsImageUrl(), rating);
		}
	}

	@Override
	public boolean saveNews(NewNewsDto newNewsDto) {
		News news = new News();
		news.setAuthor(userDao.getUser(newNewsDto.getAuthor()));
		news.setCreateDate(newNewsDto.getCreateDate());
		news.setLink(newNewsDto.getLink());
		news.setNewsImageUrl(newNewsDto.getImage());
		news.setNewsText(newNewsDto.getText());
		news.setNewsTitle(newNewsDto.getTitle());
		news.setCategory(categoryDao.getCategory(newNewsDto.getCategory()));

		return newsDao.saveNews(news);
	}

	@Override
	public boolean saveRate(RateDto rateDto) {
		Rate rate = new Rate();
		rate.setEvaluator(userDao.getUser(rateDto.getUserName()));
		rate.setNews(newsDao.getNews(rateDto.getNewsId()));
		boolean rating;
		if (rateDto.getRating() == 1) {
			rating = true;
		} else {
			rating = false;
		}
		rate.setRating(rating);
		return rateDao.saveRating(rate);
	}
}
