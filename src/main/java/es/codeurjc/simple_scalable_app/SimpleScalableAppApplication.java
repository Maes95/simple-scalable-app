package es.codeurjc.simple_scalable_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication
@RestController
public class SimpleScalableAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleScalableAppApplication.class, args);
	}

	@GetMapping("/")
	public String getServerIP() {
		try {
			InetAddress inetAddress = InetAddress.getLocalHost();
			String ipAddress = inetAddress.getHostAddress();
			String hostname = inetAddress.getHostName();
			return "Server IP: " + ipAddress + "\nHostname: " + hostname;
		} catch (UnknownHostException e) {
			return "Unable to get IP address: " + e.getMessage();
		}
	}

}
