import javax.swing.table.AbstractTableModel;
@SuppressWarnings("serial")
public class GornerTableModel extends AbstractTableModel {
    private Double[] coefficients;
    private Double from;
    private Double to;
    private Double step;
    public GornerTableModel(Double from, Double to, Double step,
                            Double[] coefficients) {
        this.from = from;
        this.to = to;
        this.step = step;
        this.coefficients = coefficients;
    }
    public Double getFrom() {
        return from;
    }
    public Double getTo() {
        return to;
    }
    public Double getStep() {
        return step;
    }
    public int getColumnCount() {
// В данной модели два столбца
        return 3;
    }
    public int getRowCount() {
// Вычислить количество точек между началом и концом отрезка
// исходя из шага табулирования
        return new Double((Math.ceil((to-from)/step))).intValue()+1;
    }
    public Object getValueAt(int row, int col) {
// Вычислить значение X как НАЧАЛО_ОТРЕЗКА + ШАГ*НОМЕР_СТРОКИ
        double x = from + step*row;
        switch(col){
            case(0):{
// Если запрашивается значение 1-го столбца, то это X
            return x;
        }


            case(1):{
                Double result = 0.0;
// Вычисление значения в точке по схеме Горнера.
// Вспомнить 1-ый курс и реализовать
// ...
                result += coefficients[0];
                Integer polynom_order = coefficients.length;
                for (Integer i = 1; i < polynom_order; i++){
                    result = coefficients[i] + result * x;
                }
                return result;
            }
// Если запрашивается значение 2-го столбца, то это значение
// многочлена

            case(2): {
                Double result = 0.0;
// Вычисление значения в точке по схеме Горнера.
// Вспомнить 1-ый курс и реализовать
// ...
                result += coefficients[0];
                Integer polynom_order = coefficients.length;
                for (Integer i = 1; i < polynom_order; i++){
                    result = coefficients[i] + result * x;
                }
            Boolean isPositive = false;
            if (result > 0) isPositive = true;
            return isPositive;
            }
    }
    return 0;
    }
    public String getColumnName(int col) {
        switch (col) {
            case 0:
// Название 1-го столбца
                return "Значение X";
            case 1:
// Название 2-го столбца
                return "Значение многочлена";
            case 2:
                return "Число положительное?";
        }
        return "0";
    }
    public Class<?> getColumnClass(int col) {
        if (col == 2) return Boolean.class;
        else return Double.class;
// И в 1-ом и во 2-ом столбце находятся значения типа Double
    }
}
