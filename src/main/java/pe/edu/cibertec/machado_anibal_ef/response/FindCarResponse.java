package pe.edu.cibertec.machado_anibal_ef.response;

import pe.edu.cibertec.machado_anibal_ef.dto.CarDetailDto;
import pe.edu.cibertec.machado_anibal_ef.dto.CarDto;
import pe.edu.cibertec.machado_anibal_ef.entity.Car;

public record FindCarResponse(String code,
                              String error,
                              CarDetailDto car) {
}
