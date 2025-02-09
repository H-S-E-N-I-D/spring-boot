package com.shdinesh.asyncdemo.vo;

import com.shdinesh.asyncdemo.model.GitRepo;
import com.shdinesh.asyncdemo.model.GitUser;

import java.util.List;

public class UserResponse {
    private List<GitUser> userList;
    private List<GitRepo> repoList;

    public List<GitRepo> getRepoList() {
        return repoList;
    }

    public void setRepoList(List<GitRepo> repoList) {
        this.repoList = repoList;
    }

    public UserResponse(List<GitUser> userList, List<GitRepo> repoList) {
        this.userList = userList;
        this.repoList = repoList;
    }

    public List<GitUser> getUserList() {
        return userList;
    }

    public void setUserList(List<GitUser> userList) {
        this.userList = userList;
    }
}
