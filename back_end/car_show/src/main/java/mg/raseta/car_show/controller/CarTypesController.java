package mg.raseta.car_show.controller;

import mg.raseta.car_show.model.CarTypes;
import mg.raseta.car_show.service.implementations.CarTypesServiceImplementation;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/carType")
public class CarTypesController {

    private CarTypesServiceImplementation carTypesService;

    @PostMapping
    public ResponseEntity<CarTypes> createCarType(@RequestBody CarTypes carTypes) {
        CarTypes createCarType = carTypesService.createCarType(carTypes);
        return ResponseEntity.ok(createCarType);
    }

    @GetMapping
    public ResponseEntity<Page<CarTypes>> getAllCarTypes(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "6") int limit
    )
    {
        Page<CarTypes> carTypes = carTypesService.findAllCarTypes(page, limit);
        return ResponseEntity.ok(carTypes);
    }

    @GetMapping("/search/id")
    public ResponseEntity<Optional<CarTypes>> getCarTypeById(@RequestParam int carTypeId) {
        Optional<CarTypes> carTypes = carTypesService.findCarTypeById(carTypeId);
        return ResponseEntity.ok(carTypes);
    }

    @GetMapping("/search/name")
    public ResponseEntity<Page<CarTypes>> getCarTypeByName(
            @RequestParam String name,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "6") int limit
    )
    {
        Page<CarTypes> carTypes = carTypesService.findCarTypesByName(name, page, limit);
        return ResponseEntity.ok(carTypes);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarTypes> updateCarType(
            @PathVariable int id,
            @RequestBody CarTypes carTypes
    )
    {
        CarTypes carType = carTypesService.updateCarType(id, carTypes);
        return ResponseEntity.ok(carType);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCarType(@PathVariable int id) {
        carTypesService.deleteCarType(id);
        return ResponseEntity.noContent().build();
    }

}