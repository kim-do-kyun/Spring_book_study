abstract class professor {

    public void start_class(){
        inside();
        attendance();
        teach();
        outside();
    }

    //공통 메서드
    public void inside() {
        System.out.println("교수님이 강의실로 들어옵니다.");
    }

    public void attendance() {
        System.out.println("교수님이 출석을 부릅니다.");
    }

    public void outside() {
        System.out.println("교수님이 강의실을 나갑니다.");
    }

    //추상 메서드
    abstract void teach();
}
class OS_professor extends professor{

    @Override
    void teach() {
        System.out.println("교수님이 운영체제 수업을 합니다.");
    }
}
class Java_professor extends professor{

    @Override
    void teach() {
        System.out.println("교수님이 자바프로그래밍 수업을 합니다.");
    }
}
class Algorithm_professor extends professor{

    @Override
    void teach() {
        System.out.println("교수님이 알고리즘 수업을 합니다.");
    }
}
public class Driver{
    public static void main(String[] args){
        OS_professor os = new OS_professor();
        Java_professor java = new Java_professor();
        Algorithm_professor algo = new Algorithm_professor();

        os.start_class();
        System.out.println("=====================================");
        java.start_class();
        System.out.println("=====================================");
        algo.start_class();
    }

}