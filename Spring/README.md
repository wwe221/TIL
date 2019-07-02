### Framework

뼈대, 골격

아키텍쳐 , 기본골격

애플리케이션에 대한 분석, 설계 , 구현 에서 재사용성이 증가한다.

장점

- 빠른 구현시간
- 쉬운 관리
- 개발자들의 역량 획일화
- 검증된 아키텍처의 재사용과 일관성 유지

자바 기반의 프레임워크는 대부분 오픈소스로 제공된다.



Presentation : Client

Business 

Persistence ; Data base

## 스프링 환경구축

1. Make Project
2. Spring Nature
3. Maven(Add Spring Library)
   - pox.xml (List up Library)
   - Download Library (automatic)
   - maven -> update project



## 스프링 프레임 워크

POJO (기존 자바 클래스 Plain Old Java Object)

POJO를 사용할 수 있다.



특징

- 경량
- 제어의 역행(Inversion of Control IoC)
  
  - 객체와 객체 사이의 의존관계가 없어 낮은 결합도를 가질 수 있다.
  
    
- 관점지향 프로그래밍 (Aspect Oriented Programming AOP)
  
  - 각 로직과 메소드 등에서 공통 적으로 등장하는 로직을 분리하여 응집도가 높게 개발할 수 있다.

```java
AbstractApplicationContext factory = 
		new GenericXmlApplicationContext("myspring.xml");
//Spring Container 를 만드는 작업
//myspring.xml 에서 정의 되어 있는 객체들이 먼저 만들어 진다.
//먼저 만들어진 객체들을 referencing 하기 때문에 
//IoC 라고 한다.
TV stv = (TV)factory.getBean("sstv");
```

```xml
<!--myspring.xml -->
<bean id="sstv" class="springtv.STV" ></bean>
```

###### Maven

여러가지 외부 라이브러리를 관리  하기 위한 기법

.m2/repository/ 에 자동으로 필요하다고 선언한 라이브러리들을 다운 받아 준다.

##### Bean

```xml
<bean id="sstv" class="springtv.STV" lazy-init="true"></bean> 
<!-- lazy-init="true" 해당 객체의 생성은 호출에 이루어진다.  -->
<bean id="sstv" class="springtv.LTV" scope="prototype"></bean> 
<!-- 객체를 하나만 사용할지 scope="singleton"
여러개를 사용할지를 정한다. scope="prototype" -->

<bean name="stv" class="com.sds.STV" lazy-init="true">
	<constructor-arg index="0" value="65"></constructor-arg>
    <constructor-arg index="1" ref="sp"></constructor-arg>
	</bean>
<!-- stv 를 생성할때의 arg 인자에 65와 sp를 넣는다는 의미다
	stv = new STV(65,sp); -->

<bean name="stv" class="com.sds.LTV" lazy-init="true" p:size="75" p:speaker-ref="sp"></bean>
<!-- LTV.setSize(75) -->

```

###### 문제

특정 객체에서만 사용하는 함수 specialization 이 불가능하다

이를 구현하기 위해서는 interface에 함수를 선언하고 다른 객체에서는 빈 함수로 나두어야한다.