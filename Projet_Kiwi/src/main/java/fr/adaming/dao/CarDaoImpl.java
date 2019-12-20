package fr.adaming.dao;

import fr.adaming.entities.Booking;
import fr.adaming.entities.Car;

public class CarDaoImpl extends GenericDaoImpl<Car> implements ICarDao {

	public CarDaoImpl() {
		clazz = Car.class;
	}
}
