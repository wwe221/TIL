##### Network Setting

/etc/sysconfig/network-scripts/

IPADDR=70.12.114.206

NETMASK=255.255.255.0

GATEWAY=70.12.114.1

DNS1=168.126.63.1

##### yum repository setting

cd /etc/yum.repo.d/

wget  http://download.hanbit.co.kr/centos/7/CentOS-Base.repo

rm *.repo~

yum clean all

##### 보안 기능 off

vi /etc/sysconfig/selinux

SELINUX = disabled

##### envset.sh 실행

###### jdk , eclipse , tomcat 설치 , firewall 세팅

##### /etc/profile 설정

TOMCAT_HOME=/root/file/apache-tomcat-9.0.22
export TOMCAT_HOME
JAVA_HOME=/etc/jdk1.8
export JAVA_HOME
CLASSPATH=$JAVA_HOME/lib
export CLASSPATH
PATH=.:$JAVA_HOME/bin:$PATH
export PATH USER LOGNAME MAIL HOSTNAME HISTSIZE HISTCONTROL