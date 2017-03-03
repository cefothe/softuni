package app.view;


import server.http.View;

/**
 * Created by cefothe on 03.03.17.
 */
public class HomeIndexView implements View {



    @Override
    public String view() {
        return "<html><body><h1>Welcome</h1></body></html>";
    }
}
