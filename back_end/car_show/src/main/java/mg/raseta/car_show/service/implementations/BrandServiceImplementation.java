package mg.raseta.car_show.service.implementations;

import lombok.AllArgsConstructor;
import mg.raseta.car_show.model.Brand;
import mg.raseta.car_show.repository.BrandRepository;
import mg.raseta.car_show.service.interfaces.BrandService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class BrandServiceImplementation implements BrandService {

    private final BrandRepository brandRepository;

    @Override
    public Brand createBrand(Brand brand) {
        return brandRepository.save(brand);
    }

    @Override
    public Page<Brand> findAllBrand(int page, int limit) {
        Pageable pageable = PageRequest.of(page, limit);
        return brandRepository.findAll(pageable);
    }

    @Override
    public Optional<Brand> findBrandByBrandId(int brandId) {
        return brandRepository.findById(brandId);
    }

    @Override
    public Page<Brand> findBrandByBrandName(String brandName, int page, int limit) {
        Pageable pageable = PageRequest.of(page, limit);
        return brandRepository.findBrandByName(brandName, pageable);
    }

    @Override
    public Brand updateBrand(int brandId, Brand brand) {
        return brandRepository.findById(brandId)
                .map(b -> {
                    b.setBrandId(brandId);
                    b.setName(brand.getName());
                    return brandRepository.save(b);
                })
                .orElseThrow(() -> new RuntimeException("Brand with brandId : " + brandId + " not found."));
    }

    @Override
    public void deleteBrand(int brandId) {
        Optional<Brand> brand = brandRepository.findById(brandId);
        if (brand.isPresent()) {
            brandRepository.delete(brand.get());
        } else {
            throw new RuntimeException("Brand with brandId : " + brandId + " not found.");
        }
    }

}