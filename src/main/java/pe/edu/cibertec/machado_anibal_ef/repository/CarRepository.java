package pe.edu.cibertec.machado_anibal_ef.repository;

import org.springframework.data.repository.CrudRepository;
import pe.edu.cibertec.machado_anibal_ef.entity.Car;

public interface CarRepository extends CrudRepository<Car, Integer> {
}
