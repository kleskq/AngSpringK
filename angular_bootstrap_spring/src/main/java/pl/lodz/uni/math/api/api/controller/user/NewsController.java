package pl.lodz.uni.math.api.api.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import pl.lodz.uni.math.api.service.NewsService;
import pl.lodz.uni.math.dto.NewNewsDto;
import pl.lodz.uni.math.dto.NewsDto;
import pl.lodz.uni.math.dto.NewsListDto;
import pl.lodz.uni.math.dto.RateDto;

import java.util.Date;
import java.util.List;

@RestController
public class NewsController {
	@Autowired
	private NewsService newsService;

	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
	@RequestMapping(value = "/rest/newslist", method = RequestMethod.GET)
	public List<NewsListDto> getNewsList() {
		return newsService.getAll();
	}

	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
	@RequestMapping(value = "/rest/news/{id:.+}", method = RequestMethod.GET)
	public NewsDto getNews(@PathVariable("id") long id) {
		return newsService.getNews(id, SecurityContextHolder.getContext().getAuthentication().getName());
	}

	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
	@RequestMapping(value = "/rest/savenews", method = RequestMethod.POST, produces = "application/json")
	public boolean saveUser(@RequestBody NewNewsDto newNewsDto) {
		newNewsDto.setAuthor(SecurityContextHolder.getContext().getAuthentication().getName());
		Date date = new Date();
		newNewsDto.setCreateDate(date);
		newNewsDto.setLink(date.getTime());
		return newsService.saveNews(newNewsDto);
	}

	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
	@RequestMapping(value = "/rest/ratenote", method = RequestMethod.POST, produces = "application/json")
	public boolean saveUser(@RequestBody RateDto rateDto) {
		rateDto.setUserName(SecurityContextHolder.getContext().getAuthentication().getName());
		return newsService.saveRate(rateDto);
	}

	@SuppressWarnings("unchecked")
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
	@RequestMapping(value = "/rest/isadmin", method = RequestMethod.GET)
	public boolean isAdmin() {

		List<GrantedAuthority> list = (List<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication()
				.getAuthorities();
		return list.get(0).getAuthority().equals("ROLE_ADMIN");
	}
}
