package com.intellect.springbootcud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * This configuration class has three responsibilities:
 * <ol>
 *     <li>It enables the auto configuration of the Spring application context.</li>
 *     <li>
 *         It ensures that Spring looks for other components (controllers, services, and repositories) from the
 *         <code>com.intellect.springbootcud.repository</code> package.
 *     </li>
 *     <li>It launches our application in the main() method.</li>
 * </ol>
 * @author Arun
 */
@SpringBootApplication
public class SpringbootcudApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootcudApplication.class, args);
	}
}
