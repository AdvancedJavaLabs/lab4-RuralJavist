//
//import org.apache.hadoop.io.Text;
//import org.apache.hadoop.io.WritableComparable;
//import org.apache.hadoop.io.WritableComparator;
//
//public class ValueComparator  extends WritableComparator {
//
//    @Override
//    public int compare(WritableComparable a, WritableComparable b) {
//        String[] columnsA = a.toString().split("\t");
//        String[] columnsB = b.toString().split("\t");
//
//        // Получаем выручку из первого столбца
//        double revenueA = Double.parseDouble(columnsA[0]);
//        double revenueB = Double.parseDouble(columnsB[0]);
//
//        return Double.compare(revenueB, revenueA);  // Сортировка по убыванию выручки
//    }
//}
