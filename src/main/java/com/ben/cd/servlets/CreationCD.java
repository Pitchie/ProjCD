package com.ben.cd.servlets;



import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ben.cd.beans.Album;



public class CreationCD extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

    String titre = request.getParameter( "titre" );
//    String categorie = request.getParameter( "categorie" );

    Album album = new Album();
    album.setTitre( titre );
//    album.setCategorie( categorie );

    request.setAttribute( "album", album );
    this.getServletContext().getRequestDispatcher( "/afficherAlbum.jsp" ).forward( request, response );
	}
}