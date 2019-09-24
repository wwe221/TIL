package com.example.wschatt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
    Client c;
    TextView tv , getin;
    Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.editText);
        bt = findViewById(R.id.button);
        getin=findViewById(R.id.textView);
        ClThread cl = new ClThread();
        cl.start();
    }
    class ClThread extends Thread{
        @Override
        public void run() {
            try {
                c = new Client("70.12.60.111",1234);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    class Client {
        Socket socket;
        boolean rflag = true;

        public Client() {

        }

        public Client(String ip, int port) throws IOException {
            boolean flag = true;
            while (flag) {
                try {
                    // Construct에서는 socket만 만듦
                    // connection이 일어나 socket이 만들어지면?
                    socket = new Socket(ip, port);
                    if (socket != null && socket.isConnected()) {
                        break; // socket은 한 번만 만들면 됨
                    }
                } catch (Exception e) {
                    System.out.println("Re-Try");
                    // socket이 안 만들어지면 retry 해야 됨
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                }
            } // end while
            new Receiver(socket).start();
        }
        public void sendMsg(String msg) throws IOException {
            Sender sender = null;
            sender = new Sender(socket);
            sender.setMsg(msg);
            sender.start();
        }

        public void start() throws Exception {
            Scanner sc = new Scanner(System.in);
            boolean sflag = true;
            while (sflag) {
                System.out.println("Input Msg.");
                String str = sc.next();
                sendMsg(str);
                if (str.equals("q")) {
                    break;
                }
            }
            System.out.println("Bye...");
            sc.close();
        }

        class Sender extends Thread {

            OutputStream out;
            DataOutputStream dout;
            String msg;

            public Sender(Socket socket) throws IOException {
                out = socket.getOutputStream();
                dout = new DataOutputStream(out);
            }

            public void setMsg(String msg) {
                this.msg = msg;
            }

            public void run() {
                if (dout != null) {
                    try {
                        dout.writeUTF(msg);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }
        }

        class Receiver extends Thread {
            Socket socket;
            InputStream in;
            DataInputStream din;

            public Receiver(Socket socket) throws IOException {
                this.socket = socket;
                in = socket.getInputStream();
                din = new DataInputStream(in);
            }

            public void run() {
                try {
                    while (rflag) {
                        String str = din.readUTF();
                        System.out.println(str);
                        getin.append("\n"+str);
                    }
                } catch (Exception e) {

                }
            }
        }
    }
    public void btclick(View v){
        String str = tv.getText().toString();
        try {
            c.sendMsg(str);
            tv.setText("");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
