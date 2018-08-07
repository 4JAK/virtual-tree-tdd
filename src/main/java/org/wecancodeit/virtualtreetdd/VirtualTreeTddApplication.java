/*
 * PlanT'DD is a full-stack web application and Test Driven Development educational tool. This self-learning program takes you through the 
 * fundamentals of Java JUnit testing with the Hamcrest and Mockito Libraries. The website contains a login page, profile page, and lessons 
 * on the creation of a Virtual Tree through TDD. Users must correctly answer questions before they can proceed to the next lesson.
 * The questions are either multiple choice , true or false, drag and drop, or fill in the blank. With each correct answer, the user's 
 * Virtual Tree sapling matures into a full-grown tree. Once the lessons are finished, the user will receive a certificate of completion.
 * 
 * The application uses: Java,Spring,Hibernate,Thymleaf,HTML,CSS,JavaScript and JPA.
 * 
 * @Version: 1.0
 *
 * @Authors: Julian Perge, Jeanne Clair, Jaylen Guevara-Kirksey Bey, Kevin Cobb, Amal Ali, and James Zebreski
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
