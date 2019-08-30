package com.example.p353;

import android.app.Service;
import android.content.Intent;
import android.content.IntentSender;
import android.os.IBinder;
import android.util.Log;

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
