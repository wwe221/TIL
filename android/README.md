# Android

리눅스 기반으로 만들어진 OS. 따라서 하드웨어에 이식하는것이 어렵지 않다.

OS 위에 ART 라는 런타임 (Runtime) 이 탑재되어 있다. ( 자바의 JVM 느낌)

각 버전간의 호환성이 떨어진다. 따라서 대부분의 어플리케이션들은 네이티브 앱이 아닌 웹 앱이다.

정교한 MVC 모델

[Anroid studio download](developer.android.com/studio)

설치 후 SDK Manager 를 통해 필요한 버전의 sdk 를 설치한다.

###### 구성요소

액티비티 ( Activity) - 화면구성

서비스 (Service) - 백그라운드에서 실행된다.

브로드캐스트 수신자 (Broadcast Receiver) - OS 의 신호를 받는다. 

- 브로드캐스트 - OS 가 특정신호( 전화, 메세지 수신 등) 를 모두에게 뿌린다.

내용 제공자 ( Content Provider) - 저장된 정보를 가져와서 사용할 수 있다.



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
- 
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



###### 버튼 리스너

```java
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);        
        bt= findViewById(R.id.button);
        bt.setOnClickListener(this); // 버튼에 이벤트가 들어오면~ MainActivity 가 처리한다. -> onClick 함수가 처리한다.
    }
    @Override
    public void onClick(View view) {
        Toast.makeText(this, "Button Clicked", Toast.LENGTH_SHORT).show();
    }
}
```

###### 스위치 리스너

```java
aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
    // anonymous class 를 통해 리스너를 만든다.
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Toast.makeText(MainActivity.this, "changed", Toast.LENGTH_SHORT).show();     //anonymous 에서는 context를 this 로 설정할수 없기 때문에 상위 클래스를 통해 설정한다.
                if (b)
                    bt.setBackgroundColor(Color.BLUE);
                else
                    bt.setBackgroundColor(Color.RED);

            }
        });
```

###### 가로 / 세로 전환시

mnifest.xml

```xml
<activity android:name=".MainActivity"
          android:configChanges="orientation|screenSize|keyboardHidden" >
    <!--추가가 필요하다-->
```



```java
@Override
    public void onConfigurationChanged(Configuration newConfig) {// 가로/세로 방향이 바뀌었을때
        super.onConfigurationChanged(newConfig);
        if(newConfig.orientation ==Configuration.ORIENTATION_LANDSCAPE){
            show("Landscape 방향쓰");
        }
        else if(newConfig.orientation ==Configuration.ORIENTATION_PORTRAIT){
            show("Portrait 방향쓰");
        }
    }
```

###### View 를 Toast 에 붙이기

```java
public void toast(View v){ // Toast 에 새로 만든 화면을 붙이기
        LayoutInflater inflater = getLayoutInflater();
        View tview = inflater.inflate(R.layout.toast, (ViewGroup) findViewById(R.id.tLayout)); // 만든 view layout 호출
        Toast toast = new Toast(this);
        toast.setView(tview); 
        toast.setDuration(Toast.LENGTH_LONG);
    
    	TextView view = tview.findViewById(R.id.textView);
    	view.setText("Itzy is exist");
     	// layout 의 개체 의 속성도 바꿀수 있다.
        toast.show();
```

###### dialog

```java
 public void dialog(View v){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("new Dialog");
        builder.setMessage("message 1 2 3 ");
        builder.setIcon(R.drawable.itzy);
        builder.setNegativeButton("no", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "nonono", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "yesyesyes", Toast.LENGTH_SHORT).show();
                finish(); // 어플리케이션 종료
            }
        });
      LayoutInflater inflater = getLayoutInflater();
        View tview = inflater.inflate(R.layout.toast, (ViewGroup) findViewById(R.id.tLayout));
        builder.setView(tview);
     // dialog 의 Message 영역은 다른 view로 치환이 가능 하다.
     
        AlertDialog dialog = builder.create();
        dialog.setCancelable(false); // dialog 무시 불가
        dialog.show();
    }
```

###### progressBar / progressDialog

```java
 public void pbar(View v){
        int a = progressBar.getProgress();
        if(v.getId() == R.id.button){
            progressBar.setProgress(a+10);
        }else{
            progressBar.setProgress(a-10);
        }
    }
    public void pdia(View v){
        if(v.getId() == R.id.button3){
            progressDialog= new ProgressDialog(MainActivity.this);
            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progressDialog.setMessage("progressing...");
            progressDialog.setButton(progressDialog.BUTTON_NEGATIVE, "canclse", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    progressDialog.dismiss();
                }
            });
            progressDialog.setCancelable(false);
            progressDialog.show();
        }
    }
```

###### SharePreference 정보 저장

```java
//저장
SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();
                editor.putBoolean("save", true);
                editor.putString("id",ID);
                editor.putString("pwd",PWD);
                editor.commit();
//가져오기
SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
        if((pref!=null)&& pref.contains("save")){
            if(pref.getBoolean("save",false)){
                return true;
            }
        }
```



###### Intent 

화면과 화면간의 연결을 돕는다.

```java
	Intent intent = new Intent(MainActivity.this,Main2Activity.class);
    //Intent intent = new Intent(getApplicationContext(),Main2Activity.class);
    intent.putExtra("key",500);
    intent.putExtra("str","String is good to go");
    startActivity(intent);
```



###### Service

기존의 Activity 와 동일하지만 화면이 필요없다.

백그라운드 동작을 하기 때문.



MainActivity.java

```java
//서비스 호출
i=  new Intent(this,MyService.class);
        startService(i);
```

Myservice.java

```java
public class MyService extends Service {
    boolean flag = false;
    public MyService() {

    }
    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("@@@nCreate","Service Created-------------------");
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("@@@nCreate","DESTROY-------------------");
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //액티비티가 서비스를 호출할 때 onCreate가 호출된 후 호출된다.
        // args 의 intent 를 서비스 호출시 입력 한다.
        Log.i("@@@nStartComm","yes , Commander-----------");
        flag=true;
        final Intent sendi = new Intent(getApplicationContext(),MainActivity.class);
        sendi.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK |
                Intent.FLAG_ACTIVITY_SINGLE_TOP|
                Intent.FLAG_ACTIVITY_CLEAR_TOP);
        //서비스에서 메인으로 보내기 위한 플레그 설정
        Runnable run = new Runnable() {
            boolean flaga = flag;
            @Override
            public void run() {
                for(int i=0;i<5;i++){
                    sendi.putExtra("cmd",i);
                    startActivity(sendi);
                    try {
                        Thread.sleep(1000);
                        Log.i("@@@onWhile","while-----------");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if(!flaga)
                        break;
                }
            }
        };
        Thread t =new Thread(run);
        t.start();

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}

```



