package org.wecancodeit.virtualtreetdd.EntityTests;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.wecancodeit.virtualtreetdd.entity.VirtualTree;

public class VirtualTreeTest {

  @Mock private VirtualTree testTree;
  
  @Before
  public void treeSetup() { // test to show that new tree class is made
	  testTree = new VirtualTree("Java Tree", null);
  }

  @Test
  public void shouldBeAbleToCreateNewVirtualTree() { // test to show that a created tree exists
    assertNotNull(testTree);
  }

  @Test
  public void shouldHaveName() { // test to show that a tree has a name and that it's getter works
    assertThat(testTree.getName(), is(equalTo("Java Tree")));
  }

  @Test
  public void shouldHaveGrowthUnit() { // test to show that tree has a growth amount
	  assertNotNull(testTree.getGrowth());
  }
  
  @Test
  public void wateringTreeIncreasesGrowth() { // test to show that watering increases growth
	  testTree.water();
	  assertThat(testTree.getGrowth(), is(greaterThan(0)));
  } 
}
