## 빅데이터

대량 ( 수십테라바이트 이상) 의 정형 / 비정형 데이터로 부터 가치를 추출하고 결과를 분석하는 기술.

스마트폰 대중화로 인해 이뤄진 다수의 사용자의 다양한 서비스 이용 에서 발생하는 수많은 데이터를 대상으로 다양한 종류의 대규모 데이터를 생성, 수집, 분석, 표현 현대 사회를 더욱 정확하게 예측, 효율적으로 작동케 하고 개인화된 현대 사회 구성원 마다 맞춤형 정보를 제공, 관리, 분석 을 가능하게 하는 기술.



### 빅데이터 3V 모델

Volume - 데이터 규모  테라바이트 ~ 페타바이트 급의 규모

Velocity - 데이터는 하루 단위에서 실시간에 이르기까지 상대적으로 짧은 시간 내에 수집, 저장, 처리 및 분석되어야 한다.

Variety - 다양한 소스 및 형식의 데이터를 포함 (웹 로그, 소셜 미디어 상호 작용, 전자 상거래 및 온라인 트랜잭션, 금융 트랜잭션 등).

`+` veracity(정확성) , variablilty(가변성) , visualizaition(시각화)

# Hadoop

간단한 프로그래밍 모델을 사용하여 여러대의 컴퓨터 클러스터에서 대규모 데이터 세트를 분산 처리 할 수있게 해주는 자바 기반의 오픈소스 프레임워크이다.

많은 양의 데이터를 저장하기 위한 상용 RDBMS의 하드웨어를 구축하기 위해서는 비용이 상당하지만,

하둡은 오픈소스 Free OS 인 Linux 를 이용하기 때문에 비용적인 부담이 없다.

트랜잭션처리나 무결성 보장에는 적합하지 않기 때문에 RDMBS와 함께 사용된다.

#### HDFS

Hadoop Distributed File System (하둡 분산 파일 시스템)에 데이터를 저장하고,

분산 처리 시스템인 맵리듀스를 이용해 데이터를 처리한다.







##### NoSQL

RDBMS , SQL 문을 사용하지 않는 데이터베이스 시스템 / 데이터저장소를 의미

단순히 키와 값의 쌍으로 이루어져 있고 익덱스와 데이터가 분리되어 별도로 운영된다.

조인이 없고 RDBMS 의 row 를 하나의 집합된 형태로 저장한다. 완벽한 무결성, 정합성을 제공하지않고 데이터를 보관하고 처리하는 경우에 주로 이용된다.

#### 하둡의 과제

고가용성 - High Availability

파일 네임스페이스 제한

데이터 수정 불가 

POSIX 명령어 미지원

전문 업체 부족 - 오라클 과 같은 상용DBMS 는 전문업체가 있어 유지보수, 문제해결 방법을 찾기 수월하지만 하둡은 비교적 그렇지 않다.

###### 실행모드

- 독립실행 모드
- 가상 분산 모드 - 하나의 서버에 온전한 하둡 환경을 구축한 것
- 완전 분산 모드 - 둘 이상의 하둡서버를 구축한 것



##ssh

SeciureSHell

네트워크 상의 다른컴퓨터에 로그인하거나 원격시스템에서 명령을 실행하게 해주는 프로그램/프로토콜



##### Setting

1. 필요 소프트웨어 다운로드

1) java

2) hadoop

3) eclipse

4) tomcat

5) mysql

wget https://archive.apache.org/dist/hadoop/common/hadoop-1.2.1/[hadoop-1.2.1.tar.gz

2. 네트워크 설정

1)etc/hosts

2)etc/hostname  /     hostnamectl -setname hadoopserver1

3)etc/sysconfig/network-scripts

4)systemctl disable firewalld  로 port들을 모두 열어둔다.

3. 패스 설정

etc/profile

HADOOP_HOME=/etc/hadoop-1.2.1

export HADOOP_HOME

PATH=$HADOOP_HOME/bin:$JAVA_HOME/bin:$PATH

export PATH



4. ssh 키 생성

[ssh](#ssh)

키를 통해 접속하면 접속시 마다 id pwd 입력을 하는 번거러움을 덜고 자유롭게 서버들을 오갈 수 있게 만든다.

private key 와 public key 를 이용해서, key가 일치하는 서버끼리는 자유롭게 접속이 가능하다.

```shell
$ ssh-keygen -t dsa -P '' -f ~/.ssh/id_dsa
#dsa 알고리즘을 통해 public, private Key 생성
$ cat /.ssh/id_dsa.pub >> /.ssh/authorized_keys
# 만들어진 authorized_keys를 다른 서버의 ~/.ssh 에 복사하게 되면 자유롭게 접속을 할 수 있게 된다.
```

5. hadoop/conf 내의 configuration 파일 수정

```xml
<!--core-site.xml-->
<configuration>
<property>
  <name>fs.default.name</name>
  <value>hdfs://localhost:9000</value>
  <!--외부에서 namenode를 접속할때의 port를 지정해준다.-->
</property>
<property>
  <name>hadoop.tmp.dir</name>
  <value>/usr/local/hadoop/tmp</value>
</property>
</configuration>

<!--hdfs-site.xml-->
<configuration>
<property>
  <name>dfs.replication</name>
  <value>1</value>
    <!--데이터를 몇개의 형태로 저장할것 인지 지정-->
</property>
<property>
  <name>dfs.name.dir</name>
  <value>/usr/local/hadoop/name</value>
    <!--namenode가 사용하는 정보를 저장하는 디렉토리 지정-->
</property>
<property>
  <name>dfs.data.dir</name>
  <value>/usr/local/hadoop/data</value>
    <!--데이터를 저장하는 디렉토리 지정-->
</property>
<property>
  <name>dfs.webhdfs.enabled</name>
  <value>true</value>
</property>
</configuration>

<!--mapred-site.xml-->
<configuration>
<property>
  <name>mapred.job.tracker</name>
  <value>localhost:9001</value>
    <!--jobtracker로 접근하는 prot 설정-->
</property>
</configuration>

맵리듀스
JOBTRACKER
분석에 대한 요청을 받는곳
TASKTARCKER
실재로 수행을 하는 것
```

6. hadoop-env.sh 수정

```

#8번 라인 수정, 한줄 추가
export JAVA_HOME=/etc/jdk1.8
export HADOOP_HOME_WARN_SUPPRESS="TRUE"
```

7. /etc/bashrc 에 추가 , 부팅시 자동으로 실행

```
. /etc/hadoop-1.2.1/conf/hadoop-env.sh
```

8. hadoop namenode -format       //name 디렉토리가 생성된다.
9. start-all.sh //hadoop 실행, data 디렉토리가 생성된다. jps 로 확인



###### 데이터 넣기 및 처리

```
$ hadoop dfs -mkdir /data
## test 디렉토리 생성
$ hadoop dfs -put README.txt /data/input1
## 하둡서버에 파일 넣기
$ hadoop jar hadoop-examples-1.2.1jar wordcount /data/input1 /data/output1
## examples... 의 wordcount 메소드를 이용해 아웃풋 생성

```



#### 완전분산모드 설정하기

1. ssh 활성화

   ssh-keygen

   public key 를 authorized_keys 로 서버들에게 나누어줘서 자유로운 출입 설정

2. systemctl stop firewalld ,

   systemctl disable firewalld  로 방화벽 완전 해제하기

3. namenode 컴퓨터 hadoop 설치 및 configuration 파일 설정 + /etc/profile , /etc/bashrc 에서 path 설정 하기.

conf/masters 에는 secondaryNamenode 를 담을 server를  지정 , conf/slaves 에는 datanode를 저장할 server를 지정한다.

```
#conf/master
hadoop2

#conf/slaves
hadoop2
hadoop3
hadoop4
```

```xml
<!--core-site.xml-->
<configuration>
<property>
    <name>fs.default.name</name>
    <value>hdfs://hadoop1:9000</value>
  </property>
  <property>
    <name>hadoop.tmp.dir</name>
    <value>/etc/hadoop-1.2.1/tmp</value>
  </property>
</configuration>

<!--hdfs-site.xml-->
<configuration>
  <property>
    <name>dfs.permissions</name>
    <value>false</value>
  </property>
  <property>
    <name>dfs.replication</name>
    <value>2</value>      
  </property>
  <property>
    <name>dfs.http.address</name>
    <value>192.168.111.201:50070</value>
      <!---->
  </property>
  <property>
    <name>dfs.secondary.http.address</name>
    <value>192.168.111.202:50090</value>
      <!--SecondaryNamenode를 가질 서버 지정-->
  </property>
  <property>
    <name>dfs.name.dir</name>
    <value>/etc/hadoop-1.2.1/name</value>
  </property>
  <property>
    <name>dfs.data.dir</name>
    <value>/etc/hadoop-1.2.1/data</value>
  </property>
</configuration>

<!-- mapred-site.xml -->
<configuration>
  <property>
   <name>mapred.job.tracker</name>
   <value>master:9001</value>
  </property> 
</configuration>

```

4. 각 서버에 hadoop 복사 

5. namenode 서버에서 hadoop namenode -format 로 포맷, start-all.sh 로 실행 . 각 서버에서 jps 로 설정한대로 실행 중 인지 확인하기



NameNode

파일시스템의 네임스페이스를 관리한다.

파일시스템 트리와 그 트리에 포함된 모든 파일과 디렉터리에 대한 메타데이터를 유지한다. 네임스페이스 이미지, 에디트 로그 파일로 저장된다. 파일에 속한 모든 블록이 어느 datanode에 있는지 파악하고 있다.

Datanode

클라이언트나 네임노드의 요청에 의해 블록을 저장, 탐색 한다. 저장하고 있는 블록의 목록을 주기적으로 네임노드에 보고한다.

Secondary-NameNode

주 네임노드에 장애가 발생할 것을 대비해서 네임스페이스 이미지의 복제본을 보관하는 역할을 한다. 

네임스페이스의 이미지가 약간의 시간차를 두고 secondary로 복제되기 때문에 어느정도의 데이터 손실은 불가피 하다.

