package it.begear.corso.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import it.begear.corso.dao.DAOscarpaImpl;
import it.begear.corso.entity.Scarpa;



@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		DAOscarpaImpl daoscarpa = context.getBean(DAOscarpaImpl.class);
		
		String keyword = (String) request.getParameter("keyword");
		String parameters = "";
		
		List<Scarpa> scarpaList = daoscarpa.findByKeyword(keyword);
		if (scarpaList.isEmpty()) {         // se non ci sono ordini
			 parameters += "<br/>"
					    +  "<h3> Non ci sono scarpe. </h3>"
	                    +  "<br/><br/>";
		}
		else {
			
			int index = 1;      // per stampare index di ogni scarpa secondo l'ordine della visualizzazione
			int counter = 1;     // Per rispettare il formato di ogni riga di html 
			
			for(Scarpa scarpa : scarpaList) {
				if(counter <= 2) {
					parameters += "<div class='product_box'>"
							   +      "<h3>" + scarpa.getCodice() + "</h3>"
							   +      "<a href='#'><img src='IMAGES/scarpe/" + scarpa.getCodice() + ".jpg' alt='Shoes " + index + "'/></a>"
							   +      "<p>" + scarpa.getDescrizione() + "</p>"
							   +    "<p class='product_price'>" + scarpa.getCosto() + "€ </p>"
							   +      "<a href='AddItemCartServlet?codice=" + scarpa.getCodice() + "&amp;quantita=1' class='addtocart'></a>"
							   +      "<a href='DetailItemServlet?codice=" + scarpa.getCodice() + "' class='detail'></a>"
							   +  "</div> \n";
					counter = 1;
				} else {
					parameters += "<div class='product_box no_margin_right'>"
							   +      "<h3>" + scarpa.getCodice() + "</h3>"
							   +      "<a href='#'><img src='IMAGES/scarpe/" + scarpa.getCodice() + ".jpg' alt='Shoes " + index + "'/></a>"
							   +      "<p>" + scarpa.getDescrizione() + "</p>"
							   +    "<p class='product_price'>" + scarpa.getCosto() + "€ </p>"
							   +      "<a href='AddItemCartServlet?codice=" + scarpa.getCodice() + "&amp;quantita=1' class='addtocart'></a>"
							   +      "<a href='DetailItemServlet?codice=" + scarpa.getCodice() + "' class='detail'></a>"
							   +  "</div> \n";
					
					parameters += "<div class='cleaner'></div> \n";
					counter++;
				}
				index++;
			}
		}
			request.setAttribute("scarpe", parameters);
			RequestDispatcher dispatcher = request.getRequestDispatcher("products.jsp");
			dispatcher.forward(request, response); 
			
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	
	
}
