package models;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "Hotel_New")
public class Hotel_New  implements Serializable{
	 	@Id
	 	@GeneratedValue(strategy = GenerationType.AUTO)
	    private Integer Hotel_id;
	 	@Column(unique=true)
	    private String Hotel_name;
	    private Integer Room_price;
	    private Integer Hotel_rating;
	    private String Hotel_location;
//	    @OneToMany(cascade = CascadeType.ALL)
//		@JoinColumn(name = "hotelid", referencedColumnName = "Hotel_id")
//		List< HotelRooms > HotelRooms = new ArrayList< >();

		//new code added
		private Integer availablerooms;

		public Hotel_New() {
			
		}

	public Integer getAvailablerooms() {return availablerooms;}

	public void setAvailablerooms(Integer availablerooms) {
		this.availablerooms = availablerooms;
	}

	public Integer gethotel_id() {
			return Hotel_id;
		}
		public void sethotel_id(Integer hotel_id) {
			Hotel_id = hotel_id;
		}
		public String gethotel_name() {
			return Hotel_name;
		}
		public void sethotel_name(String hotel_name) {
			Hotel_name = hotel_name;
		}
		public Integer getroom_price() {
			return Room_price;
		}
		public void setroom_price(Integer room_price) {
			Room_price = room_price;
		}
		public Integer gethotel_rating() {
			return Hotel_rating;
		}
		public void sethotel_rating(Integer hotel_rating) {
			Hotel_rating = hotel_rating;
		}
		public String gethotel_location() {
			return Hotel_location;
		}
		public void sethotel_location(String hotel_location) {
			Hotel_location = hotel_location;
		}
		
//		public List<HotelRooms> gethotelRooms() {
//			return HotelRooms;
//		}
//		public void sethotelRooms(List<HotelRooms> hotelRooms) {
//			HotelRooms = hotelRooms;
//		}
//		@Override
//		public String toString() {
//			return "Hotel_New [Hotel_id=" + Hotel_id + ", Hotel_name=" + Hotel_name + ", Room_price=" + Room_price
//					+ ", Hotel_rating=" + Hotel_rating + ", Hotel_location=" + Hotel_location + ", HotelRooms="
//					+ HotelRooms + "]";
//		}


	@Override
	public String toString() {
		return "Hotel_New{" +
				"Hotel_id=" + Hotel_id +
				", Hotel_name='" + Hotel_name + '\'' +
				", Room_price=" + Room_price +
				", Hotel_rating=" + Hotel_rating +
				", Hotel_location='" + Hotel_location + '\'' +
				", availablerooms=" + availablerooms +
				'}';
	}
}

