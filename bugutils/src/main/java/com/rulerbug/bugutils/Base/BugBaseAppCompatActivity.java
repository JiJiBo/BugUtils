package com.rulerbug.bugutils.Base;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.rulerbug.bugutils.Utils.BugActivityUtils;

public class BugBaseAppCompatActivity extends AppCompatActivity {
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
