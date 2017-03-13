package server.http.response;

/**
 * Created by cefothe on 03.03.17.
 */
public class RedirectResponse extends  HttpResponseImpl {

    public RedirectResponse(String redirectUrl) {
        super(redirectUrl);
    }
}
