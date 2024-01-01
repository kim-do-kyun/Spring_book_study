//새로운 방식의 코드 블록 사용 - 람다
public class B003 {
    public static void main(String[] args){
        Runnable r = () -> {
            System.out.println("Hello Lambda 3!!!");
        };
        r.run();
    }
}
