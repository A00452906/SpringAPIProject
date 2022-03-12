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
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "hotel_rooms")
public class HotelRooms {
	@Id
 	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer roomid;
	private Integer bookingidfk;
	public Integer getroomid() {
		return roomid;
	}
	public void setroomid(Integer roomid) {
		this.roomid = roomid;
	}
	public Integer getBookingidfk() {
		return bookingidfk;
	}
	public void setBookingidfk(Integer bookingidfk) {
		this.bookingidfk = bookingidfk;
	}
	@Override
	public String toString() {
		return "HotelRooms [roomid=" + roomid + ", bookingidfk=" + bookingidfk + "]";
	}


	
}
