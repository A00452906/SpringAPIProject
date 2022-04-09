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
@Table(name = "bookingdetails")
public class Bookingdetails {
	@Id
 	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer bookingid;
	private LocalDate checkin;
	private LocalDate checkout;
	private Integer hotelid;
	private Integer numberofdays;
	private Integer numberofrooms;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "bookingidfk", referencedColumnName = "bookingid")
	List< Guest > Guest = new ArrayList< >();
	public Integer getbookingid() {
		return bookingid;
	}
	public void setbookingid(Integer bookingid) {
		this.bookingid = bookingid;
	}
	public LocalDate getcheckin() {
		return checkin;
	}
	public void setcheckin(LocalDate checkin) {
		this.checkin = checkin;
	}
	public LocalDate getcheckout() {
		return checkout;
	}
	public void setcheckout(LocalDate checkout) {
		this.checkout = checkout;
	}

	public Integer getnumberofrooms() {
		return numberofrooms;
	}

	public void setnumberofrooms(Integer numberofrooms) {
		this.numberofrooms = numberofrooms;
	}

	public Integer gethotelid() {
		return hotelid;
	}
	public void sethotelid(Integer hotelid) {
		this.hotelid = hotelid;
	}
	
	public Integer getnumberofdays() {
		return numberofdays;
	}
	public void setnumberofdays(Integer numberofdays) {
		this.numberofdays = numberofdays;
	}
	
	public List<Guest> getguest() {
		return Guest;
	}
	public void setguest(List<Guest> guest) {
		Guest = guest;
	}

	@Override
	public String toString() {
		return "Bookingdetails{" +
				"bookingid=" + bookingid +
				", checkin=" + checkin +
				", checkout=" + checkout +
				", hotelid=" + hotelid +
				", numberofdays=" + numberofdays +
				", Guest=" + Guest +
				", numberofrooms=" + numberofrooms +
				'}';
	}
}
