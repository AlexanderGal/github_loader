package com.examples.galochkin.githublookup.loader;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import com.examples.galochkin.githublookup.model.Repository;

import java.util.List;

/**
 * Created by ASGalochkin on 24.05.2017.
 */

public class RepositoryLoader extends AsyncTaskLoader<List<Repository>> {

    public RepositoryLoader(Context context) {
        super(context);
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<Repository> loadInBackground() {
        //todo make a parser
        return null;
    }

    @Override
    public void deliverResult(List<Repository> data) {
        super.deliverResult(data);
    }
}
