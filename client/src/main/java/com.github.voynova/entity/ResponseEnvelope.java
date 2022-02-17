package com.github.voynova.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Value;

import java.io.Serializable;

@Getter
@Value
public class ResponseEnvelope {

    private String status;
    private String error;
    private Serializable data;

    public ResponseEnvelope(@JsonProperty("status") String status,
                            @JsonProperty("error") String error,
                            @JsonProperty("data") Serializable data) {
        this.status = status;
        this.error = error;
        this.data = data;
    }
}
