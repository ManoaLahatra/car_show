package mg.raseta.car_show.repository;

import mg.raseta.car_show.model.MotorTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MotorTypesRepository extends JpaRepository<MotorTypes, Integer>, CrudRepository<MotorTypes, Integer> {}