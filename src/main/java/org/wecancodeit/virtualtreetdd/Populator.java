package org.wecancodeit.virtualtreetdd;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class Populator implements CommandLineRunner {

  @Autowired BranchRepository branchRepo;

  @Autowired VirtualTreeRepository vTreeRepo;

  @Autowired ClusterRepository clusterRepo;

  @Autowired BeanRepository beanRepo;

  @Autowired LessonRepository lessonRepo;

  @Override // Command Line Runner method
  public void run(String... args) throws Exception {
    // Virtual tree for Java Testing & TDD
    VirtualTree javaTree = vTreeRepo.save(new VirtualTree("Java Tree", getTreeImages()));

    // First Branch
    Branch introTddBranch = branchRepo.save(new Branch("Introduction To TDD", javaTree));
    // 01Branch01Cluster
    Cluster clusterTdd =
        clusterRepo.save(new Cluster("Introduction To Test Driven Development", introTddBranch));

    Bean tddQuestion1 =
        beanRepo.save(
            new Bean(
                clusterTdd,
                lessonRepo.save(new Lesson(getLesson1Tdd(), null)),
                1,
                QuestionType.MultipleChoice,
                getQuestion1Tdd(),
                getCorrectAnswer1Tdd(),
                getAnswersFor1Tdd()));
    Bean tddQuestion2 =
        beanRepo.save(
            new Bean(
                clusterTdd,
                lessonRepo.save(new Lesson(getLesson2Tdd(), null)),
                2,
                QuestionType.MultipleChoice,
                getQuestion2Tdd(),
                getCorrectAnswer2Tdd(),
                getAnswersFor2Tdd()));
    Bean tddQuestion3 =
        beanRepo.save(
            new Bean(
                clusterTdd,
                lessonRepo.save(new Lesson(getLesson3Tdd(), null)),
                3,
                QuestionType.FillInTheBlanks,
                getQuestion3Tdd(),
                getCorrectAnswer3Tdd(),
                getAnswersFor3Tdd()));
    Bean tddQuestion4 =
        beanRepo.save(
            new Bean(
                clusterTdd,
                lessonRepo.save(new Lesson(getLesson4Tdd(), null)),
                4,
                QuestionType.FillInTheBlanks,
                getQuestion4Tdd(),
                getCorrectAnswer4Tdd(),
                getAnswersFor4Tdd()));
    Bean tddQuestion5 =
        beanRepo.save(
            new Bean(
                clusterTdd,
                lessonRepo.save(new Lesson(getLesson5Tdd(), null)),
                5,
                QuestionType.TrueOrFalse,
                getQuestion5Tdd(),
                getCorrectAnswer5Tdd(),
                getAnswersFor5Tdd()));

    // JUnit Branch, Second branch
    Branch jUnit = branchRepo.save(new Branch("Introduction to JUnit", javaTree));
    // JUnit 02Branch01Cluster
    Cluster clusterJUnit = clusterRepo.save(new Cluster("Introduction To JUnit Testing", jUnit));
    // JUnit Questions
    Bean jUnitQ1 =
        beanRepo.save(
            new Bean(
                clusterJUnit,
                lessonRepo.save(new Lesson(getLesson1JUnit(), "/images/Test_1_Error_Display.png")),
                6,
                QuestionType.MultipleChoice,
                getLesson1Question1JUnit(),
                getCorrectAnswerLesson1Answer1JUnit(),
                getAnswersForLesson1Answer1JUnit()));
    Bean jUnitQ2 =
        beanRepo.save(
            new Bean(
                clusterJUnit,
                lessonRepo.save(new Lesson(getLesson1JUnit(), "/images/Test_1_Error_Display.png")),
                7,
                QuestionType.TrueOrFalse,
                getLesson1Question2JUnit(),
                getCorrectAnswerLesson1Answer2JUnit(),
                getAnswersForLesson1Answer2JUnit()));
    Bean jUnitQ3 =
        beanRepo.save(
            new Bean(
                clusterJUnit,
                lessonRepo.save(new Lesson(getLesson1JUnit(), "/images/Test_1_Error_Display.png")),
                8,
                QuestionType.FillInTheBlanks,
                getLesson1Question3JUnit(),
                getCorrectAnswerLesson1Answer3JUnit(),
                getAnswersForLesson1Answer3JUnit()));
    Bean jUnitQ4 =
        beanRepo.save(
            new Bean(
                clusterJUnit,
                lessonRepo.save(new Lesson(getLesson1JUnit(), "/images/Test_1_Error_Display.png")),
                9,
                QuestionType.FillInTheBlanks,
                getLesson1Question4JUnit(),
                getCorrectAnswerLesson1Answer4JUnit(),
                getAnswersForLesson1Answer4JUnit()));
    Bean jUnitQ5 =
        beanRepo.save(
            new Bean(
                clusterJUnit,
                lessonRepo.save(new Lesson(getLesson1JUnit(), "/images/Test_1_Error_Display.png")),
                10,
                QuestionType.TrueOrFalse,
                getLesson1Question5JUnit(),
                getCorrectAnswerLesson1Answer5JUnit(),
                getAnswersForLesson1Answer5JUnit()));

    // This bean shows a passing 1st test
    Bean jUnitLesson02bean01 =
        beanRepo.save(
            new Bean(
                clusterJUnit,
                lessonRepo.save(new Lesson(getLesson2JUnit(), "/images/Test_1_Pass.png")),
                11,
                QuestionType.TrueOrFalse,
                getLesson1Question6JUnit(), // duplicate
                getCorrectAnswerLesson1Answer6JUnit(),
                getAnswersForLesson1Answer6JUnit()));

    //    new Bean(cluster, lesson, questionNum, type, question, correctAnswer, answers)

    // Hamcrest / JUnit transition 03Branch
    Branch hamcrest = branchRepo.save(new Branch("JUnit/Hamcrest Transition", javaTree));

    // Hamcrest & JUnit Cluster 03Branch01Cluster
    Cluster clusterHamcrestJUnit =
        clusterRepo.save(new Cluster("Introduction To Hamcrest/JUnit", jUnit));

    // Hamcrest & JUnit Beans
    Bean jUnitHamcrestQ1 =
        beanRepo.save(
            new Bean(
                clusterHamcrestJUnit,
                lessonRepo.save(
                    new Lesson(getLesson1JUnitHamcrest(), "/images/Test_2_Requirements.png")),
                12,
                QuestionType.MultipleChoice,
                getLesson1Question1JUnitHamcrest(),
                getCorrectAnswerLesson1Answer1JUnitHamcrest(),
                getAnswersForLesson1Answer1JUnitHamcrest()));
    Bean jUnitHamcrestQ2 =
        beanRepo.save(
            new Bean(
                clusterHamcrestJUnit,
                lessonRepo.save(
                    new Lesson(getLesson2JUnitHamcrest(), "/images/Test_2_Requirements.png")),
                13,
                QuestionType.TrueOrFalse,
                getLesson2Question1JUnitHamcrest(),
                getCorrectAnswerLesson2Answer1JUnitHamcrest(),
                getAnswersForLesson2Answer1JUnitHamcrest()));
    Bean jUnitHamcrestQ3 =
        beanRepo.save(
            new Bean(
                clusterHamcrestJUnit,
                lessonRepo.save(
                    new Lesson(getLesson2JUnitHamcrest(), "/images/Test_2_Requirements.png")),
                14,
                QuestionType.TrueOrFalse,
                getLesson2Question2JUnitHamcrest(),
                getCorrectAnswerLesson2Answer3JUnitHamcrest(),
                getAnswersForLesson2Answer2JUnitHamcrest()));
    Bean jUnitHamcrestQ4 =
        beanRepo.save(
            new Bean(
                clusterHamcrestJUnit,
                lessonRepo.save(
                    new Lesson(getLesson2JUnitHamcrest(), "/images/Test_2_Requirements.png")),
                15,
                QuestionType.MultipleChoice,
                getLesson2Question3JUnitHamcrest(),
                getCorrectAnswerLesson2Answer3JUnitHamcrest(),
                getAnswersForLesson2Answer3JUnitHamcrest()));
  }

  private String strAnswerTrue = "True";
  private String strAnswerFalse = "False";

  public Collection<String> getTreeImages() {
    ArrayList<String> treeImages = new ArrayList<String>();
    treeImages.add("/images/pre-tree.png");
    treeImages.add("/images/bean-1.png");
    treeImages.add("/images/bean-2.png");
    treeImages.add("/images/bean-3.png");
    treeImages.add("/images/bean-4.png");
    treeImages.add("/images/bean-5.png");
    treeImages.add("/images/bean-6.png");
    treeImages.add("/images/bean-7.png");
    treeImages.add("/images/bean-8.png");
    treeImages.add("/images/bean-9.png");
    treeImages.add("/images/bean-10.png");
    treeImages.add("/images/bean-11.png");
    treeImages.add("/images/bean-12.png");
    treeImages.add("/images/bean-13.png");
    treeImages.add("/images/bean-14.png");
    treeImages.add("/images/bean-15.png");
    return treeImages;
  }

  public String getLesson1Tdd() {
    return "<h1>Lesson 1</h1>"
        + "<p>Using Test Driven Development allows for the developer to constantly see that their code is working as intended. The process of creating a test for a piece of code that does not exist yet provides technical documentation for others working on the same project. This process allows developers on the same team to see what the code is doing and feel confident in themselves that they can refactor the code without breaking it. It is a disciplined approach that is based on the following:</p>"
        + "<h2>The 3 Laws of TDD are:</h2>"
        + "<ol>"
        + "<li>	Only write production code in order to make a failing unit test pass.</li>"
        + "<li>	Write no more of a test than that which is required to make it fail.</li>"
        + "<li>	Do not write more production code than is necessary to make a failing unit test pass.</li>"
        + "</ol>"
        + "<h2>The 3 A&#39;s of TDD are:</h2>"
        + "<ol>"
        + "<li>	Arrange</li>"
        + "<li>	Act</li>"
        + "<li>	Assert</li>"
        + "</ol>";
  }

  public String getLesson2Tdd() {
    return "<h1>Lesson 2</h1>"
        + "<h2>Why do we use TDD?</h2>"
        + "<ol>"
        + "<li>TDD creates documentation of our work and ensures that our code is doing what we expect it to do.</li>"
        + "<li>TDD emphasises focusing on one piece of code at a time and is used to make code transmutable.</li>"
        + "<li>This allows the programmer to write manageable code that is able to change as the program develops.</li>"
        + "<li>TDD provides a roadmap of tested code for other programmers to reference and utilize for future testing and production.</li>"
        + "</ol>";
  }

  public String getLesson3Tdd() {
    return "<h1>Lesson 3</h1>"
        + "<p>The 1st of the 3 A&#39;s of TDD is to arrange. When you arrange, you are initializing and setting the values of the variables that you are about to test for in that block of code. For example:</p>"
        + "<pre class=\"code\">"
        + "<p><span class='purple'>public class</span> ArrangeExample {</p>"
        + "<strong>	@Test</strong>"
        + "<p><span class='purple'>	public void</span> wateringShouldGiveGrowthToYourTree() {</p>"
        + "<strong class=\"triple-aaa-tdd\">		//arrange</strong>"
        + "<p>		int currentGrowth = 10;<p>"
        + "<p>		int water = 1;</p>"
        + "<p>		int expectedGrowthAfterWatering = 11;</p>"
        + "<p>		VirtualTree testTree = new VirtualTree(\"testTree\", currentGrowth);</p>"
        + "<p class=\"triple-aaa-tdd\">		//act</p>"
        + "<p class=\"triple-aaa-tdd\">		//assert</p>"
        + "<p>	}</p>"
        + "<p>}</p>"
        + "</pre>";
  }

  public String getLesson4Tdd() {
    return "<h1>Lesson 4</h1>"
        + "<p>The 2nd of the 3 A&#39;s of TDD is to act. To act is to do something with the instantiated variables that we previously arranged.</p>"
        + "<p>For example, we can call a method that modifies one of the variables.</p>"
        + "<pre class=\"code\">"
        + "<p><span class='purple'>public class</span> ActExample { </p>"
        + "<strong>	@Test</strong>"
        + "<p><span class='purple'>	public void</span> wateringShouldGiveGrowthToVirtualTree() {</p>"
        + "<p class=\\\"triple-aaa-tdd\\\">		//arrange</p>"
        + "<p>		int currentGrowth = 10;<p>"
        + "<p>		int waterAmount = 1;</p>"
        + "<p>		int expectedGrowthAfterWatering = 11;</p>"
        + "<p>		VirtualTree testTree= new VirtualTree(\"testTree\", currentGrowth);</p>"
        + "<strong class=\"triple-aaa-tdd\">		//act</strong>"
        + "<p>		testTree.water(waterAmount)</p>"
        + "<p>		int actualGrowth  = testTree.getGrowth();</p>"
        + "<p class=\"triple-aaa-tdd\">		//assert</p>"
        + "<p>	}</p>"
        + "<p>}</p>"
        + "</pre>";
  }

  public String getLesson5Tdd() {
    return "<h1>Lesson 5</h1>"
        + "<p>The 3rd of the 3 A&#39;s of TDD is to assert. To assert is to verify that the action of the method is doing what we expected it to do .</p>"
        + "<pre class=\"code\">"
        + "<p><span class='purple'>public class</span> AssertExample {</p>"
        + "<p>	@Test</p>"
        + "<p><span class='purple'>	public void</span> wateringShouldGiveGrowthToYourTree() {</p>"
        + "<p class=\"triple-aaa-tdd\">		//arrange</p>"
        + "<p>		int currentGrowth = 10;</p>"
        + "<p>		int waterAmount = 1;</p>"
        + "<p>		int expectedGrowthAfterWatering = 11;</p>"
        + "<p>		VirtualTree testTree= new VirtualTree(\"testTree\", currentGrowth);</p>"
        + "<p class=\"triple-aaa-tdd\">		//act</p>"
        + "<p>		testTree.water(waterAmount);</p>"
        + "<p>		int actualGrowth = testTree.getGrowth();</p>"
        + "<strong class=\"triple-aaa-tdd\">		//assert</strong>"
        + "<p>		assertThat(actualGrowth, is(equalTo(expectedGrowthAfterWatering)));</p>"
        + "<p>	}</p>"
        + "<p>}</p>"
        + "</pre>";
  }

  public String getQuestion1Tdd() {
    return "<h1 id=\"beanQuestion\">What is TDD?</h1>";
  }

  public String getQuestion2Tdd() {
    return "<h1 id=\"beanQuestion\">Why do we use TDD?</h1>";
  }

  public String getQuestion3Tdd() {
    return "<h1 id=\"beanQuestion\">The 1st of the 3 A&#39;s of TDD is to _____.</h1>"
        + "<h2>When you _____ in the context of TDD you are initializing and setting the values of the variables that you are about to test for in that block of code.</h2>";
  }

  public String getQuestion4Tdd() {
    return "<h1 id=\"beanQuestion\">The 2nd of the 3 A&#39;s of  TDD is to _____.</h1>"
        + "<h2>To _____ is to call the method which we intend to test.</h2>";
  }

  public String getQuestion5Tdd() {
    return "<h1 id=\"beanQuestion\">Based on the current lesson, the following code snippet will give us a passing test.</h1>"
        + "<h2>assertThat(actualAnswer, is(equalTo(expectedAnswer)));</h2>";
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
    return strAnswerTrue;
  }

  public Collection<String> getAnswersFor1Tdd() {
    ArrayList<String> answers = new ArrayList<String>();
    answers.add("TDD is a programming language.");
    answers.add(
        "TDD is keeping your test as failing even though your code is working as you expect it to.");
    answers.add("TDD is a style of writing code and then testing it.");
    answers.add(
        "TDD is the discipline of writing failing tests before production code throughout the entire application.");
    return answers;
  }

  public Collection<String> getAnswersFor2Tdd() {
    ArrayList<String> answers = new ArrayList<String>();
    answers.add(
        "We use TDD so that the code we produce is immutable and nothing can be added to the code.");
    answers.add("We use TDD to decrease the speed in which it takes for a project to be developed");
    answers.add("We use TDD to use less programmers when developing a project.");
    answers.add("We use TDD to make sure that our code is doing what we expect it to do.");
    return answers;
  }

  public Collection<String> getAnswersFor3Tdd() {
    ArrayList<String> answers = new ArrayList<String>();
    answers.add("assert");
    answers.add("act");
    answers.add("arrange");
    return answers;
  }

  public Collection<String> getAnswersFor4Tdd() {
    ArrayList<String> answers = new ArrayList<String>();
    answers.add("act");
    answers.add("arrange");
    answers.add("assert");
    return answers;
  }

  public Collection<String> getAnswersFor5Tdd() {
    ArrayList<String> answers = new ArrayList<String>();
    answers.add(strAnswerTrue);
    answers.add(strAnswerFalse);
    return answers;
  }

  // Beginning of JUnit Bean methods

  public String getLesson1JUnit() {
    return "<h1>Lesson 6</h1>"
        + "<ol class=\"noCode\">"
        + "<li>JUnit is a unit testing framework used in an IDE to determine if the code being tested is doing what you expect. There are many different assertion methods to determine a pass/fail. If a test fails in Eclipse, JUnit brings up a description of the issue: Red for failing, Green for passing. The testing methods are procedural. They do not return anything and do not take parameters.</li>"
        + "<li>This is an example of what a Junit testing bar looks like after running our failing test for the first time. The bar will then change to green once the production code has been written that will make the test pass.</li>"
        + "<li>This test is failing because the VirtualTree class does not exist. After we run the test and it fails, we then create the class.</li>"
        + "<li>The assertNotNull method used here is part of the JUnit library package. In this example,  we are asserting that the VirtualTree object exists, using the variable treeTest. In this case, treeTest is null because the VirtualTree class does not exist yet, so the test fails. This is how Test Driven Development proceeds throughout the build.</li>"
        + "<li>The <span class='bold'>@Test</span> annotation is needed to run the test through the JUnit console.</p>"
        + "</ol>";
  }

  public String getLesson2JUnit() {
    return "<h1>Lesson 7</h1>"
        + "<p>After we create the VirtualTree class,  we run our test again and get our first passing test.</p>";
  }

  // Questions JUnit
  public String getLesson1Question1JUnit() {
    return "<h1 id=\"beanQuestion\">What color does a failing JUnit test return in the JUnit console?</h1>";
  }

  public String getLesson1Question2JUnit() {
    return "<h1 id=\"beanQuestion\">If the class doesn't exist, the object instantiated will be equal to null and asserting that the Object is equal to null will make the test fail in JUnit.</h1>";
  }

  public String getLesson1Question3JUnit() {
    return "<h1 id=\"beanQuestion\">What annotation should be placed in the underlined section below?</h1>"
        + "<pre class=\"code\">"
        + "<p>____</p>"
        + "<p><span class='purple'>public void</span> shouldBeAbleToInstantiateClass() {</p>"
        + "<p>	Branch branch = new Branch();</p>"
        + "<p>	assertNotNull(branch);</p>"
        + "<p>}</p>"
        + "</pre>";
  }

  public String getLesson1Question4JUnit() {
    return "<h1 id=\"beanQuestion\">Which code snippet below would make our test valid if placed in the underlined section below?</h1>"
        + "<pre class=\"code\">"
        + "<p>@Test</p>"
        + "<p><span class='purple'>public void</span> shouldBeAbleToInstantiateClass() {</p>"
        + "<p>	Cluster cluster = new Cluster()</p>"
        + "<p>	______NotNull(cluster);</p>"
        + "<p>}</p>"
        + "</pre>";
  }

  public String getLesson1Question5JUnit() {
    return "<h1 id=\"beanQuestion\">JUnit is a testing framework used in an IDE to determine if code being tested is doing what it is expected to do.</h1>";
  }

  public String getLesson1Question6JUnit() {
    return "<h1 id=\"beanQuestion\">Our first passing test should always be the result of creating a new class.</h1>";
  }

  public String getCorrectAnswerLesson1Answer1JUnit() {
    return "Red";
  }

  public String getCorrectAnswerLesson1Answer2JUnit() {
    return strAnswerFalse;
  }

  public String getCorrectAnswerLesson1Answer3JUnit() {
    return "@Test";
  }

  public String getCorrectAnswerLesson1Answer4JUnit() {
    return "assert";
  }

  public String getCorrectAnswerLesson1Answer5JUnit() {
    return strAnswerTrue;
  }

  public String getCorrectAnswerLesson1Answer6JUnit() {
    return strAnswerTrue;
  }

  public Collection<String> getAnswersForLesson1Answer1JUnit() {
    ArrayList<String> answers = new ArrayList<String>();
    answers.add("Red");
    answers.add("Blue");
    answers.add("Yellow");
    answers.add("Green");
    return answers;
  }

  public Collection<String> getAnswersForLesson1Answer2JUnit() {
    ArrayList<String> answers = new ArrayList<String>();
    answers.add(strAnswerTrue);
    answers.add(strAnswerFalse);
    return answers;
  }

  public Collection<String> getAnswersForLesson1Answer3JUnit() {
    ArrayList<String> answers = new ArrayList<String>();
    answers.add("@Test");
    answers.add("@Annotation");
    answers.add("@Build");
    answers.add("@GeneratedValue");
    return answers;
  }

  public Collection<String> getAnswersForLesson1Answer4JUnit() {
    ArrayList<String> answers = new ArrayList<String>();
    answers.add("assert");
    answers.add("if ()");
    answers.add("assertIf");
    answers.add("this.");
    return answers;
  }

  public Collection<String> getAnswersForLesson1Answer5JUnit() {
    ArrayList<String> answers = new ArrayList<String>();
    answers.add(strAnswerTrue);
    answers.add(strAnswerFalse);
    return answers;
  }

  public Collection<String> getAnswersForLesson1Answer6JUnit() {
    ArrayList<String> answers = new ArrayList<String>();
    answers.add(strAnswerTrue);
    answers.add(strAnswerFalse);
    return answers;
  }

  // Questions JUnit/Hamcrest Beans

  public String getLesson1JUnitHamcrest() {
    return "<h1>Lesson 8</h1>"
        + "<p>Our 2nd test demonstrated here is failing as expected because our class does not have the getName() method, a constructor that can be built with a String parameter, or a String variable in our class to store the data.</p>";
  }

  public String getLesson2JUnitHamcrest() {
    return "<h1>Lesson 9</h1>"
        + "<ol class=\"noCode\">"
        + "<li>We are testing to check the properties of our object treeTest. The new method assertThat() uses Matchers from the Hamcrest library. The hamcrest library is used in conjunction with JUnit to make more flexible expressions of intent. For example, we use: assertThat([value] , [Matcher Statement]). The Matcher statement contains another value being compared.</li>"
        + "<li>The VirtualTree class is empty and contains no methods or constructors. We want the getName method, so we create a failing test first.</li>"
        + "<li>The Hamcrest method is() decorates a Matcher and makes it more expressive, so it reads like an English statement. We can chain Matcher statements together to make a desired expressive comparison statement. The not() method can be added inside of the is() method to make is(not( )). Example: assertThat(word,is(not(equalTo(words))));</li>"
        + "<li>The Hamcrest method equalTo() is checking to see if the first parameter is (equal to()) the second parameter.</li>"
        + "</ol>";
  }

  public String getLesson3JUnitHamcrest() {
    return "<h1>Lesson 10</h1>"
        + "<p>Once we add the constructor with a String parameter, the method getName() and we pass Java Tree as our String , the assertThat method will return a passing test.</p>";
  }

  // Lesson1
  // True or false
  public String getLesson1Question1JUnitHamcrest() {
    return "<h1 id=\"beanQuestion\">We run a failing test before we create a method (getter) necessary to retrieve information from other classes.</h1>";
  }

  // Lesson 2
  public String getLesson2Question1JUnitHamcrest() {
    return "<h1 id=\"beanQuestion\">What is required, at minimum, in the assertThat() JUnit method?</h1>";
  }

  public String getLesson2Question2JUnitHamcrest() {
    return "<h1 id=\"beanQuestion\">We can write the method getName() before our initial failing test.</h1>";
  }

  public String getLesson2Question3JUnitHamcrest() {
    return "<h1 id=\"beanQuestion\">We can chain Matcher statements to express different requirements.</h1>";
  }

  public String getLesson2Question4JUnitHamcrest() {
    return "<h1 id=\"beanQuestion\">What is the Hamcrest Library used for?</h1>";
  }

  // Correct Answer match Strings
  public String getCorrectAnswerLesson1Answer1JUnitHamcrest() {
    return strAnswerTrue;
  }

  public String getCorrectAnswerLesson2Answer1JUnitHamcrest() {
    return "A Value and Matcher statement";
  }

  public String getCorrectAnswerLesson2Answer2JUnitHamcrest() {
    return strAnswerFalse;
  }

  public String getCorrectAnswerLesson2Answer3JUnitHamcrest() {
    return strAnswerTrue;
  }

  public String getCorrectAnswerLesson2Answer4JUnitHamcrest() {
    return "Hamcrest matcher methods are used in conjunction with JUnit testing to make more expressive statements.";
  }

  public Collection<String> getAnswersForLesson1Answer1JUnitHamcrest() {
    ArrayList<String> answers = new ArrayList<String>();
    answers.add(strAnswerTrue);
    answers.add(strAnswerFalse);
    return answers;
  }

  public Collection<String> getAnswersForLesson2Answer1JUnitHamcrest() {
    ArrayList<String> answers = new ArrayList<String>();
    answers.add("A Value and Matcher statement");
    answers.add("Value");
    answers.add("A return method");
    answers.add("No minimum value");
    return answers;
  }

  public Collection<String> getAnswersForLesson2Answer2JUnitHamcrest() {
    ArrayList<String> answers = new ArrayList<String>();
    answers.add(strAnswerTrue);
    answers.add(strAnswerFalse);
    return answers;
  }

  public Collection<String> getAnswersForLesson2Answer3JUnitHamcrest() {
    ArrayList<String> answers = new ArrayList<String>();
    answers.add(strAnswerTrue);
    answers.add(strAnswerFalse);
    return answers;
  }

  public Collection<String> getAnswersForLesson2Answer4JUnitHamcrest() {
    ArrayList<String> answers = new ArrayList<String>();
    answers.add("Hamcrest Matcher methods are used by themselves to determine matching.");
    answers.add(
        "Hamcrest matcher methods are used in conjunction with JUnit testing to make more expressive statements.");
    answers.add("The Hamcrest library methods are used to alter values of variables.");
    answers.add("Hamcrest methods intrinsically increase the success rate of methods.");
    return answers;
  }
}
