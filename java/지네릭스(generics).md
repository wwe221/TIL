## Generics

다양한 타입의 객체들을 다루는 메소드나 컬렉션 클래스에 컴파일시 자동으로 타입체크를 하주는 기능이다. 객체의 타입 안전성을 높이고, 형 변환의 번거러움을 줄일 수 있다.

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



## Collection API

###### 	set

​		중복 허용 X , 순서 고려 X ( 입력한 순서 유지 X)

###### 	List

​		중복 허용 O , 순서 O, (속도느림)

###### 	HashMap

​		<Key , Value> 로 구분, Key는 중복 X

##### CRUD

Create - insert

Read - select(key)  ,   ?  select()

// 가상으로 객체만들어 전달.

Update -update

Delete -delete



## Catch Exception

```java
try{
    dao.insert(v);
} catch (Exception e) {
    throw e;    
}finally{
    transactionEnd();
}
```

insert() 함수가 Exception 을 가지고 온다면, 이 함수도 Exception 을 throw 하고,

insert가 정상작동 했던 아니던 finally 안의 transcantionEnd를 실행한다.