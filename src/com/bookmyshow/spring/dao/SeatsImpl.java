package com.bookmyshow.spring.dao;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bookmyshow.spring.entity.Seats;

@Repository
public class SeatsImpl implements SeatsDao {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	@Transactional
	public void updateSeats(Seats theSeats) {

		Session session = sessionFactory.getCurrentSession();

		session.saveOrUpdate(theSeats);

	}

	@Override
	@Transactional
	public List<Seats> getAllSeats() {
		Session session = sessionFactory.openSession();

		Query theQuery = session.createQuery("from Seats", Seats.class);
		List<Seats> list = theQuery.getResultList();
		System.out.println("Movies dao " + list);
		return list;
	}

	@Override
	@Transactional
	public int getSeats() {
		Session session = sessionFactory.openSession();

		Seats seats = (Seats) session.load(Seats.class, 0);
		int setes = seats.getSeatsvacant();
		System.out.println("setes" + setes);
		System.out.println(seats.getSeatsvacant());

		return seats.getSeatsvacant();

	}
}
