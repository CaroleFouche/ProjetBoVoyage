package fr.adaming.dao;

import org.springframework.stereotype.Repository;

import fr.adaming.entities.Booking;
import fr.adaming.entities.Traveller;
@Repository
public class BookingDaoImpl extends GenericDaoImpl<Booking> implements IBookingDao {

	public BookingDaoImpl() {
		clazz = Booking.class;
	}
}
