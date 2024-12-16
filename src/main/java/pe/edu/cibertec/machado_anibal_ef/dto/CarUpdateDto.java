package pe.edu.cibertec.machado_anibal_ef.dto;

import java.util.Date;

public record CarUpdateDto(Integer carId,
                           String model,
                           String ownerName,
                           String ownerContact,
                           Integer mileage,
                           String engineType,
                           String color) {
}
