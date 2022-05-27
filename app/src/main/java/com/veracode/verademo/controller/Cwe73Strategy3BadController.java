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
public class Cwe73Strategy3BadController {
    @RequestMapping(value = "/avatar", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
    public void getImage(HttpServletResponse response, HttpServletRequest request) throws IOException {
        int variantNumber = Integer.parseUnsignedInt(request.getParameter("variantNumber"));
        FileInputStream imgFile = new FileInputStream("picture/" + variantNumber + ".png");
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        StreamUtils.copy(imgFile, response.getOutputStream());
    }
}
