package org.wecancodeit.virtualtreetdd;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class VirtualTreeRepositoryTest {

  @Autowired VirtualTreeRepository vTreeRepo;

  @Mock VirtualTree vTree;

  @Before
  public void saveTreeSetup() {
    vTree = vTreeRepo.save(new VirtualTree("Java"));
  }

  @Test
  public void shouldBeAbleToSaveVirtualTreeToRepo() throws Exception {
    assertNotNull(vTreeRepo.exists(1L));
  }

  @Test
  public void virtualTreeShouldHaveGeneratedId() {
    assertNotNull(vTreeRepo.findOne(1L));
  }
}
