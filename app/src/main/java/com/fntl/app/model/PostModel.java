package com.fntl.app.model;

import java.util.List;

public class PostModel {
    private long id;
    private long personId;
    private String fullName;
    private String content;
    private String createdDate;
    private boolean isLikeByCurrentPerson;
    private int likesCount;
    private boolean isDisLikeByCurrentPerson;
    private int disLikesCount;
    private int commentCount;
    private String avatar;
    private int membershipTypeEnum;
    private String membershipTypeTitle;
    private long parentId;
    private List<Image> images;

    public PostModel(long id, long personId, String fullName, String content, String createdDate, boolean isLikeByCurrentPerson, int likesCount, boolean isDisLikeByCurrentPerson, int disLikesCount, int commentCount, String avatar, int membershipTypeEnum, String membershipTypeTitle, long parentId, List<Image> images) {
        this.id = id;
        this.personId = personId;
        this.fullName = fullName;
        this.content = content;
        this.createdDate = createdDate;
        this.isLikeByCurrentPerson = isLikeByCurrentPerson;
        this.likesCount = likesCount;
        this.isDisLikeByCurrentPerson = isDisLikeByCurrentPerson;
        this.disLikesCount = disLikesCount;
        this.commentCount = commentCount;
        this.avatar = avatar;
        this.membershipTypeEnum = membershipTypeEnum;
        this.membershipTypeTitle = membershipTypeTitle;
        this.parentId = parentId;
        this.images = images;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public boolean isLikeByCurrentPerson() {
        return isLikeByCurrentPerson;
    }

    public void setLikeByCurrentPerson(boolean likeByCurrentPerson) {
        isLikeByCurrentPerson = likeByCurrentPerson;
    }

    public int getLikesCount() {
        return likesCount;
    }

    public void setLikesCount(int likesCount) {
        this.likesCount = likesCount;
    }

    public boolean isDisLikeByCurrentPerson() {
        return isDisLikeByCurrentPerson;
    }

    public void setDisLikeByCurrentPerson(boolean disLikeByCurrentPerson) {
        isDisLikeByCurrentPerson = disLikeByCurrentPerson;
    }

    public int getDisLikesCount() {
        return disLikesCount;
    }

    public void setDisLikesCount(int disLikesCount) {
        this.disLikesCount = disLikesCount;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getMembershipTypeEnum() {
        return membershipTypeEnum;
    }

    public void setMembershipTypeEnum(int membershipTypeEnum) {
        this.membershipTypeEnum = membershipTypeEnum;
    }

    public String getMembershipTypeTitle() {
        return membershipTypeTitle;
    }

    public void setMembershipTypeTitle(String membershipTypeTitle) {
        this.membershipTypeTitle = membershipTypeTitle;
    }

    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }
}
