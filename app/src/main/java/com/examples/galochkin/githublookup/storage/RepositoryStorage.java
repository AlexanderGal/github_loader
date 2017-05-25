package com.examples.galochkin.githublookup.storage;

import com.examples.galochkin.githublookup.model.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * Created by ASGalochkin on 25.05.2017.
 */

public class RepositoryStorage {
    private static final String TAG = RepositoryStorage.class.getCanonicalName();
    private final HashMap<String, List<Repository>> mRepoMap;

    public RepositoryStorage() {
        this.mRepoMap = new HashMap<>();
    }

    public List<Repository> getRepositoriesByUserName(String userName) {
        return mRepoMap.get(userName);
    }

    public void addRepositories(String userName, List<Repository> repositoryList) {
        mRepoMap.put(userName, repositoryList);
    }

    public HashMap<String, List<Repository>> getmRepoMap() {
        return mRepoMap;
    }
}
