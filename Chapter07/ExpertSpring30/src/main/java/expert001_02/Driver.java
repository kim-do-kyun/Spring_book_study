package expert001_02;

public class Driver {
    public static void main(String[] args){
        Tire tire = new KoreaTire();    //new를 통해 타이어를 생산하는 부분 이동(_01에서는 car에 있었음)

        Car car = new Car(tire);

        System.out.println(car.getTireBrand());
    }
}
