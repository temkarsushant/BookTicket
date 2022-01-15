package com.bookmyshow.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bookmyshow.spring.dao.MoviesDao;
import com.bookmyshow.spring.dao.UserDao;
import com.bookmyshow.spring.entity.Movies;
import com.bookmyshow.spring.entity.User;

@Controller
public class UserController {

	@Autowired
	UserDao userDao;

	@Autowired
	MoviesDao moviesDao;

	@RequestMapping("/registerUser")
	public String registrationPage(Model theModel) {

		User user = new User();

		theModel.addAttribute("user", user);
		return "register-user";
	}

	@RequestMapping("/confirmRegistration")
	public String confirmRegistration(@ModelAttribute("user") User theUser) {
		User user = new User();
		String email = theUser.getEmail();

		System.out.println("Registered Email is " + email);

		userDao.saveCustomer(theUser);

		return "login-user";
	}

	@RequestMapping("/loginPage")
	public String loginPage() {
		return "login-user";
	}

	@RequestMapping("/login")
	public String login(@RequestParam("email") String email, @RequestParam("password") String password, Model model) {

		System.out.println("controller" + email);
		User user = userDao.getEmail(email);
		System.out.println("user controlle" + user);
		System.out.println("user controlle" + user.getEmail());
		System.out.println("user controlle" + user.getPassword());
		System.out.println("user jsp password " + password);

		if (password.equals(user.getPassword())) {

			model.addAttribute("email", email);

			List<Movies> movies = moviesDao.getAllMovies();

			System.out.println("Controller Movies" + movies);

			model.addAttribute("moviesList", movies);

			return "movies-list";
		}

		return "login-user";
	}

}
