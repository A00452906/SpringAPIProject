package dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import models.Bookingdetails;




@Repository
public interface BookingdetailsRepository extends JpaRepository<Bookingdetails,Integer>{

}
