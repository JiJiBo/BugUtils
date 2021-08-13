package com.rulerbug.bugutils.domain;

import java.util.ArrayList;
import java.util.List;

public class BugOkHttpDataList {
    public List<BugOkHttpDataBean> dataList = new ArrayList<>();

    public BugOkHttpDataList add(String key, String value) {
        BugOkHttpDataBean b = new BugOkHttpDataBean(key, value);
        dataList.add(b);
        return this;
    }

}
