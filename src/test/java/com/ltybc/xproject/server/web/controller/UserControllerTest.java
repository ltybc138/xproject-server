package com.ltybc.xproject.server.web.controller;

import com.google.gson.Gson;
import com.ltybc.xproject.server.model.Role;
import com.ltybc.xproject.server.model.User;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


public class UserControllerTest {

    private final String HOST = "http://localhost:8090/";

    @Test
    public void whenGiveAllUsersIsRetrieved_then200isReceived() throws Exception {
        HttpUriRequest request = new HttpGet(HOST + "users");

        HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);

        assertThat(httpResponse.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_OK));
    }

    @Test
    public void givenUserNotExist_whenUserInfoIsRetrieved_then404IsReceived() throws Exception {
        String name = RandomStringUtils.randomAlphabetic(8);
        HttpUriRequest request = new HttpGet(HOST + "users/" + name);

        HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);

        assertThat(httpResponse.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_NOT_FOUND));
    }

    @Test
    public void givenUserDoExist_whenUserInfoIsRetrieved_then200IsReceived() throws Exception {
        String name = "denis";
        HttpUriRequest request = new HttpGet(HOST + "users/" + name);

        HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);

        assertThat(httpResponse.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_OK));
    }

    @Test
    public void newUserHasNoLogin_whenCreateNewUserIsRetrieved_then400IsReceived() throws Exception {
        User user = new User();
        user.setPassword("password");
        user.setEmail("someperson@gmail.com");
        user.setRole(Role.USER);

        Gson gson = new Gson();
        String json = gson.toJson(user);

        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost request = new HttpPost(HOST + "users/");

        StringEntity entity = new StringEntity(json);
        request.setEntity(entity);
        request.setHeader("Accept", "application/json");
        request.setHeader("Content-type", "application/json");

        CloseableHttpResponse response = client.execute(request);
        assertThat(response.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_BAD_REQUEST));
    }

    @Test
    public void newUserHasNoPassword_whenCreateNewUserIsRetrieved_then400IsReceived() throws Exception {
        User user = new User();
        user.setLogin("abracadabra");
        user.setEmail("someperson@gmail.com");
        user.setRole(Role.USER);

        Gson gson = new Gson();
        String json = gson.toJson(user);

        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost request = new HttpPost(HOST + "users/");

        StringEntity entity = new StringEntity(json);
        request.setEntity(entity);
        request.setHeader("Accept", "application/json");
        request.setHeader("Content-type", "application/json");

        CloseableHttpResponse response = client.execute(request);
        assertThat(response.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_BAD_REQUEST));
    }

    @Test
    public void newUserHasNoEmail_whenCreateNewUserIsRetrieved_then400IsReceived() throws Exception {
        User user = new User();
        user.setLogin("abracadabra");
        user.setPassword("password");
        user.setRole(Role.USER);

        Gson gson = new Gson();
        String json = gson.toJson(user);

        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost request = new HttpPost(HOST + "users/");

        StringEntity entity = new StringEntity(json);
        request.setEntity(entity);
        request.setHeader("Accept", "application/json");
        request.setHeader("Content-type", "application/json");

        CloseableHttpResponse response = client.execute(request);
        assertThat(response.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_BAD_REQUEST));
    }

    @Test
    public void newUserHasAllParams_whenCreateNewUserIsRetrieved_then201IsReceived() throws Exception {
        User user = new User();
        user.setLogin("abracadabra");
        user.setPassword("password");
        user.setEmail("somepearson@gmail.com");
        user.setRole(Role.USER);

        Gson gson = new Gson();
        String json = gson.toJson(user);

        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost request = new HttpPost(HOST + "users/");

        StringEntity entity = new StringEntity(json);
        request.setEntity(entity);
        request.setHeader("Accept", "application/json");
        request.setHeader("Content-type", "application/json");

        CloseableHttpResponse response = client.execute(request);
        assertThat(response.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_OK));
    }

    @Test
    public void updateNotRegisteredUser_whenUpdateUserIsRetrieved_then400IsReceived() throws Exception {
        User user = new User();
        user.setId(1L);
        user.setLogin("abcdefg");
        user.setEmail("abs@gmail.com");
        user.setPassword("password");
        user.setRole(Role.USER);

        Gson gson = new Gson();
        String json = gson.toJson(user);

        CloseableHttpClient client = HttpClients.createDefault();
        HttpPut request = new HttpPut(HOST + "users/");

        StringEntity entity = new StringEntity(json);
        request.setEntity(entity);
        request.setHeader("Accept", "application/json");
        request.setHeader("Content-type", "application/json");

        CloseableHttpResponse response = client.execute(request);
        assertThat(response.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_BAD_REQUEST));
    }

    @Test
    public void updateRegisteredUser_whenUpdateUserIsRetrieved_then202IsReceived() throws Exception {
        // TODO
    }

    @Test
    public void deleteNotRegisteredUser_whenDeleteUserIsRetrieved_then400IsReceived() throws Exception {
        // TODO
    }

    @Test
    public void deleteRegisteredUser_whenDeleteUserIsRetrieved_then202IsReceived() throws Exception {
        // TODO
    }


}
