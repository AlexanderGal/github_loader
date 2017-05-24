package com.examples.galochkin.githublookup.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.examples.galochkin.githublookup.R;
import com.examples.galochkin.githublookup.utils.TextWatcherImpl;

public class SearchUserActivity extends AppCompatActivity {
    private static final String TAG = SearchUserActivity.class.getCanonicalName();
    public static final String USERNAME = "Username";
    private EditText mUserTextView;
    private Button mSearchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_user);

        mUserTextView = (EditText) findViewById(R.id.user_name_textview);
        mSearchButton = (Button) findViewById(R.id.find_user_button);

        TextWatcherImpl textWatcher = new TextWatcherImpl(mSearchButton, mUserTextView);
        mUserTextView.addTextChangedListener(textWatcher);

        mSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SearchUserActivity.this, ListUserRepoActivity.class);
                intent.putExtra(USERNAME, mUserTextView.getText().toString());
                startActivity(intent);
            }
        });
    }
}
