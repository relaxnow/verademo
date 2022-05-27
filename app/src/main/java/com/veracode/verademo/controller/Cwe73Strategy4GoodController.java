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
import java.util.regex.Pattern;

@RestController
public class Cwe73Strategy4GoodController extends Cwe73BaseController {
    @RequestMapping(value = "/avatar", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
    public void getImage(HttpServletResponse response, HttpServletRequest request) throws IOException {
        FileInputStream imgFile = new FileInputStream(buildValidAvatarPath("images/", request));
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        StreamUtils.copy(imgFile, response.getOutputStream());
    }

    // [[LINK]]
    // To learn more about the optional @FilePathCleanser attribute please visit:
    // https://community.veracode.com/s/article/How-To-Use-Custom-Cleanser
    // @FilePathCleanser
    public static String buildValidAvatarPath(String configPath,  HttpServletRequest request) {
        String username = request.getParameter("username");
        if (!Pattern.matches("^[a-zA-Z0-9]+$", username)) {
            throw new ValidationException("Invalid username", username);
        }
        String path = configPath + "/" + username + "/avatar.png";

        // See "Note on authorization"
        User user = getCurrentUser();
        if (!userMayAccessFile(user, path)) {
            throw new AuthorizationException("User may not access this file", user);
        }

        return path;
    }
}
