# SpringAPIProject
MODEL:
 there are 4 models in the project
	-Hotel_New: the model represents the hotel_new table of database 
	-HotelRooms:the model represents the hotel_rooms table of datbase
	-Bookingdetails: the model represents the booking details table of database
	-Guest:the model represents the guest table of database

DAO:
there are four interfaces which are being used for communicating with the database specific to each of the Models except the Guest which is being saved using the Bookindetails

SERVICE:
Hotel_service.java holds the entire code for handling the bussiness logic.

Hotel_new:stores details about the hotels like location,name,rating,price
hotel_rooms:has list of all the rooms of all the hotels with hotel_id as fk to hotel_new and bookingidfk refering to bookingdetails table
bbokingdetails:this tables stores the booking details like bookingid,checkin,checkout,hotelid,numberofdays,totalbill,totalrooms with hotelid as foreign key to hotel_new
guest:this tables hold details about the primary guest and how many guest will be arriving also has field bookingidfk as a foreign key refering to the booking details

the controller for the project is HotelController which handles two requests GET/POST
- GET request(/HotelList): it returns the list of hotels and the rooms of that hotels along with bookingid if the rooms are booked
- POST request(/HotelBook): the post request takes below JSON object and uses the information to confirm booking. If rooms the total rooms that are required by the customer are   available that the booking will be confirmed and the booking id will be returned as a reference otherwise error message will be thrown stating "rooms are not available"

Error Handling:
- number of rooms and total days validation:
 if the user provided invalid number of rooms and days i.e less than 1 than error message will be displayed to the customer "please enter valid number of rooms and days"
- checkin date validation:
 if the checkin date sent in the api is less than the current date than the booking will not be confirmed and error message "checkin date can't be less than current date" will be displayed to the customer
 
 
-GET:
request:
- http://localhost:8080/HotelList
response:
[
    {
        "hotel_rating": 4,
        "room_price": 3000,
        "hotelRooms": [
            {
                "roomid": 1,
                "bookingidfk": 28
            },
            {
                "roomid": 2,
                "bookingidfk": 30
            },
            {
                "roomid": 3,
                "bookingidfk": 30
            },
            {
                "roomid": 4,
                "bookingidfk": null
            }
        ],
        "hotel_id": 1,
        "hotel_name": "Radisson",
        "hotel_location": "Delhi"
    }
]

-POST:
request:
http://localhost:8080/HotelBook
body:
{
    "hotelid": 1,
    "totalrooms": 2,
    "numberOfDays": 1,
    "hotelName": "Radisson",
    "checkin": "2022-03-07",
    "checkout": "2022-03-19",
    "numberofdays": 2,
    "guest": [
        {
            "numberofguets": 3,
            "gender": "M",
            "primaryguestname": "AD"
        }
    ]
}
response:
New Booking created successfully, your booking id is:	32


 
