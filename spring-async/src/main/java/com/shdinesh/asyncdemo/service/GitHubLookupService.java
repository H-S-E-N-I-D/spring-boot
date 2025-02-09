package com.shdinesh.asyncdemo.service;

import com.shdinesh.asyncdemo.model.GitRepo;
import com.shdinesh.asyncdemo.model.GitUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;


@Service
public class GitHubLookupService {
    private static final Logger logger = LoggerFactory.getLogger(GitHubLookupService.class);

    private final RestTemplate restTemplate;

    public GitHubLookupService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Async("asyncTaskExecutor")
    public CompletableFuture<GitUser> findUser(String user) throws InterruptedException {
        logger.info("Looking up user:" + user);
        String url = String.format("https://api.github.com/users/%s", user);
        GitUser results = restTemplate.getForObject(url, GitUser.class);
        // Artificial delay of 1s for demonstration purposes
        Thread.sleep(1000L);
        return CompletableFuture.completedFuture(results);
    }

    @Async("asyncTaskExecutor")
    public CompletableFuture<GitRepo> findRepo(String repo) throws InterruptedException {
        logger.info("Looking up repo: " + repo);
        String url = String.format("https://api.github.com/repos/%s", repo);
        GitRepo results = restTemplate.getForObject(url, GitRepo.class);
        // Artificial delay of 1s for demonstration purposes
        Thread.sleep(1000L);
        return CompletableFuture.completedFuture(results);
    }

}
