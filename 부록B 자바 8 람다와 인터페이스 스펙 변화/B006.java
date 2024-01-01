//사용자 정의 함수형 인터페이스의 최적화된 람다식
public class B006 {
    public static void main(String[] args){
        MyFunctionalInterface mfi = a -> a*a;
        int b = mfi.runSomething(5);
        System.out.println(b);
    }
}
