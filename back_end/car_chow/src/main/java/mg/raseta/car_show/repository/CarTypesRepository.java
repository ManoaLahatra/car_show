package mg.raseta.car_show.repository;

import mg.raseta.car_show.model.CarTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarTypesRepository extends JpaRepository<CarTypes, Integer>, CrudRepository<CarTypes, Integer> {}