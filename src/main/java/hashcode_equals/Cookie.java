package hashcode_equals;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Cookie {

    private Ingredients ingredients;

    public Cookie(Ingredients ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cookie cookie = (Cookie) o;

        return Objects.equals(ingredients, cookie.ingredients);
    }

    @Override
    public int hashCode() {
        return ingredients != null ? ingredients.hashCode() : 0;
    }

    public static void main(String[] args) {

        Cookie cookie1 = new Cookie(new Ingredients("yellow", "citrus"));
        Cookie cookie2 = new Cookie(new Ingredients("yellow", "citrus"));
        Cookie cookie3 = new Cookie(new Ingredients("pink", "strawberry"));
        Cookie cookie4 = new Cookie(new Ingredients("pink", "raspberry"));
        Cookie cookie5 = new Cookie(new Ingredients("blue", "blueberry"));

        Map<Cookie, Integer> cookies = new HashMap<>();

        System.out.println("==: " + (cookie1 == cookie2));
        System.out.println("equals: " + (cookie1.equals(cookie2)));
    }
}
