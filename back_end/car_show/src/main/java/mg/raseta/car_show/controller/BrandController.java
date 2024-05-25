package mg.raseta.car_show.controller;

import mg.raseta.car_show.model.Brand;
import mg.raseta.car_show.service.BrandServiceImplementation;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/brand")
public class BrandController {

    private BrandServiceImplementation brandService;

    @PostMapping
    public ResponseEntity<Brand> createBrand(@RequestBody Brand brand) {
        Brand createdBrand = brandService.createBrand(brand);
        return ResponseEntity.ok(createdBrand);
    }

    @GetMapping
    public ResponseEntity<Page<Brand>> getAllBrands(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "6") int size) {
        Page<Brand> brands = brandService.findAllBrand(page, size);
        return ResponseEntity.ok(brands);
    }

    @GetMapping("/search/id")
    public ResponseEntity<Optional<Brand>> getBrandById(@RequestParam int brandId) {
        Optional<Brand> brand = brandService.findBrandByBrandId(brandId);
        return ResponseEntity.ok(brand);
    }

    @GetMapping("/search/name")
    public ResponseEntity<Page<Brand>> getBrandsByName(@RequestParam String name, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "6") int size) {
        Page<Brand> brands = brandService.findBrandByBrandName(name, page, size);
        return ResponseEntity.ok(brands);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Brand> updateBrand(@PathVariable int id, @RequestBody Brand brand) {
        Brand updatedBrand = brandService.updateBrand(id, brand);
        return ResponseEntity.ok(updatedBrand);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBrand(@PathVariable int id) {
        brandService.deleteBrand(id);
        return ResponseEntity.noContent().build();
    }
}
