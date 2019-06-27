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

###### codes

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

a link

마우스 포인터를 올려놓으면 손가락 모양으로 바뀐다!

```html
<a href= "http://www.naver.com"> goToNaver</a>
<a href ="b2/b2.html" target="_blank">  b2 </a>
<a href = "#h_target"> Move</a>
<h1 id="h_target">header target</h1>
```

table

```html
<table border="1">
		<caption>Number List</caption>
		<thead>
			<tr>
				<th>one</th>
				<th>two</th>
				<th>three</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td colspan="2">1</td>
				<td rowspan="3"><img src="img/img01.jpg"></td>
			</tr>
			<tr>
				<td>4</td>
				<td>5</td>
			</tr>
			<tr>
				<td>7</td>
				<td>8</td>
			</tr>
		</tbody>
	</table>
```

media

```html
<audio src="file/Kalimba.mp3" controls="controls">
</audio>
<video src="http://media.w3.org/2010/05/bunny/movie.ogv" controls="controls"></video>
```

div , span

```html
<div>block <span>Area</span> Blue Zone..</div>
```

form

​	화면에 입력된 값을 서버로 전송하기 위해 사용.

```html
<script >
function login(f){
	var c = confirm('Are You Login>?,.?');
	if(c){
		f.method = 'GET';
		f.action='a';
		f.submit();
	};
};
</script>
<form>
ID <input type="text" name="nm">
PWD <input type="password" name="pwd">
<input type="button" onclick="login(this.form);" value ="Login">
<input type="reset" value ="Reset">
```

```html
<form>
		<fieldset>
		<legend>Employee Register</legend>
		<input type="hidden" name="geo" value="fff">
		Text <input type="text" name="tx"> <br> 
		password <input
		type="password" name="pwd"> <br> 
		<label for="male">Male</label>
		<input	type="radio" name="g" value="m" id="male"> 
		Female <input type="radio"name="g" value="f"> 
		Aze <input type="radio" name="g"value="a">
		<hr>
		Chicken <input type="checkbox" name="f" value="c"> <br>
		Pizza <input type="checkbox" name="f" value="p"> <br>
		Hamburger <input type="checkbox" name="f" value="H">
        Level <input value="level1" type="text" name="nm" readonly="readonly"><br>
		Date <input type="date" name="d"><br>
		Color <input type="color" name="c"><br>
		Email <input type="email" name = "e" required ="required"><br>
		Tel<input type="tel" name = "t" pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}" title="###-####-####"><br>
		Number<input type="Number" name = "num"><br>
		Range<input type="range" min="1" max="10" name="range"><br>

<input type="submit" value= "register">
		<hr>
		<select name="car">
			<option value="h">Hyundai</option>
			<option value="k">Kia</option>
			<option value="c">Chevolet</option>
			<option value="b">BMW</option>
		</select>
			<hr>
			file <input type="file" name="ff">
			<hr>
			<input type="button" value="Button"> <input type="submit"
				value="Submit">
		</fieldset>
	</form>
```

input 의 형식에 제한사항을 걸어 둘 수 있다.

```html
<td><input type="password" name="pwd" required="required" placeholder ="Password" 
				pattern="(?=.*\d{1,50})(?=.*[~`!@#$%\^&*()-+=]{1,50})(?=.*[a-zA-Z]{2,50}).{8,50}">
				<!-- 숫자와 특수문자 각각 1개이상, 영문 2자이상, 총8글자 이상 -->
```

## CSS

```css
p  {  backgroun-color   :   yellow  ;   }
/*선태자(selector) { 속성(attribute) : 값 (value); }*/
*{ } /*전체 선택자*/
.className{ }/*클래스 선택자*/
#idName{}/* 아이디 선택자 */
selectorName [attribute="value"]{ }/* 속성 선택자*/
```

###### 외부 스타일 시트 링크

```html
<link type="text/css" rel="stylesheet" href="c1.css">
```



```css
.classname > tag {} /*클래스 안의 태그*/
.classname tag{} /*클래스 안의 모든 태그 */
tag > tag > tag:nth-child(n){} /* 경로를 타고 들어간 태그의 n번째 마다*/
```



## JavaScript

기존의 정적인 웹페이지를 Dynamic 하고 사용자에 의해 Interactive 하게 만들수 있도록 해준다.

Script 언어 이기 때문에 컴파일이 필요가 없다. 하지만 그렇기 때문에 코드 작성과정에서 에러를 찾아내기가 까다롭다. 

기본적으로 Server가 아닌 Browser에서 동작을 한다.

###### 특징

- 인터프리트 언어 - 컴파일을 거치지 않고 바로 실행시킬 수 있다.
- 동적 타이핑 - 변수의 자료형을 선언하지 않아도 된다.
- 구조적 프로그래밍 - if, else while for 등의 구조적 프로그래밍을 지원한다.
- 객체 기반
- 함수형 프로그래밍 - 함수는 일급객체로서, 속성과 메서드를 가진다.
- 프로토타입 기반 - 상속을 위해 클래스 개념 대신에 프로토타입을 사용한다.



###### 용도별 확장언어

- Node.js

  자바스크립트를 서버프로그래밍 언어로 변화 시킨 서버사이드 소프트웨어 시스템이다.

- jQuery

  자바스크립트를 보다 편하고 보기 쉽게 사용할 수 있도록 변환시킨 언어이다.

- JSON

  JavaScript Object Notation

  개발언어에 독립적인 데이터 형식으로  XML을 대체하고 있다. 또한, 문서 데이터베이스의 표준 저장 형식으로도 사용된다.





```javascript
	//number
	var v1 = 10;
	var v2 = 1.13;
	//boolean
	v1 = true;
	//string
	v1 = '"abc"';
	v1 = "abc";
	//JavaSciptObject
	//== JSON (javascript object notation)
	var v3 = {
		name : 'k1',
		size : 1000,
		go : function() {
		},
		stop : function() {
		}
	};
	//function
	var v7 = function() {
	};
	//array
	var v8 = [ 1, 2, 3, 'a', v3 ];
	alert(typeof (v8));
	//undefined
	var v9;
	//null
	var v10 = null;
```

```javascript
function calc(){
		var v1 = document.getElementById('n1').value;
		var v2 = document.getElementById('n2').value;
		var sum= Number(v1) +Number(v2);
		var r = document.getElementById('result');
		var r2 = document.getElementById('r1');
		if(isNaN(sum))
		r.innerHTML = '<a href = "">'+0+'</a>';			
		else
		r.innerHTML = '<a href = "">'+sum+'</a>';

		r.style.color='blue';
		r2.value = sum;
	};
```

###### 객체 와 프로토타입

```javascript
function Person(name,age){
	this.name = name;
	this.age = age;	
};
Person.prototype.print= function(){
	return this.name +' ' + this.age;
};
var p1 = new Person('Kim',20);
var p2 = new Person('Lee',30);
var d= new Date();
alert(p1.print());


var Sk= {
	a:function(){alert('a');}
};
var Hb= {
    a:function(){alert('bbb');}
};
Sk.a();
```

window navigator

사용자가 어떤 환경에서 접속을 하는지에 대해 접근할 수 있다. 

```javascript
for(var key in navigarot){
    value= navigator[key];
    document.write(key+":"+value+"<br>");
}
```

window.onload

html 이 모두 load 됐을 때에 기능을 실행하려 할때 사용한다.

```javascript
window.onload = function () {};
```

## Cros

HTML이 직접 접속 하고 있는 SERVER 외에는 연결하면 안된다.

보안상으로 서버가 갖고 있는 Data를 다른 server에 흘려보내는 문제가 생길 수 있기 때문에.

하지만 그룹 NetWork 망 안에서 필요시, 직접 연결하고 있는 server 외의 서버를 신뢰할 수 있는 server 라면 두가지 이상의 server 에 연결이 가능하다.

혹은 메인 Server 를 통해서 외부 서버에 접근해야 한다.

## WebSocket

웹 애플리케이션을 위한 양방향 통신 기술.

HTTP 의 한계(요청을 한 것들만 받을수 있는)를 벗어나 HTML5에서 JavaScript 를 통해 TCP/IP 가 제공하는 기능을 사용할 수 있다.



Server Side 역할

1. 입력을 받아 처리
2. 데이터를 가져와서 Client 에게 뿌려준다.

