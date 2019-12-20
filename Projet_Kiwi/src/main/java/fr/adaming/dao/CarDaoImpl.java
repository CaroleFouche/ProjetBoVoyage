package fr.adaming.dao;

import org.springframework.stereotype.Repository;

import fr.adaming.entities.Booking;
import fr.adaming.entities.Car;

@Repository
public class CarDaoImpl extends GenericDaoImpl<Car> implements ICarDao {

	public CarDaoImpl() {
		clazz = Car.class;
	}
}
