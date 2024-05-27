package mg.raseta.car_show.service.interfaces;

import mg.raseta.car_show.model.Brand;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface BrandService {
    Brand createBrand(Brand brand);
    Page<Brand> findAllBrand(int page, int limit);
    Optional<Brand> findBrandByBrandId(int brandId);
    Page<Brand> findBrandByBrandName(String brandName, int page, int limit);
    Brand updateBrand(int brandId, Brand brand);
    void deleteBrand(int brandId);
}