package com.example.user.myapplication.entity;

public class SOFResponse {
    private String questTitle;
    private String questAuthor;
    private String questLink;
    private Integer answId;
    private String answScore;
    private String answLink;

    public String getQuestTitle() {
        return questTitle;
    }

    public void setQuestTitle(String questTitle) {
        this.questTitle = questTitle;
    }

    public String getQuestAuthor() {
        return questAuthor;
    }

    public void setQuestAuthor(String questAuthor) {
        this.questAuthor = questAuthor;
    }

    public String getQuestLink() {
        return questLink;
    }

    public void setQuestLink(String questLink) {
        this.questLink = questLink;
    }

    public Integer getAnswId() {
        return answId;
    }

    public void setAnswId(Integer answId) {
        this.answId = answId;
    }

    public String getAnswScore() {
        return answScore;
    }

    public void setAnswScore(String answScore) {
        this.answScore = answScore;
    }

    public String getAnswLink() {
        return answLink;
    }

    public void setAnswLink(String answLink) {
        this.answLink = answLink;
    }
}
