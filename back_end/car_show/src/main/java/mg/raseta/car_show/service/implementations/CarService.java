package mg.raseta.car_show.service.implementations;

import mg.raseta.car_show.model.Car;
import mg.raseta.car_show.repository.CarRepository;
import mg.raseta.car_show.service.GenericService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class CarService extends GenericService<Car, Integer> {

    private CarRepository carRepository;

    public Page<Car> searchCars(Specification<Car> spec, Pageable pageable) {
        return carRepository.findAll(spec, pageable);
    }

}