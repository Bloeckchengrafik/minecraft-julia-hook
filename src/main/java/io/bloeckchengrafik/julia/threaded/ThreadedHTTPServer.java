package io.bloeckchengrafik.julia.threaded;

import com.sun.net.httpserver.HttpServer;
import io.bloeckchengrafik.julia.MinecraftJl;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadedHTTPServer extends Thread {

    HttpServer server;
    ThreadPoolExecutor threadPoolExecutor;

    /**
     * If this thread was constructed using a separate
     * <code>Runnable</code> run object, then that
     * <code>Runnable</code> object's <code>run</code> method is called;
     * otherwise, this method does nothing and returns.
     * <p>
     * Subclasses of <code>Thread</code> should override this method.
     *
     * @see #start()
     * @see #stop()
     */
    @Override
    public void run() {
        try {
            server = HttpServer.create(new InetSocketAddress("localhost", 3672), 0);
            threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
            server.createContext("/connect", new ConnectionHttpHandler());
            server.setExecutor(threadPoolExecutor);
            server.start();

            MinecraftJl.logger.info("Julia Receptor Server started on port 3672");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
