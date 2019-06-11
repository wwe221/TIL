웹 접속

Web Server 주소 접속 -> web서버에 요청 -> html 파일 연결 

###### Web Client Application

html , JavaScript , CSS

jquery - JavaScript 를 편리하게 사용하기 위해 	변형시킨 것.

Computer -> hub -> gateway -> dns -> server 

Hub - 빌딩 혹은 층의 모든 connection 을 관리하는 것.

Gateway - hub와 연결되어 외부로 연결하는 라인.

DNS - Domain 의 실제 ip주소를 갖고있다. ( 주기적으로 업데이트)

## HTML

(Hyper Text Markup Language)

Markup 언어의 일종. - Text에 Tag를 붙여 어느부분에 해당하는지 기술한 언어.

한동안 정적이었던  기능만 있던 HTML

HTML5 가 나오면서 다이나믹한 기능까지 갖게 되었지만 완벽한 수행을 하는 브라우저는 아직 없다.



###### Setting

 apache 설치 <http://tomcat.apache.org/>

Eclipse 의  server at localhost 를 apache에 연결,

​	Dynamic Web Application 프로젝트 생성

​	프로젝트의 web 폴더에  html 파일 작성.

browser 에서,  ip/port/ProjectName/Filename.html 로 접속



element  -  <tag> contents </tag>  태그와 컨텐츠로 이루어짐

attribute  속성 -  tag 안에 들어가서 태그를 꾸미는 녀석

주석 -  <!--      -->

추가적인 공부 html www.w3schools.com

```html
<p>this is paragraph</p>
&nbsp;
<!-- 각 문단(Paragraph)의 사이에서는 빈줄이나 스페이스는 무시된다 또한 문단은 화면의 (가로)영역을 모두 가져간다. 이러한 태그들을 블럭태그라 한다.-->
<img src="img01.jpg">
<!--영역을 가져가지 않는 - 인라인 태그 -->
<br> 강제 행변환
<pre>엔터와 스페이스가 입력이 된다</pre>
<!-- br 과 pre 는 기능이 있지만, 화면 해상도, 브라우져의 사이즈에 따라서 출력이 나오지 않을 수 있다. 따라서 자주 사용하지는 않는다. -->
<ul>
    <li>List1 </li>
    <li>List1 </li>
    <li>List1 </li>
</ul>
<!-- 여러가지의 것들을 묶어서 관리하는 list -->
```

