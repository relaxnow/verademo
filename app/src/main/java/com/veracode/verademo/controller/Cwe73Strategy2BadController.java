package com.veracode.verademo.controller;

import org.springframework.http.MediaType;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

@RestController
public class Cwe73Strategy2BadController {
    @RequestMapping(value = "/avatar", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
    public void getImage(HttpServletResponse response, HttpServletRequest request) throws IOException {
        FileInputStream imgFile = new FileInputStream(buildValidAvatarPath("images/", request));
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        StreamUtils.copy(imgFile, response.getOutputStream());
    }

    // WARNING DO NOT USE THIS VULNERABLE CODE
    public String buildValidAvatarPath(String configPath, HttpServletRequest request) {
        return configPath + "avatar." + request.getParameter("extension");
    }
}
