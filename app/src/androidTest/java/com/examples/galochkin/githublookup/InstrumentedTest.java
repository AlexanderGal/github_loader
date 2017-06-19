package com.examples.galochkin.githublookup;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.examples.galochkin.githublookup.model.Repository;
import com.examples.galochkin.githublookup.network.NetworkReader;
import com.examples.galochkin.githublookup.parser.GitHubJSONParser;
import com.examples.galochkin.githublookup.storage.RepositoryStorage;
import com.examples.galochkin.githublookup.storage.RepositoryStorageProvider;

import static org.hamcrest.CoreMatchers.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import static org.junit.Assert.*;


@RunWith(AndroidJUnit4.class)
public class InstrumentedTest {
    private Context mContext;
    private Repository mEmptyRepository;
    private String mJsonFromNet;
    private NetworkReader mNetworkReader;
    private RepositoryStorageProvider mRepositoryStorage;
    private LoaderTestMock mLoaderTestMock;

    @Before
    public void testPrepare() {
        mContext = InstrumentationRegistry.getTargetContext();
        mEmptyRepository = new Repository(mContext.getString(R.string.user_not_exist), "", "", "");
        mRepositoryStorage = ((RepositoryStorageProvider) mContext.getApplicationContext());
        mNetworkReader = new NetworkReader("AlexanderGal");
        mNetworkReader.readContentPage();
        mJsonFromNet = mNetworkReader.getReadedString();
        mLoaderTestMock = new LoaderTestMock(mContext, mNetworkReader, mRepositoryStorage);
    }

    @Test
    public void testParsingBadJSONFromString() {
        List<Repository> list = new GitHubJSONParser(mContext).parse("SOME BAD JSON");
        assertNotNull(list);
        assertThat(list.get(0), is(mEmptyRepository));
    }

    @Test
    public void testParsingNULL() {
        List<Repository> list = new GitHubJSONParser(mContext).parse(null);
        assertNotNull(list);
        assertThat(list.get(0), is(mEmptyRepository));
    }

    @Test
    public void testParsingGoodJSONFromString() throws IOException {
        List<Repository> list = new GitHubJSONParser(mContext).parse(parseJsonFromTestFile().toString());
        assertNotNull(list);
        assertThat(list, not(hasItem(mEmptyRepository)));
    }

    @Test
    public void testReadedStringFromNet() {
        assertNotNull(mJsonFromNet);
        assertThat(false, is(mJsonFromNet.isEmpty()));
    }

    @Test
    public void testParsingJSONFromNettwork() throws IOException {
        List<Repository> list = new GitHubJSONParser(mContext).parse(mJsonFromNet);
        assertNotNull(list);
        assertThat(list, not(hasItem(mEmptyRepository)));
    }

    @NonNull
    private StringBuilder parseJsonFromTestFile() {
        BufferedReader bufferedReader = null;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(InstrumentationRegistry.getTargetContext().getResources().getAssets().open("test")));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return stringBuilder;
    }

    @After
    public void clear() {
        mContext = null;
        mEmptyRepository = null;
        mJsonFromNet = null;
    }
}
