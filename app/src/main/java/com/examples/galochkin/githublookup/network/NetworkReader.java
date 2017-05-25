package com.examples.galochkin.githublookup.network;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by ASGalochkin on 25.05.2017
 *
 * @version 1.0
 */

public class NetworkReader {
    private static final String TAG = NetworkReader.class.getCanonicalName();
    private static final String REQUEST_METHOD = "GET";
    private static final String GITHUB_API_URL = "https://api.github.com/users/%s/repos";
    private URL mURL;
    private String mURLAdress;
    private String mUserLogin;
    private HttpURLConnection mHttpURLConnection;
    private BufferedReader mBufferedReader;
    private String mReadedString;

    public NetworkReader(String userLogin) {
        this.mUserLogin = userLogin;
    }

    public static String getTAG() {
        return TAG;
    }

    public void readContentPage() {
        mURLAdress = String.format(GITHUB_API_URL, mUserLogin);
        Log.e(TAG, "public String readContentPage(), url = " + mURLAdress);
        StringBuilder result = new StringBuilder();

        try {
            mURL = new URL(mURLAdress);
            mHttpURLConnection = (HttpURLConnection) mURL.openConnection();
            mHttpURLConnection.setRequestMethod(REQUEST_METHOD);
            mHttpURLConnection.connect();

            mBufferedReader = new BufferedReader(new InputStreamReader(mHttpURLConnection.getInputStream()));

            String line;
            while ((line = mBufferedReader.readLine()) != null) {
                result.append(line);
            }
            mReadedString = result.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (mHttpURLConnection != null) {
                mHttpURLConnection.disconnect();
            }
            if (mBufferedReader != null) {
                try {
                    mBufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        Log.e(TAG, "Readed content page: " + mReadedString);
    }

    public String getmURLAdress() {
        return mURLAdress;
    }

    public void setmURLAdress(String mURLAdress) {
        this.mURLAdress = mURLAdress;
    }

    public String getReadedString() {
        return mReadedString;
    }

    public String getmUserLogin() {
        return mUserLogin;
    }

    public void setmUserLogin(String mUserLogin) {
        this.mUserLogin = mUserLogin;
    }

    @Override
    public String toString() {
        return "NetworkReader{" +
                "mURL=" + mURL +
                ", mHttpURLConnection=" + mHttpURLConnection +
                ", mBufferedReader=" + mBufferedReader +
                ", mURLAdress='" + mURLAdress + '\'' +
                '}';
    }
}
