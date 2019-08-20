# R

데이터 분석을 위한 통계 및 그래픽스를 지원하는 오픈 소프트웨어 환경이다. 컴퓨터 언어이자 다양한 패키지의 집합이고 이를 무료로 이용할 수 있다. 

오픈소스기 때문에 새로운 패키지가 날마다 생기지만 동시에 끊임없이 배워야한다.

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
- 객체의 불변성, 객체의 값을 수정할 수 없고 다만 새로운 객체를 생성한다.



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

###### 아이리스 데이터 셋

봋꽃의 3가지 종에 대해 정리한 데이터, 기본으로 내장되어 있는 데이터로 데이터 분석이나 기계 학습 관련 라이브러리에서 자주 사용되고 있다.

###### 파일 읽기

```R
user <- read.csv(
  "user.csv",          # 파일명
  header=FALSE,  # 파일의 첫 행을 헤더로 처리할 것인지 여부
  na.strings="NO", # 데이터에 결측치가 포함되어 있을 경우 R의 NA에 대응시킬 값을 지정한다.
  # 기본값은 "NA"로, "NO"로 저장된 문자열들은 R의 NA로 저장된다.
stringsAsFactors=default.stringsAsFactors()
  # 문자열을 팩터로 저장할지 또는 문자열로 저장할지 여부를 지정하는 데 사용한다. 별다른
  # 설정을 하지 않았다면 기본값은 보통 TRUE다.
print(user);
    
    
#excel 파일 열기
    install.packages("readxl")
    library(readxl)
    st <- read_excel("st.xlsx")
```

###### 파일 쓰기

```R
write.csv(
  user,              # 파일에 저장할 데이터 프레임 또는 행렬
  file="user01.csv",        # 데이터를 저장할 파일명
  row.names=FALSE,  # TRUE면 행 이름을 CSV 파일에 포함하여 저장한다.
  fileEncoding = "EUC-KR"
)
```

```R
user$NAME <-as.character(user$NAME) # Factor로 입력 되어있는 데이터를 string 으로 변환한다.
```

###### 객체의 파일 입출력 save, load

```R
v1 <-c(1:10)
save(v1,file="v1.dat") #v1 의 값을 저장하고
v1 <-c(100:120)
load("v1.dat") #저장했던 v1 객체를 불러온다
print(v1) # 따라서 결과는 1 부터 10의 값이 나온다.
```

###### 데이터프레임의 행과 컬럼 합치기

```R
x <- data.frame(id=c(1, 2), name=c("a", "b"),stringsAsFactors=F)
x$age <- c(20,25) #컬럼 추가
y <- rbind(x,c(3,"c",27)) #데이터프레임 x 에 row를 새로 추가한다. == y[4,]<- c(3,"c",27)
y <- cbind(y,level=c(1,2,3,4),addr=c("a","b","c","d"))# column 추가
print(y)
```





```R
student <-read.csv("student.csv",stringsAsFactors = FALSE)
print(student)
avg <-c(1:8)
avg2 <-c(1:ncol(student))
for (i in c(1:nrow(student))){
  avg[i] <-round(mean(as.numeric(student[i,c(3:6)])),1)
}
for(i in c(3:ncol(student2))){
  avg2[i] <-round(mean(student2[,i]),1)
}
avg2[1]<-"ID"
avg2[2]<-"AVG"
student2 <-cbind(student,avg)
student3 <-rbind(student2,avg2)
print(student2)
print(student3)



```

##### apply  계열 함수

벡터 , 행렬 , 데이터 프레임에 임의의 함수를 적용한 결과를 얻기 위한 함수들. 데이터 전체에 함수를 한번에 적용하는 벡터 연산을 수행하므로 속도가 빠르다.

| 함수      | 설명                                                         | 특징                                  |
| --------- | ------------------------------------------------------------ | ------------------------------------- |
| apply( )  | 배열 또는 행렬에 주어진 함수를 적용한 뒤 그 결과를 벡터, 배열 또는 리스트로 반환 | 배열 또는 행렬에 적용                 |
| lapply( ) | 벡터, 리스트 또는 표현식에 함수를 적용하여 그 결과를 리스트로 반환 | 결과가 리스트                         |
| sapply( ) | lapply와 유사하지만 결과를 벡터, 행렬 또는 배열로 반환       | 결과가 벡터, 행렬 또는 배열           |
| tapply( ) | 벡터에 있는 데이터를 특정 기준에 따라 그룹으로 묶은 뒤 각 그룹마다 주어진 함수를 적용하고 그 결과를 반환 | 데이터를 그룹으로 묶은 뒤 함수를 적용 |
| mapply( ) | sapply의 확장된 버전으로, 여러 개의 벡터 또는 리스트를 인자로 받아 함수에 각 데이터의 첫째 요소들을 적용한 결과, 둘째 요소들을 적용한 결과, 셋째 요소들을 적용한 결과 등을 반환 | 여러 데이터를 함수의 인자로 적용      |



```R
apply(
  X,       # 배열 또는 행렬
  MARGIN,  # 함수를 적용하는 방향. 1은 행 방향, 2는 열 방향
           # c(1, 2)는 행과 열 방향 모두를 의미
  FUNC      # 적용할 함수
)

st <-read.csv("student.csv",stringsAsFactors = FALSE)
print(apply(st[,c(3:6)], 2, mean))

print(colMeans(st[,c(3:6)]))
print(rowMeans(st[,c(3:6)]))

lapply()
sapply()
```

```R
tapply( # 그룹별로 함수를 적용 GROUP BY 와 비슷, #vector를 리턴한다.
  X,      # 벡터
  INDEX,  # 데이터를 그룹으로 묶을 색인. 팩터를 지정해야 하며 팩터가 아닌 타입이 지정되면
          # 팩터로 형 변환된다.
  FUN,    # 각 그룹마다 적용할 함수
  ...,    # 추가 인자. 이 인자들은 FUN에 전달된다.
)
```



##### 데이터 형태 변환

**1.** unlist( ) 리스트를 벡터로 변환

**2.** matrix( ) 벡터를 행렬로 변환

**3.** as.data.frame( ) 행렬을 데이터 프레임으로 변환한다.

**4.** names( ) 리스트로부터 변수명을 얻어와 데이터 프레임의 각 컬럼에 이름을 부여한다.



###### 데이터 정렬 

```R
sort(
  x,                 # 정렬할 벡터
  decreasing=FALSE,  # 내림차순 여부
  # na.last는 NA 값을 정렬한 결과의 어디에 둘 것인지를 제어한다. na.last=TRUE는 NA 값을
  # 정렬한 결과의 마지막에 두고, na.last=FALSE는 정렬한 값의 처음에 둔다.
  # 기본값인 na.last=NA는 NA 값을 정렬 결과에서 제외한다.
  na.last=NA
)

x <- c(20, 11, 33, 50, 47)
sort(x)

iris[order(iris$Sepal.Length, decreasing=TRUE), ]

#sort 는 vector 데이터, order 는 데이터프레임 을 다룬다.
```

그룹별 연산 aggregate

```R
aggregate( #데이터프레임을 리턴한다.
  x, # R 객체
  by, # 그룹으로 묶을 값의 리스트
  FUN # 그룹별로 요약치 계산에 사용할 함수
)
tag <-  aggregate(Sepal.Width ~ Species, iris, mean) #sepal.Width 를 Species 별로 처리 하겠다~

aggregate(data=st, avg~class , mean)
```



###### SQL문으로

```R
install.packages("sqldf")

library(sqldf)
iris
result <- sqldf('select Species,avg("Sepal.Length" ) from iris group by Species')
print(result)

```

```R
install.package("dplyr") #다양한 함수들을 가진 패키지
library(dplyr)
st<- rename(st, MA=MATH) #column 이름 변경
st %>% filter(CLASS==1)

```

조건에 따라 column 추가

```R
st$text <- ifelse(st$AVG>85 , "pass","fail")
#AVG 가 85 면 pass, 아니면 fail
```



연습

```R
cty<- aggregate(data=mpg,cty~class,mean)
cty<- cty[order(cty$cty, decreasing = T),]

#정렬
comp<-aggregate(data=mpg,hwy~manufacturer,mean)
comp<- comp[order(comp$hwy, decreasing = T),]
comp[c(1:3),]

#갯수 세기
comp2 <-  mpg[mpg$class=="compact",]
comp2<-as.data.frame(table(comp2$manufacturer))
comp2<-comp2[order(comp2$Freq,decreasing = T),]
```



데이터프레임 병합

```R
x <- data.frame(name=c("a", "b", "c"), math=c(1, 2, 3))
y <- data.frame(name=c("c", "b", "a"), english=c(4, 5, 6))
merge(x, y)
#

x <- data.frame(name=c("a", "b", "c"),math=c(1, 2, 3))
y <- data.frame(name=c("a", "b", "d"),english=c(4, 5, 6))
merge(x, y) #없는 데이터는 행을 삭제한 체로
merge(x, y, all=TRUE) # 없는 데이터는 NA로
```

ggplot 이용해 그래프 그리기

```R
ggplot(data=mpg,aes(x= displ, y = hwy)) + #배경 그리기
geom_point() +# 산점도 추가
xlim(3,6) + ylim(10,30) # 범위 제한 추가
```



##### 텍스트마이닝

```R
library(KoNLP)
library(dplyr)
library(stringr)
txt <- readLines("hiphop.txt") #타겟파일
txt2<-str_replace_all(txt,"\\W"," ") # 특수문자 제거
nouns <- extractNoun(txt2)
cnt<-table(unlist(nouns))
df_cnt <- as.data.frame(cnt,stringsAsFactors = F)
colnames(df_cnt) <- c("word","freq")
df_word<- filter(df_cnt,nchar(word)>=2)
df_word<-df_word[order(df_word$freq,decreasing = T),]
head(df_word,20)

library(wordcloud)
pal <- brewer.pal(8,"Dark2") #팔레트 생성
set.seed(4321) #난수 생성
wordcloud(words= df_word$word,
          freq= df_word$freq,
          min.freq = 2,
          max.words = 200,
          random.order=F,
          rot.per = .1,
          scale = c(4,0,3),
          colors= pal)


```

R Oracle 연동

```R
#1. RJDBC, rJava 두가지 패키지 인스톨
>install.packages("RJDBC")
>install.packages("DBI")
>install.packages("rJava")
>library(RJDBC)
>library(DBI)
>library(rJava)

#2. JDBC 드라이버 로딩 및 Connection 만들기
> drv=JDBC(driverClass="oracle.jdbc.driver.OracleDriver",classPath="c:\\ojdbc6.jar")
> conn=dbConnect(drv,"jdbc:oracle:thin:@127.0.0.1:1521:EX","db","db")

#3. 데이터 가지고 오기
> emp <- dbGetQuery(conn,"select * from emp") 

#4. Connection Close
> dbDisconnect(conn)
```



###### R Java와 연동

REngine.jar , RseveEngine.jar 가 필요하다.

```R
#R 에서의 listener 역할
> install.package("Rserve")
> Rserve::run.Rserve() # Rserve 리스너 실행

#remote 로 실행, run 은 Rstudio 에서 다른 작업을 하지 못하기 때문에
#이를 방지하기 위해 remote로 한다.
Rserve(args="--RS-enable-remote")
```

```java
RConnection rc = new RConnection();
		System.out.println("Connection OK");
		rc.eval("source('C:/rstudio/r4/r05.R', echo=TRUE)");
		// R 에서의 명령어 실행
		REXP rx = rc.eval("dd(3,24)");
		double result = rx.asDouble();	

		// R 에서의 return 값을 받아 와 타입 변환하기		
		System.out.println(result);

		// R 에서 return 하는 dataFrame 을 받아오기
		REXP rx2 = rc.eval("df()");
		RList rlist = rx2.asList();
		double years [] = rlist.at("YEAR").asDoubles();
		double qts [] = rlist.at("QT").asDoubles();
		rc.close();
	}

```

###### 한글 문제 해결

```java
RConnection rconn = null;
rconn = new RConnection();

rconn.setStringEncoding("utf8")

rconn.eval("source('C:/r/d1/jdbc.R',encoding='UTF-8')");
```



###### R Hive 연동

```R
rhive <- function(){
  library(RJDBC);
  library(DBI);
  library(rJava);
    
  #Hive 연동에 필요한 라이브러리의 경로 지정
  hive_lib <- 'c:\\lib';
  .jinit();
  .jaddClassPath(dir(hive_lib,full.names = T));
  .jclassPath();
  
  #라이브러리 지정 및 Connect
  drv=JDBC(driverClass='org.apache.hive.jdbc.HiveDriver','hive-jdbc-1.0.1.jar');  
  conn=dbConnect(drv,"jdbc:hive2://70.12.114.207:10000","root","111111");
  
  #쿼리 문을 통해 데이터 가져오기
  user=dbGetQuery(conn,"select hdi.country, hdi.hdi from hdi limit 10");
  dbDisconnect(conn);
  return (user);
}
```

