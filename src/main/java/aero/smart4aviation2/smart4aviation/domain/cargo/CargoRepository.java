package aero.smart4aviation2.smart4aviation.domain.cargo;

import java.util.Optional;

public interface CargoRepository {
    Optional<CargoData> getCargo(String flightNumber);

}
