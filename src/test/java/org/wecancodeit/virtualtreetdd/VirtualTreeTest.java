package org.wecancodeit.virtualtreetdd;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

public class VirtualTreeTest {

  @Mock private VirtualTree testTree;
  
  @Before
  public void treeSetup() {
	  testTree = new VirtualTree("Java Tree");
  }

  @Test
  public void shouldBeAbleToCreateNewVirtualTree() {
    assertNotNull(testTree);
  }

  @Test
  public void shouldHaveName() {
    assertThat(testTree.getName(), is(equalTo("Java Tree")));
  }

  @Test
  public void shouldHaveGrowthUnit() {
	  assertNotNull(testTree.getGrowth());
  }
  
  @Test
  public void wateringTreeIncreasesGrowth() {
	  testTree.water();
	  assertThat(testTree.getGrowth(), is(greaterThan(0)));
  } 
}
