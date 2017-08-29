
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Administrator on 2017/8/11.
 */
public class CMEValidate {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(100000);
        //第一种
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            Integer ii = iterator.next();
            list.remove(ii);
        }
//        //第二种
//        for (Integer dd : list) {
////            list.add(300);
//            list.remove(dd);
//        }
    }
}
