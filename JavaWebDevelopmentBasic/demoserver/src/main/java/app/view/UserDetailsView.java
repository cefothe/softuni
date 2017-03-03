package app.view;

import server.Model;
import server.http.View;

/**
 * Created by cefothe on 03.03.17.
 */
public class UserDetailsView implements View {

    private final Model model;

    public UserDetailsView(Model model) {
        this.model = model;
    }

    @Override
    public String view() {
        return (String)model.get("name");

    }
}
