package mg.raseta.car_show.controller;

import mg.raseta.car_show.model.Car;
import mg.raseta.car_show.service.implementations.CarService;
import mg.raseta.car_show.specification.CarSpecification;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CarController {

    private CarService carService;

    @GetMapping("/cars")
    public List<Car> searchCars(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String model,
            @RequestParam(required = false) Integer price,
            @RequestParam(required = false) String color,
            @RequestParam(required = false) Integer power,
            @RequestParam(required = false) Integer placeNumber,
            @RequestParam(required = false) Boolean status,
            @RequestParam(required = false) Integer brandId,
            @RequestParam(required = false) Integer carTypeId,
            @RequestParam(required = false) Integer motorTypeId
    ) {
        Specification<Car> spec = Specification.where(null);

        if (name != null) {
            spec = spec.and(CarSpecification.hasName(name));
        }
        if (model != null) {
            spec = spec.and(CarSpecification.hasModel(model));
        }
        if (price != null) {
            spec = spec.and(CarSpecification.hasPrice(price));
        }
        if (color != null) {
            spec = spec.and(CarSpecification.hasColor(color));
        }
        if (power != null) {
            spec = spec.and(CarSpecification.hasPower(power));
        }
        if (placeNumber != null) {
            spec = spec.and(CarSpecification.hasPlaceNumber(placeNumber));
        }
        if (status != null) {
            spec = spec.and(CarSpecification.hasStatus(status));
        }
        if (brandId != null) {
            spec = spec.and(CarSpecification.hasBrandId(brandId));
        }
        if (carTypeId != null) {
            spec = spec.and(CarSpecification.hasCarTypeId(carTypeId));
        }
        if (motorTypeId != null) {
            spec = spec.and(CarSpecification.hasMotorTypeId(motorTypeId));
        }

        return carService.searchCars(spec);
    }

}