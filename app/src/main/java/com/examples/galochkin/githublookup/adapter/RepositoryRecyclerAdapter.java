package com.examples.galochkin.githublookup.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.examples.galochkin.githublookup.R;
import com.examples.galochkin.githublookup.model.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASGalochkin on 24.05.2017.
 */

public class RepositoryRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final List<Repository> mRepositoryList;

    public RepositoryRecyclerAdapter() {
        this.mRepositoryList = new ArrayList<>();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_repo_item, parent, false);
        return new ViewHolder(view);
    }

    public void setData(List<Repository> data) {
        mRepositoryList.clear();
        mRepositoryList.addAll(data);
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Repository repository = mRepositoryList.get(position);
        ((ViewHolder) holder).setText(
                repository.getmRepoName(),
                repository.getmRepoBranch(),
                repository.getmRepoUrl(),
                repository.getmRepoLanguage()
        );
    }

    @Override
    public int getItemCount() {
        return mRepositoryList.size();
    }

    private class ViewHolder extends RecyclerView.ViewHolder {
        TextView mRepoNamelTextView;
        TextView mRepoBranchTextView;
        TextView mRepoUrlTextView;
        TextView mRepoLanguageTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            mRepoNamelTextView = (TextView) itemView.findViewById(R.id.repo_name_textview);
            mRepoBranchTextView = (TextView) itemView.findViewById(R.id.default_branch_textview);
            mRepoUrlTextView = (TextView) itemView.findViewById(R.id.url_textview);
            mRepoLanguageTextView = (TextView) itemView.findViewById(R.id.language_textview);
        }

        void setText(String repoName, String repoBranch, String repoUrl, String repoLanguage) {
            mRepoNamelTextView.setText(repoName);
            mRepoBranchTextView.setText(repoBranch);
            mRepoUrlTextView.setText(repoUrl);
            mRepoLanguageTextView.setText(repoLanguage);
        }
    }
}
