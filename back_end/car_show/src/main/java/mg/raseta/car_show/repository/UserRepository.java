package mg.raseta.car_show.repository;

import mg.raseta.car_show.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>, CrudRepository<User, Integer> {}