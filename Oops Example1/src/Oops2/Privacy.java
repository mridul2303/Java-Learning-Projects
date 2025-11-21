package Oops2;

public class Privacy {
    public static void main(String[] args) {
InstagramUser iu1 = new InstagramUser("mridul2303" , "282004");
iu1.setPassword("1234");
    }

}
class InstagramUser{
    private String username;
    private String password;
  InstagramUser(String id , String pass){
      username = id;
      password = pass;
  }
    // Getter for username
    public String getUsername() {
        return username;
    }

    // Setter for password (password can only be updated through setter)
    public void setPassword(String password) {
        // og validation
        if(password.length() >= 6) {
            this.password = password;
            System.out.println("Password updated successfully!");
        } else {
            System.out.println("Password must be at least 6 characters long.");
        }}
}
