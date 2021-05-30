package com.app.rwm.model;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.*;
public class VerificationToken {
private static final int EXPIRATION = 60 * 24;
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String token;
	
	@OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
	@JoinColumn(name="user_id")
	private User user;
	
	private Date expiryDate;
	
	private Date calculateExpiryDate(int expiryTimeMinutes) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Timestamp(cal.getTime().getTime()));
		cal.add(Calendar.MINUTE, expiryTimeMinutes);
		return new Date(cal.getTime().getTime());
	}
	
	public VerificationToken(User user, String token) {
		this.user = user;
		this.token = token;
		this.expiryDate = this.calculateExpiryDate(EXPIRATION);
	}
	
}
