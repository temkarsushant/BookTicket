package com.bookmyshow.spring.dao;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bookmyshow.spring.entity.User;

@Repository
public class UserImpl implements UserDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<User> getAllCustomers() {
		Session session = sessionFactory.openSession();

		Query theQuery = session.createQuery("from User", User.class);
		List<User> list = theQuery.getResultList();
		return list;
	}

	@Override
	@Transactional
	public void saveCustomer(User theUser) {
		Session session = sessionFactory.getCurrentSession();

		session.save(theUser);
	}

	@Override
	@Transactional
	public User getEmail(String email) {
		System.out.println(email);

		Session session = sessionFactory.openSession();

		org.hibernate.Query theQuery = session.createQuery("from User where email=:email", User.class);
		theQuery.setParameter("email", email);
		List<User> user = theQuery.getResultList();
		System.out.println(user);
		return user.get(0);

	}

	@Override
	public void updateSeats(String email, int seats) {
		System.out.println(email);

		Session session = sessionFactory.openSession();

		Transaction tt = session.beginTransaction();

		org.hibernate.Query theQuery = session
				.createQuery("update User set seatsbooked=:seats" + " where email=:email");

		theQuery.setParameter("email", email);
		theQuery.setParameter("seats", seats);
		theQuery.executeUpdate();

		tt.commit();

	}

}
