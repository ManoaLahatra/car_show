package mg.raseta.car_show.service;

import mg.raseta.car_show.model.MotorTypes;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface MotorTypesService {
    MotorTypes createMotorType(MotorTypes motorTypes);
    Page<MotorTypes> findAllMotorTypes(int page, int limit);
    Optional<MotorTypes> findMotorTypeById(int motorTypeId);
    Page<MotorTypes> findMotorTypesByName(String motorTypeName, int page, int limit);
    MotorTypes updateMotorType(int motorTypeId, MotorTypes motorTypes);
    void deleteMotorType(int motorTypeId);
}