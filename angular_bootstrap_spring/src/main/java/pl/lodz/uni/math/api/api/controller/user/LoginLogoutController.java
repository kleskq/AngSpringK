/**
 * 
 */
package pl.lodz.uni.math.api.api.controller.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles and retrieves the login or denied page depending on the URI template
 */
@Controller
@RequestMapping("/auth")
public class LoginLogoutController {

	private static final Logger logger = LoggerFactory.getLogger(LoginLogoutController.class);

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLoginPage(@RequestParam(value = "error", required = false) boolean error, ModelMap model) {
		logger.debug("Received request to show login page");


		 
		if (error == true) {
	
			model.put("error", "You have entered an invalid username or password or captcha code!");
		} else {
			model.put("error", "");
		}

		return "public/loginpage";
	}

	@RequestMapping(value = "/denied", method = RequestMethod.GET)
	public String getDeniedPage() {
		logger.debug("Received request to show denied page");

		return "public/deniedpage";
	}
}