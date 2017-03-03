package server.http.response;

import server.http.View;

/**
 * Created by cefothe on 03.03.17.
 */
public class ViewResponse extends HttpResponseImpl {

    public ViewResponse(HttpResponseCode responseCode, View view) {
        super(responseCode, view);
    }
}
