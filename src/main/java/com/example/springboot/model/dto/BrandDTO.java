package com.example.springboot.model.dto;

public class BrandDTO {
    private Long id;
    private String name;
    private String description;

    public BrandDTO(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
