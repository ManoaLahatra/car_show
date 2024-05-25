package mg.raseta.car_show.service;

import mg.raseta.car_show.model.Brand;
import org.springframework.data.domain.Page;

import java.util.List;

public interface BrandService {
    Brand createBrand(Brand brand);
    Page<Brand> findAllBrand(int page, int limit);
    Brand updateBrand(int brandId, Brand brand);
    boolean deleteBrand(int brandId);
}