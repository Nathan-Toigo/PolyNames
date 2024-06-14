import webserver.WebServer;
import webserver.WebServerContext;
import webserver.WebServerResponse;
import webserver.WebServerSSEEventType;

public class App {
    public static void main(String[] args) throws Exception {
        WebServer webServer = new WebServer();
        final int port_number = 8000;
        // ConnectCallback connectCallback = new ConnectCallback();
        // SubscribeCallback subscribeCallback = new SubscribeCallback();
        // UnsubscribeCallback unsubscribeCallback = new UnsubscribeCallback();
        // webServer.getSSE().addEventListeners(WebServerSSEEventType.CONNECT, connectCallback);
        // webServer.getSSE().addEventListeners(WebServerSSEEventType.SUBSCRIBE, subscribeCallback);
        // webServer.getSSE().addEventListeners(WebServerSSEEventType.UNSUBSCRIBE, unsubscribeCallback);
        webServer.getRouter().post("/id/:id/:channelId", (WebServerContext context) -> {
            WebServerResponse response = context.getResponse();
            int id = Integer.parseInt(context.getRequest().getParam("id"));
            String channelId = context.getRequest().getParam("channelId");
            System.out.println("id: " + id + " channelId: " + channelId);
            context.getSSE().emit(channelId, "{\"id\":" + id + ", \"channelId\":\"" + channelId + "\"}");
            response.ok("Enchère effectuée avec succès");

        });
        webServer.listen(port_number);

    }

}
