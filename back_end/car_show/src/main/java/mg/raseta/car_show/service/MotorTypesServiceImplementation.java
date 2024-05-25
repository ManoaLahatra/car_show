package mg.raseta.car_show.service;

import lombok.AllArgsConstructor;
import mg.raseta.car_show.model.MotorTypes;
import mg.raseta.car_show.repository.MotorTypesRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class MotorTypesServiceImplementation implements MotorTypesService {

    private final MotorTypesRepository motorTypesRepository;

    @Override
    public MotorTypes createMotorType(MotorTypes MotorTypes) {
        return motorTypesRepository.save(MotorTypes);
    }

    @Override
    public Page<MotorTypes> findAllMotorTypes(int page, int limit) {
        Pageable pageable = PageRequest.of(page, limit);
        return motorTypesRepository.findAll(pageable);
    }

    @Override
    public Optional<MotorTypes> findMotorTypeById(int MotorTypesId) {
        return motorTypesRepository.findById(MotorTypesId);
    }

    @Override
    public Page<MotorTypes> findMotorTypesByName(String MotorTypesName, int page, int limit) {
        Pageable pageable = PageRequest.of(page, limit);
        return motorTypesRepository.findMotorTypesByName(MotorTypesName, pageable);
    }

    @Override
    public MotorTypes updateMotorType(int motorTypeId, MotorTypes motorTypes) {
        return motorTypesRepository.findById(motorTypeId)
                .map(b -> {
                    b.setMotorTypeId(motorTypeId);
                    b.setName(motorTypes.getName());
                    return motorTypesRepository.save(b);
                })
                .orElseThrow(() -> new RuntimeException("MotorType with id : " + motorTypeId + " not found."));
    }

    @Override
    public void deleteMotorType(int motorTypeId) {
        Optional<MotorTypes> MotorTypes = motorTypesRepository.findById(motorTypeId);
        if (MotorTypes.isPresent()) {
            motorTypesRepository.delete(MotorTypes.get());
        } else {
            throw new RuntimeException("MotorType with id : " + motorTypeId + " not found.");
        }
    }

}