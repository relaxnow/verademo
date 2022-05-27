package com.veracode.verademo.controller;

import com.veracode.verademo.utils.User;
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
public class Cwe73Strategy2GoodController extends Cwe73BaseController {
    @RequestMapping(value = "/avatar", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
    public void getImage(HttpServletResponse response, HttpServletRequest request) throws IOException {
        FileInputStream imgFile = new FileInputStream(buildValidAvatarPath("images/", request));
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        StreamUtils.copy(imgFile, response.getOutputStream());
    }

    // [[LINK]]
    public String buildValidAvatarPath(String configPath, HttpServletRequest request) {
        String[] allowedExtensions = new String[]{"jpg","gif","png"};
        String extension = "png"; // Default extension
        for (String allowedExtension: allowedExtensions) {
            if (allowedExtension.equals(request.getParameter("extension"))) {
                extension = allowedExtension;
            }
        }
        String path = configPath + "avatar." + extension;
        // See "Note on authorization"
        User user = getCurrentUser();
        if (!userMayAccessFile(user, path)) {
            throw new AuthorizationException("User may not access this file", user);
        }
        return path;
    }
}
