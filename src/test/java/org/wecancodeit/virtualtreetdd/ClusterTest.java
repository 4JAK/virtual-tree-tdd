package org.wecancodeit.virtualtreetdd;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

public class ClusterTest {

	@Mock
	private Cluster testCluster;
	
	@Before
	public void clusterSetup() {
		testCluster = new Cluster("Java Cluster", new Branch());
	}
	
	@Test
	public void shouldBeAbleToCreateNewCluster() {
		assertNotNull(testCluster);
	}

	@Test
	public void shouldHaveName() {
		assertThat(testCluster.getName(), is(equalTo("Java Cluster")));
	}
	
	@Test
	public void clusterShouldHaveBranch () {
		assertNotNull(testCluster.getBranch());
	}
}
