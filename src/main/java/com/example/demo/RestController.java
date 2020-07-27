package com.example.demo;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.web.bind.annotation.GetMapping; 

@org.springframework.web.bind.annotation.RestController
public class RestController {

	@GetMapping("/")
	public String hello() throws UnknownHostException {
		InetAddress local = InetAddress.getLoopbackAddress();
		InetAddress host  = InetAddress.getLocalHost();

		return host.getHostName() + " :: " + host.getHostAddress() + " :: " + local.toString();
	}

}
