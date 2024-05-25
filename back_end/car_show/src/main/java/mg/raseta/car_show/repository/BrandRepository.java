package mg.raseta.car_show.repository;

import mg.raseta.car_show.model.Brand;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer>, CrudRepository<Brand, Integer> {
    Page<Brand> findBrandByName(String brandName, Pageable pageable);
}