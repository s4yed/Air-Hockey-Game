package gameassets;

import gameobjects.Point;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.concurrent.CountDownLatch;

public class SocketClient {
    private Socket socket;
    private InetAddress host;
    private int port;

    /**
     * Socket Client class in order to connect to the AI game server.
     *
     * @param port The AI game server port.
     */
    public SocketClient(int port) {
        try {
            host = InetAddress.getLocalHost();
            socket = new Socket(host.getHostName(), port);
            this.port = port;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * A function that interact with the AI server.
     *
     * @param p     The point (x, y) to be predicted.
     * @param speed The velocity of the game object.
     * @return      The predicted point from the server.
     */
    public Point interact(Point p, float speed) {
        final Point[] predicted = new Point[1];
        final CountDownLatch latch = new CountDownLatch(1);
        new Thread(() -> {
            try {
                socket = new Socket(host.getHostName(), port);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                out.println(p.x + "," + p.y + "," + speed);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String[] response = in.readLine().split("\\s+");
                predicted[0] = new Point(Float.parseFloat(response[0]), Float.parseFloat(response[1]));
                latch.countDown();
                socket.close();
                Thread.sleep(100);
            } catch (IOException | InterruptedException e) {
                System.err.println(e.getMessage());
            }
        }).start();
        try {
            latch.await();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return predicted[0];
    }
}
