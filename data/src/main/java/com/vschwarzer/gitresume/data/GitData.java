package com.vschwarzer.gitresume.data;

import java.util.HashMap;
import java.util.Map;

/**
 * Is used as data transfer object and holds all relevant information retrieved from the github api
 * Created by Vincent Schwarzer on 02.11.15.
 */
public class GitData {

    private UserDetail user;
    private Map<String, Integer> usedLanguages = new HashMap<>();
    private boolean isInErrorState = false;
    private String error;

    public UserDetail getUser() {
        return user;
    }

    public void setUser(UserDetail user) {
        this.user = user;
    }

    public Map<String, Integer> getUsedLanguages() {
        return usedLanguages;
    }

    public void setUsedLanguages(Map<String, Integer> usedLanguages) {
        this.usedLanguages = usedLanguages;
    }

    public boolean isInErrorState() {
        return isInErrorState;
    }

    public void setInErrorState(boolean isInErrorState) {
        this.isInErrorState = isInErrorState;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
