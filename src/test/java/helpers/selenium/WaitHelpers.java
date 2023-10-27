package helpers.selenium;

public class WaitHelpers {

    public static void wait(int sn){

        try {
            Thread.sleep(sn* 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
