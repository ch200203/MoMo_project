package momo.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Process {
	public void process(HttpServletRequest request, HttpServletResponse response, PrintWriter out) 
			throws ServletException, IOException;
}