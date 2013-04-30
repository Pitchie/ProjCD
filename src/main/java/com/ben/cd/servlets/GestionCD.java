package com.ben.cd.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ben.cd.model.Album;

public class GestionCD extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
		public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		
		Album album = new Album();
		
		//  List<Album> allAlbums = AlbumService.getInstance().getAllAlbums();
		//  List<Categorie> allCategories = CategorieService.getInstance().getAllCategories();
		    
		//String categorie = request.getParameter( "categorie" );
		//  album.setCategorie( categorie );
		
		  
		  request.setAttribute( "album", album );
		  this.getServletContext().getRequestDispatcher( "/WEB-INF/jsp/gererAlbum.jsp" ).forward( request, response );
	}
}
