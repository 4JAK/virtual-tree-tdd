package org.wecancodeit.virtualtreetdd;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
<<<<<<< HEAD
import static org.junit.Assert.assertTrue;
=======
import static org.mockito.BDDMockito.*;
>>>>>>> f8a37e68ee86a6dd7343153157cf2f4c7bdf4a11

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ApiControllerTest {

<<<<<<< HEAD
  @Resource TestRestTemplate restTemplate;

  @Mock private Bean testBean;

  @Test
  public void canary() {
    ResponseEntity<String> response = restTemplate.getForEntity("/", String.class);
    HttpStatus status = response.getStatusCode();
    assertThat(status, is(HttpStatus.OK));
  }

  // test to show that there is a path to virtual tree
  @Test
  public void shouldBeOkForVirtualTrees() {
    ResponseEntity<String> response = restTemplate.getForEntity("/api/virtualtrees", String.class);
    HttpStatus status = response.getStatusCode();
    assertThat(status, is(HttpStatus.OK));
  }

  // test to show that there is no other virtual tree currently
  @Test
  public void shouldNotBeOkayForVirtualTrees() {
    ResponseEntity<String> response =
        restTemplate.getForEntity("/api/virtualtrees/2", String.class);
    HttpStatus status = response.getStatusCode();
    assertThat(status, is(HttpStatus.NOT_FOUND));
  }

  // shows that there is a path to  branch that is apart of a tree
  @Test
  public void shouldBeOkForBranches() {
    ResponseEntity<String> response =
        restTemplate.getForEntity("/api/virtualtrees/1/branches", String.class);
    HttpStatus status = response.getStatusCode();
    assertThat(status, is(HttpStatus.OK));
  }

  // shows that wrong spelling of branch will bring up not found error
  @Test
  public void shouldNotBeOkayForBranches() {
    ResponseEntity<String> response =
        restTemplate.getForEntity("/api/virtualtrees/1/brances", String.class);
    HttpStatus status = response.getStatusCode();
    assertThat(status, is(HttpStatus.NOT_FOUND));
  }

  // test to show that there is a path to clusters
  @Test
  public void shouldBeOkForClusters() {
    ResponseEntity<String> response =
        restTemplate.getForEntity("/api/virtualtrees/1/branches/1/clusters", String.class);
    HttpStatus status = response.getStatusCode();
    assertThat(status, is(HttpStatus.OK));
  }

  @Test
  public void
      shouldNotBeOkayForClusters() { // test to show that wrong spelling of clusters will show not
    // found error
    ResponseEntity<String> response =
        restTemplate.getForEntity("/api/virtualtrees/1/branches/1/clustes", String.class);
    HttpStatus status = response.getStatusCode();
    assertThat(status, is(HttpStatus.NOT_FOUND));
  }

  @Test
  public void
      shouldBeOkForBeans() { // test to show that there is a pathway to beans from tree and branch
    // and cluster
    ResponseEntity<String> response =
        restTemplate.getForEntity("/api/virtualtrees/1/branches/1/clusters/1/beans", String.class);
    HttpStatus status = response.getStatusCode();
    assertThat(status, is(HttpStatus.OK));
  }

  @Test
  public void
      shouldNotBeOkayForBeans() { // test to show that wrong spelling of bean will return not found
    // page
    ResponseEntity<String> response =
        restTemplate.getForEntity("/api/virtualtrees/1/branches/1/clusters/1/bans", String.class);
    HttpStatus status = response.getStatusCode();
    assertThat(status, is(HttpStatus.NOT_FOUND));
  }

  @Test
  public void shouldBeOkForSingleBean() {
    ResponseEntity<String> response =
        restTemplate.getForEntity(
            "/api/virtualtrees/1/branches/1/clusters/1/beans/1", String.class);
    HttpStatus status = response.getStatusCode();
    assertThat(status, is(HttpStatus.OK));
  }

  @Test
  public void shouldNotBeOkayForSingleBean() {
    ResponseEntity<String> response =
        restTemplate.getForEntity("/api/virtualtrees/1/branches/1/clusters/1/bans/1", String.class);
    HttpStatus status = response.getStatusCode();
    assertThat(status, is(HttpStatus.NOT_FOUND));
  }

  @Test
  public void shouldBeOkForCheckAnswerOfBean() {
    ResponseEntity<String> response =
        restTemplate.getForEntity("/api/beans/1/checkanswer?answerToCheck=test1", String.class);
    HttpStatus status = response.getStatusCode();
    assertThat(status, is(HttpStatus.OK));
  }

  @Test
  public void shouldNotBeOkayForCheckAnswerOfBean() {
    ResponseEntity<String> response =
        restTemplate.getForEntity("/api/beeans/1/checkanswer?answerToCheck=test1", String.class);
    HttpStatus status = response.getStatusCode();
    assertThat(status, is(HttpStatus.NOT_FOUND));
  }

  @Test
  public void shouldReturnFalseForCorrectAnswerToBean() {
    ResponseEntity<String> response =
        restTemplate.getForEntity("/api/beans/1/checkanswer?answerToCheck=test1", String.class);
    String body = response.getBody();
    assertThat(body, is("false"));
  }

  @Test
  public void shouldReturnTrueForCorrectAnswerToBean() {
    ResponseEntity<String> response =
        restTemplate.getForEntity("/api/beans/5/checkanswer?answerToCheck=true", String.class);
    String body = response.getBody();
    assertThat(body, is("true"));
  }

  @Test
  public void shouldBeOkForNextBeanFromClusterCollection() {
    ResponseEntity<String> response =
        restTemplate.getForEntity(
            "/api/clusters/1/getnextbean?currentBeanQuestionNum=1", String.class);
    HttpStatus status = response.getStatusCode();
    assertThat(status, is(HttpStatus.OK));
  }

  // Our API call right now is checking a cluster for its beans,
  // so cluster 1 has 5 beans, but cluster 2 only has 4
  // Lets test trying to grab a question that doesn't exist in a cluster
  @Test
  public void shouldNotBeOkayForNextBeanFromClusterCollection() {
    ResponseEntity<String> response =
        restTemplate.getForEntity(
            "/api/clusters/1/getnextbean?currentBeanQuestionNum=5", String.class);
    // We're not testing the connection because we know the connection TO the API works.

    // response.getBody() being a Bean object, because that is what our API call is returning
    assertNull(response.getBody());
  }

  @Test
  public void shouldGetNextBeanFromClusterCollection() {
    ResponseEntity<String> response =
        restTemplate.getForEntity(
            "/api/clusters/1/getnextbean?currentBeanQuestionNum=3", String.class);
    // Since it's a bean object that we're returning,
    // we can check it's if it contains the questionNum property, which it should
    boolean body = response.getBody().contains("\"questionNum\":4");
    assertThat(body, is(true));
  }

  @Test
  public void shouldMakeIsCompletedVariableTrueForBean() {
    ResponseEntity<String> response =
        restTemplate.getForEntity("/api/beans/5/checkanswer?answerToCheck=true", String.class);
    assertThat(testBean.isCompletedQuestion(), is(true));
  }

  @Test
  public void shouldReturnJavaTreeCompletedPage() {
    ResponseEntity<String> response =
        restTemplate.getForEntity("/api/JavaTreeCompleted", String.class);
    HttpStatus status = response.getStatusCode();
    assertThat(status, is(HttpStatus.OK));
  }

  @Test
  public void shouldBeOkayForLastBeanInCluster() {
    ResponseEntity<String> response =
        restTemplate.getForEntity("/api/clusters/1/checkBean?beanId=1", String.class);
    HttpStatus status = response.getStatusCode();
    assertThat(status, is(HttpStatus.OK));
  }

  @Test
  public void shouldReturnTrueForLastBeanInCluster() {
    ResponseEntity<Boolean> response =
        restTemplate.getForEntity("/api/clusters/1/checkBean?beanId=5", Boolean.class);
    assertTrue(response.getBody());
  }

  @Test
  public void shouldReturnFalseForLastBeanInCluster() {
    ResponseEntity<Boolean> response =
        restTemplate.getForEntity("/api/clusters/1/checkBean?beanId=4", Boolean.class);
    assertFalse(response.getBody());
  }
=======
	@Resource
	TestRestTemplate restTemplate;
	
	
	@Autowired private BeanRepository beanRepo;
	  
	@Mock private Bean testBean;

	@Test
	public void canary() {
		ResponseEntity<String> response = restTemplate.getForEntity("/", String.class);
		HttpStatus status = response.getStatusCode();
		assertThat(status, is(HttpStatus.OK));
	}
	
	//test to show that there is a path to virtual tree
	@Test
	public void shouldBeOkForVirtualTrees() { 
		ResponseEntity<String> response = restTemplate.getForEntity("/api/virtualtrees", String.class);
		HttpStatus status = response.getStatusCode();
		assertThat(status, is(HttpStatus.OK));
	}

	@Test public void shouldNotBeOkayForVirtualTrees() { //test to show that there is no other virtual tree currently
		ResponseEntity<String> response = restTemplate.getForEntity("/api/virtualtrees/2", String.class);
		HttpStatus status = response.getStatusCode();
		assertThat(status, is(HttpStatus.NOT_FOUND));
	}

	@Test
	public void shouldBeOkForBranches() { //shows that there is a path to  branch that is apart of a tree
		ResponseEntity<String> response = restTemplate.getForEntity("/api/virtualtrees/1/branches", String.class);
		HttpStatus status = response.getStatusCode();
		assertThat(status, is(HttpStatus.OK));
	}

	@Test public void shouldNotBeOkayForBranches() { //shows that wrong spelling of branch will bring up not found error
		ResponseEntity<String> response = restTemplate.getForEntity("/api/virtualtrees/1/brances", String.class);
		HttpStatus status = response.getStatusCode();
		assertThat(status, is(HttpStatus.NOT_FOUND));
	}

	@Test
	public void shouldBeOkForClusters() { //test to show that there is a path to clusters
		ResponseEntity<String> response = restTemplate.getForEntity("/api/virtualtrees/1/branches/1/clusters", String.class);
		HttpStatus status = response.getStatusCode();
		assertThat(status, is(HttpStatus.OK));
	}
	
	@Test public void shouldNotBeOkayForClusters() { // test to show that wrong spelling of clusters will show not found error
		ResponseEntity<String> response = restTemplate.getForEntity("/api/virtualtrees/1/branches/1/clustes", String.class);
		HttpStatus status = response.getStatusCode();
		assertThat(status, is(HttpStatus.NOT_FOUND));
	}

	@Test
	public void shouldBeOkForBeans() { //test to show that there is a pathway to beans from tree and branch and cluster
		ResponseEntity<String> response = restTemplate.getForEntity("/api/virtualtrees/1/branches/1/clusters/1/beans", String.class);
		HttpStatus status = response.getStatusCode();
		assertThat(status, is(HttpStatus.OK));
	}
	
	@Test public void shouldNotBeOkayForBeans() { // test to show that wrong spelling of bean will return not found page
		ResponseEntity<String> response = restTemplate.getForEntity("/api/virtualtrees/1/branches/1/clusters/1/bans", String.class);
		HttpStatus status = response.getStatusCode();
		assertThat(status, is(HttpStatus.NOT_FOUND));
	}

	@Test
	public void shouldBeOkForSingleBean() {
		ResponseEntity<String> response = restTemplate.getForEntity("/api/virtualtrees/1/branches/1/clusters/1/beans/1",
				String.class);
		HttpStatus status = response.getStatusCode();
		assertThat(status, is(HttpStatus.OK));
	}

	@Test
	public void shouldNotBeOkayForSingleBean() {
		ResponseEntity<String> response = restTemplate.getForEntity("/api/virtualtrees/1/branches/1/clusters/1/bans/1",
				String.class);
		HttpStatus status = response.getStatusCode();
		assertThat(status, is(HttpStatus.NOT_FOUND));
	}

	@Test
	public void shouldBeOkForCheckAnswerOfBean() {
		ResponseEntity<String> response = restTemplate.getForEntity("/api/beans/1/checkanswer?answerToCheck=test1",
				String.class);
		HttpStatus status = response.getStatusCode();
		assertThat(status, is(HttpStatus.OK));
	}

	@Test
	public void shouldNotBeOkayForCheckAnswerOfBean() {
		ResponseEntity<String> response = restTemplate.getForEntity("/api/beeans/1/checkanswer?answerToCheck=test1",
				String.class);
		HttpStatus status = response.getStatusCode();
		assertThat(status, is(HttpStatus.NOT_FOUND));
	}

	@Test
	public void shouldReturnFalseForCorrectAnswerToBean() {
		ResponseEntity<String> response = restTemplate.getForEntity("/api/beans/1/checkanswer?answerToCheck=test1",
				String.class);
		String body = response.getBody();
		assertThat(body, is("false"));
	}

	@Test
	public void shouldReturnTrueForCorrectAnswerToBean() {
		ResponseEntity<String> response = restTemplate.getForEntity("/api/beans/5/checkanswer?answerToCheck=true",
				String.class);
		String body = response.getBody();
		assertThat(body, is("true"));
	}
	
	@Test
	public void shouldBeOkForNextBeanFromClusterCollection() {
		ResponseEntity<String> response = restTemplate.getForEntity("/api/clusters/1/getnextbean?currentBeanQuestionNum=1", String.class);
		HttpStatus status = response.getStatusCode();
		assertThat(status, is(HttpStatus.OK));
	}

	// Our API call right now is checking a cluster for its beans,
	// so cluster 1 has 5 beans, but cluster 2 only has 4
	// Lets test trying to grab a question that doesn't exist in a cluster
	@Test
	public void shouldNotBeOkayForNextBeanFromClusterCollection() {
		ResponseEntity<String> response = restTemplate.getForEntity("/api/clusters/1/getnextbean?currentBeanQuestionNum=5", String.class);
		// We're not testing the connection because we know the connection TO the API works.
		
		// response.getBody() being a Bean object, because that is what our API call is returning
		assertNull(response.getBody());
	}
	
	@Test
	public void shouldGetNextBeanFromClusterCollection() {
		ResponseEntity<String> response = restTemplate.getForEntity("/api/clusters/1/getnextbean?currentBeanQuestionNum=3", String.class);
		// Since it's a bean object that we're returning, 
		// we can check it's if it contains the questionNum property, which it should
		System.out.println(response.getBody());
		boolean body = response.getBody().contains("\"questionNum\":4"); 
		assertThat(body, is(true));
	}
	
	@Test
	public void shouldMakeIsCompletedVariableTrueForBean() {
		ResponseEntity<String> response = restTemplate.getForEntity("/api/beans/5/checkanswer?answerToCheck=true",
				String.class);
		
//		given(beanRepo.findOne(5L)).willReturn(testBean);
		
		assertThat(testBean.isCompletedQuestion() , is(true));
	}
	
	@Test
	public void shouldReturnJavaTreeCompletedPage() {
		ResponseEntity<String> response = restTemplate.getForEntity("/api/JavaTreeCompleted", String.class);
		HttpStatus status = response.getStatusCode();
		assertThat(status, is(HttpStatus.OK));
	}
	@Test
	public void shouldGetNextClusterFromBranchCollection() {
		ResponseEntity<String> response = restTemplate.getForEntity("/api/branches/1/getnextcluster?currentClusterId=1", String.class);
		boolean body = response.getBody().contains("\"id\":2"); 
		assertThat(body, is(true));
	}
>>>>>>> f8a37e68ee86a6dd7343153157cf2f4c7bdf4a11
}
