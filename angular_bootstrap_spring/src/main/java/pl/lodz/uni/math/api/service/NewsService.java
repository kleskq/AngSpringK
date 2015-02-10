package pl.lodz.uni.math.api.service;

import pl.lodz.uni.math.dto.NewNewsDto;
import pl.lodz.uni.math.dto.NewsDto;
import pl.lodz.uni.math.dto.NewsListDto;
import pl.lodz.uni.math.dto.RateDto;

import java.util.List;

public interface NewsService {
	public List<NewsListDto> getAll();

	public NewsDto getNews(long id, String userName);

	public boolean saveNews(NewNewsDto newNewsDto);

	public boolean saveRate(RateDto rateDto);

	public long getNewsCount();
}
