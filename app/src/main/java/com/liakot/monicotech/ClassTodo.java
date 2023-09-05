package com.liakot.monicotech;

public class ClassTodo {
    int userid, id;
    String title;
    boolean completed;

    public ClassTodo(int userid, int id, String title, boolean completed) {
        this.userid = userid;
        this.id = id;
        this.title = title;
        this.completed = completed;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
