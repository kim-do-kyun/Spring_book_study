package expert005;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;

public class Car {
    @Resource
    Tire tire;
    public String getTireBrand() {
        return "장착된 타이어: " + tire.getBrand();
    }
}