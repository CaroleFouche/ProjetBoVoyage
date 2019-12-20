package fr.adaming.dao;

import fr.adaming.entities.Booking;
import fr.adaming.entities.Traveller;

public class BookingDaoImpl extends GenericDaoImpl<Booking> implements IBookingDao {

	public BookingDaoImpl() {
		clazz = Booking.class;
	}
}
