package com.example.springboot.repository;

import com.example.springboot.model.entity.BrandEntity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class BrandMapper implements RowMapper {
    @Override
    public BrandEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        BrandEntity brand = new BrandEntity();
        brand.setId(rs.getLong("id"));
        brand.setName(rs.getString("name"));
        brand.setDescription(rs.getString("description"));

        return brand;
    }
}
