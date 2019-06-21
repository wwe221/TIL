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

