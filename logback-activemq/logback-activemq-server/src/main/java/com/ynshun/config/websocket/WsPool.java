package com.ynshun.config.websocket;

import java.util.HashSet;
import java.util.Set;

import org.java_websocket.WebSocket;

public class WsPool {
	private static final Set<WebSocket> sockets = new HashSet<WebSocket>();

	
	public static void addUser(WebSocket socket) {
		sockets.add(socket);
	}

	
	public static boolean removeUser(WebSocket socket) {
		sockets.remove(socket);
		return true;
	}

	
	public static void sendMessageToAll(String message) {
		for (WebSocket socket : sockets) {
			socket.send(message);
		}
	}
}