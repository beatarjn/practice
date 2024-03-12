package hashcode_equals;

import java.util.Objects;

public class Ingredients {

    private String color;
    private String taste;

    public Ingredients(String color, String taste) {
        this.color = color;
        this.taste = taste;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ingredients that = (Ingredients) o;

        if (!Objects.equals(color, that.color)) return false;
        return Objects.equals(taste, that.taste);
    }

    @Override
    public int hashCode() {
        int result = color != null ? color.hashCode() : 0;
        result = 31 * result + (taste != null ? taste.hashCode() : 0);
        return result;
    }
}
