package com.invmanage.inventory.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoProductIU {

    @Size(min = 2, max = 50, message = "Ürün adı 2-50 karakter arasında olmalıdır")
    @NotNull(message = "Ürün adı boş olamaz")
    private String name;

    @Size(max = 250, message = "Açıklama 255 karakterden uzun olamaz")
    private String description;

    @Min(value = 0, message = "Stok miktarı negatif olamaz")
    @NotNull(message = "Stok miktarı boş olamaz")
    private int quantity;

    @NotNull
    @DecimalMin(value = "0.0", inclusive = true, message = "Fiyat negatif olamaz")
    private BigDecimal price;

    @NotNull(message = "Kategori ID boş olamaz")
    private Long categoryId;
}
