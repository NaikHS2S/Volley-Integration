package com.telstra.imagelist;

import android.app.Instrumentation;
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
        final ArrayList<SingleUserInfo> dummyUsers = new ArrayList<SingleUserInfo>();
        dummyUsers.add(new SingleUserInfo("Title", "Description", "null"));

        getActivity().runOnUiThread(
                new Runnable() {
                    @Override
                    public void run() {
                        list.setAdapter(new TxListAdapter(getActivity(), dummyUsers));
                    }
                }
        );

        getInstrumentation().waitForIdleSync();

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

}