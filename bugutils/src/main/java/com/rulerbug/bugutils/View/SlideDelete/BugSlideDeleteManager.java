package com.rulerbug.bugutils.View.SlideDelete;

public class BugSlideDeleteManager {
    public BugSlideDelete hadOpen ;
    public static BugSlideDeleteManager SlideDeleteManager = new BugSlideDeleteManager();

    public static BugSlideDeleteManager getInstence() {
        return SlideDeleteManager;
    }

    public void regist_a_open(BugSlideDelete hadOpen) {
        this.hadOpen = hadOpen;
    }

    public void remove_a_open() {
        this.hadOpen = null;
    }

    public void closeCurrentSlideDelete() {
        if (hadOpen != null) {
            hadOpen.close();
//            remove_a_open();
        }
    }

    public boolean hadOpen(BugSlideDelete sd) {
        if (hadOpen == null) {
            return true;
        } else {
            return hadOpen == sd;
        }
    }

}
