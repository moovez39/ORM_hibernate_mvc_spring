package web.dao;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarsDao {
    private List<Car> cars;

    public CarsDao() {
        cars = new ArrayList<>();
        cars.add(new Car("Toyota","Rav-4",1337));
        cars.add(new Car("BMW","E36",7280));
        cars.add(new Car("Citroen","C5",3398));
        cars.add(new Car("Nissan","Skyline",5151));
        cars.add(new Car("Porsche","911",8276));
        cars.add(new Car("Lada","Priora",2319));
        cars.add(new Car("VAZ","2106",9291));

    }

    public List<Car> getCars() {
        return cars;
    }

    public void addCar(Car car){
        cars.add(car);
    }
}
