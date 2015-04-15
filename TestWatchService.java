import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchService;
import java.nio.file.WatchKey;  
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

public class TestWatchService {

    public static void main(String[] args) throws Exception {
        TestWatchService tws = new TestWatchService();
        tws.testResourceChanged();

    }

    public void testResourceChanged() throws IOException, InterruptedException,
           ExecutionException {

        final String pathName = TestWatchService.class.getResource("./").getPath();


        Executors.newCachedThreadPool().submit(new Runnable() {
            public void run() {
                try {
                    WatchService watchService = FileSystems.getDefault().newWatchService();
                    Path path = Paths.get(pathName);

                    path.register(watchService, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE);

                    while (true) {
                        WatchKey key = watchService.take();
                        List<WatchEvent<?>> watchEvents = key.pollEvents();
                        for (WatchEvent<?> watchEvent : watchEvents) {
                            System.out.printf("[%s]file occur [%s] event.%n", watchEvent.context(), watchEvent.kind());
                        }

                        if (!key.reset()) {
                            break;
                        }

                    }
               } catch (Exception e) {

               }
            }
        });

        Thread.sleep(1000);

        Path path2 = Paths.get(pathName + "test.xml");
        File file = path2.toFile();
        file.createNewFile();
        file.delete();

        Thread.sleep(1000);
    }
}

