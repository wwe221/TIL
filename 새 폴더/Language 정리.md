# Java

## JVM 에 대해서, GC 의 원리

- [Java Virtual Machine 에 대해서](http://asfirstalways.tistory.com/158)
- [Garbage Collection 에 대해서](http://asfirstalways.tistory.com/159)

### **JVM 의 구조**



### ![image-20180602145758293](https://d2.naver.com/content/images/2015/06/helloworld-1230-1.png)

Class Loader – 생성된 java Class 파일 (Byte Code) 을 읽어 JVM 내의 Runtime Data Area에 배치하는 작업을 수행한다.

Execution Engine – 런타임 영역에 배치된 바이트 코드를 명령어 단위로 읽어 실행하는 Runtime Module

​                     (정적 번역기법인 Interpreter 방식과 동적 번역 기법인 JIT (Just In Time) 방식이 있다.)

Garbage Collector - 생성한 객체들 중 참조되지 않는 객체들을 탐색 후 제거 하는 역할을 한다.

 

### **Java 의 바이트코드 가 실행되는 과정**

1)	Class Loader 가 Byte Code를 읽어 Runtime Data Area에 배치

2)	Method Area의 Byte Code 를 JVM이 Execution Engine에 전달하여 정의된 내용에 따라 수행한다.



### **JVM 내의 메모리 구조**

**Runtime Data Areas** – JVM이 운영체제 위에서 실행되면서 OS로부터 할당 받는 메모리 영역으로, Class Loader 가 데이터들을 보관하는 저장소 이다

크게 Method (Static) Area , Heap Area , Stack Area , PC register , Native Method Stack 으로 나뉘어 진다.

1. **Method (Static) Area** – JVM이 읽어 들인 필드 정보와 메소드 정보, Type 정보 Constant Pool, Static 변수 final변수,멤버 변수 , 클래스 변수 등의 정보를 저장하는 공간이다.

   모든 스레드가 공유하는 영역

2. **Heap Area** – new 키워드로 생성된 객체와 배열이 생성되는 영역이다. 이 영역에서 생성된 객체와 배열은 Stack Area 나 다른 객체의 필드에서 참조한다.

참조하는 변수나 필드가 없다면 Garbage Collector의 대상이 된다.

Method Area 에 로드 된 클래스만 생성이 가능하다.

3. **Stack Area** – 각 스레드 마다 하나씩 존재하며 스레드가 시작될 때 할당 된다.

지역 변수, 파라미터 , 리턴값, 연산에 사용되는 임시 값 등을 저장한다.

Primitive Type 의 변수는 영역 내에 직접 값을 가지고 Reference Type의 변수는 Heap Area 또는 Method Area 의 객체 주소를 가진다.

4. **PC register** – 현재 수행중인 JVM 명령의 주소를 갖는다. 쓰레드가 생성될 때마다 생성되는 영역으로, 현재 쓰레드가 실행되는 부분의 주소와 명령을 저장하고 있는 영역이다.
5. **Native Method Stack Area** – 자바 외 언어로 작성된 네이티브 코드를 저장하기 위한 Stack 으로, JNI(Java Native Interface)를 통해 호출되는 C/C++ 등의 코드를 수행하기 위한 스택



## Collection

Java Collection 에는 `List`, `Map`, `Set` 인터페이스를 기준으로 여러 구현체가 존재한다. 이에 더해 `Stack`과 `Queue` 인터페이스도 존재한다. 왜 이러한 Collection 을 사용하는 것일까? 그 이유는 다수의 Data 를 다루는데 표준화된 클래스들을 제공해주기 때문에 DataStructure 를 직접 구현하지 않고 편하게 사용할 수 있기 때문이다. 또한 배열과 다르게 객체를 보관하기 위한 공간을 미리 정하지 않아도 되므로, 상황에 따라 객체의 수를 동적으로 정할 수 있다. 이는 프로그램의 공간적인 효율성 또한 높여준다.

- List
  `List` 인터페이스를 직접 `@Override`를 통해 사용자가 정의하여 사용할 수도 있으며, 대표적인 구현체로는 `ArrayList`가 존재한다. 이는 기존에 있었던 `Vector`를 개선한 것이다. 이외에도 `LinkedList` 등의 구현체가 있다.

  중복 허용 O , 순서 O, (속도느림)

  

- Set
  대표적인 구현체로 `HashSet`이 존재한다. `value`에 대해서 중복된 값을 저장하지 않는다. 사실 Set 자료구조는 Map 의 key-value 구조에서 key 대신에 value 가 들어가 value 를 key 로 하는 자료구조일 뿐이다. 마찬가지로 순서를 보장하지 않으며 순서를 보장해주기 위해서는 `LinkedHashSet`을 사용한다.

  중복 허용 X , 순서 고려 X ( 입력한 순서 유지 X)

  

- Map
  대표적인 구현체로 `HashMap`이 존재한다. (밑에서 살펴볼 멀티스레드 환경에서의 개발 부분에서 HashTable 과의 차이점에 대해 살펴본다.) key-value 의 구조로 이루어져 있으며 Map 에 대한 구체적인 내용은 DataStructure 부분의 hashtable 과 일치한다. key 를 기준으로 중복된 값을 저장하지 않으며 순서를 보장하지 않는다. key 에 대해서 순서를 보장하기 위해서는 `LinkedHashMap`을 사용한다.

  <Key , Value> 로 구분, Key는 중복 X

  

- Stack 과 Queue
  `Stack` 객체는 직접 `new` 키워드로 사용할 수 있으며, `Queue` 인터페이스는 JDK 1.5 부터 `LinkedList`에 `new` 키워드를 적용하여 사용할 수 있다. 자세한 부분은 DataStructure 부분의 설명을 참고하면 된다.
  
  

## Java Collection Framework

![Pasted Graphic 25.tiff](https://tramyu.github.io/images/etc/image-20180603144347219.png)

Set은 중복을 허용하지 않음, List 는 중복 가능

HashSet은 입력 순서 보장 X LinkedHashSet 입력 순서 보장.

Vector 동기화 지원, ArrayList는 지원하지 않음

![Java Collection interfaces and concrete classes](http://shivasoft.in/blog/wp-content/uploads/2011/04/Java-Collection-interfaces-and-concrete-classes.jpg)

![JAVA Map interface and concrete classes](http://shivasoft.in/blog/wp-content/uploads/2011/04/JAVA-Map-interface-and-concrete-classes.jpg)

HashMap은 내부 hashing된 값에 따라 키 순서가 정해지므로 key는 특정 순서 없이 나온다.

TreeMap은 내부적으로 RedBlack Tree로 저장됨, 키값에 대한 Compartor 구현으로 정렬 순서를 바꿀수 있다. 정렬된 순서로 key 값이 나온다.

LinkedHashMap은 내부적으로 LinkedList, 입력 순서대로 key 값이 나온다.



## LinkedList와 ArrayList의 차이

ArrayList는 검색에 유리한 구조, 삽입 삭제가 자주 일어나면 LinkedList를 사용하는것이 낫다.

ArrayList는 내부적으로 데이터를 배열에서 관리하며 데이터의 추가, 삭제를 위해 아래와 같이 임시 배열을 생성해 데이터를 복사 하는 방법을 사용 하고 있기 때문에 삽입 삭제시 많은 복사가 일어나기 때문.

![arraylist-internal](https://tramyu.github.io/images/etc/ArrayList.jpg)



## Annotation

어노테이션이란 본래 주석이란 뜻으로, 인터페이스를 기반으로 한 문법이다. 

주석처럼 코드에 달아 클래스에 특별한 의미를 부여하거나 기능을 주입할 수 있다. 또 해석되는 시점을 정할 수도 있다.(Retention Policy) 어노테이션에는 크게 세 가지 종류가 존재한다.

 JDK 에 내장되어 있는 `built-in annotation`과 

어노테이션에 대한 정보를 나타내기 위한 어노테이션인 `Meta annotation` 

 개발자가 직접 만들어 내는 `Custom Annotation`이 있다. 

built-in annotation 은 상속받아서 메소드를 오버라이드 할 때 나타나는 @Override 어노테이션이 그 대표적인 예이다. 어노테이션의 동작 대상을 결정하는 Meta-Annotation 에도 여러 가지가 존재한다.

#### Reference

- http://asfirstalways.tistory.com/309





## Generic

제네릭은 자바에서 안정성을 맡고 있다고 할 수 있다. 다양한 타입의 객체들을 다루는 메서드나 컬렉션 클래스에서 사용하는 것으로, 컴파일 과정에서 타입체크를 해주는 기능이다. 

객체의 타입을 컴파일 시에 체크하기 때문에 객체의 타입 안전성을 높이고 형변환의 번거로움을 줄여준다. 자연스럽게 코드도 더 간결해진다. 

예를 들면, Collection 에 특정 객체만 추가될 수 있도록, 또는 특정한 클래스의 특징을 갖고 있는 경우에만 추가될 수 있도록 하는 것이 제네릭이다. 이로 인한 장점은 collection 내부에서 들어온 값이 내가 원하는 값인지 별도의 로직처리를 구현할 필요가 없어진다. 또한 api 를 설계하는데 있어서 보다 명확한 의사전달이 가능해진다.



example)

class className<A,B>{} 와 같이 조상 클래스를 선언하고, 이를 상속 받는 클래스에서 상속 받을때  A,B 에 필요한 타입을 입력해 준다.

```java
public abstract class Db<T,U> {
	public abstract void insert(T obj);
	public abstract T select(U obj);		
}// Db.java
public class ProductDb extends Db<User, Integer> {
    @Override
	public void insert(Product obj) {System.out.println(obj.getId() + " Inserted");	}
	@Override
	public Product select(Integer obj) {
        Product p = null;
		System.out.println("Search:" + obj);
		p = new Product(300, "shirt", 30000);
		return p;
	}
}//ProductDb.java
```



## final keyword

- final class
  다른 클래스에서 상속하지 못한다.
- final method
  다른 메소드에서 오버라이딩하지 못한다.
- final variable
  변하지 않는 상수값이 되어 새로 할당할 수 없는 변수가 된다.

추가적으로 혼동할 수 있는 두 가지를 추가해봤다.

- finally
  `try-catch` or `try-catch-resource` 구문을 사용할 때, 정상적으로 작업을 한 경우와 에러가 발생했을 경우를 포함하여 마무리 해줘야하는 작업이 존재하는 경우에 해당하는 코드를 작성해주는 코드 블록이다.
- finalize()
  keyword 도 아니고 code block 도 아닌 메소드이다. `GC`에 의해 호출되는 함수로 절대 호출해서는 안 되는 함수이다. `Object` 클래스에 정의되어 있으며 GC 가 발생하는 시점이 불분명하기 때문에 해당 메소드가 실행된다는 보장이 없다. 또한 `finalize()` 메소드가 오버라이딩 되어 있으면 GC 가 이루어질 때 바로 Garbage Collecting 되지 않는다. GC 가 지연되면서 OOME(Out of Memory Exception)이 발생할 수 있다.





## Overriding vs Overloading

- 오버라이딩(Overriding)
  상위 클래스에 존재하는 메소드를 하위 클래스에서 필요에 맞게 재정의하는 것을 의미한다.
- 오버로딩(Overloading) 상위 클래스의 메소드와 이름, return 값은 동일하지만, 매개변수만 다른 메소드를 만드는 것을 의미한다. 다양한 상황에서 메소드가 호출될 수 있도록 한다.

[뒤로](https://github.com/JaeYeopHan/for_beginner)/[위로](https://github.com/JaeYeopHan/Interview_Question_for_Beginner/tree/master/Java#part-2-1-java)



## Access Modifier

변수 또는 메소드의 접근 범위를 설정해주기 위해서 사용하는 Java 의 예약어를 의미하며 총 네 가지 종류가 존재한다.

- public
  어떤 클래스에서라도 접근이 가능하다.
- protected
  클래스가 정의되어 있는 해당 패키지 내 그리고 해당 클래스를 상속받은 외부 패키지의 클래스에서 접근이 가능하다.
- (default)
  클래스가 정의되어 있는 해당 패키지 내에서만 접근이 가능하도록 접근 범위를 제한한다.
- private
  정의된 해당 클래스에서만 접근이 가능하도록 접근 범위를 제한한다.





## Wrapper classe

기본 자료형(Primitive data type)에 대한 클래스 표현을 Wrapper class 라고 한다. `Integer`, `Float`, `Boolean` 등이 Wrapper class 의 예이다. int 를 Integer 라는 객체로 감싸서 저장해야 하는 이유가 있을까? 일단 컬렉션에서 제네릭을 사용하기 위해서는 Wrapper class 를 사용해줘야 한다. 또한 `null` 값을 반환해야만 하는 경우에는 return type 을 Wrapper class 로 지정하여 `null`을 반환하도록 할 수 있다. 하지만 이러한 상황을 제외하고 일반적인 상황에서 Wrapper class 를 사용해야 하는 이유는 객체지향적인 프로그래밍을 위한 프로그래밍이 아니고서야 없다. 일단 해당 값을 비교할 때, Primitive data type 인 경우에는 `==`로 바로 비교해줄 수 있다. 하지만 Wrapper class 인 경우에는 `.intValue()` 메소드를 통해 해당 Wrapper class 의 값을 가져와 비교해줘야 한다.

### AutoBoxing

JDK 1.5 부터는 `AutoBoxing`과 `AutoUnBoxing`을 제공한다. 이 기능은 각 Wrapper class 에 상응하는 Primitive data type 일 경우에만 가능하다.

```
List<Integer> lists = new ArrayList<>();
lists.add(1);
```

우린 `Integer`라는 Wrapper class 로 설정한 collection 에 데이터를 add 할 때 Integer 객체로 감싸서 넣지 않는다. 자바 내부에서 `AutoBoxing`해주기 때문이다.



## 프로세스와 스레드의 차이

자바에서 예를 들면, 실행중인 프로그램을 종종 프로세스라고 한다. 스레드는 그 프로세스 내에서 실행될 수 있는 여러개의 경량화된 프로세스의 개념이다. 한 프로세스 내 여러 스레드는 프로세스 내의 주소 공간이나 자원들을 대부분 공유하면서 실행된다.

프로세스를 여러개 생성하기 보다는 멀티 스레드를 이용하는것이 효율적이다.

우선 컨텍스트 스위칭 비용이 적어진다. 프로세스 간 통신보다는 스레드 간 통신이 훨씬 비용이 적다. 물론 스레드 간 데이터 공유에 따른 동기화 문제를 해결하기 어렵고 그에 따라 디버깅이 어려워지는 단점도 존재한다.



## Multi-Thread 환경에서의 개발

개발을 시작하는 입장에서 멀티 스레드를 고려한 프로그램을 작성할 일이 별로 없고 실제로 부딪히기 힘든 문제이기 때문에 많은 입문자들이 잘 모르고 있는 부분 중 하나라고 생각한다. 하지만 이 부분은 정말 중요하며 고려하지 않았을 경우 엄청난 버그를 양산할 수 있기 때문에 정말 중요하다.

### Field member

`필드(field)`란 클래스에 변수를 정의하는 공간을 의미한다. 이곳에 변수를 만들어두면 메소드 끼리 변수를 주고 받는 데 있어서 참조하기 쉬우므로 정말 편리한 공간 중 하나이다. 하지만 객체가 여러 스레드가 접근하는 싱글톤 객체라면 field 에서 상태값을 갖고 있으면 안된다. 모든 변수를 parameter 로 넘겨받고 return 하는 방식으로 코드를 구성해야 한다.

### 동기화(Synchronized)

필드에 Collection 이 불가피하게 필요할 때는 어떠한 방법을 사용할까? Java 에서는 `synchronized` 키워드를 사용하여 스레드 간 race condition 을 통제한다. 이 키워드를 기반으로 구현된 Collection 들도 많이 존재한다. `List`를 대신하여 `Vector`를 사용할 수 있고, `Map`을 대신하여 `HashTable`을 사용할 수 있다. 하지만 이 Collection 들은 제공하는 API 가 적고 성능도 좋지 않다.

기본적으로는 `Collections`라는 util 클래스에서 제공되는 static 메소드를 통해 이를 해결할 수 있다. `Collections.synchroziedList()`, `Collections.synchroziedSet()`, `Collections.synchroziedMap()` 등이 존재한다. JDK 1.7 부터는 `concurrent package`를 통해 `ConcurrentHashMap`이라는 구현체를 제공한다. Collections util 을 사용하는 것보다 `synchronized` 키워드가 적용된 범위가 좁아서 보다 좋은 성능을 낼 수 있는 자료구조이다.



### ThreadLocal

스레드 사이에 간섭이 없어야 하는 데이터에 사용한다. 멀티스레드 환경에서는 클래스의 필드에 멤버를 추가할 수 없고 매개변수로 넘겨받아야 하기 때문이다. 즉, 스레드 내부의 싱글톤을 사용하기 위해 사용한다. 주로 사용자 인증, 세션 정보, 트랜잭션 컨텍스트에 사용한다.

스레드 풀 환경에서 ThreadLocal 을 사용하는 경우 ThreadLocal 변수에 보관된 데이터의 사용이 끝나면 반드시 해당 데이터를 삭제해 주어야 한다. 그렇지 않을 경우 재사용되는 쓰레드가 올바르지 않은 데이터를 참조할 수 있다.

*ThreadLocal 을 사용하는 방법은 간단하다.*

1. ThreadLocal 객체를 생성한다.

2. ThreadLocal.set() 메서드를 이용해서 현재 스레드의 로컬 변수에 값을 저장한다.

3. ThreadLocal.get() 메서드를 이용해서 현재 스레드의 로컬 변수 값을 읽어온다.

4. ThreadLocal.remove() 메서드를 이용해서 현재 스레드의 로컬 변수 값을 삭제한다.

   

## Java의 접근 제어자

**public** : 접근 제한이 없다.

**protected :** 클래스가 정의되어 있는 해당 패키지 내 그리고 해당 클래스를 상속받은 외부 패키지의 클래스에서 접근이 가능

**default :** 아무런 접근 제한자를 명시하지 않으면 default 값이 되며, 동일한 패키지 내에서만 접근이 가능

**private :** 자기 자신, 클래스 내부에서만 접근이 가능



## String, StringBuilder, StringBuffer

- ### String

String 클래스는 Immutable(불변) 객체이기 때문에 + 등 concat 연산 시 원본을 변경하지 않고 새로운 String 인스턴스를 생성해야 하는 단점이 존재한다. 

  String 객체는 한번 생성되면 할당된 메모리 공간이 변하지 않는다. + 연산 또는 concat 메서드를 통해 기존에 생성된 String 클래스 객체 문자열에 다른 문자열을 붙여도 기존 문자열에 새로운 문자열을 붙이는 것이 아니라,  새로운 String 객체를 만든 후, 새 String 객체에 연결된 문자열을 저장하고, 그 객체를 참조하도록 한다. (즉, String 클래스 객체는 Heap 메모리 영역(가비지 컬렉션이 동작하는 영역)에 생성. 한번 생성된 객체의 내부 내용을 변화시킬 수 없다. 기존 객체가 제거되면 Java의 가비지 컬렉션이 회수합니다.)

때문에 연산이 많을 경우 성능이 좋지 않다.

하지만 Immutable한 객체는 간단하게 사용 가능하고, 동기화에 대해 신경쓰지 않아도 되기 때문에(thread-safe) 내부 데이터를 자유롭게 공유 가능하다.



- ### StringBuilder , StringBuffer

문자열 연산 등으로 기존 객체의 공간이 부족하게 되는 경우, 기존의 버퍼 크기를 늘리며 유연하게 동작한다. StringBuffer와 StringBuilder 클래스가 제공하는 메서드는 서로 동일.

- **그럼 두 클래스의 차이점은 무엇일까요? 바로 동기화 여부입니다.**

  \- **StringBuffer**는 각 메서드별로 Synchronized Keyword가 존재하여, 멀티스레드 환경에서도 동기화를 지원.

  \- 반면, **StringBuilder**는 동기화를 보장하지 않음.

  

  그렇기때문에 **멀티스레드 환경**이라면 값 동기화 보장을 위해 **StringBuffer**를 사용

  **단일스레드 환경**이라면 **StringBuilder**를 사용하는 것이 좋습니다. 단일 스레드환경에서 StringBuffer를 사용한다고 문제가 되는 것은 아니지만, 동기화 관련 처리로 인해 StringBuilder에 비해 성능이 좋지 않다.

**String은 짧은 문자열을 더할 경우 사용.**

**StringBuffer는 스레드에 안전한 프로그램이 필요할 때나, 개발 중인 시스템의 부분이 스레드에 안전한지 모를 경우 사용다.**

**StringBuilder는 스레드에 안전한지 여부가 전혀 관계 없는 프로그램을 개발할 때 사용.**



## Comparable, Comparator

정렬을 위해서 사용하는 인터페이스들인데 

**Comparable** 인터페이스는 정렬 기준을 설정할 클래스가 직접 상속해 compareTo 메소드를 오버라이딩 해야 하며, 

**Comparator**는 직접 구현해서 Arrays.sort 같은 정렬 메소드에 인자로 넘겨 정렬 기준을 직접 설정해 줄 수 있다.

> Comparable

```java
public class Example implements Comparable<Example> { 
    private int age;    
    @Override    
    public int compareTo(Example o) {
        return this.age - o.age;    
    }
}
```

> Comparator

```java
Integer a[] = {1, 5, 6, 8, 9};
Arrays.sort(a, (a1, a2) -> a2 - a1); //FunctionalInterface로 Comparator 구현
```

기본 sort는 오름차순이지만, 위처럼 Comparator를 구현해서 파라미터로 넘겨주면 내림차순으로 정렬이 가능.





## Abstract Class, Interface 차이점

추상 클래스는 상속을 통해 부모 클래스의 기능을 이용, 확장하기 위해 제공되며 다중 상속이 불가능하다.

인터페이스는 빈 껍데기 형태로 구현할 메소드를 정의하고, 강제해서 서브클래스들에 같은 동작을 보장하기 위해 제공되며 다중 상속이 가능하다. 자바 8 부터 인터페이스에도 default 메소드 구현이 가능하다.

> Abstract Class

abstract 키워드가 붙거나 클래스 내 추상 메소드가 하나 이상 포함되는 클래스

만약 추상 클래스를 상속한다면, 추상 클래스에 존재하는 추상 메소드를 반드시 구현해주어야 하며 `extends`키워드를 사용한다.

```java
public abstract class Greeting {    
    public String defaultGreeting() {        
        return "hello";    
    }
}
public abstract class Greeting {    
    public void hi() {        
        System.out.println("hi");    
    }    
    public abstract String defaultGreeting();
}//아래 greeting 메소드를 구현 안 해주면 에러가 발생
public class AmericanGreeting extends Greeting {    
    @Override    
    public String greeting() {        
        return "american hello";    
    }
}
```

> Interface

추상 메소드만을 가지며, 메소드의 껍데기만 존재한다. 서브클래스는 무조건 모든 메소드들을 구현해야하며 `implements` 키워드를 사용한다.

```java
public interface Greeting {    
    String hello();    
    String bye();
}
public class KoreanGreeting implements Greeting {    
    @Override    
    public String hello() {        
        return null;    
    }    
    @Override    
    public String bye() { 
        return null;    
    }
}
```



# Spring Framework

자바플랫폼을 위한 오픈소스 애플리케이션 프레임워크.

자바 SE 로 된 자바객체 POJO를 자바 EE에 의존적이지 않게 연결해주는 역할.

크기와 부하 측면에서 경량시킨 것, IOC 기술로 애플리케이션의 느슨한 결합을 도모시킨것.

##### MVC패턴

코드의 재사용에 유용, 사용자 인터페이스와 응용프로그램 개발에 소요되는 시간을 줄여주는 효과적인 설계 방식.

Model, View, Controller로 구성.

Mode : 핵심적인 비즈니스 로직을 담당, 데이터베이스를 관리하는 부분

View : 사용자에게 보여주는 화면

Controller : 모델과 뷰 사이에서 정보를 교환할 수 있도록 연결시켜주는 역할



① **경량 컨테이너**(크기와 부하의 측면)로서 자바 객체를 직접 관리

 \- 각각의 객체 생성, 소멸과 같은 라이프 사이클을 관리하며 스프링으로부터 필요한 객체를 얻어올 수 있다.

 

② **제어 역행**(**IoC** : Inversion of Control)

 \- 애플리케이션의 느슨한 결합을 도모.

 \- 컨트롤의 제어권이 사용자가 아니라 프레임워크에 있어 필요에 따라 스프링에서 사용자의 코드를 호출한다.

 

③ **의존성 주입**(**DI** : Dependency Injection)

 \- 각각의 계층이나 서비스들 간에 의존성이 존재할 경우 프레임워크가 서로 연결시켜준다.



③ **관점지향 프로그래밍**(**AOP** : Aspect-Oriented Programming)

 \- 트랜잭션이나 로깅, 보안과 같이 여러 모듈에서 **공통적으로 사용하는 기능의 경우 해당 기능을 분리**하여 관리할 수 있다.



 \- AOP를 공부하려면 Filter, Interceptor, AOP를 비교하면서 공부하면 이해가 더 빠를 것이다.

   *http://goddaehee.tistory.com/154*



④ 애플리케이션 객체의 생명 주기와 설정을 포함하고 관리한다는 점에서 일종의 **"****컨테이너"**(Container)라고 할 수 있다.

 \- iBatis, myBatis나 Hibernate 등 완성도가 높은 데이터베이스처리 라이브러리와 연결할 수 있는 인터페이스를 제공한다.

 

⑤ **트랜잭션 관리** 프레임워크

 \- 추상화된 트랜잭션 관리를 지원하며 설정파일(xml, java, property 등)을 이용한 선언적인 방식 및 프로그래밍을 통한 방식을 모두 지원한다.



⑥ **모델-뷰-컨트롤러** 패턴

 \- 웹 프로그램밍 개발 시 거의 표준적인 방식인 **"Spring MVC"**라 불리는 모델-뷰-컨트롤러(MVC) 패턴을 사용한다. 

 \-  DispatcherServlet이 Controller 역할을 담당하여 각종 요청을 적절한 서비스에 분산시켜주며 이를 각 서비스들이 처리를 하여 결과를 생성하고 그 결과는 다양한 형식의 View 서비스들로 화면에 표시될 수 있다.



⑦ 배치 프레임워크

 \- 스프링은 특정 시간대에 실행하거나 대용량의 자료를 처리하는데 쓰이는 일괄 처리(Batch Processing)을 지원하는 배치 프레임워크를 제공한다. 기본적으로 스프링 배치는 Quartz 기반으로 동작한다.



⑧ **즉 공통 부분의 소스 코딩이 용이하며 확장성도 매우 높다.**



https://goddaehee.tistory.com/156

##### AOP

관점 지향 프로그래밍.

기존 OOP 에서 기능별로 클래스를 분리 했음에도 불구, 여전히 로그나 트랜잭션, 자원해제, 성능테스트 메서트처럼 공통적으로 반복되는 중복코드를 해결할수 있도록. 

개발코드에서는 비즈니스 로직에 집중, 실행 시 비즈니스 로직의 앞과 뒤에서 원하는 지점에 해당 공통 관심사를 수행할 수 있게 하면서, 중복코드를 줄일 수 있는 방식.

##### DI

의존성 주입.

객체들 간의 의존성을 줄이기 위해 사용되는 스프링의 IOC 컨테이너의 구체적 구현 방식.

개발코드부분에서 객체를 생성하는 것이 아니라, 데이터 주입만 담당하는 별도의 공간에서 객체를 생성, 데이터 간의 의존성을 주입해 개발코드에서 가져다 쓰면서 의존성을 줄이는 방식.

##### IOC

인스턴스의 생성부터 소멸까지 개발자 대신 관리해주는 컨테이너.

인스턴스 생성의 제어를 서블릿과 같은 bean을 관리해주는 컨테이너가 관리.







## Spring 구동 방식

스프링에 들어온 요청을 스프링이 어떻게 처리해줄까.

## 요청에 따른 응답

우선 필터를 거치고, DispatcherServlet에서 스프링에 들어온 모든 요청을 받게 된다. DispatcherServlet에서 클라이언트의 요청에 해당하는 컨트롤러를 탐색한다. `@RestController` 나 `@Controller`로 매핑된 컨트롤러들의 하위에 있는 `@GetMapping, @PostMapping ...` 등이 스캔의 대상이 된다. 적절한 컨트롤러를 찾은 뒤에는 `HttpServletRequest` 를 전달해 준 뒤 ViewResolver가 `ModelAndView` 를 리턴해주며 이때 `@ResponseBody`나 `@RestController`가 붙은 경우에는 MessageConverter가 HTTP Body에 적절한 내용을 기록해서 응답을 하게 된다.

## Bean 생성 원리

스프링 부트에서는 `@SpringBootApplication` 어노테이션을 SpringBootApplication.run을 하는 메인 메소드가 있는 클래스 위에 붙이면 그 하위 패키지를 스캔한다. `@SpringBootApplication` 의 내부를 보면 `@ComponentScan, @SpringBootConfiguration, @EnableAutoConfiguration` 등의 어노테이션이 붙어있고 `@ComponentScan` 을 통해서 메인 메소드가 있는 클래스의 하위 패키지를 스캔하게 된다.

메인 메소드가 있는 클래스 하위의 `@Bean, @Service, @Component, @Repo, @Controller...` 등의 어노테이션이 붙은 클래스들을 빈 형태로 만들어서 빈 팩토리에서 관리하게 된다. 그리고 빈을 생성할 때 해당 빈 내부에 다른 주입이 필요한 빈이 있다면, 재귀적으로 하위에 있는 빈들을 처리하고 나서 빈을 생성후 관리하게 된다.