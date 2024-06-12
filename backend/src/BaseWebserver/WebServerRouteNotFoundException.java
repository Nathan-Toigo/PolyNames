package BaseWebserver;

public class WebServerRouteNotFoundException extends Exception {
    WebServerRouteNotFoundException(String method, String path)
    {
        super(String.format("Route not found : %s %s", method, path));
    }
}
