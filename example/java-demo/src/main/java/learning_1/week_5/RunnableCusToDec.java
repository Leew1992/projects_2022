package learning_1.week_5;

public class RunnableCusToDec implements Runnable {

    private ShareData shareData;

    public RunnableCusToDec(ShareData data) {
        this.shareData = data;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i ++) {
            shareData.dec();
        }
    }

    /*public static void main(String[] args) {

        ShareData shareData = new ShareData();

        for (int i = 0; i < 4; i ++) {
            new Thread(new RunnableCusToInc(shareData), "Thread " + i).start();
        }
    }*/

    public static void main(String[] args) {
        ShareData shareData = new ShareData();

        for (int i = 0; i < 4; i ++) {
            if (i % 2 == 0) {
                new Thread(new RunnableCusToDec(shareData), "Thread" + i).start();
            } else {
                new Thread(new RunnableCusToDec(shareData), "Thread" + i).start();
            }
        }
    }
}
