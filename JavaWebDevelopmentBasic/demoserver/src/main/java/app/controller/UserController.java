package app.controller;

import app.view.UserDetailsView;
import server.Model;
import server.http.response.HttpResponse;
import server.http.response.HttpResponseCode;
import server.http.response.ViewResponse;

/**
 * Created by cefothe on 03.03.17.
 */
public class UserController{

    public HttpResponse details(String name) {
        Model model = new Model();
        model.add("name", name);
        return  new ViewResponse(HttpResponseCode.OK,new UserDetailsView(model));
    }
}
