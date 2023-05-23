package Part12;

public class CheckAndDoActionApplication {

    private volatile boolean flag;

    public static void main(String[] args) throws InterruptedException {
        CheckAndDoActionApplication checkAndDoActionApplication = new CheckAndDoActionApplication();

        new Thread(()->{
            while (!checkAndDoActionApplication.flag){
                ;
            }
            System.out.println(checkAndDoActionApplication.flag);
        }).start();

        System.out.println( "Wait for 4 s");

        Thread.sleep(4000);

        System.out.println("Change flag value");
        checkAndDoActionApplication.flag=true;
    }
}
