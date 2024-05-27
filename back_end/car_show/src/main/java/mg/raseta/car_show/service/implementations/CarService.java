package mg.raseta.car_show.service.implementations;

import mg.raseta.car_show.model.Car;
import mg.raseta.car_show.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    private CarRepository carRepository;

    public List<Car> searchCars(Specification<Car> spec) {
        return carRepository.findAll(spec);
    }
}