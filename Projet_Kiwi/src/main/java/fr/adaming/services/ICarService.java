package fr.adaming.services;

import java.util.List;

import fr.adaming.entities.Car;

public interface ICarService {

	public List<Car> getAllCar();

	public Car getCarById(Car car);

	public Car addCar(Car car);

	public boolean deleteCar(Car car);

	public boolean updateCar(Car car);
}
