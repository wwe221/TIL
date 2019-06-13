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

