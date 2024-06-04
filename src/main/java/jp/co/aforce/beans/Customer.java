package jp.co.aforce.beans;

public class Customer implements java.io.Serializable{

    private int MEMBER_ID; // idをMEMBER_IDに変更
    private String userID;
    private String password;
    
    public int getMEMBER_ID() { // getId()をgetMEMBER_ID()に変更
        return MEMBER_ID;
    }
    public String getUserId() {
        return userID;
    }
    
    
    public String getPassword() {
        return password;
    }
    
    public void setMEMBER_ID(int MEMBER_ID) { // setId()をsetMEMBER_ID()に変更
        this.MEMBER_ID = MEMBER_ID;
    }
    public void setUserId(String userID) {
        this.userID=userID;
    }
    public void setPassword(String password) {
        this.password=password;
    }

}
