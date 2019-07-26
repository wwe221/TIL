**시스템 Setting**

CENTOS 폴더 복사 -> C에 붙여넣기 (CENTOS2)

CENTOS2의 파일(CENTOS 64-bit 20190718) 이름 SERVER2라고 바꾸기 

SERVER2로 작업할 것임. 

복사해서 사용할 경우 moved it을 클릭해서 시스템 구성할 것.

setting 가서 hardware의 Advanced눌러서 IP바꾸기 

SERVER2 켜서 FIREFOX 클릭 -> naver들어가기 



**DHCP**

IP address를 할당받을 때, 0~255까지 할당받을 수 있음.

앞의 3개의 수는 정해지고 나머지 하나만 다름(우리 교실은 254개의 컴퓨터를 설치할 수 있음)

마찬가지로 가상의 세계에서도 254개의 컴퓨터를 설치할 수 있음(IP addreess할당)



cmd창 (속성 -> 다 체크 )

강사님 게시판 글(VMware IP Setting**[출처]** VMware IP Setting (비공개 카페))

로 가서 cmd창에 명령어 치기 

68페이지대로 하기 



115 페이지대로 하기 (업데이트 안 하려고 이렇게 함)

최신의 것들만 업데이트하게 되면 OS까지 갈아엎어야 하는 상황이 생길 수 있음

-> 이것 때문에 115페이지의 내용을 수행함.



OS는 CentOS-Base.repo.bak의 파일 안에 있는 내용을 보고 프로그램 업데이트를 함 

가상머신의 inet은 미국의 컴퓨터에서 내 컴퓨터로 접속하려면 안 됨. (얘는 가상이라서...)

반대로 진짜 그냥 컴퓨터에서는 static address 사용하기 때문에 접속이 됨. 



*ping*

살았는지 죽었는지 물어보는 것

자기 자신에게 하는 경우 밖으로 나갔다가 다시 들어온다.

ping 하고 나서 주소를 쳐줘야 제대로 됨.

server1은 진짜 이름은 아님.



gedit /etc/hosts

해주고 들어가서 마지막 문장 지우고 192.168.111.100 server1를 추가해주기



CENTOS에서 보안이 너무 강해서 나중에 문제 생길 수 있음 

119페이지 대로 진행 (~120)

122페이지의 step8은 못함 

step7까지만 함. 



server2 세팅(ip: 200으로하기 hostname:server2)



여기있는 윈도우 컴퓨터와 다른 곳의 윈도우 컴퓨터 연결 

192.168.111.200

2





system driver etc

