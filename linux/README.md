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

### Shell

HardWare > 커널 > Shell > OS

사용자가 입력한 명열을 해석해 커널에게 전달, 커널의 처리 결과를 사용자에게 전달하는 역할

linux 에서는 bash shell 을 널리 쓴다.

#### Shell 명령어

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
u // undo

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

##### 권한

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

x - 실행

접근권한 변경

```
chmod 644 filename // file 접근 권한을 644로 변경한다.
chown muser1.musers musersfile
// musersfile 의 소유권을 muser1에게,  그룹을 musers 로 변경한다
chgrp musers filename // 소유 그룹을 변경한다
```



##### PATH 설정 

~/.bashrc

```
PATH=.:$PATH // 현재디렉토리 . 를 path로 추가
export PATH


```

###### 링크

Hard Link - 원본파일과 동일한 형태로, inode블록을 원본파일과 동일하게 가지게 된다.

Symbolic Link (soft link) - 일반적인 바로가기, 원본 파일에 연결을 해주는 역할, 원본파일의 inode를 가리키기만 한다.



`inode - 모든 파일/디렉토리가 하나씩 갖고 있는 데이터, 파일의 소유권, 허가권, 파일종류, 실제데이터의 위치(주소) 등을 담고 있다.`

```
ln originfile hardlink // 하드링크 생성
ln -s ogfile symbolicLink // 심볼릭 링크 생성
```

원본 파일에 손상이 가더라도 하드링크 파일은 원본 그대로의 형태를 보존하고 있지만 심볼릭링크는 갈곳을 잃게된다.



###### RPM

프로그램 설치를 위한 redhat package manager, Redhat 사에서 만든 설치파일 종류

rpm -Uvh installfile.rpm

프로그램 설치에 의존성 문제가 있다. 

이를 해결한 것이 yum이다

###### yum

yellowdog updater modified

rpm과 별도라기 보다 rpm패키지 설치를 돕는 도구.

인터넷을 통해 해당 파일과 의존성이 있는 다른 rpm 파일을 모두 다운받고 자동으로 설치한다.

인터넷이 연결되어 있어야만 한다.

yum -y install somehthing



###### java setting

```
tar xvf jdk~
```

/etc/profile

```
JAVA_HOME=/opt/jdk1.8;
export JAVA_HOME
CLASSPATH=$JAVA_HOME/lib;
export CLASSPATH JAVA_HOME
PATH=.:$JAVA_HOME/bin:$PATH;
export PATH

```

firewall-config 방화벽 설정 열기

http port 열기

###### tomcat -apache setting

conf/server.xml 

​	line 69 - Connector port 80으로 변경

bin/startup.sh



###### 파일압축

xz

xz -d

###### 파일묶기

tar

- c - 새로운 묶음 만들기
- x - 묶인 파일을 푼다
- t -묶음을 풀기 전에 경로를 보여준다.
- f - 묶음 파일의 이름을 지정한다. 
- J : xz , z : gzip , j : bzip2

```
tar cvfz atest.tar2.gz atest
// atest 폴더를 묶고, gzip으로 압축하겠다.
tar xvfz atest.tar2.gz
// gz 파일의 압축을 풀고 묶음을 풀겠다.
```

###### 파일 찾기 find

```
find /tec -name *.conf
find ~ -user user1
//소유자가 user1인 파일들을 찾아라.
find /usr/bin -perm 644
find /usr/bin -size +10k -size -100k
find ~ -size 0k -exec cp {} temp \;
//사이즈가 0인것들을 모두 찾아서 temp로 copty 해라
// find 의 결과가 {} 안에 순서대로 들어가 작동하게 된다.
```

```
which java //PATH에 설정된 디렉토리 검색
whereis java //실행파일 ,소스 , man 페이지 파일까지 검색
locate java // 파일목록 데이터베이스에서 검색
```

firewall-config // 방화벽 설정 ui 를 연다

//포트 설정 등 을 할 수 있다.

###### OracleDB 설치

www.oracle.co.kr/

oracle database 11g express edition -

oracle database express edition 11grelease 2 for linux x64

oracle-xe-11.2.0-1.0.x86_64.rmp.zip 다운로드.

```
unzip oracle*
dd if=/swapfile of=/swapfile bs=1024 count=4194304
mkswap /swapfile
swapon /swapfile
swapon -s
cd /etc/rc.d/
chmod 755 rc.local
vi rc.local   
//설정 저장하기 위해 마지막라인에 swapon /swapfile 추가
cd /download/Disk1
yum -y localinstall oracle*
service oracle-xe configure
// 오라클 서버 기본 설정 default는 엔터로 넘기기
service oracle-xe start
//오라클 실행
. /u01/app/oracle/product/11.2.0/xe/bin/oracle_env.sh
//오라클 환경설정 스크립트 실행
vi /etc/bashrc
//마지막 줄에 . /u01/app/oracle/product/11.2.0/xe/bin/oracle_env.sh 추가
설정 지속적용
firewall-config 로 포트 8080, 1521을 열어 준다.
127.0.0.1:8080/apex 로 접속 하여 세팅가능하다.
```

###### MariaDB 설치

```mysql

```

###### 하드디스크 추가

```
ls -l /dev/sd*
fdisk /dev/sdc
:n      new
:p      primary
:1      no.1
:
mkfs.ext4 /dev/sdc1
//ext4 형식으로 포맷을 한다.
생성된 저장소를 mount 해줘야 사용이 가능하다.
mount /dev/sdc1 /mydisk1
//이 설정을 저장하기 위해서 /etc/fstab 에 설정을 추가한다.
#/etc/fstab/
/dev/sdc1	/mydisk1	ext4	defaults	1	2

```

##### RAID

`R`edundant `A`rray of `I`nexpensive/Independent `D`isks

여러개의 하드디스크를 하나의 하드디스크처럼 사용하는 방식

비용절감, 신뢰성 향상, 성능까지 향상

하드웨어 Raid 는 안정적이지만 굉장한 고가이기 때문에 이를 대안하기 위해 소프트웨어 Raid가 가능하다.

Linear Raid -  다수의 하드디스크를 하나의 볼륨으로 사용한다. 앞 하드디스크에 데이터가 완전히 저장되지 않는다면 다음 하드디스크는 전혀 사용되지 않는다.

Raid0 -  하드디스크를 동시에 사용한다. 성능은 빠르지만 하나의 하드디스크가 손상되면 쓸모없는 데이터가 된다. 데이터를 다수의 디스크에 나눠서 저장한다.

Raid1 - Mirroring .한곳의 데이터의 거울을 만들어 놓는다. 하나의 디스크가 고장나도 데이터는 손상되지 않는다. `결함허용 Fault-tolerance`

Raid5 -  Raid0 의 속도와 Raid1의 안전성을 합친 것 Parity 를 사용하여 하나의 하드디스크가 고장나더라도 그 내용을 예측하여 복구가능하다. 하지만 2개가 손상된다면 불가능하다.

Raid6 - 

VMware 에서 해보기

```
#각각의 Disf fdisk 의 형식 fd로 만들기
fdisk /dev/sdb
:t
:fd
mdadm --create /dev/md5 --level=5 --raid-devices=3 /dev/sdb1 /dev/sdc1 /dev/sdd1
#sdb1 , sdc1 디스크를 /dev/md9 로 묶기
mkfs.ext4 /dev/md5
# 포맷
mount /dev/md5 /raid5
#마운트
#/etc/fstab 에 설정 저장
/dev/md5	/raid5	ext4	default 1 2
```

만약 raid5 의 3개 디스크 sdb1, sdc1, sdd1 중 하나가 손상이 된다면, Emergency-mode 로 실행이 되고, 데이터 복구를 위해서

```

mdadm --run /dev/md5 
#를 통해 복구할 수 있다.
mdadm /dev/md5 --add /dev/sdf1
#을 통해 손상된 하드디스크 하나를 교체시켜 raid를 유지할 수 있다.
```

##### LVM

Logical Volume Manager 논리 하드디스크 관리자

Raid와 비슷하지만 더 많은 기능이 있다.

주요 용도는 여러개의 하드디스크를 합쳐 하나의 파티션으로 구성한후 필요에 따라서 원하는 크기별로 나누어 사용할 수 있다. 또는 하나의 하드디스크로 파티션을 구분 할 수도 있다.

- Physical Volume :  물리적 파티션 /dev/sda1
- Volume Groupe : 물리 볼륨을 합쳐 만든 1개의 물리 그룹
- Logical Volume : 볼륨그룹을 1개이상으로 나눈 것

```
#일단 fdisk를 이용해 파티션 분할을 한뒤,
:t
Hex Code : 8e
#를 입력하여 LVM 파일시스템으로 선언한다.
$
pvcreate /dev/sdc1
pvcreate /dev/sdd1
#물리적 볼륨을 생성하고
vgcreate myVG /dev/sdc1 /dev/sdd1
#하나의 볼륩그룹을 생성한다.
vgdisplay
#생성한 볼륨의 상태를 확인할 수 있다.

lvcreate --size 1G --name myLG1 myVG
#myVG 의 1G 짜리 파티션을 만든다.
lvcreate --extends 100%FREE --name myLG2 myVG
#myVG 의 남은 용량을 가진 파티션을 만든다.
mkfs.ext4 /dev/myVG/myLG1
mount /dev/myVG/myLG1 /lvm1
#일반적인 하드디스크 파티션과 동일하게 포맷과 마운트를 해준다


```

#### scp

 secure copy (remote file copy program)

`ssh`이용 네트워크로 연결된 호스트간에 파일을 주고 받는 명령어

`로컬 -> 리모트 (보내기)`, `리모트 -> 로컬 (가져오기)`

`리모트 -> 리모트 (다른 호스트끼리 전송)` 로 복사 가능

`ssh`를 이용하기 때문에 password를 입력하거나 ssh 키파일과 같은 identity file을 이용해 파일 송수신 가능

보내기

```
##파일 보내기
scp 파일 계정@서버주소:목적경로
##디렉토리 보내기
scp -r 디렉토리 계정@서버주소:목적경로
## scp -r 무엇을 어디로
scp -r /root/file root@192.168.111.115:/root/file

```

가져오기

```
##기본 포트 사용
scp 계정@서버주소:원본경로 목적파일명
##다른 포트 사용
scp -P 포트 계정@서버주소:원본경로 목적파일명
##폴더 복사
scp -r 계정@서버주소:원본경로 목적상위폴더
## scp -r 무엇을 어디로
scp -r root@192.168.111.115:/root/file /root/file

```

###### 원시리눅스

방화벽 설정

```
systemctl status firewalld
## CentOS 에서는 iptables 대산 firewalld를 사용한다.
firewall-cmd --zone=public --add-port=1521/tcp
##1521 포트를 연다.
firewall-cmd --zone=public --remove-port=1521/tcp
##1521 포트 차단
firewall-cmt --permanet --add-service=http
firewall-cmt --permanet --add-service=https
firewall-cmt --permanet --add-port=1521/tcp
##영구적으로 설정 저장. service 지정해서 열기

```

###### 브릿지 

Host PC 외의 pc 과 가상머신의 연결을 위해서는 브릿지 설정이 필요하다.

<details markdown="1">
<summary>접기/펼치기    설정하기   </summary>

![브릿지설정하기](bridge.jpg)

</details>



