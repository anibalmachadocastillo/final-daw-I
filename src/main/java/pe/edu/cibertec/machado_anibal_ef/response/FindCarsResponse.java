package pe.edu.cibertec.machado_anibal_ef.response;

import pe.edu.cibertec.machado_anibal_ef.dto.CarDto;
import pe.edu.cibertec.machado_anibal_ef.entity.Car;

public record FindCarsResponse(String code,
                               String error,
                               Iterable<CarDto> cars) {
}
