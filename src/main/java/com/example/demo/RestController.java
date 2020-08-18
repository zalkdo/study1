package com.example.demo;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {

	@GetMapping("/")
	public String hello() throws UnknownHostException, SocketException {
		String ips = "";
		Enumeration e = NetworkInterface.getNetworkInterfaces();
		while(e.hasMoreElements()){
			NetworkInterface n = (NetworkInterface) e.nextElement();
			Enumeration ee = n.getInetAddresses();
			while(ee.hasMoreElements()){
				InetAddress i = (InetAddress) ee.nextElement();
				if(!(i.isLoopbackAddress()||i.isLinkLocalAddress())&&i.isSiteLocalAddress())
					ips += "\t-"+n.getName() + " :: "+i.getHostAddress() + " \n";
			}
		}
//		InetAddress local = InetAddress.getLoopbackAddress();
//		InetAddress host  = InetAddress.getLocalHost();

//		return host.getHostName() + " :: " + host.getHostAddress() + " :: " + local.toString();
		return ips;
	}

}
