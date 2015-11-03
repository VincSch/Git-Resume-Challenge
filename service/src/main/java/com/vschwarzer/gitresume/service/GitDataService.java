package com.vschwarzer.gitresume.service;

import com.vschwarzer.gitresume.data.GitData;

/**
 * Interface defining service methods
 * Created by Vincent Schwarzer on 03.11.15.
 */
public interface GitDataService {

    /**
     * Retrieve relevant data from the github api
     * @param username name of the user
     * @return git data
     */
    GitData retrieveGitData(String username);
}
