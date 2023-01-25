package io.acornsoft.client;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.acornsoft.util.DateUtil;

public class Client1 extends Thread {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private Socket socket;
	private BufferedReader br;
	private PrintWriter pw;

	
	
	public Client1(int i, String ip, int port) {
		try {
			// 서버에 요청 보내기
			socket = new Socket(ip, port);
			logger.info((i+1)+"th connection to "+socket.getInetAddress().getHostAddress() + "...");
			
			// 메시지 받기
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			pw = new PrintWriter(socket.getOutputStream());
			
			// 메세지 전달
			String uuid = UUID.randomUUID().toString();
			pw.println(DateUtil.getTimeStampAsString()+ " "+uuid);
			pw.flush();
			
			// 응답 출력
			logger.info(br.readLine());
		} catch (IOException e) {
		    System.out.println(e.getMessage());
		} finally {
		    // 소켓 닫기 (연결 끊기)
		    try {
		    	if(socket != null) { socket.close(); }
		        if(br != null) { br.close(); }
		        if(pw != null) { pw.close(); }
		    } catch (IOException e) {
		        System.out.println(e.getMessage());
		    }
		}
	}
}
