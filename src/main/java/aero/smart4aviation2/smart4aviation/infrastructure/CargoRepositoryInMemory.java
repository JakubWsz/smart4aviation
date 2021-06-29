package aero.smart4aviation2.smart4aviation.infrastructure;

import aero.smart4aviation2.smart4aviation.domain.cargo.*;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Stream;


@Repository
public class CargoRepositoryInMemory implements CargoRepository, ApplicationRunner {
    private final List<Cargo> cargoList = new ArrayList<>();


    @Override
    public Optional<CargoData> getCargo(String flightNumber) {
        return cargoList.stream()
                .flatMap(cargo -> Stream.of(cargo.getCargoDataList()))
                .flatMap(List::stream)
                .filter(cargoData -> cargoData.getFlightId().equals(flightNumber))
                .findFirst();
    }

    @Override
    public void run(ApplicationArguments args) {
        cargoList.add(generateCargo("1", "2"));
        cargoList.add(generateCargo("3", "4", "5"));
        System.out.println(cargoList);
    }

    private List<Load> generateLoad() {
        List<Load> loadList = new ArrayList<>();
        for (int i = 0; i < new Random().nextInt(4) + 1; i++) {
            loadList.add(new Load(UUID.randomUUID().toString(), new Random().nextInt(50) + 5, WeightUnit.KG,
                    new Random().nextInt(5) + 1));
        }
        return loadList;
    }

    private CargoData generateCargoData(String flightId) {
        return new CargoData(flightId, generateLoad(), generateLoad());
    }

    private Cargo generateCargo(String... flightIds) {
        List<CargoData> cargoDataList = new ArrayList<>();
        for (String flightId : flightIds) {
            cargoDataList.add(generateCargoData(flightId));
        }
        return new Cargo(cargoDataList);
    }

}
