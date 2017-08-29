import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Administrator on 2017/8/11.
 */
public class CMEMultithreadingValidate {
    private static final List<Integer> list = new ArrayList<>();

    static {
        list.add(100);
        list.add(200);
        list.add(300);
    }

    public static void main(String[] args) {
        new Thread(() -> {
            Iterator<Integer> iterator = list.iterator();
            while (iterator.hasNext()) {
                System.out.println(Thread.currentThread().getName() + "---" + iterator.next());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(() -> {
            Iterator<Integer> ii = list.iterator();
            while (ii.hasNext()) {
                ii.next();
                ii.remove();
            }
        }).start();
    }
}
