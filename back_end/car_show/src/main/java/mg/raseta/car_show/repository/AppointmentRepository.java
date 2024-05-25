package mg.raseta.car_show.repository;

import mg.raseta.car_show.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer>, CrudRepository<Appointment, Integer> {}