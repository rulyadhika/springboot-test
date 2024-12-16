package com.example.springboot.service;

import com.example.springboot.model.dto.BrandDTO;
import com.example.springboot.model.entity.BrandEntity;
import com.example.springboot.repository.BrandRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {
    private final BrandRepository brandRepository;

    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public List<BrandDTO> getAllBrands() {
        return brandRepository.getAll().stream()
                .map(this::convertToDTO)
                .toList();
    }

    public BrandDTO findOneBrandById(Long id) {
        return this.convertToDTO(brandRepository.findOneById(id));
    }

    public int createBrand(BrandDTO brandDTO) {
        BrandEntity brand = convertToEntity(brandDTO);
        return brandRepository.create(brand);
    }

    public int updateBrand(Long id, BrandDTO brandDTO) {
        BrandEntity brand = convertToEntity(brandDTO);
        return brandRepository.update(id, brand);
    }

    public int deleteBrand(Long id) {
        return brandRepository.delete(id);
    }

    private BrandDTO convertToDTO(BrandEntity brand) {
        return new BrandDTO(brand.getId(), brand.getName(), brand.getDescription());
    }

    private BrandEntity convertToEntity(BrandDTO brandDTO) {
        BrandEntity brand = new BrandEntity();
        brand.setName(brandDTO.getName());
        brand.setDescription(brandDTO.getDescription());
        return brand;
    }
}
