package com.fnmusic.base.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty(value = "Id")
    private Long id;
    @JsonProperty(value = "Username")
    private String username;
    @JsonProperty("FirstName")
    private String firstName;
    @JsonProperty("LastName")
    private String lastName;
    @JsonProperty("Email")
    private String email;
    @JsonProperty("EmailConfirmed")
    private boolean emailConfirmed;
    @JsonIgnore
    private String passwordHash;
    @JsonProperty("Gender")
    private String gender;
    @JsonProperty("DateOfBirth")
    private Date dateOfBirth;
    @JsonProperty("Nationality")
    private String nationality;
    @JsonProperty("PhoneNumber")
    private String phoneNumber;
    @JsonProperty("Location")
    private String location;
    @JsonProperty("Genre")
    private String genre;
    @JsonProperty("Biography")
    private String biography;
    @JsonProperty("Website")
    private String website;
    @JsonProperty("ProfileImagePath")
    private String profileImagePath;
    @JsonProperty("CoverImagePath")
    private String coverImagePath;
    @JsonProperty("Following")
    private Long following;
    @JsonProperty("Followers")
    private Long followers;
    @JsonProperty("Role")
    private Role role;
    @JsonProperty("TwitterProfile")
    private String twitterProfileUrl;
    @JsonProperty("Verified")
    private boolean verified;
    @JsonProperty("DateCreated")
    private Date dateCreated;
    @JsonIgnore
    private boolean lockOutEnabled;
    @JsonIgnore
    private Date lockOutEndDateUtc;
    @JsonIgnore
    private int accessFailedCount;
    @JsonIgnore
    private boolean deleted;
    @JsonIgnore
    private Date dateDeleted;
    @JsonIgnore
    private boolean suspended;
    @JsonIgnore
    private Date suspensionEndDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEmailConfirmed() {
        return emailConfirmed;
    }

    public void setEmailConfirmed(boolean emailConfirmed) {
        this.emailConfirmed = emailConfirmed;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getProfileImagePath() {
        return profileImagePath;
    }

    public void setProfileImagePath(String profileImagePath) {
        this.profileImagePath = profileImagePath;
    }

    public String getCoverImagePath() {
        return coverImagePath;
    }

    public void setCoverImagePath(String coverImagePath) {
        this.coverImagePath = coverImagePath;
    }

    public Long getFollowing() {
        return following;
    }

    public void setFollowing(Long following) {
        this.following = following;
    }

    public Long getFollowers() {
        return followers;
    }

    public void setFollowers(Long followers) {
        this.followers = followers;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getTwitterProfileUrl() {
        return twitterProfileUrl;
    }

    public void setTwitterProfileUrl(String twitterProfileUrl) {
        this.twitterProfileUrl = twitterProfileUrl;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public boolean isLockOutEnabled() {
        return lockOutEnabled;
    }

    public void setLockOutEnabled(boolean lockOutEnabled) {
        this.lockOutEnabled = lockOutEnabled;
    }

    public Date getLockOutEndDateUtc() {
        return lockOutEndDateUtc;
    }

    public void setLockOutEndDateUtc(Date lockOutEndDateUtc) {
        this.lockOutEndDateUtc = lockOutEndDateUtc;
    }

    public int getAccessFailedCount() {
        return accessFailedCount;
    }

    public void setAccessFailedCount(int accessFailedCount) {
        this.accessFailedCount = accessFailedCount;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public Date getDateDeleted() {
        return dateDeleted;
    }

    public void setDateDeleted(Date dateDeleted) {
        this.dateDeleted = dateDeleted;
    }

    public boolean isSuspended() {
        return suspended;
    }

    public void setSuspended(boolean suspended) {
        this.suspended = suspended;
    }

    public Date getSuspensionEndDate() {
        return suspensionEndDate;
    }

    public void setSuspensionEndDate(Date suspensionEndDate) {
        this.suspensionEndDate = suspensionEndDate;
    }
}