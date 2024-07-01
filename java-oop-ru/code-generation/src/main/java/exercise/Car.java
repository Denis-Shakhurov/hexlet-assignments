package exercise;

import lombok.Value;
import com.fasterxml.jackson.databind.ObjectMapper;

// BEGIN
@Value
// END
class Car {
    int id;
    String brand;
    String model;
    String color;
    User owner;

    // BEGIN
    public static String serialize(Car car){
        ObjectMapper mapper = new ObjectMapper();
        String json = "";
        try {
            json = mapper.writeValueAsString(car);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return json;
    }

    public static Car unserialize(String json) {
        ObjectMapper mapper = new ObjectMapper();
        Car car = null;
        try {
            car = mapper.readValue(json, Car.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return car;
    }
    // END
}
