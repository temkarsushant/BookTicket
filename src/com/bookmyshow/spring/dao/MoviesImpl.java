package com.bookmyshow.spring.dao;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bookmyshow.spring.entity.Movies;

@Repository
public class MoviesImpl implements MoviesDao {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<Movies> getAllMovies() {

		Session session = sessionFactory.openSession();

		Query theQuery = session.createQuery("from Movies", Movies.class);
		List<Movies> list = theQuery.getResultList();
		System.out.println("Movies dao " + list);
		return list;
	}

}
