package Publish_Subscribe.Server;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.nio.charset.StandardCharsets;

public class Server
{
  private static final String EXCHANGE_NAME = "logs";

  public static void main(String[] argv) throws Exception
  {
    ConnectionFactory factory = new ConnectionFactory();
    factory.setHost("localhost");

    Connection connection = factory.newConnection();
    Channel channel = connection.createChannel();

    channel.exchangeDeclare(EXCHANGE_NAME, "fanout", false, false, false, null);
    String message = "Hello World!";

    channel.basicPublish(EXCHANGE_NAME, EXCHANGE_NAME, null, message.getBytes(
        StandardCharsets.UTF_8));
    System.out.println(" [x] Sent '" + message + "'");

  }
}
