package com.vschwarzer.github.service;

import com.vschwarzer.gitresume.data.GitData;
import com.vschwarzer.gitresume.service.GitDataService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Simple test case for the GitDataService
 * Created by Vincent Schwarzer on 03.11.15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfig.class})
public class GitDataServiceTest {

    @Autowired
    private GitDataService gitDataService;
    private final String fakeUser = "83kdkd8383jj";
    private final String user = "VincSch";


    @Test
    public void testRetrieveGitData() {
        GitData gitData = gitDataService.retrieveGitData(user);
        Assert.assertNotNull(gitData);
        Assert.assertEquals(gitData.getUser().getName(), "VincSch");

        GitData fakeGitData = gitDataService.retrieveGitData(fakeUser);
        Assert.assertTrue(fakeGitData.isInErrorState());
        Assert.assertEquals(fakeGitData.getError(), "The user doesn't exist!");
    }
}
