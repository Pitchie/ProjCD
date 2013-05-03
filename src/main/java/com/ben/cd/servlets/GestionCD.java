package com.ben.cd.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ben.cd.model.Album;
import com.ben.cd.service.AlbumService;

public class GestionCD extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String current = request.getParameter("current");
		String status = request.getParameter("status");
		Album album = new Album();
		String test = "delete";
		if (test.equals(status)){
			AlbumService.getInstance().deleteByTitre(album, current);
		}

		List<Album> liste = AlbumService.getInstance().getAllAlbums();
		request.setAttribute("liste", liste);
		this.getServletContext()
				.getRequestDispatcher("/WEB-INF/jsp/gererAlbum.jsp")
				.forward(request, response);
	}
}
