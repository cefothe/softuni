package app.controller;

import app.view.HomeIndexView;
import server.http.response.HttpResponse;
import server.http.response.HttpResponseCode;
import server.http.response.ViewResponse;

/**
 * Created by cefothe on 03.03.17.
 */
public class HomeController {

    public HttpResponse index(){
        return new ViewResponse(HttpResponseCode.OK, new HomeIndexView());
    }
}
