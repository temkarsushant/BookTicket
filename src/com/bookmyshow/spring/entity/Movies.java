package com.bookmyshow.spring.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "movies")
public class Movies {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int mid;

	private String mname;

	@Override
	public String toString() {
		return "Movies [mid=" + mid + ", mname=" + mname + "]";
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

}
