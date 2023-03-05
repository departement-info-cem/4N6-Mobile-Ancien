package org.deguet.retrofit2_demo.http;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;

public class SessionCookieJar implements CookieJar {

    private List<Cookie> cookies;

    @Override
    public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
        this.cookies = new ArrayList<>(cookies);
    }


    @Override
    public List<Cookie> loadForRequest(HttpUrl url) {
        // TODO verifier si l'URL est la même que l'origine du cookie
        // TODO verifier qu'il n'est pas expiré.
        if (cookies != null) {
            return cookies;
        }
        return Collections.emptyList();
    }
}