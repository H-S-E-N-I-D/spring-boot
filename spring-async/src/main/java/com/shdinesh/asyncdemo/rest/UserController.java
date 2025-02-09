package com.shdinesh.asyncdemo.rest;

import com.shdinesh.asyncdemo.model.GitRepo;
import com.shdinesh.asyncdemo.model.GitUser;
import com.shdinesh.asyncdemo.service.GitHubLookupService;
import com.shdinesh.asyncdemo.vo.UserRequest;
import com.shdinesh.asyncdemo.vo.UserResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);


    @Autowired
    private GitHubLookupService lookupService;

    @PostMapping("/user")
    public UserResponse findUserDetails(@RequestBody() UserRequest userRequest) throws InterruptedException, ExecutionException {
        // Start the clock
        long start = System.currentTimeMillis();

        List<String> futureList = userRequest.getUserList();
        List<GitUser> userList = new ArrayList<>();
        List<GitRepo> repoList = new ArrayList<>();

        CompletableFuture<GitUser> futureUser1 = lookupService.findUser(futureList.get(0));
        CompletableFuture<GitUser> futureUser2 = lookupService.findUser(futureList.get(1));

        CompletableFuture<GitRepo> futureRepo1 = lookupService.findRepo(futureList.get(2));
        CompletableFuture<GitRepo> futureRepo2 = lookupService.findRepo(futureList.get(3));

        CompletableFuture.allOf(futureUser1, futureUser2, futureRepo1, futureRepo2).join();

        // Print results, including elapsed time
        logger.info("Elapsed time: " + (System.currentTimeMillis() - start));
        GitUser user1 = futureUser1.get();
        GitUser user2 = futureUser2.get();
        GitRepo repo1 = futureRepo1.get();
        GitRepo repo2 = futureRepo2.get();

        userList.add(user1);
        userList.add(user2);
        repoList.add(repo1);
        repoList.add(repo2);

        return new UserResponse(userList, repoList);


    }
}
