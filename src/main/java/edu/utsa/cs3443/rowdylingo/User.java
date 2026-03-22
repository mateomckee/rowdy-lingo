package edu.utsa.cs3443.rowdylingo;

public abstract class User {
    public int userID;
    public String username;
    public String email;
    public String password;
    public int totalStudyTimeMinutes;
    public int wordsLearned;
    public int sessionsCompleted;

    public User(int userID, String username, String email, String password,
                int totalStudyTimeMinutes, int wordsLearned, int sessionsCompleted) {
        this.userID = userID;
        this.username = username;
        this.email = email;
        this.password = password;
        this.totalStudyTimeMinutes = totalStudyTimeMinutes;
    }

    public void setUserID(int newUserID) {
        this.userID = newUserID;
    }

    public void setUsername(String newUsername) {
        this.username = newUsername;
    }

    public void setEmail(String newEmail) {
        this.email = newEmail;
    }

    public void setPassword(String newPassword) {
        this.password = newPassword;
    }

    public void setTotalStudyTimeMinutes(int newTotalStudyTimeMinutes) {
        this.totalStudyTimeMinutes = newTotalStudyTimeMinutes;
    }

    public void setWordsLearned(int newWordsLearned) {
        this.wordsLearned = newWordsLearned;
    }

    public void setSessionsCompleted(int newSessionsCompleted) {
        this.sessionsCompleted = newSessionsCompleted;
    }

    public int getUserID() {
        return userID;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int getTotalStudyTimeMinutes() {
        return totalStudyTimeMinutes;
    }

    public int getWordsLearned() {
        return wordsLearned;
    }

    public int getSessionsCompleted() {
        return sessionsCompleted;
    }

    public String toString() {
        String returnString = String.format("%d,%s,%s,%s,%d,%d,%d", userID, username, email, password,
                totalStudyTimeMinutes, wordsLearned, sessionsCompleted);

        return returnString;
    }
}
