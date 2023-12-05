# 07장[스프링 삼각형과 설정 정보]
### 1. IoC(Inversion of Control)/DI(Dependency Injection) - 제어의 역전/의존성 주입
#### 프로그래밍에서 의존성이란?
* 의사코드
  * 운전자가 자동차를 생산한다
  * 자동차는 내부적으로 타이어를 생산한다
* 자바로 표현
  * new Car();
  * Car 객체 생성자에서 new Tire();
* <strong>의존성을 단순하게 정의하면</strong>
  * 의존성은 new다
  * new를 실행하는 Car와 Tire 사이에서 Car가 Tire에 의존한다
  * 결론적으로 전체가 부분에 의존한다고 표현할 수 있다
* 정리
  * 자동차는 타이어에 의존한다
  * 운전자는 자동차를 사용한다
  * 운전자가 자동차에 의존한다고 봐도 된다
  * 자동차의 생성자 코드에서 tire 속성에 새로운 타이어를 생성해서 참조할 수 있게 해주었다

#### 스프링 없이 의존성 주입하기 1 - 생성자를 통한 의존성 주입
* 의사 코드
  * 운전자가 타이어를 생산한다
  * 운전자가 자동차를 생산하면서 타이어를 장착한다
* 자바로 표현 - 생성자 인자 이용
  * Tire tire = new KoreaTire();
  * Car car = new Car(tire);
* 주입이란?
  * 외부에서라는 뜻을 내포하고 있는 단어
  * 결국 자동차 내부에서 타이어를 생산하는 것이 아니라 외부에서 생산된 타이어를 자동차에 장착하는 작업이 주입
* <strong>이런 방식의 코드 장식의 이점</strong>
  * 기존 방식에서는 Car는 KoreaTire, AmericaTire에 대해 정확히 알고 있어야만 그에 해당하는 객체를 생성할 수 있었지만 의존성 주입을 적용할 경우 Car는 Tire인터페이스를 구현한 어떤 객체가 들어오기만해도 정상적으로 작동함
  * 이는 나중에 어떤 새로운 타이어 브랜드가 생겨도 각 브랜드들이 Tire인터페이스를 구현한다면 그대로 쓸수 있기 때문
* 현실 세계의 표준 규격 준수 = 프로그래밍 세계의 인터페이스 구현

#### 스프링 없이 의존성 주입하기 2 - 속성을 통한 의존성 주입
* 의사코드
  * 운전자가 터이어를 생산한다
  * 운전자가 자동차를 생산한다
  * 운전자가 자동차에 타이어를 장착한다
* 자바로 표현 - 속성 접근자 메서드 사용
  * Tire tire = new KoreaTire();
  * Car car = new Car();
  * car.setTire(tire)
* 최근에는 속성을 통해 의존성을 주입하는 방법보단 생성자를 통한 의존성 주입을 선호하는 사람들이 많아짐

#### 스프링을 통한 의존성 주입 - XML 파일 사용
* 의사코드
  * 운전자가 종합 쇼핑몰에서 타이어를 구매한다
  * 운전자가 종합 쇼핑몰에서 자동차를 구매한다
  * 운전자가 자동차에 타이어를 장착한ㄷ
* 자바로 표현 - 속성 메서드 사용
  * ApplicationContext context = new ClassPathXmlApplicationContext("expert002.xml", Driver.class);
  * Tire tire = (Tire)context.getBean("tire");
  * Car car = (Car)context.getBean("car");
  * car.setTire(tire);
* <strong>스프링을 도입해서 얻는 이득</strong>
  * 자동차의 타이어브랜드를 변경할때 XML파일만 수정하면 실행결과를 바꿀수 있다는것

#### 스프링을 통한 의존성 주입 - 스프링 설정 파일(XML)에서 속성 주입
* 의사코드 - 점점 더 현실 세계를 닮아가고 있다
  * 운전자가 종합 쇼핑몰에서 자동차를 구매요청한다
  * 종합 쇼핑몰은 자동차를 생산한다
  * 종합 쇼핑몰은 타이어를 생산한다
  * 종합 쇼핑몰은 자동차에 타이어를 장착한다
  * 종합 쇼핑몰은 운전자에게 자동차를 전달한다
* 자바로 표현
  * ApplicationContext context = new ClassPathXmlApplicationContext("expert003/expert003.xml");
  * Car car = context.getBean("car", Car.class);
* XML로 표현
  * <bean id="koreaTire" class="expert003.KoreaTire"></bean>
  * <bean id="americaTire" class="expert003.AmericaTire"></bean>
  * <bean id="car" class="expert003.car">
        <property name="tire" ref="koreaTire"></property>
    </bean>
    * 자바에서 접근자 및 선정자 메서드를 속성 메서드라고 하는데 이를 Property라고함
  * Driver.java에서 car.setTire(tire)라고하던 부분을 XML파일의 property 태그를 이용해 대체

#### 스프링을 통한 의존성 주입 - @Autowired를 통한 속성 주입
* 의사코드
  * 위와 동일
* 프로그래머의 3대 스킬
  * C&P - Copy & Paste / 복사 & 붙여넣기
  * D&C - Divide & Conquer / 분할 & 정복
  * C&I - Creative Idleness / 창조적 게으름
```
Tire tire;

public void setTire(Tire tire){
  this.tire = tire;
}
이를 @Autowired를 이용하면

import org.spingframework.beans.factory.annotation.Autowired;

@Autowired
Tire tire;
으로 사용
```
* 위와같은 방법을 사용하면 설정자 메서드를 이용하지 않아도 설정파일을 통해 설정자 메서드 대신 속성을 주입해 준다
* @Autowired - 스프링 설정 파일을 보고 자동으로 속성의 설정자 메서드에 해당하는 역할을 해주겠다는 의미
* 인텔리제이에서 @Autowired 하려면 ctrl+shitf+alt+s => Modules => +(오른쪽) => @Autowired하려는 xml파일 불러와야함
* <strong>@Autowired는 type과 id 가운데 매칭 우선순위는 type이 높다</strong>

#### 스프링을 통한 의존성 주입 - @Resource를 통한 속성 주입
* 의사코드
  * 이전과 동일
* @Autowired에서 @Resource로 변경이유
  * @Autowired는 스프링의 어노테이션
  * @Resource는 자바 표준 어노테이션
    * <strong>즉 스프링 프레임워크를 사용하지 않으면 @Autowired를 사용할 수 없고 @Resource만을 사용해야함
* <strong>@Resource는 type과 id가운데 매칭 우선순위는 id가 높다</strong>
* Resource의 경우 id로 매칭할 빈을 찾지 못한 경우 type으로 매칭할 빈을 찾게 된다

#### 스프링을 통한 의존성 주입 - @Autowired vs @Resource vs <property>태그
* @Autowired와 @Resource를 바꿔서 사용하는데 큰 차이가 없음
* @Autowired와 @Resource중에서는 @Resource 추천
* @Resource와 <property>중에서는 <property>추천
* 프로젝트의 규모가 커질수록 XML파일도 용도별로 분리할 수 있어 <property>를 추천

### 2. AOP(Aspect-Oriented Programming) - Aspect? 관점? 핵심 관심사? 횡단 관심사?
* Aop(Aspect-Oriented Programming) : 관점 지향 프로그래밍
* <strong>DI가 의존성(new)</strong>에 대한 주입이라면 <strong>AOP는 로직(code)</strong>주입라고 할 수 있음
* 횡단 관심사(cross-cutting concern) : 다수의 모듈에 공통적으로 나타나는 부분이 존재하는 것
* 코드 = 핵심 관심사 + 횡단 관심사
* 핵심 관심사 : 모듈별로 반복되어 중복해서 나타나는 부분
* 어노테이션
  * @Aspect는 이 클래스를 이제 AOP에서 사용하겠다는 의미
  * @Before는 대상 메서드 실행 전에 이 메서드를 실행하겠다는 의미
* ```<aop:aspectj-autoproxy />```는 스프링 프레임워크에서 AOP프록시를 사용하라고 알려주는 지시자
* <strong>스프링 AOP의 핵심</strong> 
  * 스프링 AOP는 인터페이스(interface) 기반이다.
  * 스프링 AOP는 프록시(proxy) 기반이다.
  * 스프링 AOP는 런타임(runtime) 기반이다.

#### 용어
* Aspect - 관점, 측면, 양상
* Advisor - 조언자, 고문
* Advice - 조언, 충고
* JoinPoin - 결합점
* Pointcut - 자르는 점

