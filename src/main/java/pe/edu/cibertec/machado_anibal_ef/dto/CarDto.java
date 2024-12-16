package pe.edu.cibertec.machado_anibal_ef.dto;

public record CarDto(Integer carId,
                     String make,
                     String model,
                     Integer year,
                     String licensePlate,
                     String ownerName) {
}
