package com.example.springboot.repository;

import com.example.springboot.model.entity.BrandEntity;

import java.util.List;

public interface BrandRepository {
    public List<BrandEntity> getAll();

    public BrandEntity findOneById(Long id);

    public int create(BrandEntity brandEntity);

    public int update(Long id, BrandEntity brandEntity);

    public int delete(Long id);
}
