/*
 * This is a full stack web/Java educational application designed to properly a user Test Driven Development
 * from start to finish. This self-education program also defines testing and the fundamental basics involved
 * in Java JUnit testing in conjunction with the Hamcrest & Mockito Libraries in particular. The website
 * contains a home/login page , profile page, a hierarchical structure for learning of trees , branches,
 * clusters, beans(questions). The questions are of type multiple choice , true or false, drag and drop, fill in the
 * blank. 
 * 
 * 
 * 
 * The application uses: Java,Spring,Hibernate,Thymleaf,HTML,CSS,JavaScript and JPA.
 * 
 * 
 * @Version: 1.0
 * @Author(s): Julian Perge, Jeanne Clair, Jaylen Guevara-Kirksey Bey, Kevin Cobb, Amal Ali, James Zebreski
 */


package org.wecancodeit.virtualtreetdd;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VirtualTreeTddApplication {

	public static void main(String[] args) {
		SpringApplication.run(VirtualTreeTddApplication.class, args);
	}
}
