package com.chatroom;

import java.io.DataInputStream;

import java.io.*;
import java.net.*;
import java.rmi.UnknownHostException;
import java.util.Scanner;

public class TestSockClient {
public static void main(String[] args) {
	DataInputStream dis=null;
	DataOutputStream dos=null;
	Socket socket=null;
	String s=null;
	String str=null;
	Scanner input=new Scanner(System.in);
	try {
		socket=new Socket("127.0.0.1",8888);
		do {
			dos=new DataOutputStream(socket.getOutputStream());
			dis=new DataInputStream(socket.getInputStream());
			str=input.next();
			dos.writeUTF(str);
			//System.out.println("客户端输入："+str);
			if ((str=dis.readUTF())!=null) {//之前是s，？？？
				System.out.println("fuwu"+str);
			}
		} while (!str.equals("88"));
		System.out.println("结束！");
	} catch (UnknownHostException e) {
		e.printStackTrace();
	}catch(IOException e){
		e.printStackTrace();
	}finally {
		try {
			
			dos.close();
			dis.close();
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
	}
}
}
