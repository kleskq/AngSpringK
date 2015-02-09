package pl.lodz.uni.math.api.service;

import java.util.List;

import pl.lodz.uni.math.dto.NewNewsDto;
import pl.lodz.uni.math.dto.NewsDto;
import pl.lodz.uni.math.dto.NewsListDto;
import pl.lodz.uni.math.dto.RateDto;

public interface NewsService {
	public List<NewsListDto> getAll();

	public NewsDto getNews(long id);

	public boolean saveNews(NewNewsDto newNewsDto);

	public boolean saveRate(RateDto rateDto);

	public long getNewsCount();
}
