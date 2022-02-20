package com.github.voynova.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@AllArgsConstructor
@Getter
public class ResponseEnvelope {
    private String status;
    private String error;
    private Serializable data;

}
