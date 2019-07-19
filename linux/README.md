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

gedit ifcfg-enc33

수정

BOOTPROTO="none"   

추가

IPADDR=192.168.111.100  

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

192.168.111.101  server1 



###### 보안 기능을 끄자

gedit /etc/sysconfig/selinux

수정

SELINUX = disabled



windows 에서 ip setting

