package com.example.p360;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    int a =0;
    int b =0;
    class myBinder extends Binder { //myBinder를 통해 MyService 객체를 끄집어 낼 수 있다.
        //액티비티가 서비스에 접근하기 위해 사용
        public MyService getService(){
            return MyService.this;
        }
    }
    IBinder iBinder= new myBinder();
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("MyService]","onStartCommand -----");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return iBinder;
    }
    public void method1() {
        Log.i("MyService]", "method111111111111111111111");
        final Intent sendi = new Intent(getApplicationContext(), MainActivity.class);
        sendi.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK |
                Intent.FLAG_ACTIVITY_SINGLE_TOP |
                Intent.FLAG_ACTIVITY_CLEAR_TOP);
        //서비스에서 메인으로 보내기 위한 플레그 설정
        Runnable run = new Runnable() {
            @Override
            public void run() {
                for (a = 0; a <= 30; a++) {
                    sendi.putExtra("cmd", a);
                    sendi.putExtra("cmd2", b);
                    startActivity(sendi);
                    try {
                        Thread.sleep(700);
                        Log.i("@@@onWhile", "while-----------");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread t =new Thread(run);
        t.start();
    }
    public void method2(){
        final Intent sendi = new Intent(getApplicationContext(), MainActivity.class);
        sendi.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK |
                Intent.FLAG_ACTIVITY_SINGLE_TOP |
                Intent.FLAG_ACTIVITY_CLEAR_TOP);
        //서비스에서 메인으로 보내기 위한 플레그 설정
        Runnable run = new Runnable() {
            @Override
            public void run() {
                for (b = 0; b < 15; b++) {
                    sendi.putExtra("cmd", a);
                    sendi.putExtra("cmd2", b);
                    startActivity(sendi);
                    try {
                        Thread.sleep(1000);
                        Log.i("@@@onWhile", "while-----------");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            public void run2(){
                for (b = 0; b < 15; b++) {
                    sendi.putExtra("cmd3", a);
                    startActivity(sendi);
                    try {
                        Thread.sleep(1000);
                        Log.i("@@@onWhile", "while-----------");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread t =new Thread(run);

        t.run();
        Log.i("MyService]","method2222222222222222222222222");

    }
}
