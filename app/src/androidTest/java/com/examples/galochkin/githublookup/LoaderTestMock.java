package com.examples.galochkin.githublookup;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;

import com.examples.galochkin.githublookup.loader.RepositoryLoader;
import com.examples.galochkin.githublookup.model.Repository;
import com.examples.galochkin.githublookup.network.NetworkReader;
import com.examples.galochkin.githublookup.storage.RepositoryStorage;
import com.examples.galochkin.githublookup.storage.RepositoryStorageProvider;

import java.util.List;

/**
 * Created by CaraTaker88 on 19.06.2017.
 */

public class LoaderTestMock implements LoaderManager.LoaderCallbacks<List<Repository>> {
    private final Context mContext;
    private final NetworkReader mNetworkReader;
    private final RepositoryStorageProvider mRepositoryStorage;
    public List<Repository> result = null;


    public LoaderTestMock(Context mContext, NetworkReader mNetworkReader, RepositoryStorageProvider mRepositoryStorage) {
        this.mContext = mContext;
        this.mNetworkReader = mNetworkReader;
        this.mRepositoryStorage = mRepositoryStorage;
    }

    @Override
    public Loader<List<Repository>> onCreateLoader(int id, Bundle args) {
        return new RepositoryLoader(mContext, mRepositoryStorage.getStorage(), mNetworkReader);
    }

    @Override
    public void onLoadFinished(Loader<List<Repository>> loader, List<Repository> data) {
        result = data;
    }

    @Override
    public void onLoaderReset(Loader<List<Repository>> loader) {
    }
}
