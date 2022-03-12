package dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import models.HotelRooms;


@Repository
public interface HotelRoomsRepository extends JpaRepository<HotelRooms,Integer>{
	
	@Query(value = "select * from hotel_rooms where bookingidfk is null and hotelid=?1", nativeQuery = true)
	public List<HotelRooms> findRoomListWithNoBooking(int hotelid);
	
	@Modifying
	@Query(value="update hotel_rooms set bookingidfk = ?1 where roomid = ?2", nativeQuery = true)
	void updateBookingId(int bookingid,int roomid);
}
