package com.examples.galochkin.githublookup.parser;

import android.content.Context;

import com.examples.galochkin.githublookup.R;
import com.examples.galochkin.githublookup.model.Repository;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASGalochkin on 24.05.2017
 * @version 1.0
 */

public class GitHubJSONParser {
    private static final String TAG = GitHubJSONParser.class.getCanonicalName();
    private final Context mContext;

    public GitHubJSONParser(Context context){
        mContext = context;
    }

    public List<Repository> parse(String jsonArray) {
        ArrayList<Repository> result = new ArrayList<>();
        try {
            JSONArray jArray = new JSONArray(jsonArray);

            for (int i = 0; i < jArray.length(); i++) {
                JSONObject jsonObject = jArray.getJSONObject(i);
                Repository rep = new Repository(
                        jsonObject.getString(mContext.getString(R.string.json_name)),
                        jsonObject.getString(mContext.getString(R.string.json_default_branch)),
                        jsonObject.getString(mContext.getString(R.string.json_svn_url)),
                        jsonObject.getString(mContext.getString(R.string.json_language))
                );
                result.add(rep);
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.add(new Repository(mContext.getString(R.string.user_not_exist), "", "", ""));
        }
        return result;
    }
}
