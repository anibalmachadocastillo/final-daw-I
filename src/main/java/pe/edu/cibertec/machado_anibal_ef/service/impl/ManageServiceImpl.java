package pe.edu.cibertec.machado_anibal_ef.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.machado_anibal_ef.dto.CarDetailDto;
import pe.edu.cibertec.machado_anibal_ef.dto.CarDto;
import pe.edu.cibertec.machado_anibal_ef.dto.CarUpdateDto;
import pe.edu.cibertec.machado_anibal_ef.entity.Car;
import pe.edu.cibertec.machado_anibal_ef.repository.CarRepository;
import pe.edu.cibertec.machado_anibal_ef.service.ManageService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ManageServiceImpl implements ManageService {

    @Autowired
    CarRepository carRepository;

    @Override
    public boolean addCar(CarDetailDto carDetailDto) {
        Optional<Car> optional = carRepository.findById(carDetailDto.carId());
        if (optional.isPresent()) {
            return false;
        }else {
            Car car = new Car();
            car.setMake(carDetailDto.make());
            car.setModel(carDetailDto.model());
            car.setYear(carDetailDto.year());
            car.setVin(carDetailDto.vin());
            car.setLicensePlate(carDetailDto.licensePlate());
            car.setOwnerName(carDetailDto.ownerName());
            car.setOwnerContact(carDetailDto.ownerContact());
            car.setPurchaseDate(carDetailDto.purchaseDate());
            car.setMileage(carDetailDto.mileage());
            car.setEngineType(carDetailDto.engineType());
            car.setColor(carDetailDto.color());
            car.setInsuranceCompany(carDetailDto.insuranceCompany());
            car.setInsurancePolicyNumber(carDetailDto.insurancePolicyNumber());
            car.setRegistrationExpirationDate(carDetailDto.registrationExpirationDate());
            car.setServiceDueDate(carDetailDto.serviceDueDate());
            carRepository.save(car);
            return true;
        }
    }

    @Override
    public List<CarDto> getAllCars() throws Exception{
        List<CarDto> carDtos = new ArrayList<>();
        Iterable<Car> iterable = carRepository.findAll();
        iterable.forEach(car->
                    carDtos.add(new CarDto(car.getCarId(),
                            car.getMake(),
                            car.getModel(),
                            car.getYear(),
                            car.getLicensePlate(),
                            car.getOwnerName()))
                );
        return carDtos;
    }

    @Override
    public Optional<CarDetailDto> getCarById(int i) throws Exception {
        Optional<Car> optional = carRepository.findById(i);
        return optional.map(car->
                new CarDetailDto(car.getCarId(),
                        car.getMake(),
                        car.getModel(),
                        car.getYear(),
                        car.getVin(),
                        car.getLicensePlate(),
                        car.getOwnerName(),
                        car.getOwnerContact(),
                        car.getPurchaseDate(),
                        car.getMileage(),
                        car.getEngineType(),
                        car.getColor(),
                        car.getInsuranceCompany(),
                        car.getInsurancePolicyNumber(),
                        car.getRegistrationExpirationDate(),
                        car.getServiceDueDate())
                );
    }

    @Override
    public boolean updateCar(CarUpdateDto carUpdateDto) {
        Optional<Car> optional = carRepository.findById(carUpdateDto.carId());
        return optional.map(car ->{
        car.setModel(carUpdateDto.model());
        car.setOwnerName(carUpdateDto.ownerName());
        car.setOwnerContact(carUpdateDto.ownerContact());
        car.setMileage(carUpdateDto.mileage());
        car.setEngineType(carUpdateDto.engineType());
        car.setColor(carUpdateDto.color());
        carRepository.save(car);
        return true;
        }).orElse(false);


    }

    @Override
    public boolean deleteCarById(int id) {
        Optional<Car> optional = carRepository.findById(id);
        return optional.map(user->{
            carRepository.delete(user);
            return true;
        }).orElse(false);
    }
}
