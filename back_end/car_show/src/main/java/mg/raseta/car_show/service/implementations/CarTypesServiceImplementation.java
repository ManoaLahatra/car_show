package mg.raseta.car_show.service.implementations;

import lombok.AllArgsConstructor;
import mg.raseta.car_show.model.CarTypes;
import mg.raseta.car_show.repository.CarTypesRepository;
import mg.raseta.car_show.service.interfaces.CarTypesService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class CarTypesServiceImplementation implements CarTypesService {

    private final CarTypesRepository carTypesRepository;

    @Override
    public CarTypes createCarType(CarTypes carTypes) {
        return carTypesRepository.save(carTypes);
    }

    @Override
    public Page<CarTypes> findAllCarTypes(int page, int limit) {
        Pageable pageable = PageRequest.of(page, limit);
        return carTypesRepository.findAll(pageable);
    }

    @Override
    public Optional<CarTypes> findCarTypeById(int carTypeId) {
        return carTypesRepository.findById(carTypeId);
    }

    @Override
    public Page<CarTypes> findCarTypesByName(String carTypeName, int page, int limit) {
        Pageable pageable = PageRequest.of(page, limit);
        return carTypesRepository.findCarTypesByName(carTypeName, pageable);
    }

    @Override
    public CarTypes updateCarType(int carTypeId, CarTypes carTypes) {
        return carTypesRepository.findById(carTypeId)
                .map(carType -> {
                    carType.setCarTypeId(carTypeId);
                    carType.setName(carTypes.getName());
                    return carTypesRepository.save(carType);
                })
                .orElseThrow(() -> new RuntimeException("CarType with id : " + carTypeId + " not found."));
    }

    @Override
    public void deleteCarType(int carTypeId) {
        Optional<CarTypes> carTypes = carTypesRepository.findById(carTypeId);
        if (carTypes.isPresent()) {
            carTypesRepository.delete(carTypes.get());
        } else {
            throw new RuntimeException("CarType with id : " + carTypeId + " not found.");
        }
    }

}