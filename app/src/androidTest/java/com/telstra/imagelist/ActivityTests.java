package com.telstra.imagelist;

import android.app.Instrumentation;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.ListView;

import com.telstra.imagelist.ui.activity.TxMainActivity;

public class ActivityTests extends
        ActivityInstrumentationTestCase2<TxMainActivity> {
    public TxMainActivity mTxMainActivity;
    private Instrumentation mInstrumentation;
    ListView list;

    public ActivityTests() {
        super(TxMainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        setActivityInitialTouchMode(true);
        mInstrumentation = getInstrumentation();
        mTxMainActivity = getActivity();
        list = (ListView) mTxMainActivity.findViewById(R.id.list);
    }

    public void testLoadsTxMainActivity() {
        // Set up Activity Monitor
        Instrumentation.ActivityMonitor mTxActivityMonitor =
                mInstrumentation.addMonitor(TxMainActivity.class.getName(),
                        null, false);

        assertNotNull("The list was not loaded", list);

        getInstrumentation().waitForIdleSync();

        // Remove the Activity Monitor
        getInstrumentation().removeMonitor(mTxActivityMonitor);
    }

}