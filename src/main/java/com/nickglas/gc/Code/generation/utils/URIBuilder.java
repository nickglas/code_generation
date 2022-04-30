package com.nickglas.gc.Code.generation.utils;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

public class URIBuilder {
    public static URI build(String path){
        return URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path(path).toUriString());
    }
}
