package com.examples.galochkin.githublookup.model;

/**
 * Created by ASGalochkin on 24.05.2017.
 */

public class Repository {
    private String mRepoName;
    private String mRepoBranch;
    private String mRepoUrl;
    private String mRepoLanguage;

    public Repository() {
    }

    public Repository(String mRepoName, String mRepoBranch, String mRepoUrl, String mRepoLanguage) {
        this.mRepoName = mRepoName;
        this.mRepoBranch = mRepoBranch;
        this.mRepoUrl = mRepoUrl;
        this.mRepoLanguage = mRepoLanguage;
    }

    public String getmRepoName() {
        return mRepoName;
    }

    public void setmRepoName(String mRepoName) {
        this.mRepoName = mRepoName;
    }

    public String getmRepoBranch() {
        return mRepoBranch;
    }

    public void setmRepoBranch(String mRepoBranch) {
        this.mRepoBranch = mRepoBranch;
    }

    public String getmRepoUrl() {
        return mRepoUrl;
    }

    public void setmRepoUrl(String mRepoUrl) {
        this.mRepoUrl = mRepoUrl;
    }

    public String getmRepoLanguage() {
        return mRepoLanguage;
    }

    public void setmRepoLanguage(String mRepoLanguage) {
        this.mRepoLanguage = mRepoLanguage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Repository that = (Repository) o;

        if (mRepoName != null ? !mRepoName.equals(that.mRepoName) : that.mRepoName != null)
            return false;
        if (mRepoBranch != null ? !mRepoBranch.equals(that.mRepoBranch) : that.mRepoBranch != null)
            return false;
        if (mRepoUrl != null ? !mRepoUrl.equals(that.mRepoUrl) : that.mRepoUrl != null)
            return false;
        return mRepoLanguage != null ? mRepoLanguage.equals(that.mRepoLanguage) : that.mRepoLanguage == null;
    }

    @Override
    public int hashCode() {
        int result = mRepoName != null ? mRepoName.hashCode() : 0;
        result = 31 * result + (mRepoBranch != null ? mRepoBranch.hashCode() : 0);
        result = 31 * result + (mRepoUrl != null ? mRepoUrl.hashCode() : 0);
        result = 31 * result + (mRepoLanguage != null ? mRepoLanguage.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Repository{" +
                "mRepoName='" + mRepoName + '\'' +
                ", mRepoBranch='" + mRepoBranch + '\'' +
                ", mRepoUrl='" + mRepoUrl + '\'' +
                ", mRepoLanguage='" + mRepoLanguage + '\'' +
                '}';
    }
}
