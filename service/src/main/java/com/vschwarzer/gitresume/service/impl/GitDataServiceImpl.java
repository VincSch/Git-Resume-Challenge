package com.vschwarzer.gitresume.service.impl;

import com.vschwarzer.gitresume.data.GitData;
import com.vschwarzer.gitresume.data.UserDetail;
import com.vschwarzer.gitresume.service.GitDataService;
import com.vschwarzer.gitresume.service.common.BaseService;
import org.eclipse.egit.github.core.Repository;
import org.eclipse.egit.github.core.User;
import org.eclipse.egit.github.core.client.RequestException;
import org.eclipse.egit.github.core.service.RepositoryService;
import org.eclipse.egit.github.core.service.UserService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Service implementation to retrieve user data from the github api using the org.eclipse.egit.github project
 * Created by Vincent Schwarzer on 03.11.15.
 */
@Service
public class GitDataServiceImpl extends BaseService implements GitDataService {


    /**
     * {@inheritDoc }
     */
    @Override
    public GitData retrieveGitData(String username) {
        GitData gitData = new GitData();
        List<Repository> repositories;
        User user;

        try {
            RepositoryService repositoryService = new RepositoryService();
            UserService userService = new UserService();
            repositories = repositoryService.getRepositories(username);
            user = userService.getUser(username);
            prepareData(gitData, repositories, user);
        } catch (RequestException rq) {
            gitData.setInErrorState(true);
            gitData.setError("The user doesn't exist!");
            LOG.debug("The user doesn't exist!");
        } catch (IOException io) {
            gitData.setInErrorState(true);
            gitData.setError("Something went wrong while trying to interact with the GitHub service!");
            LOG.debug("Something went wrong while trying to interact with the GitHub service!");
            io.printStackTrace();
        }

        return gitData;
    }

    private void prepareData(GitData gitData, List<Repository> repositories, User user) throws IOException {
        UserDetail userDetail = new UserDetail();
        userDetail.setName(user.getLogin());
        userDetail.setAvatarUrl(user.getAvatarUrl());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        userDetail.setCreatedAt(simpleDateFormat.format(user.getCreatedAt()));
        userDetail.setEmail(user.getEmail());
        userDetail.setFollower(user.getFollowers());
        userDetail.setDiskUsage(user.getDiskUsage());

        gitData.setUser(userDetail);

        Map<String, Integer> usedLanguages = new HashMap<>();
        for (Repository repository : repositories) {
            String language = (repository.getLanguage() == null) ? "Unknown" : repository.getLanguage();
            if (usedLanguages.containsKey(language)) {
                int count = usedLanguages.get(language);
                usedLanguages.replace(language, ++count);
            } else {
                usedLanguages.put(language, 1);
            }
        }

        gitData.setUsedLanguages(usedLanguages);
    }

}
