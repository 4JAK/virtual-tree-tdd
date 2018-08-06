package org.wecancodeit.virtualtreetdd;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import org.wecancodeit.virtualtreetdd.Bean.QuestionType;

//@Service
public class Populator implements CommandLineRunner {

  @Autowired BranchRepository branchRepo;

  @Autowired VirtualTreeRepository vTreeRepo;

  @Autowired ClusterRepository clusterRepo;

  @Autowired BeanRepository beanRepo;

  @Autowired LessonRepository lessonRepo;

  @Override
  public void run(String... args) throws Exception {

    VirtualTree javaTree = vTreeRepo.save(new VirtualTree("javaTree"));

    Branch introTddBranch = branchRepo.save(new Branch("Intro To TDD", javaTree));

    Cluster clusterTdd =
        clusterRepo.save(new Cluster("Introduction To Test Driven Development", introTddBranch));

    Bean tddQuestion1 =
        beanRepo.save(
            new Bean(
                clusterTdd,
                lessonRepo.save(new Lesson(getLesson1Tdd(), null)),
                "1",
                QuestionType.MultipleChoice,
                getQuestion1Tdd(),
                getCorrectAnswer1Tdd(),
                getAnswersFor1Tdd()));
    Bean tddQuestion2 =
        beanRepo.save(
            new Bean(
                clusterTdd,
                lessonRepo.save(new Lesson(getLesson2Tdd(), null)),
                "2",
                QuestionType.MultipleChoice,
                getQuestion2Tdd(),
                getCorrectAnswer2Tdd(),
                getAnswersFor2Tdd()));
    Bean tddQuestion3 =
        beanRepo.save(
            new Bean(
                clusterTdd,
                lessonRepo.save(new Lesson(getLesson3Tdd(), null)),
                "3",
                QuestionType.FillInTheBlanks,
                getQuestion3Tdd(),
                getCorrectAnswer3Tdd(),
                getAnswersFor3Tdd()));
    Bean tddQuestion4 =
        beanRepo.save(
            new Bean(
                clusterTdd,
                lessonRepo.save(new Lesson(getLesson4Tdd(), null)),
                "4",
                QuestionType.FillInTheBlanks,
                getQuestion4Tdd(),
                getCorrectAnswer4Tdd(),
                getAnswersFor4Tdd()));
    Bean tddQuestion5 =
        beanRepo.save(
            new Bean(
                clusterTdd,
                lessonRepo.save(new Lesson(getLesson5Tdd(), null)),
                "5",
                QuestionType.TrueOrFalse,
                getQuestion5Tdd(),
                getCorrectAnswer5Tdd(),
                getAnswersFor5Tdd()));

    // JUnit Branch

    Branch jUnit = branchRepo.save(new Branch("Intro to JUnit", javaTree));
    // JUnit Cluster
    Cluster clusterJUnit = clusterRepo.save(new Cluster("Introduction To JUnit Testing", jUnit));
    // JUnit Questions Section 1/3
    Bean jUnitQ1 =
        beanRepo.save(
            new Bean(
                clusterJUnit,
                lessonRepo.save(new Lesson(getLesson1JUnit(), "Test_1_Error_Display.png")),
                "6",
                QuestionType.MultipleChoice,
                getLesson1Question1JUnit(),
                getCorrectAnswerLesson1Answer1JUnit(),
                getAnswersForLesson1Answer1JUnit()));
    Bean jUnitQ2 =
        beanRepo.save(
            new Bean(
                clusterJUnit,
                lessonRepo.save(new Lesson(getLesson1JUnit(), "Test_1_Error_Display.png")),
                "7",
                QuestionType.TrueOrFalse,
                getLesson1Question2JUnit(),
                getCorrectAnswerLesson1Answer2JUnit(),
                getAnswersForLesson1Answer2JUnit()));
    Bean jUnitQ3 =
        beanRepo.save(
            new Bean(
                clusterJUnit,
                lessonRepo.save(new Lesson(getLesson1JUnit(), "Test_1_Error_Display.png")),
                "8",
                QuestionType.FillInTheBlanks,
                getLesson1Question3JUnit(),
                getCorrectAnswerLesson1Answer3JUnit(),
                getAnswersForLesson1Answer3JUnit()));
    Bean jUnitQ4 =
        beanRepo.save(
            new Bean(
                clusterJUnit,
                lessonRepo.save(new Lesson(getLesson1JUnit(), "Test_1_Error_Display.png")),
                "9",
                QuestionType.FillInTheBlanks,
                getLesson1Question4JUnit(),
                getCorrectAnswerLesson1Answer4JUnit(),
                getAnswersForLesson1Answer4JUnit()));
    Bean jUnitQ5 =
        beanRepo.save(
            new Bean(
                clusterJUnit,
                lessonRepo.save(new Lesson(getLesson1JUnit(), "Test_1_Error_Display.png")),
                "10",
                QuestionType.TrueOrFalse,
                getLesson1Question5JUnit(),
                getCorrectAnswerLesson1Answer5JUnit(),
                getAnswersForLesson1Answer5JUnit()));

    // This bean shows a passing 1st test
    Bean jUnitLesson02bean01 =
        beanRepo.save(
            new Bean(
                clusterJUnit,
                lessonRepo.save(new Lesson(getLesson2JUnit(), "Test_1_Pass.png")),
                "11",
                QuestionType.TrueOrFalse,
                getLesson1Question5JUnit(),
                getCorrectAnswerLesson1Answer5JUnit(),
                getAnswersForLesson1Answer5JUnit()));

    // Hamcrest / JUnit transition Branch
    Branch hamcrest = branchRepo.save(new Branch("Hamcrest/JUnit", javaTree));

    // Hamcrest & JUnit Cluster
    Cluster clusterHamcrestJUnit =
        clusterRepo.save(new Cluster("Introduction To Hamcrest/JUnit", jUnit));

    // Hamcrest & JUnit Beans
    Bean jUnitHamcrestQ1 =
        beanRepo.save(
            new Bean(
                clusterHamcrestJUnit,
                lessonRepo.save(new Lesson(getLesson1JUnitHamcrest(), "Test_2_Requirements.png")),
                "12",
                QuestionType.MultipleChoice,
                getLesson1Question1JUnitHamcrest(),
                getCorrectAnswerLesson1Answer1JUnitHamcrest(),
                getAnswersForLesson1Answer1JUnitHamcrest()));
    Bean jUnitHamcrestQ2 =
        beanRepo.save(
            new Bean(
                clusterHamcrestJUnit,
                lessonRepo.save(new Lesson(getLesson2JUnitHamcrest(), "Test_2_Requirements.png")),
                "13",
                QuestionType.TrueOrFalse,
                getLesson2Question1JUnitHamcrest(),
                getCorrectAnswerLesson2Answer1JUnitHamcrest(),
                getAnswersForLesson2Answer1JUnitHamcrest()));
    Bean jUnitHamcrestQ3 =
        beanRepo.save(
            new Bean(
                clusterHamcrestJUnit,
                lessonRepo.save(new Lesson(getLesson2JUnitHamcrest(), "Test_2_Requirements.png")),
                "14",
                QuestionType.TrueOrFalse,
                getLesson2Question2JUnitHamcrest(),
                getCorrectAnswerLesson2Answer3JUnitHamcrest(),
                getAnswersForLesson2Answer2JUnitHamcrest()));
    Bean jUnitHamcrestQ4 =
        beanRepo.save(
            new Bean(
                clusterHamcrestJUnit,
                lessonRepo.save(new Lesson(getLesson2JUnitHamcrest(), "Test_2_Requirements.png")),
                "15",
                QuestionType.MultipleChoice,
                getLesson2Question3JUnitHamcrest(),
                getCorrectAnswerLesson2Answer3JUnitHamcrest(),
                getAnswersForLesson2Answer3JUnitHamcrest()));

//    Bean jUnitHamcrestLesson02bean01 =
//        beanRepo.save(
//            new Bean(
//                clusterHamcrestJUnit,
//                lessonRepo.save(new Lesson(getLesson1JUnitHamcrest(), "Test_2_Code_Added.png")),
//                "1",
//                QuestionType.MultipleChoice,
//                getLesson1Question1JUnitHamcrest(),
//                getCorrectAnswerLesson1Answer1JUnitHamcrest(),
//                getAnswersForLesson1Answer1JUnitHamcrest()));
  }

  public String getLesson1Tdd() {
    return "Lesson 1\r\n"
        + "\r\n"
        + "Using Test Driven Development allows for the developer to constantly see that their code is working as intended. The process of creating a test for a piece of code that does not exist yet provides technical documentation for others working on the same project. This process allows developers on the same team to see what the code is doing and feel confident in themselves that they can refactor the code without breaking it. It is a disciplined approach that is based on the following:\r\n"
        + "\r\n"
        + "3 Laws of TDD are:\r\n"
        + "\r\n"
        + "Only write production code in order to make a failing unit test pass.\r\n"
        + "\r\n"
        + "Write no more of a test than that which is required to make it fail.\r\n"
        + "\r\n"
        + "Do not write more production code than is necessary to make a failing unit test pass.\r\n"
        + "\r\n"
        + "3 A�s of TDD are:\r\n"
        + "Arrange\r\n"
        + "Act\r\n"
        + "Assert\r\n"
        + "";
  }

  public String getLesson2Tdd() {
    return "Lesson 2\r\n"
        + "\r\n"
        + "Why do we use TDD?\r\n"
        + " \r\n"
        + "TDD creates documentation of our work and ensures that our code is doing what we expect it to do. TDD emphasises focusing on one piece of code at a time and is used to make code transmutable. This allows the programmer to write manageable code that is able to change as the program develops. TDD provides a roadmap of tested code for other programmers to reference and utilize for future testing and production.\r\n"
        + "";
  }

  public String getLesson3Tdd() {
    return "Lesson 3\r\n"
        + "\r\n"
        + "---The 1st of the 3 A�s of TDD is to arrange. When you arrange, you are initializing and setting the values of the variables that you are about to test for in that block of code. For example:\r\n"
        + "\r\n"
        + "public class ArrangeExample{\r\n"
        + "\r\n"
        + "@Test\r\n"
        + "public void wateringShouldGiveGrowthToYourTree()  {  \r\n"
        + "    // arrange  \r\n"
        + "    int currentGrowth = 10;  \r\n"
        + "    int water = 1;  \r\n"
        + "    int expectedGrowthAfterWatering = 11;  \r\n"
        + "    VirtualTree testTree= new VirtualTree(\"testTree\", currentGrowth);\r\n"
        + "	//act\r\n"
        + "\r\n"
        + "	//assert\r\n"
        + " } \r\n"
        + "";
  }

  public String getLesson4Tdd() {
    return "Lesson 4\r\n"
        + "\r\n"
        + "---The 2nd of the 3 A�s of TDD is to act. To act is to do something with the instantiated variables that we previously arranged. For example, we can call a method that modifies one of the variables. \r\n"
        + "\r\n"
        + "public class ActExample{\r\n"
        + "\r\n"
        + "@Test\r\n"
        + "public void wateringShouldGiveGrowthToVirtualTree()  {  \r\n"
        + "    // arrange  \r\n"
        + "    int currentGrowth = 10;  \r\n"
        + "    int waterAmount = 1;  \r\n"
        + "    int expectedGrowthAfterWatering = 11;  \r\n"
        + "    VirtualTree testTree= new VirtualTree(\"testTree\", currentGrowth);\r\n"
        + "	//act\r\n"
        + "	testTree.water(waterAmount)\r\n"
        + "	Int actual  = testTree.getGrowth();\r\n"
        + "\r\n"
        + "	//assert\r\n"
        + " } \r\n"
        + "";
  }

  public String getLesson5Tdd() {
    return "Lesson 5\r\n"
        + "\r\n"
        + "---The 3rd of the 3 A�s of TDD is to assert. To assert is to verify that the action of the method is doing what we expected it to do . \r\n"
        + "\r\n"
        + "public class assertExample{\r\n"
        + "\r\n"
        + "@Test\r\n"
        + "public void wateringShouldGiveGrowthToYourTree()  {  \r\n"
        + "    // arrange  \r\n"
        + "    int currentGrowth = 10;  \r\n"
        + "    int waterAmount = 1;  \r\n"
        + "    int expectedGrowthAfterWatering = 11;  \r\n"
        + "    VirtualTree testTree= new VirtualTree(\"testTree\", currentGrowth);\r\n"
        + "	//act\r\n"
        + "	testTree.water(waterAmount);\r\n"
        + "	Int actual  = testTree.getGrowth();\r\n"
        + "\r\n"
        + "	//assert\r\n"
        + "assertThat(actual, is(equalTo(expectedGrowthAfterWatering) )   );\r\n"
        + " } \r\n"
        + "";
  }

  public String getQuestion1Tdd() {
    return "What is TDD?";
  }

  public String getQuestion2Tdd() {
    return "Why do we use TDD?";
  }

  public String getQuestion3Tdd() {
    return "The 1st of the 3's of TDD is to _____. When you _____ in the context of TDD you are initializing and setting the values of the variables that you are about to test for in that block of code";
  }

  public String getQuestion4Tdd() {
    return "The 2nd of the 3's of  TDD is to ___. To ___ is to call the method which we intend to test";
  }

  public String getQuestion5Tdd() {
    return "assertThat(actual, is(equalTo(expectedGrowthAfterWatering)));  will give you a passing test. True or False?";
  }

  public String getCorrectAnswer1Tdd() {
    return "TDD is the discipline of writing failing tests before production code throughout the entire application.";
  }

  public String getCorrectAnswer2Tdd() {
    return "We use TDD to make sure that our code is doing what we expect it to do.";
  }

  public String getCorrectAnswer3Tdd() {
    return "arrange";
  }

  public String getCorrectAnswer4Tdd() {
    return "act";
  }

  public String getCorrectAnswer5Tdd() {
    return "true";
  }

  public Collection<String> getAnswersFor1Tdd() {
    ArrayList<String> answers = new ArrayList<String>();
    String answer1 = "TDD is a programming language.";
    String answer2 =
        "TDD is keeping your test as failing even though your code is working as you expect it to.";
    String answer3 = "TDD is a style of writing code and then testing it.";
    String answer4 =
        "TDD is the discipline of writing failing tests before production code throughout the entire application.";
    answers.add(answer1);
    answers.add(answer2);
    answers.add(answer3);
    answers.add(answer4);
    return answers;
  }

  public Collection<String> getAnswersFor2Tdd() {
    ArrayList<String> answers = new ArrayList<String>();
    String answer1 =
        "We use TDD so that the code we produce is immutable and nothing can be added to the code.";
    String answer2 =
        "We use TDD to decrease the speed in which it takes for a project to be developed";
    String answer3 = "We use TDD to use less programmers when developing a project.";
    String answer4 = "We use TDD to make sure that our code is doing what we expect it to do.";
    answers.add(answer1);
    answers.add(answer2);
    answers.add(answer3);
    answers.add(answer4);
    return answers;
  }

  public Collection<String> getAnswersFor3Tdd() {
    ArrayList<String> answers = new ArrayList<String>();
    String answer1 = "arrange";
    String answer2 = "arrange";
    answers.add(answer1);
    answers.add(answer2);
    return answers;
  }

  public Collection<String> getAnswersFor4Tdd() {
    ArrayList<String> answers = new ArrayList<String>();
    String answer1 = "act";
    String answer2 = "act";
    answers.add(answer1);
    answers.add(answer2);
    return answers;
  }

  public Collection<String> getAnswersFor5Tdd() {
    ArrayList<String> answers = new ArrayList<String>();
    String answer = "true";
    String answer2 = "false";
    answers.add(answer);
    answers.add(answer2);
    return answers;
  }

  // Beginning of JUnit Bean methods

  // Lesson1 JUnit

  public String getLessonJUnit() {
    return "What is JUnit Testing?\n"
        + "JUnit is a unit testing framework used in an IDE to determine if the code being tested is doing what you expect. There are many different assertion methods to determine a pass/fail. If a test fails in Eclipse, JUnit brings up a description of the issue: Red for failing, Green for passing. The testing methods are procedural. They do not return anything and do not take parameters.\n"
        + "";
  }

  public String getLesson1JUnit() {
    return "1. This is an example of what a Junit testing bar looks like after running our failing test for the first time. The bar will then change to green once the production code has been written that will make the test pass.\n"
        + "2. This test is failing because the VirtualTree class does not exist. After we run the test and it fails, we then create the class.\n"
        + "3. The assertNotNull method used here is part of the JUnit library package. In this example,  we are asserting that the VirtualTree object exists, using the variable treeTest. In this case, treeTest is null because the VirtualTree class does not exist yet, so the test fails. This is how Test Driven Development proceeds throughout the build.\n"
        + "4. The @Test annotation is needed to run the test through the JUnit console.\n"
        + "";
  }

  public String getLesson2JUnit() {
    return "After we create the VirtualTree class,  we run our test again and get our first passing test.";
  }

  // Questions JUnit
  public String getLesson1Question1JUnit() {
    return "What color does a failing JUnit test return in the JUnit console?";
  }

  public String getLesson1Question2JUnit() {
    return "If the class doesn’t exist, the object instantiated will be equal to null and asserting that the Object is equal to null will make the test fail in JUnit.";
  }

  public String getLesson1Question3JUnit() {
    return "_____\n"
        + "Public void shouldBeAbleToInstantiateClass(){\n"
        + "\n"
        + "Branch branch = new Branch();\n"
        + "\n"
        + "assertNotNull(branch);\n"
        + "}\n"
        + "";
  }

  public String getLesson1Question4JUnit() {
    return "@Test\n"
        + "Public void shouldBeAbleToInstantiateClass(){\n"
        + "\n"
        + "Cluster cluster = new Cluster();\n"
        + "\n"
        + "______NotNull(cluster); \n"
        + "}\n"
        + "";
  }

  public String getLesson1Question5JUnit() {
    return "True or False";
  }

  public String getCorrectAnswerLesson1Answer1JUnit() {
    return "Red";
  }

  public String getCorrectAnswerLesson1Answer2JUnit() {
    return "False";
  }

  public String getCorrectAnswerLesson1Answer3JUnit() {
    return "@Test";
  }

  public String getCorrectAnswerLesson1Answer4JUnit() {
    return "assert";
  }

  public String getCorrectAnswerLesson1Answer5JUnit() {
    return "True";
  }

  public Collection<String> getAnswersForLesson1Answer1JUnit() {
    ArrayList<String> answers = new ArrayList<String>();
    String answer1 = "Red";
    String answer2 = "Blue";
    String answer3 = "Yellow";
    String answer4 = "Green";
    answers.add(answer1);
    answers.add(answer2);
    answers.add(answer3);
    answers.add(answer4);
    return answers;
  }

  public Collection<String> getAnswersForLesson1Answer2JUnit() {
    ArrayList<String> answers = new ArrayList<String>();
    String answer1 = "True";
    String answer2 = "False";

    answers.add(answer1);
    answers.add(answer2);

    return answers;
  }

  public Collection<String> getAnswersForLesson1Answer3JUnit() {
    ArrayList<String> answers = new ArrayList<String>();
    String answer1 = "@Test";
    String answer2 = "@Annotation";
    String answer3 = "@Build";
    String answer4 = "@GeneratedValue";

    answers.add(answer1);
    answers.add(answer2);
    answers.add(answer3);
    answers.add(answer4);

    return answers;
  }

  public Collection<String> getAnswersForLesson1Answer4JUnit() {
    ArrayList<String> answers = new ArrayList<String>();
    String answer1 = "assert";
    String answer2 = "if()";
    String answer3 = "assertIf";
    String answer4 = "this.";
    answers.add(answer1);
    answers.add(answer2);
    answers.add(answer3);
    answers.add(answer4);
    return answers;
  }

  public Collection<String> getAnswersForLesson1Answer5JUnit() {
    ArrayList<String> answers = new ArrayList<String>();
    String answer1 = "True";
    String answer2 = "False";

    answers.add(answer1);
    answers.add(answer2);

    return answers;
  }

  // Questions JUnit/Hamcrest Beans

  public String getLesson1JUnitHamcrest() {
    return "Our 2nd test demonstrated here is failing as expected because our class does not have the getName() method, a constructor that can be built with a String parameter, or a String variable in our class to store the data.";
  }

  public String getLesson2JUnitHamcrest() {
    return "1. We are testing to check the properties of our object treeTest. The new method assertThat() uses Matchers from the Hamcrest library. The hamcrest library is used in conjunction with JUnit to make more flexible expressions of intent. For example, we use: assertThat([value] , [Matcher Statement]). The Matcher statement contains another value being compared.\n"
        + "2. The VirtualTree class is empty and contains no methods or constructors. We want the getName method, so we create a failing test first.\n"
        + "3. The Hamcrest method is() decorates a Matcher and makes it more expressive, so it reads like an English statement. We can chain Matcher statements together to make a desired expressive comparison statement. The not() method can be added inside of the is() method to make is(not( )). Example: assertThat(word,is(not(equalTo(words))));\n"
        + "4. The Hamcrest method equalTo()is checking to see if the first parameter is (equal to()) the second parameter.";
  }

  public String getLesson3JUnitHamcrest() {
    return "Once we add the constructor with a String parameter, the method getName() and we pass Java Tree as our String , the assertThat method will return a passing test.";
  }

  // Lesson1
  // True or false
  public String getLesson1Question1JUnitHamcrest() {
    return "We run a failing test before we create the method(s) necessary to retrieve information from other classes. (Getters)";
  }
  // Lesson 2
  public String getLesson2Question1JUnitHamcrest() {
    return "What is required, at minimum, in the assertThat() JUnit method?";
  }

  public String getLesson2Question2JUnitHamcrest() {
    return "We can write the method getName() before our initial failing test.";
  }

  public String getLesson2Question3JUnitHamcrest() {
    return "We can chain Matcher statements to express different requirements.";
  }

  public String getLesson2Question4JUnitHamcrest() {
    return "What is the Hamcrest Library used for?";
  }
  // Correct Answer match Strings
  public String getCorrectAnswerLesson1Answer1JUnitHamcrest() {
    return "True";
  }

  public String getCorrectAnswerLesson2Answer1JUnitHamcrest() {
    return "A Value & Matcher statement.";
  }

  public String getCorrectAnswerLesson2Answer2JUnitHamcrest() {
    return "False";
  }

  public String getCorrectAnswerLesson2Answer3JUnitHamcrest() {
    return "True";
  }

  public String getCorrectAnswerLesson2Answer4JUnitHamcrest() {
    return "Hamcrest matcher methods are used in conjunction with JUnit testing to make more expressive statements.";
  }

  public Collection<String> getAnswersForLesson1Answer1JUnitHamcrest() {
    ArrayList<String> answers = new ArrayList<String>();
    String answer1 = "True";
    String answer2 = "False";
    answers.add(answer1);
    answers.add(answer2);
    return answers;
  }

  public Collection<String> getAnswersForLesson2Answer1JUnitHamcrest() {
    ArrayList<String> answers = new ArrayList<String>();
    String answer1 = "A Value & Matcher statement.";
    String answer2 = "Value";
    String answer3 = "A return method";
    String answer4 = "No minimum value";
    answers.add(answer1);
    answers.add(answer2);
    answers.add(answer3);
    answers.add(answer4);
    return answers;
  }

  public Collection<String> getAnswersForLesson2Answer2JUnitHamcrest() {
    ArrayList<String> answers = new ArrayList<String>();
    String answer1 = "True";
    String answer2 = "False";
    answers.add(answer1);
    answers.add(answer2);
    return answers;
  }

  public Collection<String> getAnswersForLesson2Answer3JUnitHamcrest() {
    ArrayList<String> answers = new ArrayList<String>();
    String answer1 = "True";
    String answer2 = "False";
    answers.add(answer1);
    answers.add(answer2);
    return answers;
  }

  public Collection<String> getAnswersForLesson2Answer4JUnitHamcrest() {
    ArrayList<String> answers = new ArrayList<String>();
    String answer1 = "Hamcrest Matcher methods are used by themselves to determine matching.";
    String answer2 =
        "Hamcrest matcher methods are used in conjunction with JUnit testing to make more expressive statements.";
    String answer3 = "The Hamcrest library methods are used to alter values of variables.";
    String answer4 = "Hamcrest methods intrinsically increase the success rate of methods.";
    answers.add(answer1);
    answers.add(answer2);
    answers.add(answer3);
    answers.add(answer4);
    return answers;
  }
}
