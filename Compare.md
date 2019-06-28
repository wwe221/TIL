**Comparable** : 객체 간의 **일반적인 정렬**이 필요할 때, Comparable 인터페이스를 확장해서 정렬의 기준을 정의하는 compareTo() 메서드를 구현한다.

**Comparator** : 객체 간의 **특정한 정렬**이 필요할 때, Comparator 인터페이스를 확장해서 특정 기준을 정의하는 compare() 메서드를 구현한다.



  compareTo(Object o) 메서드를 구현하느냐 compare(Object o1, Object o2) 메서드를 구현하느냐



Comparable 은   오름차순, 내림차순등의 일반적인 순서를 잡는 기준이 필요할 때 사용한다.

Comparator 는   일반적이지 않은 문자열의 길이 순으로 보고 싶다든지, Comparable로 구현한 것 이외의 기준으로 정렬하고 싶다든지 할 때 사용한다.

모두 기본적으로는 리턴값이 -1 , 0 , 1 을 사용한다.

this 와 target 을 비교한다면,

-1 : this가 target 보다 먼저 온다.

0 : this 와 target이 같다.

1 : target 이 this 보다 먼저 온다.

따라서, 만약 this.CompareTo(Target) 을 했을 때, 오름차순을 원한다면,

```java
if(this >=Target)
    return 1;
```

을 해주면 된다는 것이다.

### 기본 사용법

##### Compareable

```java

```

##### Comparator

```java

```

