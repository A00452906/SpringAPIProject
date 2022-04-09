package service;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import dao.HotelRepository;
import dao.BookingdetailsRepository;
import models.Bookingdetails;
import models.Hotel_New;


@Service
public class Hotel_Service {
	@Autowired
    HotelRepository hotelRepository;
	@Autowired
	BookingdetailsRepository BookingdetailsRepository;
	@Transactional(readOnly = false)
	 public List<Hotel_New> getAllHotels() {
		 System.out.println("inside"+hotelRepository);
	        return hotelRepository.findAll();
	    }
    
    public String createBooking(Bookingdetails BookingReq) {
		System.out.println("***inisde createBooking");
		LocalDate checkin = BookingReq.getcheckin();
		LocalDate checkout = BookingReq.getcheckout();
		int hotelid = BookingReq.gethotelid();
		int days = BookingReq.getnumberofdays();
		int rooms=BookingReq.getnumberofrooms();
		System.out.println("**** find available rooms");
		float roomprice = hotelRepository.findByhotelID(hotelid);
		int roomsavailable = hotelRepository.findRoomsByhotelID(hotelid);

		if(roomsavailable>rooms) {
			int newrooms=roomsavailable-rooms;
			hotelRepository.updateroomsavailable(newrooms, hotelid);
			BookingdetailsRepository.save(BookingReq);
			return ("Your BookingID has been confirmed and your bookingID is BM_" + BookingReq.getbookingid().toString());
		}
		else
		{
			return("rooms are not available");
		}
    }
}
