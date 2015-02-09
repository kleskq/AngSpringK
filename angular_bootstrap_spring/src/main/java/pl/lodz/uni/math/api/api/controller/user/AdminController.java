package pl.lodz.uni.math.api.api.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.lodz.uni.math.api.service.NewsService;
import pl.lodz.uni.math.api.service.UserService;
import pl.lodz.uni.math.dto.UserDto;

@Controller
public class AdminController {

	@Autowired
	private UserService userService;

	@Autowired
	private NewsService newsService;

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = { "/admin/users" }, method = RequestMethod.GET)
	public String users(Model model) {

		List<UserDto> users = userService.getUsers();
		model.addAttribute("users", users);

		return "admin/admin";
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = { "/admin/newsStatus" }, method = RequestMethod.GET)
	public String news(Model model) {
		long newsCount = newsService.getNewsCount();
		model.addAttribute("newsCount", newsCount);
		return "admin/newsStatus";
	}
}
