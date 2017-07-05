package com.jwt.controller;

import java.io.IOException;
import javax.inject.Inject;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.PagedList;
import org.springframework.social.facebook.api.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.jwt.model.User;
import com.jwt.service.UserService;

@Controller
public class UserController {
	
    private Facebook facebook;
    private ConnectionRepository connectionRepository;

    @Inject
    public UserController(Facebook facebook, ConnectionRepository connectionRepository) {
        this.facebook = facebook;
        this.connectionRepository = connectionRepository;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String helloFacebook(Model model) {
        if (connectionRepository.findPrimaryConnection(Facebook.class) == null) {
            return "redirect:/connect/facebook";
        }

        model.addAttribute("facebookProfile", facebook.userOperations().getUserProfile());
        PagedList<Post> feed = facebook.feedOperations().getFeed();
        model.addAttribute("feed", feed);
        return "hello";
    }

	private static final Logger logger = Logger
			.getLogger(UserController.class);

	public UserController() {
		System.out.println("UserController()");
	}

	@Autowired
	private UserService UserService;

	//@RequestMapping(value = "/")
	public ModelAndView listUser(ModelAndView model) throws IOException {
		List<User> listUser = UserService.getAllUsers();
		model.addObject("listUser", listUser);
		model.setViewName("home");
		return model;
	}

	@RequestMapping(value = "/newUser", method = RequestMethod.GET)
	public ModelAndView newContact(ModelAndView model) {
		User User = new User();
		model.addObject("User", User);
		model.setViewName("UserForm");
		return model;
	}

	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public ModelAndView saveUser(@ModelAttribute User User) {
		if (User.getUserID() == 0) { // if User id is 0 then creating the
			// User other updating the User
			UserService.addUser(User);
		} else {
			UserService.updateUser(User);
		}
		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
	public ModelAndView deleteUser(HttpServletRequest request) {
		int UserId = Integer.parseInt(request.getParameter("userFBID"));
		UserService.deleteUser(UserId);
		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/editUser", method = RequestMethod.GET)
	public ModelAndView editContact(HttpServletRequest request) {
		int UserId = Integer.parseInt(request.getParameter("userFBID"));
		User User = UserService.getUser(UserId);
		ModelAndView model = new ModelAndView("UserForm");
		model.addObject("User", User);

		return model;
	}

}