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
		//׼��
		ServerSocket s=new ServerSocket(8888);
		System.out.println("������������");
		//����
		socket=s.accept();
		//��Ϣ����
		while (true) {
			dos=new DataOutputStream(socket.getOutputStream());
			dis=new DataInputStream(socket.getInputStream());
			String str=null;
			if ((str=dis.readUTF())!=null) {
				System.out.println("�ͻ������룺"+str);
//				System.out.println("�ͻ���ip"+socket.getInetAddress());
//				System.out.println("�ͻ��˿ں�"+socket.getPort());				
			}
			dos.writeUTF("sever say:"+str);
			
			
		}
	} catch (Exception e) {
		e.printStackTrace();
	}finally{
		//�ر�
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
