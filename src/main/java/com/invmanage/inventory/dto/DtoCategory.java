package com.invmanage.inventory.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoCategory {

    private long id;

    private String name;

    private String description;
}
