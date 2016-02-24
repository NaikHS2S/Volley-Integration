package com.telstra.imagelist;

import android.app.Instrumentation;
import android.support.annotation.NonNull;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.ListView;

import com.telstra.imagelist.network.model.SingleUserInfo;
import com.telstra.imagelist.ui.activity.TxMainActivity;
import com.telstra.imagelist.ui.adapter.TxListAdapter;

import java.util.ArrayList;

public class ActivityTests extends ActivityInstrumentationTestCase2<TxMainActivity> {
    private Instrumentation mInstrumentation;
    private ListView list;

    public ActivityTests() {
        super(TxMainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        setActivityInitialTouchMode(true);
        mInstrumentation = getInstrumentation();
        list = (ListView) getActivity().findViewById(R.id.list);
    }

    public void testLoadsTxMainActivity() {
        // Set up Activity Monitor
        Instrumentation.ActivityMonitor mTxActivityMonitor =
                mInstrumentation.addMonitor(TxMainActivity.class.getName(),
                        null, false);

        assertNotNull("The list was not loaded", list);

        int expectedCount = 10;
        int actualCount = list.getAdapter().getCount();
        assertNotSame(expectedCount, actualCount);

        getActivity().runOnUiThread(
                new Runnable() {
                    @Override
                    public void run() {
                        list.setAdapter(new TxListAdapter(getActivity(), getUsersInformation()));
                    }
                }
        );

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assertEquals(3, list.getAdapter().getCount());

        getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {

                list.performItemClick(list.getAdapter().getView(0, null, null),
                        0, list.getAdapter().getItemId(0));
            }

        });

        getInstrumentation().waitForIdleSync();

        // Remove the Activity Monitor
        getInstrumentation().removeMonitor(mTxActivityMonitor);
    }

    /**
     *
     * @return ArrayList<SingleUserInfo> using dummy data
     */

    @NonNull
    private ArrayList<SingleUserInfo> getUsersInformation() {

        ArrayList<SingleUserInfo> dummyUsers = new ArrayList<>();
        SingleUserInfo singleUserInfo = new SingleUserInfo();
        singleUserInfo.setTitle("Test Title");
        singleUserInfo.setDescription("Test Description");
        singleUserInfo.setImageHref(null);
        dummyUsers.add(singleUserInfo);

        SingleUserInfo singleUserInfoSecond = new SingleUserInfo();
        singleUserInfoSecond.setTitle(null);
        singleUserInfoSecond.setDescription("Test Description Second");
        singleUserInfoSecond.setImageHref("http://s3.amazonaws.com/37assets/svn/765-default-avatar.png");
        dummyUsers.add(singleUserInfoSecond);

        SingleUserInfo singleUserInfoThird = new SingleUserInfo();
        singleUserInfoThird.setTitle("Test Title Third");
        singleUserInfoThird.setDescription(" ");
        singleUserInfoThird.setImageHref("http://s3.amazonaws.com/37assets/svn/765-default-avatar.png");
        dummyUsers.add(singleUserInfoThird);

        return dummyUsers;
    }

}