package com.examples.galochkin.githublookup.utils;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by ASGalochkin on 24.05.2017.
 */

public class TextWatcherImpl implements TextWatcher {
    private Button mButton;
    private TextView mTextView;

    public TextWatcherImpl(Button mButton, TextView mTextView) {
        this.mButton = mButton;
        this.mTextView = mTextView;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
    }

    @Override
    public void afterTextChanged(Editable s) {
        boolean isFiledFilled = true;
        if (TextUtils.isEmpty(mTextView.getText()))
            isFiledFilled = false;
        mButton.setEnabled(isFiledFilled);
    }
}
