package com.fntl.app.utils;

import com.fntl.app.model.Response_Model;
import com.fntl.app.utils.Api.RetrofitInstance;

import java.io.IOException;
import java.lang.annotation.Annotation;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Response;

public class ErrorUtils {

    public static Response_Model parseError(Response<?> response) {
        Converter<ResponseBody, Response_Model> converter =
                RetrofitInstance.instance
                        .responseBodyConverter(Response_Model.class, new Annotation[0]);

        Response_Model error;

        try {
            error = converter.convert(response.errorBody());
        } catch (IOException e) {
            return new Response_Model();
        }

        return error;
    }
}
