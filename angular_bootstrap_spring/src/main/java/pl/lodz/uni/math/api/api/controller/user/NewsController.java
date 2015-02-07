package pl.lodz.uni.math.api.api.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pl.lodz.uni.math.api.persistence.dao.pojo.News;
import pl.lodz.uni.math.api.service.NewsService;
import pl.lodz.uni.math.dto.NewsDto;

@RestController
public class NewsController {
	@Autowired
	private NewsService newsService;

	@RequestMapping(value = "/rest/news", method = RequestMethod.GET, produces = "application/json")
	public List<NewsDto> getUsers() {
		return newsService.getAll();
	}
}
