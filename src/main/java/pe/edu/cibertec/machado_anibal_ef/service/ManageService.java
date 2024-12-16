package pe.edu.cibertec.machado_anibal_ef.service;

import org.springframework.stereotype.Service;
import pe.edu.cibertec.machado_anibal_ef.dto.CarDetailDto;
import pe.edu.cibertec.machado_anibal_ef.dto.CarDto;
import pe.edu.cibertec.machado_anibal_ef.dto.CarUpdateDto;

import java.util.List;
import java.util.Optional;

@Service
public interface ManageService {

    boolean addCar(CarDetailDto carDetailDto);

    List<CarDto> getAllCars() throws Exception;

    Optional<CarDetailDto> getCarById(int i) throws Exception;

    boolean updateCar(CarUpdateDto carUpdateDto);

    boolean deleteCarById(int i);
}
