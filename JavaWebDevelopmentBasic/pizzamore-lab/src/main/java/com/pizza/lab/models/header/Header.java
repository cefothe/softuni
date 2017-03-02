package com.pizza.lab.models.header;

import com.pizza.lab.cookie.Cookie;

/**
 * Created by cefothe on 03.03.17.
 */
public class Header {

    private static final String CONTENT_TYPE ="Content-type: text/html";

    private Cookie cookie;

    private String location;

    public Header() {
    }

    public Cookie getCookie() {
        return cookie;
    }

    public void setCookie(Cookie cookie) {
        this.cookie = cookie;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void printHeader(){
        System.out.println(Header.CONTENT_TYPE);

        if(cookie!=null){
            System.out.println("Set-Cookie:"+cookie.getCookie());
        }

        if(location!=null){
            System.out.println("Location:" + this.location);
        }

        System.out.println();
    }
}
