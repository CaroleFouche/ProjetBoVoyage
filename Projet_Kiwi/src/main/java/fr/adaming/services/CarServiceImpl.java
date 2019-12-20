package fr.adaming.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.ICarDao;
import fr.adaming.entities.Car;

@Service
@Transactional
public class CarServiceImpl implements ICarService {

	// Transformation de l'association UML en JAVA
	public ICarDao cDao;

	@Autowired
	public void setcDao(ICarDao cDao) {
		this.cDao = cDao;
	}

	@Override
	public List<Car> getAllCar() {

		return cDao.getAll();
	}

	@Override
	public Car getCarById(Car car) {
		return cDao.getById(car.getId());
	}

	@Override
	public Car addCar(Car car) {
		return cDao.add(car);
	}

	@Override
	public boolean deleteCar(Car car) {
		Car cOut = cDao.getById(car.getId());
		if (cOut != null) {
			cDao.delete(cOut.getId());
			return true;
		} else {
			return false;
		}

	}

	@Override
	public boolean updateCar(Car car) {
		Car cOut = cDao.getById(car.getId());
		if (cOut != null) {
			cOut.setCat(car.getCat());
			cOut.setLoueur(car.getLoueur());
			cOut.setTravel(car.getTravel());
			cDao.update(cOut);
			return true;
		} else {
			return false;
		}
	}

}
