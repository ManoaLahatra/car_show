package mg.raseta.car_show.repository;

import mg.raseta.car_show.model.Images;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImagesRepository extends JpaRepository<Images, Integer>, CrudRepository<Images, Integer> {}