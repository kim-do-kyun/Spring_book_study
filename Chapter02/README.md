# 02장 [자바와 절차적 / 구조적 프로그래밍]
## :pencil: 정리
### 1. 자바 프로그램의 개발과 구동
* <strong>JDK</strong> - 자바 개발도구 (소프트웨어 개발도구)
* <strong>JRE</strong> - 자바 실행 환경 (운영체제)
* <strong>JVM</strong> - 자바 가상 기계 (하드웨어 - 물리적 컴퓨터)
* <strong>Write Once Run Anywhere</strong> - 한번 작성하면 어디서든 실행할 수 있다(자바의 특성)
* 프로그램이 메모리를 사용할때는 <strong>코드 실행 영역 | 데이터 저장영역</strong> 이지만, 객체 지향 프로그램의 메모리 사용방식은 <strong>코드 실행 영역 | 스태틱영역, 스택영역, 힙영역</strong>으로 나뉜다

### 2. goto의 금지
* 자바는 goto를 사용못하게 예약어로 선점해둠(goto를 사용하게 되면 프로그램의 실행 순서가 인간이 이해하기에 너무 복잡해질 가능성이 있기 때문)

### 3. main() 메서드 실행전 JVM에서의 전처리
* java.lang 패키지, import된 패키지, 프로그램상의 모든 클래스를 T메모리의 <strong>스태틱영역</strong>에 배치함
* 메서드의 놀이터는 <strong>스택</strong>
* 메서드의 경우 <strong>스택프레임</strong>에 생성되는데 중괄호로 스택 프레임이 만들어지고 닫는 중괄호로 스택프레임이 소멸된다
=> main() 메서드가 끝나면 <strong>JRE</strong>는 <strong>JVM</strong>을 종료하고, <strong>JRE</strong>자체도 운영체제 상의 메모리에서 사라진다 

### 4. 변수와 메모리
* main() 메서드 내의 변수는 main() 메서드 스택 프레임 안에 밑에서부터 차곡차곡 변수 공간을 마련함 

### 5. 블록 구문과 메모리
* 메서드 안에 예를들어 if문이 있을경우 여는 중괄호를 만나면 스택프레임이 시작된다고 했는데 이때 만들어지는 스택프레임은 메서드의 스택프레임이 아닌 블록의 스택프레임으로 생성된다
* 위에서 말한것처럼 블록의 스택프레임안에 상주하던 변수의 저장공간 또한 닫는 중괄호를 만나면 사라진다

### 6. 지역 변수와 메모리
* <strong>지역변수</strong>는 <strong>스택 영역</strong>에서 일생을 보낸다(스택 프레임이 사라지면 사라짐)
* <strong>클래스 멤버 변수</strong>는 <strong>스태틱 영역</strong>에서 일생일 보낸다(JVM이 종료될때 까지 고정된(static)상태로 그자리를지킨다)
* <strong>객체 멤버 변수</strong>는 <strong>힙</strong>에서 일생을 보낸다(가비지 컬렉터에 의해 일생을 마친다)
* <strong>"외부 스택 프레임에서 내부 스택 프레임의 변수에 접근하는 것은 불가능하나 그 역은 가능하다"</strong>

### 7. 메서드 호출과 메모리
* <strong>"Call by Value"</strong> : 함수 호출시 값을 넘겨주는 방식(인자로 받은 값을 복사하여 처리, 즉 원래 값은 수정되지 않는다)
* 메서드의 <strong>블랙박스화</strong> : 입력값들과 반환값에 의해서만 메서드 사이에서 값이 전달될 뿐 서로 내부의 지역변수를 볼 수 없다는것을 의미
* 전역변수(공유변수)를 사용하면 가능하지만 가급적 쓰지 않는 것이 좋음

### 8. 전역 변수와 메모리
* <strong>지역변수</strong> - 스택 프레임에 종속적
* <strong>전역변수</strong> - 스택 프레임에 독립적
* 전역변수를 가급적 쓰지 마라고 하는 이유는 프로젝트의 규모가 커질경우 전역변수의 값을 추적하기 어렵기 때문(이곳 저곳에서 값의 할당이 바뀌기 때문)

### 9. 멀티 스레드 / 멀티 프로세스의 이해
* <strong>멀티 스레드</strong> - 스택 영역을 스레드 개수 만큼 분할해서 쓰는것(T 메모리 모델의 경우)
* 스태틱 영역과 힙 영역을 공유해서 사용하는 구조, 멀티 프로세스 대비 메모리를 적게 사용할수 있음
<멀티 스레드>
![멀티스레드](https://github.com/kim-do-kyun/Spring_book_study/assets/70315428/13fcdb59-6fd6-4a64-8772-9b9f06395e86)


* <strong>멀티 프로세스</strong> - 다수의 데이터 저장 영역, 즉 다수의 T 메모리를 갖는 구조
* 각자의 T 메모리를 가져 메모리 사용량은 크지만 서로 참조를 할 수 없어 안전한 구조임
<멀티 프로세스>
![멀티 프로세스](https://github.com/kim-do-kyun/Spring_book_study/assets/70315428/533d8c0f-3ea4-4c2c-8d1c-d671e7296b8c)
<br>
* 쓰기 가능한 전역변수를 사용하게 되면 스레드의 안정성이 깨진다고 표현