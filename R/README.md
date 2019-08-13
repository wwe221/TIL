# R

데이터 분석을 위한 통계 및 그래픽스를 지원하는 오픈 소프트웨어 환경이다. 컴퓨터 언어이자 다양한 패키지의 집합이고 이를 무료로 이용할 수 있다.

통계를 기반으로 한 데이터 분석.

자바언어와 연동이 수월하고 HIVE 환경에서 사용가능 하다.

###### 설치

[r-project.org](r-project.org)

[RStudio](https://www.rstudio.com/products/rstudio/download/#download)

- Java 의 Eclipse 와 같은 개발 툴

- Run - 원하는 라인을 실행
- Source - 모든 라인 실행

```R
# 변수에 값 지정
a <- 100;
b <- 200;

#파일 실행
source( 
  file  # 파일명
)

# 패키지 라이브러리 다운로드.
# R\R-3.6.1\library 에 풀리게 된다.
> install.packages("randomForest")

library(help="randomForest") # 설명 호출
```

#### 데이터 타입

###### 변수

변수 명은 알파벳 또는 . 로 시작해야 한다. 알파벳, 숫자, _ (언더스코어) , 마침표를 사용할 수 있다.

변수값 할당

```R
a <- c(1:10);
```

###### 스칼라

1 과 같은 단일 차원의 값을 뜻하는것. 

R에서의 데이터 타입의 기본은 벡터인데, 스칼라는 길이가 1인 벡터 이다.

###### NA

Not Available. 데이터 값이 없음을 나타낸다.

is.na(A) 로 변수의 값이 na인지 알 수 있다.

결측치 , 계산을 할때에 NA가 껴있다면 결과값을 구할수 없기 때문에 결과는 항상 NA가 된다. 

###### NULL

변수가 초기화 되지 않았을 때 사용.

프로그래밍의 편의를 위해 미정( undefined) 를 나타 낼 때 사용한다.

is.null(A) 로 확인가능.

##### 문자열

"hello" 로 사용 가능

###### TRUE & FALSE

TRUE , FALSE 로 boolean 과 같이 사용 가능

##### 팩터

Factor, 범주형 데이터를 표현하기 위한 데이터 타입이다.

데이터의 범주가 사전에 정해진 경우에 적절하다.

```R
data <- factor("m",c("m","f");
levels(data);
nlevels(data);
print(data[1]);
```

##### 벡터

배열의 개념. 한가지 데이터 타입만을 저장할 수 있다.

```R
#c()를 이용해 벡터를 생성 할 수 있다.
a<-c(1,3,5,);
b<-c(1:5);
c<-c(1,3,c(4:6));
#벡터의 column 이름을 지정해 줄 수 있다.
x<-c(100,90,80);
names (x) <- c("kim", "seo", "park")
print(x["kim"])
print(x[c("seo","park")]);
#벡터 변수를 함수의 인자로 넘기는게 가능하다.
print(sum(x));

v1 <-c(1:10);
# [-1] 을 하면 1번째 를 제외하고 처리한다.
print(v1[-1])
#원하는 구간만 처리 한다.
print(v1[5:7])
print(NROW(v1));
```

###### 벡터 연산 함수

```R
 identical(c(1, 2, 3), c(1, 2, 3)) # 두 벡터가 같은지
 "a" %in% c("a", "b", "c") #벡터가 해당 값을 가지고 있는지
 c(1, 2, 3) == c(1, 2, 100) #두 벡터 비교
union (c("a", "b", "c"), c("a", "d"))      # 합집합 
 intersect (c("a", "b", "c"), c("a", "d"))  # 교집합
 setdiff (c("a", "b", "c"), c("a", "d"))    # 차집합
setequal (c("a", "b", "c"), c("a", "b", "c", "c")) # 집합 간의 비교
```

###### Sequence

연속된 데이터를 처리하기 위해.

Repead

반복된 데이터를 처리

```R
a <-seq(1,10,3); #seq( 시작값, 끝값, 증가치)
b <- rep(1,times=5,each=3); #rep(반복할 값벡터, 전체 반복횟수 , 개별값의 반복횟수)
```

###### 리스트

(키, 값) 의 형태로 데이터를 담는 연관 배열이다

```R
a<-list(name=c("a","b","c"),score=c(90,70,50);
print(a$name[1]);
```

###### 행렬

matrix , 한가지 데이터타입을 갖는다.

```R
data <- c(1:9);
ma <- matrix(data,nrow=3,byrow = TRUE);
rownames(ma)<-c("r","r2","r3")
colnames(ma)<-c("c","c2","c3")
print(ma)
print(ma["r2","c2"])
ma2 <-ma[c(2:3),c(2:3)]
print(ma2)
print(mean(ma[2,]))
print(mean(ma[,3]))

```

#### 데이터프레임:star2:

다양한 데이터타입을 가질수 있다.

```R
df1 <-data.frame(x=c(1:5),y=c(6:10),z=c(11:15));
print(df1);
print(df1[2]);
print(df1[2,])
print(df1[,3])
print(df1$x[3])
print(df1["x"])
df2 <- df1[c(2:5),c(2:3)]
print(df2)


df1 <- data.frame(
  "lee" = c(90,99,70,54),
  "kim" = c(70,50,60,52),
  "park" = c(93,94,86,87),
  "cho" = c(87,99,100,94),
  "grade" = c("A","B","A","C")
)
print(df1)
each1 <-c(mean(df1$lee),mean(df1$kim),mean(df1$park),mean(df1$cho));
print(each1);
#each2 <-c(sum(df1[1]),sum(df1[2]),sum(df1[3]),sum(df1[4]));
#print(each2)

str(df1); #데이터프레임 내 값의 타입 출력
df1$hong<-c(100,100,100,100); #새로운 컬럼 추가


df1 <- data.frame(
  a = c(1:4),
  b = c(5:8),
  c = c(9:12),
  d = c("A", "B", "A", "A")
)
rownames(df1) <- c("aa", "bb", "cc", "dd")
print(df1)
df2 <- df1[, -4]
print(df2)
print(mean(df2$a))
print(df2[1, ])
print(class(df2[1, ]))
print(mean(as.numeric(df2[1, ]))) #원하는 라인만 계산

```

타입 판별

```R
class(x) #객체 x의 클래스
str(x)#객체 x의 내부 구조
is.factor(x)#주어진 객체 x가 팩터인가
is.numeric(x)#주어진 객체 x가 숫자를 저장한 벡터인가
is.character(x)#주어진 객체 x가 문자열을 저장한 벡터인가
is.matrix(x)#주어진 객체 x가 행렬인가
is.array(x)#주어진 객체 x가 배열인가
is.data.frame(x)#주어진 객체 x가 데이터 프레임인가
```

### R 프로그래밍

- 전체 데이터를 한번에 다루는 벡터 연산을 주로 사용한다.
- NA 결측치 기록 되지 않는 데이터를 표시하기 위해 사용 되는데 계산에 포함되게 되면 원하는 결과를 얻지 못할 수 있다.
- 객체의 불변성, 객체의 값을 수정할 수 없고 다만 새로운 객체를 생성된다.



```R
#for 문
for (i in 1:10) {
	print(i)
}
#while
while (i <= 10) {
	print(i)
    i <- i + 1
}
#사칙 연산
n %% m #n을 m으로 나눈 나머지
n %/% m #n을 m으로 나눈 몫
n^m #n의 m승
exp(n) #e의 n승
log(x, base=exp(1)) #logbase(x). 만약 base가 지정되지 않으면 loge(x)를 계산
log2(x), log10(x) #각각 log2(x), log10(x)를 계산
sin(x), cos(x), tan(x) #삼각 함수

d1 <- c(10,20,30,40,NA)
print(sum(d1,na.rm = TRUE))#NA를 삭제하고 계산해라~

```

###### 함수

```R
f1<-function(a){
  return(100+a) 
}
print(f1(10))

f2<-function(...){#가변 길이 인자 
  args<-(...);
  result<-0;
  for(i in args){
    if(i%%2==0){
      result=result+i;
    }
  }
  return(result);
}
print(f2(c(10:100))) 
```

```R
rm(list=ls()) #ls() 로 메모리에 올라가 있는 변수들을 모두 불러온후, rm()을 통해 제거한다.
print(list)
```



