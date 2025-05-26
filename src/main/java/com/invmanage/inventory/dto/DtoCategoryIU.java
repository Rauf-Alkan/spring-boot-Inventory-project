package com.invmanage.inventory.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoCategoryIU {


    @Size(max = 40, min = 2, message = "Kategori adı 2 ile 40 karakter arasında olmalıdır")
    @NotBlank(message = "Kategori adı boş olamaz")
    @NotBlank(message = "Kategori adı boşluk olamaz")
    private String name;

    @Size(max = 255, message = "Açıklama 255 karakterden uzun olamaz")
    private String description;
}
