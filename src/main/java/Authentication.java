public class Authentication {

    public String register(String email, String password){
        // user with taken email
        User takenUserEmail = new User("taken@email.com", "123");
        if (email.equals(takenUserEmail.getEmail())) {
            return "email is taken";
        }
        // else register just fine
        User user = new User(email, password);
        return "registered, Email: "+ user.getEmail()+" password: "+user.getPassword();
    }

    public String login(User user, String email, String password){
        // check email if its a match
        if (email.equals(user.getEmail())) {
            // then check password if its a match
            if (password.equals(user.getPassword())) {
                return "login successfully";
            }
            return "password is wrong";
        }
        return "email is wrong";
    }
}