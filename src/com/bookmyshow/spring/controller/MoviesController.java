package com.bookmyshow.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bookmyshow.spring.dao.MoviesDao;
import com.bookmyshow.spring.dao.SeatsDao;
import com.bookmyshow.spring.dao.UserDao;
import com.bookmyshow.spring.entity.Movies;
import com.bookmyshow.spring.entity.Seats;

@Controller
public class MoviesController {

	@Autowired
	UserDao userDao;

	

	@Autowired
	SeatsDao seatsDao;

//	@RequestMapping("/showMoviesList")
//	public String getMovies(Model model) {
//
//		List<Movies> movies = moviesDao.getAllMovies();
//
//		System.out.println("Controller Movies" + movies);
//
//		model.addAttribute("moviesList", movies);
//
//		return "movies-list";
//	}

	@RequestMapping("/getmoviename")
	public String getMovie(@RequestParam("category") String movie, @RequestParam("email") String email, Model model) {

		System.out.println(movie);

		System.out.println(email);

		Seats seats = new Seats();

		int numberOfSeats1 = seatsDao.getSeats();

		if (numberOfSeats1 == 0) {

//			seats.setSid(1);
			seats.setSeatsvacant(100);
			seatsDao.updateSeats(seats);
		}

		int numberOfSeats = seatsDao.getSeats();

		System.out.println(numberOfSeats);

		model.addAttribute("numberOfSeats", numberOfSeats);
		model.addAttribute("movieName", movie);
		model.addAttribute("email", email);

		return "movies-list-view";
	}

	@RequestMapping("/confirmMovie")
	public String confirmMovie(@RequestParam("sets") int seats, @RequestParam("email") String email,
			@RequestParam("seatType") String seatType, Model model) {

		System.out.println("confirm" + email);

		userDao.updateSeats(email, seats);

		Seats seats1 = new Seats();
		int price = 0;

		int numberOfSeats = seatsDao.getSeats();
		System.out.println("numberOfSeatsBafor" + numberOfSeats);

		System.out.println(seats);

		if (numberOfSeats > 0) {
			numberOfSeats = numberOfSeats - seats;
			System.out.println("numberOfSeats After " + numberOfSeats);

			Seats seats11 = new Seats();

//			seats11.setSid(1);
			seats11.setSeatsvacant(numberOfSeats);
			seatsDao.updateSeats(seats11);

			System.out.println(seatsDao.getSeats());

			if (seatType.equals("Gold")) {
				price = seats * 200;
				System.out.println(price);
			} else if (seatType.equals("Silver")) {
				price = seats * 150;
			} else if (seatType.equals("Platinum")) {
				price = seats * 100;
			}
		} else {
			System.out.println("Seats no available");
		}

		model.addAttribute("selectedSeats", seats);
		model.addAttribute("seatType", seatType);
		model.addAttribute("TotalAmount", price);

		return "confirm-movie";
	}

	/*
	 * @RequestMapping("/confirmMovie") public String
	 * confirmMovie(@RequestParam("sets") int seats, @RequestParam("seatType")
	 * String seatType, Model model) {
	 * 
	 * int price = 0;
	 * 
	 * System.out.println(seats);
	 * 
	 * if (numberOfSeats > 0) { numberOfSeats = numberOfSeats - seats; if
	 * (seatType.equals("Gold")) { price = seats * 200; System.out.println(price); }
	 * else if (seatType.equals("Silver")) { price = seats * 150; } else if
	 * (seatType.equals("Platinum")) { price = seats * 100; } } else {
	 * System.out.println("Seats no available"); numberOfSeats = 100; }
	 * 
	 * model.addAttribute("selectedSeats", seats); model.addAttribute("seatType",
	 * seatType); model.addAttribute("TotalAmount", price);
	 * 
	 * return "confirm-movie"; }
	 */

}
