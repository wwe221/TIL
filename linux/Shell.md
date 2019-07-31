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

계산

```shell
n1=100
n2=`expr \( $n1 + 200 \n) \* 2`
```

parameter

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

비교 연산자

| a > b   | a >= b  | a < c   | a <= c  | a = b   | a != b  |
| ------- | ------- | ------- | ------- | ------- | :------ |
| a -gt b | a -ge b | a -lt c | a -le c | a -eq b | a -ne b |

