package com.veracode.verademo.utils;

import com.veracode.annotation.FilePathCleanser;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

public class Cwe73Util {
    // WARNING DO NOT USE THIS VULNERABLE CODE
//    public String buildValidAvatarPath1(String configPath, HttpServletRequest request) {
//        return configPath + "avatar." + request.getParameter("extension");
//    }
//
//    // [[LINK]]
//    public String buildValidAvatarPath2(String configPath, HttpServletRequest request) {
//        int variantNumber = Integer.parseUnsignedInt(request.getParameter("variantNumber"));
//
//        File f = new File("picture/" + variantNumber + ".png");
//
//        String[] allowedExtensions = new String[]{"jpg","gif","png"};
//        String extension = "png"; // Default extension
//        for (String allowedExtension: allowedExtensions) {
//            if (allowedExtension.equals(request.getParameter("extension"))) {
//                extension = allowedExtension;
//            }
//        }
//        String path = configPath + "avatar." + extension;
//        // See "Note on authorization"
//        User user = getCurrentUser();
//        if (!userMayAccessFile(user, path)) {
//            throw new AuthorizationException("User may not access this file", user);
//        }
//        return path;
//    }
//
//    // [[LINK]]
//// To learn more about the optional @FilePathCleanser attribute please visit:
//// https://community.veracode.com/s/article/How-To-Use-Custom-Cleanser
//// @FilePathCleanser
//    public static String buildValidAvatarPath(String username) {
//        if (!username.match("[a-zA-Z0-9]")) {
//            throw new ValidationException("Invalid username", username);
//        }
//        String path = configPath + "/" + username + "/avatar.png";
//        // See "Note on authorization"
//        User user = getCurrentUser();
//        if (!userMayAccessFile(user, path)) {
//            throw new AuthorizationException("User may not access this file", user);
//        }
//        return path;
//    }
//
//    public static File buildFile(HttpServletRequest request) {
//        // GOOD CODE
//        String extension = request.getParameter("extension");
//        File f = new File(buildValidAvatarPath(extension));
//
//        return f;
//    }
//
//    // See: https://community.veracode.com/s/article/How-To-Use-Custom-Cleanser
//    //@FilePathCleanser
//    public String buildValidAvatarPath(String configPath, String requestedExtension) {
//        String[] allowedExtensions = new String[]{"jpg","gif","png"};
//        String extension = "png"; // Default extension
//        for (String allowedExtension: allowedExtensions) {
//            if (allowedExtension.equals(requestedExtension)) {
//                extension = requestedExtension;
//            }
//        }
//        String path = configPath + "avatar." + extension;
//
//        // See "Note on authorization"
//        User user = getCurrentUser();
//        if (!userMayAccessFile(user, path)) {
//            throw new AuthorizationException("User may not access this file", user);
//        }
//
//        return path;
//    }
//
//    public static User getCurrentUser() {
//        return new User();
//    }
//
//    public static boolean userMayAccessFile(User user, String path) {
//        return true;
//    }
//
//    class AuthorizationException extends RuntimeException {
//        public AuthorizationException(String message, Object variable) {
//
//        }
//    }
}
