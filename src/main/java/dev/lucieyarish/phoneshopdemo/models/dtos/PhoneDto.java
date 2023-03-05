package dev.lucieyarish.phoneshopdemo.models.dtos;

import dev.lucieyarish.phoneshopdemo.models.entities.Phone;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Data
public class PhoneDto {

    @NotBlank(message = "Brand is required.")
    private String brand;

    @NotBlank(message = "Operating system is required.")
    private String operating_system;

    @NotBlank(message = "Model is required.")
    private String model;

    @NotNull(message = "Price is required.")
    @Digits(integer = 5, fraction = 0)
    @PositiveOrZero(message = "Price must be greater than or equal to 0.")
    private Integer price;

    private String image;

    public Phone toPhone() {
        byte[] convertedImg = Base64.getDecoder().decode(image.getBytes(StandardCharsets.UTF_8));

        return new Phone()
                .setBrand(brand)
                .setOperatingSystem(operating_system)
                .setModel(model)
                .setPrice(price)
                .setImage(convertedImg);
    }
}
