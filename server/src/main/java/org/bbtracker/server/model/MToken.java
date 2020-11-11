package org.bbtracker.server.model;

import com.google.common.base.Objects;
import org.hibernate.id.GUIDGenerator;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
public class MToken  {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Basic		public Long id;
	@Basic		public String secret;
	@Basic		public Long userID;
	@Basic		public Date expirationDate;

	public static MToken forUser(MUser p, int validityInDays) {
		MToken t = new MToken();
		t.expirationDate = DateTime.now().plusDays(validityInDays).toDate();
		t.secret = UUID.randomUUID().toString()+UUID.randomUUID().toString();
		t.userID = p.id;
		return t;
	}
}
