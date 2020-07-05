package com.rulerbug.bugutils.Domain;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class BugOkHttpFileList {
    public List<BugOkHttpFileBean> dataList = new ArrayList<>();

    public BugOkHttpFileList add(String name, String filename, File f) {
        BugOkHttpFileBean b = new BugOkHttpFileBean(name, filename, f);
        dataList.add(b);
        return this;
    }

}
