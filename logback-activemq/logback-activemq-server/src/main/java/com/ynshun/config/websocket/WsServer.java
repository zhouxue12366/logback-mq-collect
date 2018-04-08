package com.ynshun.config.websocket;

import java.net.InetSocketAddress;

import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

public class WsServer extends WebSocketServer {
	
	public WsServer(int port) {
		super(new InetSocketAddress(port));
	}

	public WsServer(InetSocketAddress address) {
		super(address);
	}

	@Override
	public void onOpen(WebSocket socket, ClientHandshake handshake) {
		WsPool.addUser(socket);
	}

	
	@Override
	public void onClose(WebSocket socket, int code, String reason, boolean remote) {
		WsPool.removeUser(socket);
	}

	@Override
	public void onMessage(WebSocket socket, String message) {
		
	}

	@Override
	public void onError(WebSocket conn, Exception ex) {
		ex.printStackTrace();
	}

}