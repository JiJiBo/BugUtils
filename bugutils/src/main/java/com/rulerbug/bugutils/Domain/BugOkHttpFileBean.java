package com.rulerbug.bugutils.Domain;

import java.io.File;

public class BugOkHttpFileBean {
    public BugOkHttpFileBean() {

    }

    public BugOkHttpFileBean(String name, String filename, File f) {
        this.name = name;
        this.filename = filename;
        this.f = f;
    }

    public String name;
    public String filename;
    public File f;
}
