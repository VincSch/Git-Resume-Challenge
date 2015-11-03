package com.vschwarzer.gitresume.web.controller;

import com.vschwarzer.gitresume.data.GitData;
import com.vschwarzer.gitresume.service.GitDataService;
import com.vschwarzer.gitresume.web.controller.common.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * This spring controller represents the REST API used by the AngularJS app and retrieves git data for a user using the injected GitDataService
 * Created by Vincent Schwarzer on 03.11.15.
 */
@RestController
public class GitDataController extends BaseController {

    @Autowired
    GitDataService gitDataService;

    @RequestMapping(value = "/git/search", method = RequestMethod.POST, produces = "application/json")
    public GitData index(@RequestBody String username) {
        GitData gitData = gitDataService.retrieveGitData(username);
        return gitData;
    }


}
