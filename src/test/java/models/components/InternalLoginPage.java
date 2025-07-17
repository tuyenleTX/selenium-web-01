package models.components;

public class InternalLoginPage extends LoginPage{

    @Override
    public String username() {
        return "Internal Page | Username";
    }

    @Override
    public String password() {
        return "Internal Page | Password";
    }

    @Override
    public String loginBtn() {
        return "Internal Page | Login Button";
    }
}
