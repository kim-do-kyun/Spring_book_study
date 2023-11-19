# 04장 [자바가 확장한 객체 지향]
## :pencil: 정리
### 1. 객체 지향 설계(OOD; Object Oriented Design)의 5원칙
* <strong>SRP(Single Responsibility Principle)</strong> : 단일 책임 원칙
* <strong>OCP(Open Closed Principle)</strong> : 개방 폐쇄 원칙
* <strong>LSP(Liskov Substitution Principle)</strong> : 리스코프 치환 원칙
* <strong>ISP(Interface Segregation Principle)</strong> : 인터페이스 분리 원칙
* <strong>DP(Dependency Inversion Principle)</strong> : 의존 역전 원칙

<strong>결합도와 응집도</strong>
좋은 소프트웨어 설계를 위해서는 결합도는 낮추고, 응집도는 높이는 것이 바람직함
    => 결합도가 낮으면 모듈 간의 상호 의존성이 줄어들어 객체의 재사용이나 수정, 유지보수가 용이
    => 응집도가 높은 모듈은 하나의 책임에 집중하고 독립성이 높아져 재사용이나 기능의 수정, 유지보수가 용이하다

### 2. SRP - 단일 책임 원칙
* 객체지향의 세계에서 아래와 같은 코드는 나쁜 냄새가 나는 코드라고 함(단일 책임 원칙 위배) 
    => 이런 경우 역할(책임)을 분리 하라는 것이 <strong>단일 책임 원칙</strong>
<img src = "https://github.com/kim-do-kyun/web_programming_class/assets/70315428/07dda94d-5d17-4219-bbb3-047911017531" width = 250>

* 단일 책임 원칙은 속성, 메서드, 패키지, 모듈, 컴포넌트, 프레임워크 등에도 적용할 수 있는 개념
* 아래는 위의 클래스 설계를 단일 책임 원칙을 적용하여 수정
<img src = "https://github.com/kim-do-kyun/web_programming_class/assets/70315428/4dfed0d3-4828-4062-aeda-e67df21283d4" width = 400>

```
    class 강아지{
        final static Boolean 수컷 = true;
        final static Boolean 암컷 = false;
        Boolean 성별;

        void 소변보다(){
            if(this.성별 == 수컷) {
                //한쪽 다리를 들고 소변을 본다.
            } else {
                //뒷다리 두개를 굽혀 앉은 자세로 소변을 본다.
            }
        }
    }
```
* 위는 소변보다() 메서드가 수컷, 암컷 둘다 의 행위를 모두 구현하려고 하기에 단일 책임(행위) 원칙을 위배하고 있는 것
* 아리는 위의 구성을 단일 책임 원칙을 적용해 코드를 리팩터링 한 것
``` 
    abstract class 강아지{
        abstract void 소변보다()
    }

    class 수컷강아지 extends 강아지 {
        void 소변보다(){
            //한쪽 다리를 들고 소변을 본다.
        }
    }

    class 암컷강아지 extends 강아지 {
        void 소변보다(){
            //뒷다리 두 개를 앉은 자세로 소변을 본다.
        }
    }
```
* 단일 책임 원칙과 가장 관계가 깊은 것은 <strong>추상화</strong>임을 알 수 있다

### 3. OCP - 개방 폐쇄 원칙
* <strong>"자신의 확장에는 열려 있고, 주변의 변화에 대해서는 닫혀 있어야 한다."</strong>
<img src = "https://github.com/kim-do-kyun/Spring_book_study/assets/70315428/5c582373-b6a2-4713-935b-e935519c8721" width = 300>

* 개방 폐쇄 원칙을 적용한 클래스구조로 다양한 자동차가 생긴다고 하는 것
  * 자동차 입장에서는 자신의 확장에는 개방돼 있는것
  * 운전자 입장에서는 주변의 변화에 폐쇄돼 있는것

### 4. LSP - 리스코프 치환 원칙
* <strong>"서브 타입은 언제나 자신의 기반타입(base type)으로 교체할 수 있어야 한다."</strong>
* 하위 클래스 is a kind of 상위클래스 - 하위분류는 상위분류의 한 종류다
* 구현 클래스 is able to 인터페이스 - 구현분류는 인터페이스 할 수 있어야 한다
* 위의 두개의 문장대로 구현된 프로그램은 리스코프 치환원칙을 잘 지키고 있음

### 5. ISP - 인터페이스 분리 원칙
* <strong>"클라이언트는 자신이 사용하지 않는 메서드에 의존 관계를 맺으면 안 된다."</strong>
* 단일 책임 원칙(SRP)과 인터페이스 분할 원칙(ISP)은 같은 문제에 대한 두가지 다른 해결책임
* 특별한 경우가 아니라면 단일 책임 원칙을 적용 하는것이 더 좋은 해결책
* 인터페이스를 통해 메서드를 외부에 제공할때는 최소한의 메서드만 제공
  
### 6. DIP - 의존 역전 원칙
* <strong>"추상화된 것은 구체적인 것에 의존하면 안된다. 구체적인 것이 추상화된 것에 의존해야 한다."</strong>
* 자신보다 변하기 쉬운 것에 의존하던 것을 추상화된 인터페이스나 상위클래스를 두어 변하기 쉬운것의 변화에 영향받지 않게 하는 것

### [정리]
* SRP(단일 책임 원칙) : 어떤 클래스를 변경해야 하는 이유는 오직 하나뿐이어야 한다
* OCP(개방 폐쇄 원칙) : 자신의 확장에는 열려 있고 주변의 변화에 대해서는 닫혀 있어야 한다
* LSP(리스코프 치환 원칙) : 서브 타입은 언제나 자신의 기반 타입으로 교체할 수 있어야 한다
* ISP(인터페이스 분리 원칙) : 클라이언트는 자신이 사용하지 않는 메서드에 의존 관계를 맺으면 안 된다
* DIP(의존 역전 원칙) : 자신보다 변하기 쉬운 것에 의존하지 마라
```
<SOLID 원칙의 적용>
소스파일의 개수는 많아진다 이렇게 많아진 파일은 
논리를 더욱 잘 분할하고, 잘 표현하기에 이해하기 쉽고, 개발하기 쉬우며,
유지와 관리, 보수하기 쉬운 소스가 만들어 진다

