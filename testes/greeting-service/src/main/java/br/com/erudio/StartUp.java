package br.com.erudio;

import br.com.erudio.config.GreetingConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(GreetingConfiguration.class)
public class StartUp {

	public static void main(String[] args) {
		SpringApplication.run(StartUp.class, args);
	}

}
