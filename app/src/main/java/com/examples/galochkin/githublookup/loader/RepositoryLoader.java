package com.examples.galochkin.githublookup.loader;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;
import android.util.Log;

import com.examples.galochkin.githublookup.model.Repository;
import com.examples.galochkin.githublookup.network.NetworkReader;
import com.examples.galochkin.githublookup.parser.GitHubJSONParser;
import com.examples.galochkin.githublookup.storage.RepositoryStorage;

import java.util.List;

/**
 * Created by ASGalochkin on 24.05.2017.
 */

public class RepositoryLoader extends AsyncTaskLoader<List<Repository>> {
    private static final String TAG = RepositoryLoader.class.getCanonicalName();
    private NetworkReader mNetworkReader;
    private RepositoryStorage mRepositoryStorage;
    private GitHubJSONParser mParser;

    public RepositoryLoader(Context context, RepositoryStorage repositoryStorage, NetworkReader mNetworkReader) {
        super(context);
        this.mRepositoryStorage = repositoryStorage;
        this.mNetworkReader = mNetworkReader;
        this.mParser = new GitHubJSONParser(context.getApplicationContext());
    }

    @Override
    protected void onStartLoading() {
        Log.e(TAG, "protected void onStartLoading()");
        forceLoad();
    }

    @Override
    public List<Repository> loadInBackground() {
        Log.e(TAG, "public List<Repository> loadInBackground()");
        mNetworkReader.readContentPage();

        mRepositoryStorage.addRepositories(mNetworkReader.getmUserLogin(),
                mParser.parse(mNetworkReader.getReadedString()));

        return mRepositoryStorage.getRepositoriesByUserName(mNetworkReader.getmUserLogin());
    }

    @Override
    public void deliverResult(List<Repository> data) {
        Log.e(TAG, "public void deliverResult(List<Repository> data)");
        super.deliverResult(data);
    }

    @Override
    protected void onReset() {
        Log.e(TAG, "protected void onReset()");
        onStopLoading();
        mNetworkReader = null;
        mRepositoryStorage = null;
        mParser = null;
    }
}
