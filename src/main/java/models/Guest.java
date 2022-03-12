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
	private Integer numberofguets;
	private String primaryguestname;
	private String gender;
	public Integer getguestid() {
		return guestid;
	}
	public void setguestid(Integer guestid) {
		this.guestid = guestid;
	}
//	public Integer getbookingidfk() {
//		return bookingidfk;
//	}
//	public void setbookingidfk(Integer bookingidfk) {
//		this.bookingidfk = bookingidfk;
//	}
	public Integer getnumberofguets() {
		return numberofguets;
	}
	public void setnumberofguets(Integer numberofguets) {
		this.numberofguets = numberofguets;
	}
	public String getprimaryguestname() {
		return primaryguestname;
	}
	public void setprimaryguestname(String primaryguestname) {
		this.primaryguestname = primaryguestname;
	}
	public String getgender() {
		return gender;
	}
	public void setgender(String gender) {
		this.gender = gender;
	}
//	public Bookingdetails getBookingdetails() {
//		return bookingdetails;
//	}
//	public void setBookingdetails(Bookingdetails bookingdetails) {
//		this.bookingdetails = bookingdetails;
//	}
	@Override
	public String toString() {
		return "Guest [guestid=" + guestid + ", numberofguets=" + numberofguets
				+ ", primaryguestname=" + primaryguestname + ", gender=" + gender + "]";
	}
	
//	@Override
//	public String toString() {
//		return "Guest [guestid=" + guestid + ", bookingidfk=" + bookingidfk + ", numberofguets=" + numberofguets
//				+ ", primaryguestname=" + primaryguestname + ", gender=" + gender + "]";
//	}
	
	
}
