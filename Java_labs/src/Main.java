import foods.*;

import java.util.Arrays;
import java.util.Objects;

public class Main {
    // Конструктор класса отсутствует!!!
    // Главный метод главного класса
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception {
        // Определение ссылок на продукты завтрака
        Food[] breakfast = new Food[20];
        // Анализ аргументов командной строки и создание для них
        // экземпляров соответствующих классов для завтрака
        int itemsSoFar = 0;
        Boolean bCalories = false;
        Boolean bSort = false;
        for (String arg: args) {
            if (Objects.equals(arg, "-calories")){
                bCalories = true;
                continue;
            }
            if (Objects.equals(arg, "-sort")) {
                bSort = true;
                continue;
            }

            String[] parts = arg.split("/");
            if (parts[0].equals("Cheese")) {
// У сыра дополнительных параметров нет
                breakfast[itemsSoFar] = new Cheese();
            } else
            if (parts[0].equals("Apple")) {
// У яблока – 1 параметр, который находится в parts[1]
                breakfast[itemsSoFar] = new Apple(parts[1]);
            } else
                if (parts[0].equals("Tea")) {
                breakfast[itemsSoFar] = new Tea(parts[1]);
            }
// ... Продолжается анализ других продуктов для завтрака
            itemsSoFar++;
        }

        Boolean[] accountedFor = new Boolean[20];
        Arrays.fill(accountedFor, false);
        int currentItem = 0;
        System.out.println("Подсчёт разных типов еды");
        for (Food item: breakfast) {
            if (!accountedFor[currentItem]){
                accountedFor[currentItem] = true;
                if (item != null){
                    int Items = 1;
                    for (int i = 0; i < 20; i++){
                        if (!accountedFor[i]) {
                            if (item.equals(breakfast[i])){
                                Items++;
                                accountedFor[i] = true;
                            }
                        }
                    }
                    System.out.println(Items + " " + item);
                } else break;
            }
            currentItem++;
        }

        if(bSort) Arrays.sort(breakfast, new sortByNameLength());

// Перебор всех элементов массива
        Integer calories = 0;
        for (Food item: breakfast) {
            if (item != null) {
// Если элемент не null – употребить продукт
                item.consume();
                if (bCalories) calories += item.calculateCalories();
            } else
// Если дошли до элемента null – значит достигли конца
// списка продуктов, ведь 20 элементов в массиве было
// выделено с запасом, и они могут быть не
// использованы все
                break;
        }
            if (bCalories) System.out.println(calories + " калорий");
        System.out.println("Всего хорошего!");
    }
}