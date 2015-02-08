package pl.lodz.uni.math.api.api.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pl.lodz.uni.math.api.service.NewsService;
import pl.lodz.uni.math.dto.NewNewsDto;
import pl.lodz.uni.math.dto.NewsDto;
import pl.lodz.uni.math.dto.NewsListDto;

@RestController
public class NewsController {
	@Autowired
	private NewsService newsService;

	@RequestMapping(value = "/rest/newslist", method = RequestMethod.GET)
	public List<NewsListDto> getNewsList() {
		return newsService.getAll();
	}
	
	@RequestMapping(value = "/rest/news/{id:.+}", method = RequestMethod.GET)
	public NewsDto getNews(@PathVariable("id") long id) {
		return newsService.getNews(id);
	}
	
	@RequestMapping(value = "/rest/savenews", method = RequestMethod.POST, produces = "application/json")
    public boolean saveUser(@RequestBody NewNewsDto newNewsDto) {
        return newsService.saveNews(newNewsDto);
    }
}
