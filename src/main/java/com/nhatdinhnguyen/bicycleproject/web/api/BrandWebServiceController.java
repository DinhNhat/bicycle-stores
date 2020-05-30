package com.nhatdinhnguyen.bicycleproject.web.api;

import com.nhatdinhnguyen.bicycleproject.db.entity.Brand;
import com.nhatdinhnguyen.bicycleproject.db.repo.BrandRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api")
public class BrandWebServiceController {
    private final BrandRepository brandRepository;

    public BrandWebServiceController(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/brands")
    public Iterable<Brand> getAll() {
        return this.brandRepository.findAll();
    }

    // by using path variable
//    @RequestMapping(method = RequestMethod.GET, path = "/brands/{id}")
//    public Brand getSingleOne(@PathVariable(value = "id") int id) {
//        return verifyBrand(id);
//    }

    // by using requestparam note that http://localhost:8080/uri/?id
    @RequestMapping(method = RequestMethod.GET, path = "/brands-by-requestParam")
    public Brand getSingleOne(@RequestParam(value = "id", required = false) int id) {
        return verifyBrand(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/brands/{id}")
    public Brand updateWithPut(@PathVariable(value = "id")int id, @RequestBody String name) {
        Brand brand = verifyBrand(id);
        if (brand != null) {
            brand.setName(name);
            return this.brandRepository.save(brand);
        } else {
            return null;
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/brands/{id}")
    public void deleteSingle(@PathVariable(value = "id")int id, @RequestBody String name) {
        Brand brand = verifyBrand(id);
        if (brand != null) {
            brand.setName(name);
            this.brandRepository.delete(brand);
        }
    }

    private Brand verifyBrand(int brandId) throws NoSuchElementException {
        return this.brandRepository.findById(brandId)
                .orElseThrow(() -> new NoSuchElementException("My defined " +
                        "exception for response status: brand id " + brandId + " not found."));
    }



    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoSuchElementException.class)
    public String return400(NoSuchElementException ex) {
        return ex.getMessage();
    }
}
