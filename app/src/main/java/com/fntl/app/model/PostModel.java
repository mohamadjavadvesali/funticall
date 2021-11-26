package com.fntl.app.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PostModel {
    @SerializedName("id")
    @Expose
    private long id;

    @SerializedName("personId")
    @Expose
    private long personId;
    @SerializedName("fullName")
    @Expose
    private String fullName;
    @SerializedName("content")
    @Expose
    private String content;
    @SerializedName("createdDate")
    @Expose
    private String createdDate;
    @SerializedName("isLikeByCurrentPerson")
    @Expose
    private Boolean isLikeByCurrentPerson;
    @SerializedName("likesCount")
    @Expose
    private Integer likesCount;
    @SerializedName("isDisLikeByCurrentPerson")
    @Expose
    private Boolean isDisLikeByCurrentPerson;
    @SerializedName("disLikesCount")
    @Expose
    private Integer disLikesCount;
    @SerializedName("commentCount")
    @Expose
    private Integer commentCount;
    @SerializedName("avatar")
    @Expose
    private String avatar;
    @SerializedName("membershipTypeEnum")
    @Expose
    private Integer membershipTypeEnum;
    @SerializedName("membershipTypeTitle")
    @Expose
    private String membershipTypeTitle;
    @SerializedName("parentId")
    @Expose
    private long parentId;
    @SerializedName("images")
    @Expose
    private List<Image> images = null;
    @SerializedName("children")
    @Expose
    private List<Child> children = null;


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

    public Boolean getLikeByCurrentPerson() {
        return isLikeByCurrentPerson;
    }

    public void setLikeByCurrentPerson(Boolean likeByCurrentPerson) {
        isLikeByCurrentPerson = likeByCurrentPerson;
    }

    public Integer getLikesCount() {
        return likesCount;
    }

    public void setLikesCount(Integer likesCount) {
        this.likesCount = likesCount;
    }

    public Boolean getDisLikeByCurrentPerson() {
        return isDisLikeByCurrentPerson;
    }

    public void setDisLikeByCurrentPerson(Boolean disLikeByCurrentPerson) {
        isDisLikeByCurrentPerson = disLikeByCurrentPerson;
    }

    public Integer getDisLikesCount() {
        return disLikesCount;
    }

    public void setDisLikesCount(Integer disLikesCount) {
        this.disLikesCount = disLikesCount;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Integer getMembershipTypeEnum() {
        return membershipTypeEnum;
    }

    public void setMembershipTypeEnum(Integer membershipTypeEnum) {
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

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }
}
