package org.wecancodeit.virtualtreetdd;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

public class BranchTest {

	@Mock
	Branch testBranch;

	@Before
	public void branchSetup() {

		testBranch = new Branch("Java Branch", new VirtualTree());

	}

	@Test
	public void shouldBeAbleToCreateNewBranch() {
		assertNotNull(testBranch);
	}

	@Test
	public void shouldHaveName() {
		assertThat(testBranch.getName(), is(equalTo("Java Branch")));
	}
	
	@Test
	public void shouldHaveVirtualTree () {
		assertNotNull(testBranch.getVirtualTree());
	}
}
