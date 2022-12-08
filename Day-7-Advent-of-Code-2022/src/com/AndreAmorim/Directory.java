package com.AndreAmorim;

public class Directory {
    private String dir;
    private int size;

    public Directory(String dir) {
        this.dir = dir;

    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void addsize(int size)
    {
        this.size += size;
    }
}
