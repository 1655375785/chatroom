package com.chatroom;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TestSockServer {
public static void main(String[] args) {
	DataInputStream dis=null;
	DataOutputStream dos=null;
	Socket socket=null;
	try {
		//准备
		ServerSocket s=new ServerSocket(8888);
		System.out.println("服务器启动！");
		//链接
		socket=s.accept();
		//信息交互
		while (true) {
			dos=new DataOutputStream(socket.getOutputStream());
			dis=new DataInputStream(socket.getInputStream());
			String str=null;
			if ((str=dis.readUTF())!=null) {
				System.out.println("客户端输入："+str);
//				System.out.println("客户端ip"+socket.getInetAddress());
//				System.out.println("客户端口号"+socket.getPort());				
			}
			dos.writeUTF("sever say:"+str);
			
			
		}
	} catch (Exception e) {
		e.printStackTrace();
	}finally{
		//关闭
		try {
			dos.close();
			dis.close();
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
}
