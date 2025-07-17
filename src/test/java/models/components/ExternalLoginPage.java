package models.components;

public class ExternalLoginPage extends LoginPage{

    @Override
    public String username() {
        return "External Page | Username";
    }

    @Override
    public String password() {
        return "External Page | Password";
    }

    @Override
    public String loginBtn() {
        return "External Page | Login Button";
    }
}
