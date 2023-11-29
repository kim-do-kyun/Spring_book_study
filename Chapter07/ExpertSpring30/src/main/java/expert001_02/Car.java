package expert001_02;

public class Car {
    Tire tire;

    public Car(Tire tire){  //expert001_01과 다름
        this.tire = tire;
    }

    public String getTireBrand() {
        return "장착된 타이어: "+tire.getBrand();
    }
}
