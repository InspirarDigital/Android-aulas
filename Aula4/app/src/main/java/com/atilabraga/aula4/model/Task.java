package com.atilabraga.aula4.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by atilabraga on 10/17/15.
 */
public class Task implements Parcelable {

    public static final class Priority {
        public static final int LOW = 1;
        public static final int NORMAL = 2;
        public static final int HIGH = 3;
    }

    public static final class Status {
        public static final int TODO = 1;
        public static final int DOING = 2;
        public static final int DONE = 3;
    }

    @Retention(RetentionPolicy.SOURCE)
    @IntDef({Priority.LOW, Priority.NORMAL, Priority.HIGH})
    private @interface TaskPriority {
    }

    @Retention(RetentionPolicy.SOURCE)
    @IntDef({Status.TODO, Status.DOING, Status.DONE})
    private @interface TaskStatus {
    }

    public static final Creator<Task> CREATOR = new Creator<Task>() {
        @Override
        public Task createFromParcel(Parcel in) {
            return new Task(in);
        }

        @Override
        public Task[] newArray(int size) {
            return new Task[size];
        }
    };

    private int id;
    private String name;
    private int priority;
    private int status;
    private int createdAt;
    private List<Tag> tagList;

    public Task(int id, String name) {
        this.id = id;
        this.name = name;
    }

    protected Task(Parcel in) {
        id = in.readInt();
        name = in.readString();
        priority = in.readInt();
        status = in.readInt();
        createdAt = in.readInt();
        tagList = new ArrayList<>();
        in.readList(tagList, null);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @TaskPriority
    public int getPriority() {
        return priority;
    }

    public void setPriority(@TaskPriority int priority) {
        this.priority = priority;
    }

    @TaskStatus
    public int getStatus() {
        return status;
    }

    public void setStatus(@TaskStatus int status) {
        this.status = status;
    }

    public int getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(int createdAt) {
        this.createdAt = createdAt;
    }

    public List<Tag> getTagList() {
        return tagList;
    }

    public void setTagList(List<Tag> tagList) {
        this.tagList = tagList;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(name);
        parcel.writeInt(priority);
        parcel.writeInt(status);
        parcel.writeInt(createdAt);
        parcel.writeList(tagList);
    }

    @Override
    public String toString() {
        return this.name;
    }
}
