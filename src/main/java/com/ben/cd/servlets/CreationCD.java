package com.ben.cd.servlets;



import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ben.cd.model.Album;
import com.ben.cd.service.AlbumService;



public class CreationCD extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

    String titre = request.getParameter( "titre" );
    Album album = new Album();
    album.setTitre( titre );
    AlbumService.getInstance().insertOrUpdate(album);

    
//  String categorie = request.getParameter( "categorie" );
//    album.setCategorie( categorie );
    
    
    
    
    request.setAttribute( "album", album );
    this.getServletContext().getRequestDispatcher( "/jsp/creerAlbum.jsp" ).forward( request, response );
	}
}