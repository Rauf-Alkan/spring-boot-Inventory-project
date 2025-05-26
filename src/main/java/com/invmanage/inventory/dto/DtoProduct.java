package com.invmanage.inventory.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DtoProduct {

    private Long id;

    private String name;

    private String description;

    private int quantity;

    private BigDecimal price;

    private DtoCategory category;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
