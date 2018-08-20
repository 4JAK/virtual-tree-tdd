package org.wecancodeit.virtualtreetdd.EntityTests;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.wecancodeit.virtualtreetdd.entity.Branch;
import org.wecancodeit.virtualtreetdd.entity.VirtualTree;

public class BranchTest {

  @Mock private Branch testBranch;

  @Before
  public void branchSetup() { //shows that a branch is apart of a tree
    testBranch = new Branch("Java Branch", new VirtualTree("Java Tree", null));
  }

  @Test // should show that creating a new branch yields a new branch
  public void shouldBeAbleToCreateNewBranch() {
    assertNotNull(testBranch);
  }

  @Test // test to show that each branch has a name and is able to get that name
  public void shouldHaveName() {
    assertThat(testBranch.getName(), is(equalTo("Java Branch")));
  }

  @Test // test shows that a branch should have a virtual tree it is apart of
  public void shouldHaveVirtualTree() {
    assertNotNull(testBranch.getVirtualTree());
  }
}
