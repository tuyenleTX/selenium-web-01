package models.components;
import java.lang.reflect.Constructor;

public class ComponentExploring {
//    public void login(LoginPage loginPage) {
//        loginPage.login();
//    }
//
//    public static void main(String[] args) {
//        new ComponentExploring().login(new InternalLoginPage());
//        new ComponentExploring().login(new ExternalLoginPage());
//    }

    //convert to generic type
    public <T extends LoginPage>void login(Class<T> loginPageClass) {
        Class<?>[] paramenters = new Class[]{};
        try {
            Constructor<T> constructor = loginPageClass.getConstructor(paramenters);
            T loginPageObj = constructor.newInstance();
            loginPageObj.login();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ComponentExploring().login(InternalLoginPage.class);
        new ComponentExploring().login(ExternalLoginPage.class);
    }
}
