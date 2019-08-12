

## Framework

뼈대, 골격

아키텍쳐 , 기본골격

애플리케이션에 대한 분석, 설계 , 구현 에서 재사용성이 증가한다.

장점e

- 빠른 구현시간
- 쉬운 관리
- 개발자들의 역량 획일화
- 검증된 아키텍처의 재사용과 일관성 유지

자바 기반의 프레임워크는 대부분 오픈소스로 제공된다.



Presentation : Client

Business 

Persistence : Data base

## 스프링 환경구축

1. Make Project
2. Spring Nature
3. Maven(Add Spring Library)
   - pox.xml (List up Library)
   - Download Library (automatic)
   - maven -> update project

4. Add external Library

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

### Spring IoC(Inversion of Control)

#### XML

Bean

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

<bean id="ubiz" class="com.user.UserBiz" p:dao-ref="uod" init-method="startBiz" destroy-method="endBiz"/>
<!--객체가 생성될 때에 startBiz를 호출하고, 객체가 삭제되기 직전에 endBiz를 호출한다. -->
```

#### Annotation

```xml
<context:component-scan base-package="springtv"/>
<!-- springtv 패키지에 있는 Component 들을 모두 찾는다.-->
```

```java
@Component("mytv")
// 혹은
@Repository("mytv")
// spring 에서 읽어 드릴 id를 설정한다.
public class STV{
    @Autowired 
// Speaker 타입인 객체를 자동으로 가져온다.
// 하지만 만약 Speaker 타입인 객체가 2개 이상이면 err
    @Qualifier("ms") // Autowired 에 ms 를 연결한다.
    Speaker spk;
    @Resource(name="ms") //conponent 이름이 ms 인 녀석을 바로 연결한다.
    Speaker spk
}

```

하지만 만약 어노테이션시 의존성을 주입하게 된다면 유지보수가 불편할 수 있다.

따라서 STV 에서는 @Autowired 로만 연결을 해주고,  Speaker 에서는 @Component 를 설정 해 주지 않고 , 연결을 위한 하나의 Speaker Type은 XML 에서 선언을 해준다.

###### 추가 어노테이션

```java
//어노테이션을 단순히 @Component 라고 부를수도 있지만,
//동일한 기능을 할 수 있는 여러가지 명칭이 있다.
@Service //비즈니스 로직을 처리
@Repository //데이터베이스 연동을 처리 DAO클래스
@Controller //사용자 요청을 제어
// 다른 이름을 통해 클래스를 분류할 수 있다.
//사실 이름만 다른것이 아니라 Controller 는 MVC 아케텍처에서 컨트롤러 객체로 인식을 하며, @Repository는 DB연동 과정에서 발생하는 예외를 변환해주는 기능이 추가 되어 있다.
```



### Spring AOP(Aspect Oriented Programming)

메소드마다 공통으로 등장하는 횡단관심(Seperation of Concerns)( 로깅 , 예외 , 트랙잭션 등)

과 사용자의 요청에 따라 실제로 수행하는 비즈니스로직인 핵심관심(Core Concern)

두가지 관심을 완벽하게 분리해야만 간결하고 응집도 높은 코드를 유지할 수 있지만, 기존의 OOP 언어에서는 불가능 하다.

이를 분리시키는 것이 Spring 에서는 가능하다



조인포인트

모든 비즈니스 메소드

##### 포인트컷

필터링된 조인포인트, 원하는 메소드

###### 예시

```xml
<bean id="log" class="com.frame.Logadvice" />
	<aop:config>
		<aop:pointcut expression="execution(* com.user..*Biz.*(..))" id="id01" />
        <!-- pointcut  대상 위치-->
		<aop:aspect ref="log"> <!--aspect 어떤 클래스의-->
			<aop:before pointcut-ref="id01" method="printlog"/> 
            <!-- before 일때 method 어떤 함수를 적용할것이다-->
		</aop:aspect>
	</aop:config>


```

###### 포인트컷 표현식

```
* com.user..*Biz.*(..)
리턴타입 패키지경로 클래스명 메소드or매개변수 
모든리턴타입, com.user 패키지의 Biz로 끝나는 모든 클래스의 모든메소드.

* com..Biz+.*(..)
com 패키지 안의, Biz를 implementation 한 자식 패키지들의 모든 매개변수를 가지는 모든 메소드	
* com..Biz+.*(com.user.User)
매개변수로 User를 가지는 메소드만 해당함.
```

##### 어드바이스 동작 시점

Before : 메소드 실행 전

After : 메소드 실행 후

- Returning :  메소드가 모든 수행을 끝마치고 결과를 return 하는 시점에 실행.

  결과데이터를 이용하여 사후처리 로직을 추가할 때 사용.

- Throwing :  Exception 이 발생하는 시점에 동작한다.



Around : 메소드 실행 전, 후

```java
public Object aroundlog(ProceedingJoinPoint pjp) throws Throwable {
	Date d = new Date();
	System.out.println(d+"Before Action ...");
    // Before 어드바이스와 같은 시점
    Object obj = pjp.proceed();// 이때 메소드의 실행이 일어난다.
    // Before 어드바이스와 같은 시점
	d= new Date();
    System.out.println(d+"After Action ...");
    return obj;
}

```

#### XML

```java
public void beforelog(JoinPoint jp) {
    String method = jp.getSignature().getName(); // 실행 	함수 이름
    Object[] args = jp.getArgs(); // 입력된 매개변수
    System.out.println(method + ":" + args[0]);
    System.out.println("[before] 로직 수행");
}
// 실행 되는 메소드의 이름과 입력된 매개변수의 값을 알 수 있다.

public void afterlog(JoinPoint jp, Object returnobj) {
    System.out.println("[after] 로직 수행");
    System.out.println(returnobj);
}
//메소드가 수행되고 나서 return 값을 알 수 있다.

public void exlog(JoinPoint jp , Exception ex) {
    Date d = new Date();
    System.out.println(d + "[예외발생]...");
    System.out.println(ex.getMessage());
}
//예외가 발생했을 때, 내용을 알 수 있다.

```

```xml
<aop:after-returning pointcut-ref="id01" method="afterlog" returning="returnobj"/>
<!-- returning 으로, 리턴 받는 값을 받은 변수 이름을 일치 시켜 준다.-->
<aop:after-throwing pointcut-ref="id01" method="exlog" throwing="ex" />
<!-- thrwoing 으로, 값을 받는 변수 이름을 일치시킨다-->
```

#### Annotation

```xml
<aop:aspectj-autoproxy/>
```

```java
@Service
@Aspect
public class Logadvice {
    //before 
	@Before("execution(* com..Biz+.insert(..))")    
	public void beforelog(JoinPoint jp) {    
    }
    //after-returning
    @AfterReturning(
		pointcut="execution(* com..Biz+.select(..))",
        returning ="retrunobj"	)
	public void afterlog(JoinPoint jp, Object returnobj) {}
    
    //after-throwing
    @AfterThrowing(
		pointcut="execution(* com..Biz+.select(..))",
		throwing ="ex")
	public void exlog(JoinPoint jp , Exception ex) {}
    
   	//around
    @Around("execution(* com..Biz+.select(..))")
	public Object aroundlog(ProceedingJoinPoint pjp) throws Throwable {}
        
}
```



### Mybatis

Settings

myspring.xml

```xml
<!-- 1. Database Setting -->
<!-- 데이터 베이스를 연결한다 -->
 	<bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
 		<property name="driverClassName" value="oracle.jdbc.driver.OracleDriver"/>
 		<property name="url" value="jdbc:oracle:thin:@70.12.114.55:1521:xe"/>
 		<property name="username" value="db"/>
 		<property name="password" value="db"/>
 	</bean>

 	<!-- 2. Transaction Setting -->
	<!-- 트랜잭션이 생길경우의 처리할 매니저를 생성한다? -->
 	<bean id="txManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
 		<property name="dataSource" ref="dataSource"/>
 	</bean>
 	<!-- 3. MyBatis Setting -->
	<!-- mybatis.xml 을 연결하여 어떤 클래스를 가지고 수행할지 설정한다. -->
 	<bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
 		<property name="dataSource" ref="dataSource"/>
 		<property name="configLocation" value="classpath:com/mybatis/mybatis.xml"/>
 	</bean>	

	<!-- 4. Spring Mybatis Connect -->
	<!-- Spring Mybatis를 사용한다-->
 	<bean id="sqlSessionTemplate" class="org.mybatis.spring.SqlSessionTemplate">
 		<constructor-arg ref="sqlSessionFactory"/>
 	</bean>
 	
 	<!-- 5. Mapper Setting -->
	<!-- Mapper 들의 기본 디렉토리를 설정한다.-->
 	<bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
 		<property name="basePackage" value="com.mapper"/>
 	</bean>
```

mybatis.xml

```xml
<configuration>
	<typeAliases>
		<typeAlias type="com.vo.User" alias="user"/>
	    <typeAlias type="com.vo.Product" alias="product"/>
	   <!-- 해당 클래스들을 alias 로 줄여서 부르겠다.  -->
	</typeAliases>	
	<mappers>
		<mapper resource="com/mybatis/usermapper.xml"/>
		<mapper resource="com/mybatis/productmapper.xml"/>
	</mappers>
    <!-- Mapper 들을 쓰겠다.  -->
</configuration>
```

usermapper.xml

```xml
<mapper namespace="com.mapper.UserMapper">
	<!-- com.mapper.UserMapper Interface 와 연결하겠다.-->	
	<insert id="insert" parameterType="user">
		INSERT INTO T_USER VALUES
		(#{id},#{pwd},#{name})
	</insert>
	<select id="select" parameterType="String" resultType="user">
		SELCT *
		FROM T_USER
		WHERE ID=#{obj}
        <!-- obj 는 UserMapper Interface 의 select 메소드의 Parameter다-->
	</select>
	<select id="selectall" resultType="user">
		SELECT *
		FROM T_USER
		ORDER BY 1
        <!--selectall 의 경우 리턴값이 배열이지만, object로 처리가 되기 때문에 문제 없이 수행이 가능하다.-->
	</select>
    <!-- xml 파일에는 특수문자 입력이 제한된다.
'%L%' =  '%'||${L}||'%' 
-->
</mapper>
```

###### Transaction 처리

Interface method 선언시 @Transactional 선언을 해준다.

```java
public interface Services<K,V> {
	@Transactional
	public void insert(V v) throws Exception;
	@Transactional
	public void update(V v) throws Exception;
	@Transactional
	public void delete(K k) throws Exception;
	public V select(K k) throws Exception;
	public ArrayList<V> select() throws Exception;
}

```



### Spring MVC ( Model , View , Controller)

Settings

-web.xml

1. dispatcher
2. filter

```xml
<servlet>
		<servlet-name>action</servlet-name>
		<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
		<init-param>
			<param-name>contextConfigLocation</param-name>
			<param-value>/WEB-INF/config/spring.xml</param-value>
		</init-param>
	</servlet>
	<servlet-mapping>
		<servlet-name>action</servlet-name>
		<url-pattern>*.mc</url-pattern>
	</servlet-mapping>
<!-- .mc 가 들어오면 Dispatcher를 연결할 것이라 선언 -->
	<filter>
		<filter-name>enc</filter-name>
<filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class><init-param>
			<param-name>encoding</param-name>
			<param-value>UTF-8</param-value>
		</init-param>
	</filter>
	<filter-mapping>
		<filter-name>enc</filter-name>
		<url-pattern>/*</url-pattern>
	</filter-mapping>
<!--한글이 이쁘게 나오게 설정-->
```

-spring.xml

1. mvc:annotation-driven
2. viewResolver

```xml
<bean id="viewResolver"		class="org.springframework.web.servlet.view.InternalResourceViewResolver">
		<property name="prefix" value="/view/" />
		<property name="suffix" value=".jsp" />
		<property name="order" value="0" />
	</bean>
<!-- viewName  에 a가 들어오면 /view 폳더의 a.jsp 연결-->
```

```java
@Controller
public class MainController {
	@RequestMapping("/main.mc")// main.mc가 요청되면 실행된다
	public ModelAndView main() {
		//데이터와 화면 모델 앤드 뷰 
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main"); 
        // spring.xml 에서 설정한 대로 /view/main.jsp 로 연결된다.
		return mv;
		//modelandview 를 return 하면  자동으로 forward 가 된다
	}
}
```

Servlet 과 Dispatcher를 구현하고 설정했던 POJO 와는 다르게 매우 간단하게 핸들링할 수 있게 되었다.

##### 화면의 값 전달 받기

```java
// 화면에서 form 형식으로 action="loginmethod.mc" method="POST" 로 지정했다면
@RequestMapping(value="/loginmethod.mc" ,method=RequestMethod.POST)	
	public ModelAndView loginmethod(String id, String pwd) {
        //Parameter 로, 화면의 input Name 들을 받을 수 있다.
        //단, Parameter의 변수명과 input name이 일치해야한다.
		ModelAndView mv = new ModelAndView();
		mv.addObject("center","login");
		System.out.println(id +" "+ pwd);
		mv.setViewName("main");
		return mv;
    }

```

Controller

```java
@RequestMapping("/useraddimpl.mc")
	public ModelAndView uaddc(ModelAndView mv , User u) {
        //만약 form 의 input name 들이 User의 변수 이름과 일치한다면, 자동으로 setter 에 의해 u가 만들어져 매개변수로 들어오게 된다.
		System.out.println(u);		
		mv.setViewName("main");
		return mv;
}
```

파일 전송받기

```java
MultipartFile mf;
//파일을 받기 위해서는 객체의 변수에 MultipartFile 을 가지고 있어야 한다.

```

```html
<form action="productaddimpl.mc" method="POST" enctype="multipart/form-data">
NAME<input type="text" name="name"><br>
PRICE<input type="number" name="price"><br>
IMG<input type="file" name="mf"><br>
<!--Product 의 mf 에 파일 저장해서 보낸다.-->
<input type="submit" value="REGISTER"><br>
</form>
```

Multi Language

사용자 Browser의 기본 언어 세팅에 따라 다르게 표시

```xml
<!-- Multi language -->	
	<bean id="messageSource"
		class="org.springframework.context.support.ResourceBundleMessageSource">
		<property name="basenames">		
			<list>
				<value>messages/messages</value>
				<!-- 이 파일들에 의해서 -->
			</list>
		</property>
	</bean>
	<bean id="localeResolver"
		class="org.springframework.web.servlet.i18n.SessionLocaleResolver">
	</bean>	
	<mvc:interceptors>
	<!--사용자의 Browser 에서 접속할때 main Language 를 찾는다.  -->
		<bean			class="org.springframework.web.servlet.i18n.LocaleChangeInterceptor">
			<property name="paramName" value="lang" />
		</bean>
	</mvc:interceptors>
```

messages_en.properties

```
welcome.txt = Welcome {0} {1}
register.txt = Register OK {0}
item.list=Item List
코드 = 값{n}
		n번째 파라미터
```

```html
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<spring:message code="welcome.txt" arguments="hi,mulcam"/>
```

```java
class Product{
MultipartFile mf;
//product 의 변수 추가
}

@RequestMapping("/productaddimpl.mc")
	public String paddc(ModelAndView mv, Product p) {    
        //form 형식에서 보낸 mf 를 받아온다.
		String imgname = p.getMf().getOriginalFilename();
		p.setImgname(imgname);
		try {
			biz.insert(p);
			Util.saveFile(p.getMf());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:productlist.mc";
	}
//util.java
public class Util {
	public static void saveFile(MultipartFile mf) {
		byte [] data;
		String imgname = mf.getOriginalFilename();
		String dir="C:\\Users\\student\\KH\\TIL\\Spring\\smvc3\\web\\img\\";
		try {
			data = mf.getBytes();
			FileOutputStream fout = new FileOutputStream(dir+imgname);
			fout.write(data);
			fout.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
```



###### 환경 재구축

1. 기본 스프링 환경구축
2. Biz,Dao 구현
3. 테스트를 위한 src\myspring.xml
4. Dispatcher 를 위한 web\web-inf\web.xml
5. 웹 기능을 위한 web\web-inf\spring.xml



JSON 을 통한 값 전달하기

```java
@RequestMapping("/pchart.mc")
@ResponseBody //값을 전달한다고 알림
public void pdata(HttpServletResponse response) {
	response.setCharacterEncoding("EUC-KR");
	response.setContentType("text/json;charset=UTF-8");
	ArrayList<Product> list = new ArrayList<Product>();
	JSONArray ja = new JSONArray();
	PrintWriter pt;
	try {
		list = pbiz.select();
		int l = list.size();
		for(int i=0;i<l;i++) {
			JSONObject jo = new JSONObject();
			jo.put("name",list.get(i).getName());
			jo.put("y",list.get(i).getPrice());
			ja.add(jo);
		}
		pt = response.getWriter();
		pt.print(ja.toJSONString());
	} catch (Exception e) {
		e.printStackTrace();
	}
}
```



###### Log

web.xml

```xml
  <listener>
     <!--모든 request 에 대해서 리스너 설정-->
  	<listener-class>org.springframework.web.util.Log4jConfigListener</listener-class>
  </listener>
  <context-param>
  	<param-name>log4jConfigLocation</param-name>
      <!-- log 에 관한 설정 파일 지정 -->
  	<param-value>/WEB-INF/config/log4j.properties</param-value>
  </context-param>
```

log4j.properties

```properties
log4j.logger.user = DEBUG, console, user
#user 추가, log를 세군데에 출력하겠다.
log4j.appender.work.Threadhold=DEBUG
log4j.appender.work = org.apache.log4j.DailyRollingFileAppender
log4j.appender.work.DatePattern = '.'yyyy-MM-dd
# 매일마다 로그파일을 생성한다. 즉 하루가 지나면 어제 만들어진 로그파일의 이름을 변경한다. 패턴은 기존파일이름.yyyy-MM-dd 로 지정한다.
log4j.appender.work.layout = org.apache.log4j.PatternLayout 
log4j.appender.work.layout.ConversionPattern = %-5p , %L , %d , %m%n
log4j.appender.work.File = c:/logs/work.log 
#log 파일의 저장 경로
```

logger.java

```java
@Service
@Aspect
public class Loggers {
	private Logger user_log = 
			Logger.getLogger("user"); 
		//log4j.properties 에 정의된 user 를 사용하겠다 선언.
	
	// before com.controller 패키지의 모든 컨트롤러의 모든함수 실행 전에
	@Before("execution(* com.controller..*Controller.*(..))")
	public void logging(JoinPoint jp) {
		user_log.debug(jp.getSignature().getName());
		//user_log.debug(jp.getArgs()[0].toString());
	}
```

exception 발생시 화면 처리

web.xml

```xml
<listener>
		<listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
	</listener>
	<context-param>
		<param-name>contextConfigLocation</param-name>
		<param-value>/WEB-INF/config/springex.xml</param-value>
	</context-param>
```

springex.xml

```xml
<bean id="exeptionResolver" 
 	class="org.springframework.web.servlet.handler.SimpleMappingExceptionResolver">
 		<property name="exceptionMappings">
 			<props>
                <!-- arithmeticexception 발생시 /veiw/error.jsp 로 가겠다. -->
 				<prop key="java.lang.ArithmeticException">
 					error
 				</prop>
 			</props>
 		</property>
 	</bean>
```



Session 정보 가져와서 log 에 남기기

Logger.java

```java
HttpSession session = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest().getSession();
// session 의 정보 가져오기
String userid = (User) session.getAttribute("loginuser").getID();
MDC.put("userid",userid);
//userid 라는 변수 선언
user_log.debug(jp.getSignature().getNmae());

```

log4j.properties

```properties
log4j.appender.user.layout.ConversionPattern = %X{userid} %n
#userid 라는 변수 출력
```





###### 문제

특정 객체에서만 사용하는 함수 specialization 이 불가능하다

이를 구현하기 위해서는 interface에 함수를 선언하고 다른 객체에서는 빈 함수로 나두어야한다.