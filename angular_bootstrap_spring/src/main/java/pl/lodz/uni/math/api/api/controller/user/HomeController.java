package pl.lodz.uni.math.api.api.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	public String home( Model model) {
		return "public/index";
	}

}