package fr.adaming.services;

import java.util.List;

import fr.adaming.entities.Booking;


public interface IBookingService {

	public List<Booking> getAllBooking(); 
	
	public Booking getBookingById(Booking booking);
	
	public Booking addBooking(Booking booking);
	
	public boolean deleteBooking(Booking booking);
	
	public boolean updateBooking(Booking booking);
	
	
}
