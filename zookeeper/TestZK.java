import org.apache.zookeeper.*;
import org.apache.zookeeper.ZooDefs.*;

public class TestZK {
    private static final String  url = "192.168.159.128:2181";

    public static void main(String[] args) throws Exception {
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
        ZooKeeper zk = new ZooKeeper(url, 3000, 
                new Watcher() { 
                    public void process(WatchedEvent event) { 
                        System.out.println("triggered " + event.getType() + "event."); 
                    } 
                }); 

        zk.create("/testRootPath", "testRootData".getBytes(), Ids.OPEN_ACL_UNSAFE,
                CreateMode.PERSISTENT); 

        zk.create("/testRootPath/testChildPathOne", "testChildDataOne".getBytes(),
                Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT); 
        System.out.println(new String(zk.getData("/testRootPath",false,null))); 

        System.out.println(zk.getChildren("/testRootPath",true)); 

        zk.setData("/testRootPath/testChildPathOne","modifyChildDataOne".getBytes(),-1); 
        System.out.println("state of directory["+zk.exists("/testRootPath",true)+"]"); 

        zk.create("/testRootPath/testChildPathTwo", "testChildDataTwo".getBytes(), 
                Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT); 
        System.out.println(new String(zk.getData("/testRootPath/testChildPathTwo",true,null))); 

        zk.delete("/testRootPath/testChildPathTwo",-1); 
        zk.delete("/testRootPath/testChildPathOne",-1); 

        zk.delete("/testRootPath",-1); 

        zk.close();
    }
}
