package com.spotify.api.models.request.auth;

import groovy.lang.NamedValue;
import lombok.Data;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

@Data
public class AuthRequestBodyModel {

    private String grant_type;
    private String client_id;
    private String client_secret;

    public List<NameValuePair> getBodyParams() {
        List<NameValuePair> bodyParamsList = new ArrayList<>();
        bodyParamsList.add(new BasicNameValuePair("grant_type", getGrant_type()));
        bodyParamsList.add(new BasicNameValuePair("client_id", getClient_id()));
        bodyParamsList.add(new BasicNameValuePair("client_secret", getClient_secret()));
        return bodyParamsList;
    }
}
