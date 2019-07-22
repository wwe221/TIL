# 리눅스

기존의 유닉스 운영체제의 비용이 비싸서 이를 본따 만든 것이 Linux다

현재의 window 나 MacOs , android 등의 기반이 되는 OS다.

빅데이터 환경 구축을 위해 사용된다.



#### 환경구축 

Virtual Machine 가상머신

실제 컴퓨터와 똑같이 HW 와 OS를 모두 갖고 있는 가상의 컴퓨터를 만들어

기존의 Windows OS 에서 개발 환경을 구축할 수 있다.

###### 

swap memory

memory 가 부족할때, harddisk 를 memory로 사용하겠다



가상머신안에서 생성된 n개의 컴퓨터(서버) 끼리 통신이 가능하다.

DHCP(동적 호스트 구성 프로토콜) - ip 를 동적으로 할당되는 것. 자동으로 ip 를 지정한다.



###### ip주소 할당하기

가상 머신의 컴퓨터에 ip주소를 원하는 값으로 세팅할 수 있다.

가상의 ip 이기 때문에 외부에서의 접근이 불가능 하다.

교재 p68

cmd >    rundll32 "C:\Program Files (x86)\VMware\VMware Player\vmnetui.dll" VMNetUI_ShowStandalone 

subnet IP 에 값 세팅

호스트 OS : ~.~.~.1

게이트웨이, DNS서버 : ~.~.~.2

DHCP 서버역할 : ~.~.~.254



00:50:56:2C:B3:98



###### 업데이트 끄기, 알람 끄기,

cd /etc/yum. repos. d/

gedit CentOS-Base. repo 

gedit CentOS-Sources. repo 에서 release update를 지워준다.

mv CentOS-Base.repo CentOS-Base.repo.bak

wget http://download.hanbit.co.kr/centos/7/CentOS-Base.repo

rm *.repo~

yum clean all





###### ip 주소 설정

cd /etc/sysconfig/network-scripts/

ls

gedit ifcfg-ens33

수정

BOOTPROTO="none"   

추가

IPADDR=192.168.111.101

- 이컴퓨터의 ip 어드레스 세팅

NETMASK=255.255.255.0

- 0번 부터 255번 까지 할당

GATEWAY=192.168.111.2

DNS1=192.168.111.2

- GATEWAY 와 DNS 의 ip 주소

저장.

systemctl restart network



###### hostname 과 ip를 매칭

gedit /etc/hosts

추가

192.168.111.111 server1 



###### 보안 기능을 끄자

gedit /etc/sysconfig/selinux

수정

SELINUX = disabled



windows 에서 ip setting



### 명령어

###### 종료명령

```
poweroff
shutdown -P +10 // 10분 뒤 종료
shutdown -c //명령 취소
su root // 사용자 변경 root로
su - centos // 사용자의 폴더로 이동하면서 유저 변경
exit //사용자 변경을 로그아웃한다.


```

###### 기본 명령어

```
cat documentName // 문서의 내용을 출력
more documentName // 문서의 내용을 조금씩 출력
head //파일의 위쪽만 출력
tail // 뒤쪽만 출력
file // 파일의 종류를 알려준다.
touch filename // 파일 생성
cp // copy
rm //삭제
rm -i //삭제 확인 yes/no
rm -r //디렉토리 삭제
rm -rf // 디렉토리 내의 파일 한번에 삭제
mkdir -p dir2/subdir // 상위 폴더 까지 함께 만든다
```

###### 사용자

```
useradd user1 //만들기
passwd user1 //비번 설정
userdel user2 //삭제
grupadd newgroup //그룹 만들기
useradd -g newgroup user2 // 사용자 그룹 지정 생성
```

/etc/skel

새로운 계정 생성시에 자동으로 갖게 될 파일들

###### 권한

ls -l 출력시

파일유형 소유자/그룹/Other 링크된파일수 유저 그룹 크기  순으로 나타난다.

파일유형

- d directory
- `-`일반파일
- b 블록디바이스
- c 문자 디바이스
- l 링크 , 바로가기

r - 읽기

w -쓰기

x - 접근

접근권한 변경

```
chmod 644 filename // file 접근 권한을 644로 변경한다.
chown muser1.musers musersfile
// musersfile 의 소유권을 muser1에게,  그룹을 musers 로 변경한다
chgrp musers filename
```



###### vi 명령어

```
:q // 종료
:q! // 강제종료
:w // 저장
:d // 해당 라인 삭제
yy // 해당 라인 복사
x // 커서의 글자 잘자내기
p // 붙여넣기
o // 한줄 띄워 아래에 입력
shift + o // 한줄 띄워 위에 입력
s // 커서에 해당하는 글자 지우고 입력모드
shift + s // 
cw // 단어 삭제
^ // home
$ // end
dd // 한줄 잘라내기
3dd // 3줄 잘라내기

/text  // 문서 내에서 text 찾기 b 이전, n 다음
:%/text/change // 모든 text를 change 로 바꾼다.
h j k l //화살표 키 대신에 사용 가능, 좌 하 상 우
i //insert 커서 왼쪽에 입력
a //append 커서 오른쪽에 입력
shift + i // 커서 라인 제일 앞에 입력
shift + a // 커서 라인 제일 뒤에 입력

:set nu // 라인 넘버 표시
:30 //30번째 라인으로 이동
gg // 가장 윗 행
shift + g // 가장 아래 행


```

vi 작업시 터미널이 강제종료되면, ~.swp 파일이 생성된다.

```
vim -r filename  으로 원복, 그래도 메세지가 뜬다면
rm ~.swp 으로 swp 파일 지워준다.
```





###### cd/dvd rom 연결확인하기 

```
mount
```

........

/dev/sr0 on /run/media/root/CentOS 7 x86_64 type iso9660 

/dev/sr0 (cdrom) 이 /run/media/~~ 에 있다.

```
umount /dev/cdrom 
--cdrom 연결 해제--
```



```
mount /dev/cdrom /mycdrom
--/mycdrom 으로 mount --
```





