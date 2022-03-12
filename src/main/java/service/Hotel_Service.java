package service;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import dao.HotelRepository;
import dao.HotelRoomsRepository;
import dao.BookingdetailsRepository;
import models.Bookingdetails;
import models.HotelRooms;
import models.Hotel_New;


@Service
public class Hotel_Service {
	@Autowired
    HotelRepository hotelRepository;
	@Autowired
	HotelRoomsRepository HotelRoomsRepository;
	@Autowired
	BookingdetailsRepository BookingdetailsRepository;
	@Transactional(readOnly = false)
	 public List<Hotel_New> getAllHotels() {
		 System.out.println("inside"+hotelRepository);
	        return hotelRepository.findAll();
	    }
    
    public String createBooking(Bookingdetails BookingReq) {
    	float totalbill;
    	System.out.println("***inisde createBooking");
    	LocalDate checkin=BookingReq.getcheckin();
    	LocalDate checkout=BookingReq.getcheckout();
    	int rooms=BookingReq.gettotalrooms();
    	int hotelid=BookingReq.gethotelid();
    	int days=BookingReq.getnumberofdays();

    	System.out.println("**** find available rooms");
    	List<HotelRooms> hr=HotelRoomsRepository.findRoomListWithNoBooking(hotelid);
    	float roomprice=hotelRepository.findByhotelID(hotelid);
    	System.out.println("**** find available rooms"+hr);
    	if(checkin.isBefore(LocalDate.now()))
    	{
    		return("checkin date can't be less than current date");
    	}
    	if(rooms<1||days<1)
    	{
    		return ("please enter valid number of rooms and days");
    	}
    	if(hr.size()>=rooms)
    	{
    		totalbill=rooms*roomprice*hotelid;
    		BookingReq.settotalbill(totalbill);
    		BookingdetailsRepository.save(BookingReq);
    		
    		for(int i = 0 ; i <  rooms ; i++){
    			
    			HotelRooms hro=hr.get(i);
    			try {
    				HotelRooms hotelRoom = HotelRoomsRepository.getById(hro.getroomid());
    				hotelRoom.setBookingidfk(BookingReq.getbookingid());
    				HotelRoomsRepository.save(hotelRoom);
    				System.out.println("saved "+hotelRoom.toString());
    			//	HotelRoomsRepository.updateBookingId(BookingReq.getbookingid(),hro.getroomid());
    			} catch(Exception e) {
    				System.out.println("****************************************");
    			}
    			

    			}
    		 return ("New Booking created successfully, your booking id is:	"+BookingReq.getbookingid());
    	}
    	else
    	{
    		 return ("rooms are not available");
    	}
    	
       

    }
}
