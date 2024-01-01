//기존 방식의 코드 블록 사용 - 별도의 클래스와 객체 그리고 메서드를 생성해야 한다
public class B001 {
    public static void main(String[] args){
        MyTest mt = new MyTest();

        Runnable r = mt;
        r.run();
    }
}

class MyTest implements Runnable {
    public void run() {
        System.out.println("Hello Lambda!!!");
    }
}
