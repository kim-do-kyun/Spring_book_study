package templateMethodPattern;

public abstract class Animal {
    //추상 메서드
    abstract void play();

    //템플릿 메서드
    public void playWithOwner(){
        System.out.println("귀염둥이 이리온...");
        play();
        runSomething();
        System.out.println("잘했어");
    }
    void runSomething(){
        System.out.println("꼬리 살랑 살랑~");
    }

}
