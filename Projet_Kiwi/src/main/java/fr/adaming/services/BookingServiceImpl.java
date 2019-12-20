package fr.adaming.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IBookingDao;
import fr.adaming.entities.Admin;
import fr.adaming.entities.Booking;

@Service
@Transactional
public class BookingServiceImpl implements IBookingService {

	@Autowired
	// Transfo de lassoc UML en Java
	public IBookingDao bookDao;

	public void setBookDao(IBookingDao bookDao) {
		this.bookDao = bookDao;
	}

	@Override
	public List<Booking> getAllBooking() {
		return bookDao.getAll();
	}

	@Override
	public Booking getBookingById(Booking booking) {
		return bookDao.getById(booking.getId());
	}

	@Override
	public Booking addBooking(Booking booking) {
		return bookDao.add(booking);
	}

	@Override
	public boolean deleteBooking(Booking booking) {
		Booking bookOut = bookDao.getById(booking.getId());
		if (bookOut != null) {
			bookDao.delete(bookOut.getId());
			return true;
		}
		return false;
	}

	@Override
	public boolean updateBooking(Booking booking) {
		
		
		Booking bookOut = bookDao.getById(booking.getId());
		
		if (bookOut != null) {
			bookOut.setAssurance(booking.isAssurance());
			bookOut.setClient(booking.getClient());
			bookOut.setStatus(booking.getStatus());
			bookOut.setTravel(booking.getTravel());
			bookOut.setTravellers(booking.getTravellers());
			
			bookDao.update(bookOut);
			
			return true;
		}
		return false;

	}
}
