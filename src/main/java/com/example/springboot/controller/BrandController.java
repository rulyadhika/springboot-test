package com.example.springboot.controller;

import com.example.springboot.model.dto.BrandDTO;
import com.example.springboot.service.BrandService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/brands")
public class BrandController {
    private final BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping
    public List<BrandDTO> getAllBrands() {
        return this.brandService.getAllBrands();
    }

    @GetMapping("/{id}")
    public BrandDTO findOneBrandById(@PathVariable Long id) {
        return this.brandService.findOneBrandById(id);
    }

    @PostMapping
    public int createBrand(@RequestBody BrandDTO brandDTO) {
        return brandService.createBrand(brandDTO);
    }

    @PutMapping("/{id}")
    public String updateBrand(@PathVariable Long id, @RequestBody BrandDTO brand) {
        brand.setId(id);
        int result = this.brandService.updateBrand(id, brand);
        if (result == 1) {
            return "Brand updated successfully!";
        } else {
            return "Failed";
        }
    }

    @DeleteMapping("/{id}")
    public String deleteBrand(@PathVariable Long id) {
        int result = brandService.deleteBrand(id);
        if (result == 1) {
            return "Brand deleted successfully!";
        } else {
            return "Failed";
        }
    }

}
