package dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import models.Hotel_New;

@Repository
public interface HotelRepository extends JpaRepository<Hotel_New,Integer> {
	
	@Query(value = "SELECT room_price FROM hotel_new where hotel_id = ?1", nativeQuery = true)
	public float findByhotelID(int hotelid);
}
