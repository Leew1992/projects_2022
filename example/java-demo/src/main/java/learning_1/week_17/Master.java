package learning_1.week_17;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.security.SecureRandom;

import static org.apache.zookeeper.ZooDefs.Ids.OPEN_ACL_UNSAFE;

public class Master implements Watcher {
    ZooKeeper zk;
    String hostPort;

    public Master(String hostPort) {
        this.hostPort = hostPort;
    }

    void startZK() {
        try {
            zk = new ZooKeeper(hostPort, 1500, this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void stopZK() {
        try {
            zk.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void process(WatchedEvent e) {
        System.out.println(e);
    }

    String serverId = Integer.toString(new SecureRandom().nextInt(1000));
    boolean isLeader = false;

    boolean checkMaster() {
        while (true) {
            try {
                Stat stat = new Stat();
                byte data[] = zk.getData("/master", false, stat);

                isLeader = new String(data).equals(serverId);

                return true;
            } catch (Exception e) {
                return false;
            }
        }
    }

    void runForMaster() {
        while (true) {
            try {
                zk.create("/master", serverId.getBytes(), OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
                isLeader = true;
                break;
            } catch (Exception e) {
                isLeader = false;
                break;
            }
            // if (checkMaster()) break;
        }
    }

    public static void main(String[] args) throws Exception {
        /*Master m = new Master("111.231.78.112:2181");
        m.startZK();
        Thread.sleep(60000);
        m.stopZK();*/

        Master m = new Master("111.231.78.112:2181");
        m.startZK();
    }
}
