package org.wecancodeit.virtualtreetdd;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import org.wecancodeit.virtualtreetdd.Bean.QuestionType;

@Service
public class Populator implements CommandLineRunner {
	
	@Autowired
	BranchRepository branchRepo;
	
	@Autowired
	VirtualTreeRepository virtualTreeRepo;
	
	@Autowired
	ClusterRepository clusterRepo;
	
	@Autowired
	BeanRepository beanRepo;
	
	@Autowired
	LessonRepository lessonRepo;

	@Override
	public void run(String... args) throws Exception {
		
		VirtualTree javaTree = new VirtualTree("javaTree");
		
		Branch introTddBranch = new Branch("Intro To TDD", javaTree);
		
		Cluster clusterTdd = new Cluster("Introduction To Test Driven Development", introTddBranch);
	
		Bean tddQuestion1 = new Bean(clusterTdd, new Lesson(getLesson1Tdd(),null ), "1", QuestionType.MultipleChoice, getQuestion1Tdd(), getCorrectAnswer1Tdd(), getAnswersFor1Tdd());
		Bean tddQuestion2 = new Bean(clusterTdd, new Lesson(getLesson2Tdd(),null), "2", QuestionType.MultipleChoice, getQuestion2Tdd(), getCorrectAnswer2Tdd(), getAnswersFor2Tdd());
		Bean tddQuestion3 = new Bean(clusterTdd, new Lesson(getLesson3Tdd(),null), "3", QuestionType.FillInTheBlanks, getQuestion3Tdd(), getCorrectAnswer3Tdd(), getAnswersFor3Tdd());
		Bean tddQuestion4 = new Bean(clusterTdd, new Lesson(getLesson4Tdd(),null), "4", QuestionType.FillInTheBlanks, getQuestion4Tdd(), getCorrectAnswer4Tdd(), getAnswersFor4Tdd());
		Bean tddQuestion5 = new Bean(clusterTdd, new Lesson(getLesson5Tdd(), null), "5", QuestionType.TrueOrFalse, getQuestion5Tdd(), getCorrectAnswer5Tdd(), getAnswersFor5Tdd());
	}
	
	public String getLesson1Tdd() {
		return "Lesson 1\r\n" + 
				"\r\n" + 
				"Using Test Driven Development allows for the developer to constantly see that their code is working as intended. The process of creating a test for a piece of code that does not exist yet provides technical documentation for others working on the same project. This process allows developers on the same team to see what the code is doing and feel confident in themselves that they can refactor the code without breaking it. It is a disciplined approach that is based on the following:\r\n" + 
				"\r\n" + 
				"3 Laws of TDD are:\r\n" + 
				"\r\n" + 
				"Only write production code in order to make a failing unit test pass.\r\n" + 
				"\r\n" + 
				"Write no more of a test than that which is required to make it fail.\r\n" + 
				"\r\n" + 
				"Do not write more production code than is necessary to make a failing unit test pass.\r\n" + 
				"\r\n" + 
				"3 A’s of TDD are:\r\n" + 
				"Arrange\r\n" + 
				"Act\r\n" + 
				"Assert\r\n" + 
				"";
	}
	public String getLesson2Tdd() {
		return "Lesson 2\r\n" + 
				"\r\n" + 
				"Why do we use TDD?\r\n" + 
				" \r\n" + 
				"TDD creates documentation of our work and ensures that our code is doing what we expect it to do. TDD emphasises focusing on one piece of code at a time and is used to make code transmutable. This allows the programmer to write manageable code that is able to change as the program develops. TDD provides a roadmap of tested code for other programmers to reference and utilize for future testing and production.\r\n" + 
				"";
		
	}
	public String getLesson3Tdd() {
		return "Lesson 3\r\n" + 
				"\r\n" + 
				"---The 1st of the 3 A’s of TDD is to arrange. When you arrange, you are initializing and setting the values of the variables that you are about to test for in that block of code. For example:\r\n" + 
				"\r\n" + 
				"public class ArrangeExample{\r\n" + 
				"\r\n" + 
				"@Test\r\n" + 
				"public void wateringShouldGiveGrowthToYourTree()  {  \r\n" + 
				"    // arrange  \r\n" + 
				"    int currentGrowth = 10;  \r\n" + 
				"    int water = 1;  \r\n" + 
				"    int expectedGrowthAfterWatering = 11;  \r\n" + 
				"    VirtualTree testTree= new VirtualTree(\"testTree\", currentGrowth);\r\n" + 
				"	//act\r\n" + 
				"\r\n" + 
				"	//assert\r\n" + 
				" } \r\n" + 
				"";
		
	}
	public String getLesson4Tdd() {
		return "Lesson 4\r\n" + 
				"\r\n" + 
				"---The 2nd of the 3 A’s of TDD is to act. To act is to do something with the instantiated variables that we previously arranged. For example, we can call a method that modifies one of the variables. \r\n" + 
				"\r\n" + 
				"public class ActExample{\r\n" + 
				"\r\n" + 
				"@Test\r\n" + 
				"public void wateringShouldGiveGrowthToVirtualTree()  {  \r\n" + 
				"    // arrange  \r\n" + 
				"    int currentGrowth = 10;  \r\n" + 
				"    int waterAmount = 1;  \r\n" + 
				"    int expectedGrowthAfterWatering = 11;  \r\n" + 
				"    VirtualTree testTree= new VirtualTree(\"testTree\", currentGrowth);\r\n" + 
				"	//act\r\n" + 
				"	testTree.water(waterAmount)\r\n" + 
				"	Int actual  = testTree.getGrowth();\r\n" + 
				"\r\n" + 
				"	//assert\r\n" + 
				" } \r\n" + 
				"";
		
	}
	public String getLesson5Tdd() {
		return "Lesson 5\r\n" + 
				"\r\n" + 
				"---The 3rd of the 3 A’s of TDD is to assert. To assert is to verify that the action of the method is doing what we expected it to do . \r\n" + 
				"\r\n" + 
				"public class assertExample{\r\n" + 
				"\r\n" + 
				"@Test\r\n" + 
				"public void wateringShouldGiveGrowthToYourTree()  {  \r\n" + 
				"    // arrange  \r\n" + 
				"    int currentGrowth = 10;  \r\n" + 
				"    int waterAmount = 1;  \r\n" + 
				"    int expectedGrowthAfterWatering = 11;  \r\n" + 
				"    VirtualTree testTree= new VirtualTree(\"testTree\", currentGrowth);\r\n" + 
				"	//act\r\n" + 
				"	testTree.water(waterAmount);\r\n" + 
				"	Int actual  = testTree.getGrowth();\r\n" + 
				"\r\n" + 
				"	//assert\r\n" + 
				"assertThat(actual, is(equalTo(expectedGrowthAfterWatering) )   );\r\n" + 
				" } \r\n" + 
				"";
		
	}
	
	public String getQuestion1Tdd() {
		return "What is TDD?";
	}
	public String getQuestion2Tdd() {
		return "Why do we use TDD?";
	}
	public String getQuestion3Tdd() {
		return "The 1st of the 3 A’s of TDD is to _____. When you _____ in the context of TDD you are initializing and setting the values of the variables that you are about to test for in that block of code";
	}
	public String getQuestion4Tdd() {
		return "The 2nd of the 3 A’s of  TDD is to ___. To ___ is to call the method which we intend to test";
	}
	public String getQuestion5Tdd() {
		return "assertThat(actual, is(equalTo(expectedGrowthAfterWatering)));  will give you a passing test. True or False?";
	}
	public String getCorrectAnswer1Tdd() {
		return "d. TDD is the discipline of writing failing tests before production code throughout the entire application. ";
	}
	public String getCorrectAnswer2Tdd() {
		return "";
	}
	public String getCorrectAnswer3Tdd() {
		return "";
	}
	public String getCorrectAnswer4Tdd() {
		return "";
	}
	public String getCorrectAnswer5Tdd() {
		return "";
	}
	public Collection<String> getAnswersFor1Tdd() {
		ArrayList answers = new ArrayList();
		String answer1 = "a. TDD is a programming language. \r\n" + 
				"";
		String answer2 = "b. TDD is keeping your test as failing even though your code is working as you expect it to. ";
		String answer3 = "c. TDD is a style of writing code and then testing it. ";
		String answer4 = "d. TDD is the discipline of writing failing tests before production code throughout the entire application. ";
		return answers;
	}
	public Collection<String> getAnswersFor2Tdd() {
		
	}
	public Collection<String> getAnswersFor3Tdd() {
		
	}
	public Collection<String> getAnswersFor4Tdd() {
	
	}
	public Collection<String> getAnswersFor5Tdd() {
	
	}
}
