package com.example.springboot.repository;

import com.example.springboot.model.entity.BrandEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BrandRepositoryImpl implements BrandRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<BrandEntity> getAll() {
        String sql = "SELECT * FROM brands";
        return jdbcTemplate.query(sql, new BrandMapper());
    }

    @Override
    public BrandEntity findOneById(Long id) {
        String sql = "SELECT * FROM public.brands WHERE id = ?";
        return (BrandEntity) jdbcTemplate.queryForObject(sql, new Object[]{id}, new BrandMapper());
    }

    @Override
    public int create(BrandEntity brandEntity) {
        String sql = "INSERT INTO public.brands (name, description) " + "VALUES (?, ?)";
        return jdbcTemplate.update(sql, brandEntity.getName(), brandEntity.getDescription());
    }

    @Override
    public int update(Long id, BrandEntity brandEntity) {
        String sql = "UPDATE public.brands SET name = ?, description = ? WHERE id = ?";
        return jdbcTemplate.update(sql, brandEntity.getName(), brandEntity.getDescription(), id);
    }

    @Override
    public int delete(Long id) {
        String sql = "DELETE FROM public.brands WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }
}
