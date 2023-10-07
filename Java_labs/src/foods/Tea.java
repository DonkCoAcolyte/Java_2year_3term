package foods;

public class Tea extends Food{
    public Tea() {
        super("Чай");
    }
    public void consume() {
        System.out.println(this + " съеден");
    }
}
