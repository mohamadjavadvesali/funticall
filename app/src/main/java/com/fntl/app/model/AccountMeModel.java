package com.fntl.app.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AccountMeModel {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("fullName")
    @Expose
    private String fullName;
    @SerializedName("avatar")
    @Expose
    private String avatar;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("mobileNumber")
    @Expose
    private String mobileNumber;
    @SerializedName("personType")
    @Expose
    private Integer personType;
    @SerializedName("membershipType")
    @Expose
    private Integer membershipType;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("resumeDescription")
    @Expose
    private Object resumeDescription;
    @SerializedName("resumeHistory")
    @Expose
    private Object resumeHistory;
    @SerializedName("skills")
    @Expose
    private Object skills;
    @SerializedName("isActive")
    @Expose
    private Boolean isActive;
    @SerializedName("isTeacher")
    @Expose
    private Boolean isTeacher;
    @SerializedName("lastSignInDate")
    @Expose
    private String lastSignInDate;
    @SerializedName("verificationCodeSendDate")
    @Expose
    private String verificationCodeSendDate;
    @SerializedName("createdDate")
    @Expose
    private String createdDate;
    @SerializedName("companyName")
    @Expose
    private String companyName;
    @SerializedName("address")
    @Expose
    private String address;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public Integer getPersonType() {
        return personType;
    }

    public void setPersonType(Integer personType) {
        this.personType = personType;
    }

    public Integer getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(Integer membershipType) {
        this.membershipType = membershipType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Object getResumeDescription() {
        return resumeDescription;
    }

    public void setResumeDescription(Object resumeDescription) {
        this.resumeDescription = resumeDescription;
    }

    public Object getResumeHistory() {
        return resumeHistory;
    }

    public void setResumeHistory(Object resumeHistory) {
        this.resumeHistory = resumeHistory;
    }

    public Object getSkills() {
        return skills;
    }

    public void setSkills(Object skills) {
        this.skills = skills;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Boolean getTeacher() {
        return isTeacher;
    }

    public void setTeacher(Boolean teacher) {
        isTeacher = teacher;
    }

    public String getLastSignInDate() {
        return lastSignInDate;
    }

    public void setLastSignInDate(String lastSignInDate) {
        this.lastSignInDate = lastSignInDate;
    }

    public String getVerificationCodeSendDate() {
        return verificationCodeSendDate;
    }

    public void setVerificationCodeSendDate(String verificationCodeSendDate) {
        this.verificationCodeSendDate = verificationCodeSendDate;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
