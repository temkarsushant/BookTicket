package com.bookmyshow.spring.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "seats")
public class Seats {

	@Id
	private int sid;

	private int seatsvacant;

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public int getSeatsvacant() {
		return seatsvacant;
	}

	public void setSeatsvacant(int seatsvacant) {
		this.seatsvacant = seatsvacant;
	}

	@Override
	public String toString() {
		return "Seats [sid=" + sid + ", seatsvacant=" + seatsvacant + "]";
	}

}