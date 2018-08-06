package com.ltybc.xproject.server.web.controller;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ProductControllerTest {
    private static final String HOST = "http://localhost:8090";

    @Test
    public void whenGetAllProductsIsRetrieved_then200IsReceived() throws Exception {
        HttpUriRequest request = new HttpGet(HOST + "/products");

        HttpResponse response = HttpClientBuilder.create().build().execute(request);

        assertThat(response.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_OK));
    }

    @Test
    public void givenProductNotExist_whenProductInfoIsRetrieved_then404IsReceived() throws Exception {
        int id = 10000;
        HttpUriRequest request = new HttpGet(HOST + "products/" + id);

        HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);

        assertThat(httpResponse.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_NOT_FOUND));
    }

    @Test
    public void givenProductDoExist_whenProductInfoIsRetrieved_then200IsReceived() throws Exception {
        int id = 1;
        HttpUriRequest request = new HttpGet(HOST + "products/" + id);

        HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);

        assertThat(httpResponse.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_OK));
    }
}
