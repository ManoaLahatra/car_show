package mg.raseta.car_show.service;

import mg.raseta.car_show.model.Brand;
import mg.raseta.car_show.model.CarTypes;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface CarTypesService {
    CarTypes createCarType(CarTypes carTypes);
    Page<CarTypes> findAllCarTypes(int page, int limit);
    Optional<CarTypes> findCarTypeById(int carTypeId);
    Page<CarTypes> findCarTypesByName(String carTypeName, int page, int limit);
    CarTypes updateCarType(int carTypeId, CarTypes carTypes);
    void deleteCarType(int carTypeId);
}