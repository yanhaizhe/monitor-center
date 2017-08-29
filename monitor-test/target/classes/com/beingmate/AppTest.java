package com.beingmate;

import java.lang.ref.WeakReference;
import java.text.MessageFormat;
import java.time.Clock;
import java.time.Duration;
import java.time.ZoneId;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author yanhaizhe
 * @create 2017-03-16 下午 11:21
 **/
public class AppTest {

    public AppTest(String d) {
        this();
    }

      class dd {
        public void dddd() {
        }
    }

    public AppTest() {
    }


    public static void main(String[] args) {
////        AppTest appTest = new AppTest();
////        appTest.dd d = new
////        dd dd = new dd();
//        AppTest.dd dd= new AppTest().new dd();
//        Test test = new Test();
//        test.name = "d";
////        Res
//        Integer d = 129;
//        Integer a = 129;
//        System.out.println("ddddd" + (d.equals(a)));
//        Long dL = 10000L;
//        Long aL = 10000L;
//        System.out.println("dddddL" + (dL == aL));
////        Thread
//        Calendar c = Calendar.getInstance();
////        int[] dd = {0, 2, 1, 5, 4, 3};
////        Arrays.sort(dd);
////        System.out.printf(Arrays.toString(dd));
////        Arrays.spliterator()
//        Scanner d1 = new Scanner(System.in);
//        d1.useDelimiter("\n");
//       int hashcodeV = System.identityHashCode(d1);
//       Runtime.getRuntime();
////       Cloneable
////        Objects
////        Object
//        ThreadLocalRandom random = ThreadLocalRandom.current();
//        System.out.println("dddddL" +  random.nextDouble(2.0, 10));
//        System.out.println("dddddL" +  random.nextInt(1001,9999));
//        random.nextDouble();
//        Clock clock = Clock.systemDefaultZone();
//        System.out.println("dddddL--" +clock.toString() );
//        System.out.println("dddddL--" +System.currentTimeMillis());
//        System.out.println("dddddL--" + clock.millis());
//        System.out.println("dddddL--" +  clock.instant());
//
//        Duration duration = Duration.ofSeconds(6000);
//        System.out.println("dddddL--" +  duration.toDays());
//        System.out.println("dddddL--" +duration.toHours());
//        System.out.println("dddddL--" + duration.toMinutes());
//        ZoneId
//        Stream
//        Locale[] locales =Locale.getAvailableLocales();
//        for(Locale locale : locales){
//            System.out.println(locale.getCountry()+"----"+locale.getDisplayLanguage()+"---"+locale.getLanguage());
//        }
        Locale locale = Locale.getDefault(Locale.Category.FORMAT);
        ResourceBundle resourceBundle =ResourceBundle.getBundle("mess",locale);
        System.out.println(resourceBundle.getString("hello"));
        System.out.println(MessageFormat.format(resourceBundle.getString("hello"),"小明","肉"));
        IntStream d = IntStream.builder().add(1).build();
        List<Integer> books = new ArrayList<>();
        books.add(1);
        Stream<Integer> integerStream = books.stream();
        integerStream.mapToInt()
    }
}