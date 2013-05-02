package com.ben.cd.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ben.cd.model.Album;
import com.ben.cd.model.Categorie;
import com.ben.cd.service.AlbumService;

public class CreationCD extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String titre = request.getParameter("titre");
		Album album = new Album();
		album.setTitre(titre);
		
//		Categorie categorie = request.getParameter( "categorie" );
//		album.setCategorie( categorie );

		AlbumService.getInstance().insertOrUpdate(album);

		// List<Album> allAlbums = AlbumService.getInstance().getAllAlbums();
		// List<Categorie> allCategories =
		// CategorieService.getInstance().getAllCategories();


		request.setAttribute("album", album);
		this.getServletContext()
				.getRequestDispatcher("/WEB-INF/jsp/creerAlbum.jsp")
				.forward(request, response);
	}
}