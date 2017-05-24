package com.examples.galochkin.githublookup.activity;

import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.examples.galochkin.githublookup.R;
import com.examples.galochkin.githublookup.adapter.RepositoryRecyclerAdapter;
import com.examples.galochkin.githublookup.loader.RepositoryLoader;
import com.examples.galochkin.githublookup.model.Repository;

import java.util.List;

public class ListUserRepoActivity extends AppCompatActivity {
    private static final String TAG = ListUserRepoActivity.class.getCanonicalName();
    private static final int LOADER_ID = 12343321;
    private ProgressBar mProgressBar;
    private RepositoryRecyclerAdapter mAdapter;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_user_repo);
        mAdapter = new RepositoryRecyclerAdapter();

        mProgressBar = (ProgressBar) findViewById(R.id.list_user_progressbar);
        mRecyclerView = (RecyclerView) findViewById(R.id.list_user_recyclerview);
        mRecyclerView.setAdapter(mAdapter);
    }

    class RepoLoaderCallback implements LoaderManager.LoaderCallbacks<List<Repository>> {

        @Override
        public Loader<List<Repository>> onCreateLoader(int id, Bundle args) {
            return new RepositoryLoader(ListUserRepoActivity.this);
        }

        @Override
        public void onLoadFinished(Loader<List<Repository>> loader, List<Repository> data) {
            mProgressBar.setVisibility(View.GONE);
            mAdapter.setData(data);
        }

        @Override
        public void onLoaderReset(Loader<List<Repository>> loader) {

        }
    }
}
