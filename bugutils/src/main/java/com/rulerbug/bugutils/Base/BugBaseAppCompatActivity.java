package com.rulerbug.bugutils.Base;

import android.os.Bundle;
import androidx.annotation.Nullable;

import com.rulerbug.bugutils.Utils.BugActivityUtils;
import com.rulerbug.bugutils.swipebacklib.BaseSwipeBackActivity;

public class BugBaseAppCompatActivity extends BaseSwipeBackActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new BugActivityUtils().addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        new BugActivityUtils().finishActivity(this);
    }
}
