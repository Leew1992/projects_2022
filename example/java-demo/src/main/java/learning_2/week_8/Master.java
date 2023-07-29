package learning_2.week_8;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

public class Master implements Watcher {
    ZooKeeper zk;
    String hostPort;

    Master(String hostPort) {
        this.hostPort = hostPort;
    }

    void startZK() {
        try {
            zk = new ZooKeeper(hostPort, 15000, this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void process(WatchedEvent e) {
        System.out.println(e);
    }

    public static void main(String[] args) throws Exception {
        Master m = new Master("111.231.78.112:2181");

        m.startZK();

        // wait for a bit
        Thread.sleep(60000);
    }
}
