package com.examples.galochkin.githublookup.application;

import android.app.Application;

import com.examples.galochkin.githublookup.storage.RepositoryStorage;
import com.examples.galochkin.githublookup.storage.RepositoryStorageProvider;

/**
 * Created by ASGalochkin on 25.05.2017.
 */

public class GitHubLookUpApplication extends Application implements RepositoryStorageProvider {
    RepositoryStorage mRepositoryStorage;

    @Override
    public void onCreate() {
        super.onCreate();
        mRepositoryStorage = new RepositoryStorage();
    }

    @Override
    public RepositoryStorage getStorage() {
        return mRepositoryStorage;
    }
}
