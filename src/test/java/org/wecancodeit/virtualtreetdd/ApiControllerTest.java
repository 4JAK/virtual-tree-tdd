package org.wecancodeit.virtualtreetdd;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ApiControllerTest {
	
	@Resource
	TestRestTemplate restTemplate;
	
	@Test
	public void canary() {
		ResponseEntity<String> response = restTemplate.getForEntity("/", String.class);
		HttpStatus status = response.getStatusCode();
		assertThat(status, is(HttpStatus.OK));
	}
	
	@Test
	public void shouldBeOkForVirtualTrees() {
		ResponseEntity<String> response = restTemplate.getForEntity("/api/virtualtrees", String.class);
		HttpStatus status = response.getStatusCode();
		assertThat(status, is(HttpStatus.OK));
	}
	
	@Test public void shouldNotBeOkayForVirtualTrees() {
		ResponseEntity<String> response = restTemplate.getForEntity("/api/virtualtrees/2", String.class);
		HttpStatus status = response.getStatusCode();
		assertThat(status, is(HttpStatus.NOT_FOUND));
	}
	
	@Test
	public void shouldBeOkForBranches() {
		ResponseEntity<String> response = restTemplate.getForEntity("/api/virtualtrees/1/branches", String.class);
		HttpStatus status = response.getStatusCode();
		assertThat(status, is(HttpStatus.OK));
	}
	
	@Test public void shouldNotBeOkayForBranches() {
		ResponseEntity<String> response = restTemplate.getForEntity("/api/virtualtrees/1/brances", String.class);
		HttpStatus status = response.getStatusCode();
		assertThat(status, is(HttpStatus.NOT_FOUND));
	}
	
	@Test
	public void shouldBeOkForClusters() {
		ResponseEntity<String> response = restTemplate.getForEntity("/api/virtualtrees/1/branches/1/clusters", String.class);
		HttpStatus status = response.getStatusCode();
		assertThat(status, is(HttpStatus.OK));
	}
	
	@Test public void shouldNotBeOkayForClusters() {
		ResponseEntity<String> response = restTemplate.getForEntity("/api/virtualtrees/1/branches/1/clustes", String.class);
		HttpStatus status = response.getStatusCode();
		assertThat(status, is(HttpStatus.NOT_FOUND));
	}
	
	@Test
	public void shouldBeOkForBeans() {
		ResponseEntity<String> response = restTemplate.getForEntity("/api/virtualtrees/1/branches/1/clusters/1/beans", String.class);
		HttpStatus status = response.getStatusCode();
		assertThat(status, is(HttpStatus.OK));
	}
	
	@Test public void shouldNotBeOkayForBeans() {
		ResponseEntity<String> response = restTemplate.getForEntity("/api/virtualtrees/1/branches/1/clusters/1/bans", String.class);
		HttpStatus status = response.getStatusCode();
		assertThat(status, is(HttpStatus.NOT_FOUND));
	}
	
	@Test
	public void shouldBeOkForSingleBean() {
		ResponseEntity<String> response = restTemplate.getForEntity("/api/virtualtrees/1/branches/1/clusters/1/beans/1", String.class);
		HttpStatus status = response.getStatusCode();
		assertThat(status, is(HttpStatus.OK));
	}
	
	@Test public void shouldNotBeOkayForSingleBean() {
		ResponseEntity<String> response = restTemplate.getForEntity("/api/virtualtrees/1/branches/1/clusters/1/bans/1", String.class);
		HttpStatus status = response.getStatusCode();
		assertThat(status, is(HttpStatus.NOT_FOUND));
	}
	
	@Test
	public void shouldBeOkForCheckAnswerOfBean() {
		ResponseEntity<String> response = restTemplate.getForEntity("/api/beans/1/checkanswer?answerToCheck=test1", String.class);
		HttpStatus status = response.getStatusCode();		
		assertThat(status, is(HttpStatus.OK));
	}
	
	@Test 
	public void shouldNotBeOkayForCheckAnswerOfBean() {
		ResponseEntity<String> response = restTemplate.getForEntity("/api/beeans/1/checkanswer?answerToCheck=test1", String.class);
		HttpStatus status = response.getStatusCode();
		assertThat(status, is(HttpStatus.NOT_FOUND));
	}
	
	@Test
	public void shouldReturnFalseForCorrectAnswerToBean() {
		ResponseEntity<String> response = restTemplate.getForEntity("/api/beans/1/checkanswer?answerToCheck=test1", String.class);
		String body = response.getBody();		
		assertThat(body, is("false"));
		
	}
	
	@Test
	public void shouldReturnTrueForCorrectAnswerToBean() {
		ResponseEntity<String> response = restTemplate.getForEntity("/api/beans/5/checkanswer?answerToCheck=true", String.class);
		String body = response.getBody();
		assertThat(body, is("true"));
	}
}
