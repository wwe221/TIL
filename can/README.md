# Can



<details markdown="1">
<summary>접기/펼치기    Can 연결하기 - window7   </summary>

> Windows7 기준임
> (Windows 10은 첨부문서 참고 - 좀 무서움)
>
> 1. PC에 CAN장비 드라이버 설치(2개)
>    드라이버를 설치하지 않고 장비의 USB를 PC에 연결하고
>    제어판 > 하드웨어 및 소리 > 장치관리자를 확인하면
>    기타장치 > CANPro Analyzer가 
>    노란색 느낌표가 표시된 상태로 
>    등록된것을 볼 수 있다.
>
>    드라이버를 설치해야 하므로
>    다음의 순서대로 드라이버를 설치한다.
>    
>    1. 
>    제공된 드라이버 폴더
>    RealSYS_USB_Device_Driver(20170316)안의 
>    dp-chooser.exe를 실행해서
>    개발툴용 USB Device Driver를 설치한다. 
>    설치가 완료되면 노란색 느낌표가 있던 기타장치는
>    사라지고
>    장치관리자 > 포트 부분에 CANPro가 등록된걸 
>    확인할 수 있다.
> 정상적으로 설치가 되었으면 리부팅한번 하고가자.
>    
>    2. 
>    정상적으로 동작하는지 살펴보기 위해
>    CANPro_v1.4.exe를 실행, 설치하여 analyzer프로그램을
>    설치하고 실행시켜 동작을 확인한다.
>    송신데이터를 만들어서 송신을 시켜보고
>    CAN 데이터 송신응답이 잘 출력되는지 확인
> ( 데이터를 정상적으로 송신한다는 의미 )
>    
>    3. 
>    CANPro를 하나 더 준비하여 서로 Serial로 연결한 후
>    각각 PC에 연결하면
>    장치관리자 > 포트 부분에 USB Serial Port가 하나
>    더 잡히는걸 확인할 수 있다. 
>    이제 analyzer를 2개 실행해서 serial com포트를
>    각기 다른 port번호로 설정한 후 
>    서로 데이터 통신을 할 수 있는지를 확인한다.
>    하나의 analyzer가 송신한 데이터를 다른 analyzer가
> 정상적으로 수신하는지를 확인
>    
>    4. 
>    이번에는 CANPro를 하나 더 준비하여 총 3개를
>    연결한 후 각각을 PC에 연결하여 하나의 CANPro에서
>    송신한 데이터를 다른 2개의 CANPro가 수신하는가를
>    확인한다.
>    
> 2. 장치의 테스트가 끝나면 Java 코드를 이용해서
>    데이터를 보내고 받는 방법을 이해해보자
>
>    Eclipse를 실행해 테스트용 소스코드를 확인
>    -> RXTXcomm.jar를 프로젝트 build path에 추가
>
>    실행시 하나의 dll이 필요한데 
>    제공된 rxtxSerial.dll 파일을 Java library path에
>    등록해야 한다. VM 인자로 -Djava.library.path에
>    해당 파일의 경로를 넣어주면 된다. 혹은 
>    파일을 <JAVA_HOME>/jre/bin에 복사해도 된다. 
>
> 3. Test 프로그램을 실행한 후 Code Review 진행

</details>

can 통신은 Serial port 로 컴퓨터와 연결한다.

App 에서 serial 로 data를 real time 으로 전송 했다고 해서 serial 에서 can 으로 real time 으로 오는 것은 아니다.

serial이 수행 하던 작업을 다 끝내고 나서야 전송한다.



app 과 serial 의 연결이 지속되는 것이 아니라 한꺼번에 보내고 받는다.



Java 연동

RXTXCOMM 라이브러리 추가

rxtx~.dll 파일 2개 JAVA_HOME 의 jdk~/jre/bin 혹은 jre~/bin에 추가



```java
public class SerialTest implements SerialPortEventListener {
	private BufferedInputStream bin;
	private InputStream in;
	private OutputStream out;
	private SerialPort serialPort;
	private CommPortIdentifier portIdentifier;
	private CommPort commPort;
	public SerialTest() {
	}
	public SerialTest(String portName) throws NoSuchPortException {
		portIdentifier = CommPortIdentifier.getPortIdentifier(portName);
		// port 가 정상이면 connect
		System.out.println("Connect Com Port!");
		try {
			connectSerial();
			System.out.println("Connect OK !!");
			(new Thread(new SerialWriter())).start();
		} catch (Exception e) {
			System.out.println("Connect Fail !!");
			e.printStackTrace();
		}
	}
	private class SerialWriter implements Runnable {
		String data;
		public SerialWriter() {
			this.data = ":G11A9\r"; // can bus에 나를 연결해죠!!
		}
		public SerialWriter(String serialData) {
			// W28 00000000 000000000000
			// :W28 00000000 000000000000 53 \r
			String sdata = sendDataFormat(serialData);
			System.out.println(sdata);
			this.data = sdata;
		}
		public String sendDataFormat(String serialData) {
			serialData = serialData.toUpperCase();
			char c[] = serialData.toCharArray();
			int cdata = 0;
			for (char cc : c) {
				cdata += cc;
			}
			cdata = (cdata & 0xFF);
			String returnData = ":";
			returnData += serialData + Integer.toHexString(cdata).toUpperCase();
			returnData += "\r";
			return returnData;
		}
		public void run() {
			try {
				byte[] inputData = data.getBytes();
				out.write(inputData);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public void connectSerial() throws Exception {
		if (portIdentifier.isCurrentlyOwned()) {
			System.out.println("Error: Port is currently in use");
		} else {
			commPort = portIdentifier.open(this.getClass().getName(), 5000);
			if (commPort instanceof SerialPort) {
				serialPort = (SerialPort) commPort;
				serialPort.addEventListener(this);
				serialPort.notifyOnDataAvailable(true);
				serialPort.setSerialPortParams(921600, // 통신속도
						SerialPort.DATABITS_8, // 데이터 비트
						SerialPort.STOPBITS_1, // stop 비트
						SerialPort.PARITY_NONE); // 패리티
				in = serialPort.getInputStream();
				bin = new BufferedInputStream(in);
				out = serialPort.getOutputStream();
			} else {
				System.out.println("Error: Only serial ports are handled by this example.");
			}
		}
	}
	public static void main(String[] args) {
		try {
			new SerialTest("COM5");
		} catch (NoSuchPortException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void serialEvent(SerialPortEvent event) {
		// serial 에서 app 으로 input 요청이 들어오면 실행된다.
		switch (event.getEventType()) {
		case SerialPortEvent.BI:
		case SerialPortEvent.OE:
		case SerialPortEvent.FE:
		case SerialPortEvent.PE:
		case SerialPortEvent.CD:
		case SerialPortEvent.CTS:
		case SerialPortEvent.DSR:
		case SerialPortEvent.RI:
		case SerialPortEvent.OUTPUT_BUFFER_EMPTY:
			break;
		case SerialPortEvent.DATA_AVAILABLE:
			byte[] readBuffer = new byte[128];
			try {
				while (bin.available() > 0) {
					int numBytes = bin.read(readBuffer);
				}
				String ss = new String(readBuffer);
				System.out.println("Receive Low Data:" + ss + "||");
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		}
	}
}
```

