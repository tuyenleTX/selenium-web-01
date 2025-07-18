package models.components;

public class AnnotationTest {
    public <T>void getComponentCSSSelector(Class<T> componentClass) {

        try {
            String cssSelector = componentClass.getAnnotation(ComponentCssSelector.class).value();
            System.out.println(cssSelector);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new AnnotationTest().getComponentCSSSelector(LoginFormComponent.class);
    }
}
