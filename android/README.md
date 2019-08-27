# Android

리눅스 기반으로 만들어진 OS. 따라서 하드웨어에 이식하는것이 어렵지 않다.

OS 위에 ART 라는 런타임 (Runtime) 이 탑재되어 있다. ( 자바의 JVM 느낌)

각 버전간의 호환성이 떨어진다. 따라서 대부분의 어플리케이션들은 네이티브 앱이 아닌 웹 앱이다.

정교한 MVC 모델

[Anroid studio download](developer.android.com/studio)

설치 후 SDK Manager 를 통해 필요한 버전의 sdk 를 설치한다.



###### gradle

maven 의 업그레이드 버전 빌드 시스템



###### onCreate

어플리케이션이 실행 될 때 호출된다. 자바의 servlet 과 유사한 구조



##### Manifest

app 의 환경설정 파일.

어플리케이션의 이름, 아이콘 , 구조 등을 정의할수 있다.

```xml
<activity android:name=".MainActivity">
	<intent-filter>
        <action android:name="android.intent.action.MAIN" />
		<category android:name="android.intent.category.LAUNCHER" />
	</intent-filter>
</activity>
```



크게 java와 resource 로 나눈다.

resource - (res )

- drawable - 이미지 관리

- layout - 화면관리
- mipmap - 아이콘 등 관리
- values -  프로젝트 내에서 사용하는 전역변수 들을 관리 한다. (color, string, styles)



Activity 들을 apk로 묶어서 전송, android 가 이를 풀어서 실행하게 된다.

##### 구조 

  				Android Activity

:arrow_up:			Android Container

:arrow_up:		Android OS

:arrow_up:	Android Kernal

:arrow_up: Android HW



###### Log 찍기

```java
	Log.d("d for DEBUG@@@@","clickButton");
    Log.i("i for Info#####","bangga");
    Log.e("e for Error","error");
```

###### 안드로이드 생명주기

- onCreate - 실행
- onPause - 백그라운드 전환 등 일시정지
- onResume - 재개





모든 widget 들은 View group (Layout) 위에 올라가야한다. 

wrap_content - 내용에 맞춰 사이즈 지정

match_parent - 상위에 맞춰 사이즈 지정



버튼 지정

```java
Button bt2;
bt2= findViewById(R.id.button25);
```



margin , padding 을 이용하여 직접 값을 입력해 위치를 조정하거나, garvity / layout_gravity 를 이용해 정렬할 수 있다.

alpha 값으로 투명도를 조정할 수 있다.



layout_weight - 비율을 통해 화면내 영역 크기를 조정할수 있다. vertical - 숫자가 작을 수록 큰 비중을 차지한다. horizontal - 숫자가 클수록 큰 비중

