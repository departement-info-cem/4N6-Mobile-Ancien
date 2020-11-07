package org.bbtracker.model;

import org.joda.time.DateTime;

import java.util.Date;

public class MToken  {
	public Long id;
	public Long userID;
	
	public Date expirationDate;

	public static MToken forUser(MUser p, int validityInDays) {
		MToken t = new MToken();
		t.expirationDate = DateTime.now().plusDays(validityInDays).toDate();
		t.userID = p.id;
		return t;
	}

	@Override
	public String toString() {
		return "MToken [userID=" + userID + ", expirationDate=" + expirationDate
				+ ", getId()=" + id + "]";
	}
	
}
