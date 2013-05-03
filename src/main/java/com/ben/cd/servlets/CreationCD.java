package com.ben.cd.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ben.cd.model.Album;
import com.ben.cd.model.Categorie;
import com.ben.cd.service.AlbumService;
import com.ben.cd.service.CategorieService;

public class CreationCD extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String titre = request.getParameter("titre");
		String style = request.getParameter("style");
		Album album = new Album();
		album.setTitre(titre);
		album.setStyle(style);
		List<Categorie> liste = CategorieService.getInstance()
				.getAllCategories();
		List<Album> listebis = AlbumService.getInstance().getAllAlbums();
		
		if (!listebis.contains(titre) && titre != "")
			AlbumService.getInstance().insertOrUpdate(album);
		
		request.setAttribute("album", album);
		request.setAttribute("liste", liste);
		this.getServletContext()
				.getRequestDispatcher("/WEB-INF/jsp/creerAlbum.jsp")
				.forward(request, response);
	}
}