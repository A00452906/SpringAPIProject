package dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import models.Hotel_New;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface HotelRepository extends JpaRepository<Hotel_New,Integer> {
	
	@Query(value = "SELECT room_price FROM hotel_new where hotel_id = ?1", nativeQuery = true)
	public float findByhotelID(int hotelid);
	@Query(value = "SELECT availablerooms FROM hotel_new where hotel_id = ?1", nativeQuery = true)
	public int findRoomsByhotelID(int hotelid);
	@Transactional
	@Modifying
	@Query(value = "update hotel_new hn set hn.availablerooms = ?1 where hn.hotel_id = ?2",nativeQuery = true)
	public int updateroomsavailable(int rooms, int hotelid);
}
