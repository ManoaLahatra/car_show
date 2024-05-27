package mg.raseta.car_show.controller;

import mg.raseta.car_show.model.MotorTypes;
import mg.raseta.car_show.service.implementations.MotorTypesServiceImplementation;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/motorType")
public class MotorTypesController {

    private MotorTypesServiceImplementation motorTypesService;

    @PostMapping
    public ResponseEntity<MotorTypes> createMotorType(@RequestBody MotorTypes motorTypes) {
        MotorTypes createMotorType = motorTypesService.createMotorType(motorTypes);
        return ResponseEntity.ok(createMotorType);
    }

    @GetMapping
    public ResponseEntity<Page<MotorTypes>> getAllMotorTypes(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "6") int limit
    )
    {
        Page<MotorTypes> motorTypes = motorTypesService.findAllMotorTypes(page, limit);
        return ResponseEntity.ok(motorTypes);
    }

    @GetMapping("/search/id")
    public ResponseEntity<Optional<MotorTypes>> getMotorTypeById(@RequestParam int motorTypeId) {
        Optional<MotorTypes> motorTypes = motorTypesService.findMotorTypeById(motorTypeId);
        return ResponseEntity.ok(motorTypes);
    }

    @GetMapping("/search/name")
    public ResponseEntity<Page<MotorTypes>> getMotorTypeByName(
            @RequestParam String name,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "6") int limit
    )
    {
        Page<MotorTypes> motorTypes = motorTypesService.findMotorTypesByName(name, page, limit);
        return ResponseEntity.ok(motorTypes);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MotorTypes> updateMotorType(
            @PathVariable int id,
            @RequestBody MotorTypes motorTypes
    )
    {
        MotorTypes motorType = motorTypesService.updateMotorType(id, motorTypes);
        return ResponseEntity.ok(motorTypes);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMotorType(@PathVariable int id) {
        motorTypesService.deleteMotorType(id);
        return ResponseEntity.noContent().build();
    }

}