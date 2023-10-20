package drivers;

public class MyFunc {

    public static void Bekle(int sn){

        try {
            Thread.sleep(sn* 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
