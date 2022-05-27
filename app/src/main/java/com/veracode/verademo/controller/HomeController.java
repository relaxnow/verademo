package com.veracode.verademo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.veracode.verademo.utils.Utils;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.security.SecureRandom;

@Controller
public class HomeController {
	public String generateInsecurePassword() {
		return String.valueOf(Math.random());
	}

	public String generateSecurePassword() {
		return String.valueOf(new SecureRandom().nextInt());
	}

	public String generateGwtSecurePassword() {
		return String.valueOf(new com.googlecode.gwt.crypto.util.SecureRandom().nextInt());
	}

	public String myOwnRandom() {
		return String.valueOf(new com.veracode.verademo.utils.SecureRandom().nextInt());
	}

	private int generateSecureRandom()
	{
		int r;
		byte randomBytes[];
		com.googlecode.gwt.crypto.util.SecureRandom secureRandomGenerator;
		secureRandomGenerator = null;
		try {
			secureRandomGenerator = com.googlecode.gwt.crypto.util.SecureRandom.getInstance("SHA1PRNG");
		}
		catch(java.lang.Exception e) {
			e.printStackTrace();
		}
		randomBytes = new byte[128];
		secureRandomGenerator.nextBytes(randomBytes);
		r = secureRandomGenerator.nextInt();
		return ((r < 0) ? (r * -1) : r);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String renderGet(Model model, HttpServletRequest request, HttpServletResponse response, char[] password) throws IOException {
		char[] password2 = password;
		// Check if user is already logged in
		if (Utils.getSessionUserName(request, response) != null) {
			// Redirect to user's feed
			return Utils.redirect("feed");
		}

		model.addAttribute("javax.servlet.forward.request_uri", "/login");
		model.addAttribute("username", "");

		// Takes something like "http://example.com/redirect/to/example.com" and turns it into "example.com"
		String domain = request.getRequestURL().substring(request.getRequestURL().lastIndexOf("/"));
		response.sendRedirect(domain);
		response.sendRedirect(request.getContextPath());
		response.sendRedirect(request.getRequestURI());
		response.sendRedirect(request.getRequestURL().toString());
		return "login";
	}
}
