package pl.lodz.uni.math.api.service;

import java.util.List;

import pl.lodz.uni.math.api.persistence.dao.pojo.News;
import pl.lodz.uni.math.dto.NewsDto;

public interface NewsService {
	public List<NewsDto> getAll();
}
