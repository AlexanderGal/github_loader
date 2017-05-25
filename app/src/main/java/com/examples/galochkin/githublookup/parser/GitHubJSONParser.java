package com.examples.galochkin.githublookup.parser;

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

    public List<Repository> parse(String jsonArray) {

        ArrayList<Repository> result = new ArrayList<>();
        try {
            JSONArray jArray = new JSONArray(jsonArray);

            for (int i = 0; i < jArray.length(); i++) {
                JSONObject jsonObject = jArray.getJSONObject(i);
                Repository rep = new Repository(
                        jsonObject.getString("name"),
                        jsonObject.getString("default_branch"),
                        jsonObject.getString("svn_url"),
                        jsonObject.getString("language")
                );
                result.add(rep);
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.add(new Repository("Пользователя не существует :(", "", "", ""));
        }
        return result;
    }
}
