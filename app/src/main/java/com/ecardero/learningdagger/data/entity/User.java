package com.ecardero.learningdagger.data.entity;


public class User {
    private String UserName;
    private String Initials;
    private String AvatarUrl;
    private int AvatarResource;

    User(){}

    public String getUserName() {
        return UserName;
    }

    public String getInitials() {
        return Initials;
    }

    public String getAvatarUrl() {
        return AvatarUrl;
    }

    public int getAvatarResource() {
        return AvatarResource;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public void setInitials(String initials) {
        Initials = initials;
    }

    public void setAvatarUrl(String avatarUrl) {
        AvatarUrl = avatarUrl;
    }

    public void setAvatarResource(int avatarResource) {
        AvatarResource = avatarResource;
    }

    public static class Builder{

        private User _user;

        public Builder(){
            _user = new User();
        }

        public Builder setUserName(String userName){
            _user.setUserName(userName);
            _user.setInitials(userName.toUpperCase().substring(0,1));
            return this;
        }

        public Builder setInitials(String initials){
            _user.setInitials(initials);
            return this;
        }

        public Builder setAvatarUrl(String avatarUrl){
            _user.setAvatarUrl(avatarUrl);
            return this;
        }

        public Builder setAvatarResource(int avatarResource){
            _user.setAvatarResource(avatarResource);
            return this;
        }

        public User build(){
            return _user;
        }
    }
}
