package com.example.demo;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.web.bind.annotation.GetMapping; 

@org.springframework.web.bind.annotation.RestController
public class RestController {

	@GetMapping("/")
	public String hello(){
		String serverInfo = "";
		InetAddress local;
		try {
			local = InetAddress.getLocalHost();
			serverInfo = local.getHostName() + " :: " + local.getHostAddress();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return serverInfo;
	}

}
