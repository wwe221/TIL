# jQuery

기존의 JavaScript 의 작성을 좀더 편하게 만든 JS라이브러리

실행하기 위해서는 브라우저에 라이브러리를 plug in 하여 사용하는 방식이다



기본적으로는 라이브러리 파일을 서버에 저장 시키고 이를 이용하지만 번거롭기 때문에 CDN (Contents Delivery Network)을 이용해 runtime 시에 온라인으로 라이브러리를 로드해서 사용한다.

```html
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
```



```javascript
$('div').append('<h3>Append '+cnt++ +'</h3>');
$('div').prepend('<h3>PrePend '+cnt++ +' </h3>');
$('div').after('<h3>After '+cnt++ +' </h3>');
$('div').before('<h3>Before '+cnt++ +' </h3>');
$('div').empty();
$('div').remove();
$('div').addClass('dd');
$('div').removeClass('dd');
```

# Ajax

(Asynchronous JavaScript and XML)

서버와 데이터를 교환하는 기술 중 하나.

클라이언트가 서버와 적은양의 데이터를 비동기적으로 교환한다.

페이지를 리로딩 하지 않고 일부의 데이터를 업데이트 할 수 있다.

따라서 빠르고 동적인 대화형 웹페이지를 구현하는 데에 유용하다.

```javascript
function sendData(n1, n2) {
	var surl = 'calc1';
	$.ajax({
		url: surl,
		method: "post",
		data: { "num1": n1, "num2": n2 },
		success: function (result) {
// 서버에 전송을 성공하고, 서버에서 값을 보내오면 result로 받아온다.
			display(result);
		},
		error:function(){
			}
	});
}

```

