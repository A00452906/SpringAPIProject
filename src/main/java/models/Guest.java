package models;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "guest")
public class Guest {
	@Id
 	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer guestid;
	//private Integer numberofguets;
	private String guestname;
	private String gender;
	public Integer getguestid() {
		return guestid;
	}
	public void setguestid(Integer guestid) {
		this.guestid = guestid;
	}


	public String getGuestname() {
		return guestname;
	}

	public void setGuestname(String guestname) {
		this.guestname = guestname;
	}

	public String getgender() {
		return gender;
	}
	public void setgender(String gender) {
		this.gender = gender;
	}



	@Override
	public String toString() {
		return "Guest{" +
				"guestid=" + guestid +
				", guestname='" + guestname + '\'' +
				", gender='" + gender + '\'' +
				'}';
	}
}
