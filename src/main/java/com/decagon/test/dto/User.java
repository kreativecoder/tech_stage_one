package com.decagon.test.dto;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class User {
    private long id;
    private String username;
    private String about;
    private int submitted;
    @SerializedName("submission_count")
    private int submissionCount;
    @SerializedName("comment_count")
    private int commentCount;
    @SerializedName("created_at")
    private long createdAt;
    @SerializedName("updated_at")
    private Date updatedAt;

    public long getId() {
        return id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(final String about) {
        this.about = about;
    }

    public int getSubmitted() {
        return submitted;
    }

    public void setSubmitted(final int submitted) {
        this.submitted = submitted;
    }

    public int getSubmissionCount() {
        return submissionCount;
    }

    public void setSubmissionCount(final int submissionCount) {
        this.submissionCount = submissionCount;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(final int commentCount) {
        this.commentCount = commentCount;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(final long createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(final Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
