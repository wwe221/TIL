## Shell script programming

셸 스크립트

이를 이용해서 실행파일을 만들 수 있다.

###### 기본 틀

```shell
#!/bin/sh

exit 0
```

변수의 기본

- 변수의 선언은 하지 않으며, 값이 할당되면 변수가 생성된다.
- 모든 값은 문자열로 취급한다.
- 대소문자를 구분한다.
- 변수를 대입할 때 '=' 좌우에는 공백이 없어야 한다.

입력과 출력

```shell
read v1
echo $v1
```

###### 계산

```shell
n1=100
n2=`expr \( $n1 + 200 \n) \* 2`
```

###### parameter

```shell
echo $0
#프로그램 이름
echo $1
##첫번쨰 파라먼트
echo $2
```

ex) 

```shell
#!/bin/sh
find $1 -name "*.$2" -exec cp {} $3 \;
exit 0
```

###### 비교 연산자

| a > b   | a >= b  | a < c   | a <= c  | a = b   | a != b  |
| ------- | ------- | ------- | ------- | ------- | :------ |
| a -gt b | a -ge b | a -lt c | a -le c | a -eq b | a -ne b |

###### 파일 조건

```shell
-d filename	파일이 디렉토리면
-e filename	파일이 존재하면
-f filename	파일이 일반파일이면
-g filename set-group-id 가 설정되면
-r filename 읽기 가능이면
-s filename 크기가 0이 아니면
-u filename set-user-id 가 설정되면
-w filename 쓰기 가능 상태면
-x filename 실행 가능 상태면
```

###### case~esac 문

```shell
case "$1" in
	s | START | st | start)
    	echo "Start Tomcat"
    	$TOMCAT_HOME/bin/startup.sh;;
    t | stop | STOP)
        echo "STop TomcaT"
        $TOMCAT_HOME/bin/shutdown.sh;;
 	check)
        echo" Check TomcaT"
    	ps -ef | grep tomcat
esac

```

###### 반복문

 for

```shell
for i in $(ls *.sh)
#ls *.sh  의 결과를 하나씩 받아온다.
#즉 디렉토리의 sh 파일의 이름을 하나씩 출력하게 된다.
do
	echo $i
done

```

while

```shell
while [ 1 ]
do
	read cmd
	if [ $cmd = 'stop']
	break
	fi
done
```

###### 함수 정의와 사용

```shell
myfunction(){
	ehco "this is function"
	return
}
myfunction
```

###### 함수의 파라미터

코드를 보기 전에는 몇개의 파라미터가 필요한지 전혀 알수가없다.

```shell
sum(){
	sum=`expr $1 + $2 `
	echo $sum
	return
}
a=$(sum 10 20)
#함수의 리턴값 전달은 echo를 통해 가능하다.

```

###### set 과 $(명령어)

명령어의 결과를 파라미터 처럼 저장한다.

```shell
set $(date)
echo $5
#date 명령어 결과의 다섯번째 문자를 출력하라.
```

