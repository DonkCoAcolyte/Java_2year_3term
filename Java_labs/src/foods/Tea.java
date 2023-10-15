package foods;

import java.util.Objects;

public class Tea extends Food{
    String color = null;
    public Tea() {
        super("чай");
    }
    public Tea(String color){
        super("чай");
        this.color = color;
    }
    public void consume() {
        System.out.println(this + " съеден. Гадость!");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Tea tea = (Tea) o;
        return Objects.equals(color, tea.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color);
    }

    @Override
    public Integer calculateCalories() {
        Integer calories = 5;
        if (Objects.equals(color, "green")) calories += 2;
        if (Objects.equals(color, "black")) calories += 6;
        return calories;
    }

    public String getColor() {
        return color;
    }

    public String toString() {return this.color + " " + super.toString();}
}
