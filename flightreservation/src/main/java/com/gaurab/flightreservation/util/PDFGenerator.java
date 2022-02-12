package com.gaurab.flightreservation.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.springframework.stereotype.Component;

import com.gaurab.flightreservation.entity.Reservation;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@Component
public class PDFGenerator {
	public void generateItinerary(Reservation reservation, String filePath) {
		Document doc = new Document();
		// which document pdf we want to generate, filepath
		try {
			PdfWriter.getInstance(doc, new FileOutputStream(filePath));
			doc.open(); // it will open the pdf
			doc.add(generateTable(reservation));
			doc.close();

		} catch (FileNotFoundException | DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private PdfPTable generateTable(Reservation reservation) {
		PdfPTable table = new PdfPTable(2); // 2---> no of columns
		PdfPCell cell; //

		cell = new PdfPCell(new Phrase("Flight Itinerary"));
		cell.setColspan(2); // span 1 entire row
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("Flight Details"));
		cell.setColspan(2);
		table.addCell(cell);

		table.addCell("Airlines");
		table.addCell(reservation.getFlight().getOperatingAirlines());

		table.addCell("departure City");
		table.addCell(reservation.getFlight().getDepartureCity());

		table.addCell("Arrival City");
		table.addCell(reservation.getFlight().getArrivalCity());

		table.addCell("Flight Number");
		table.addCell(reservation.getFlight().getFlightNumber());

		cell = new PdfPCell(new Phrase("Flight Itinerary"));
		cell.setColspan(2); // span 1 entire row l;
		table.addCell(cell);

		table.addCell("FirstName");
		table.addCell(reservation.getPassenger().getFirstName());

		table.addCell("LastName");
		table.addCell(reservation.getPassenger().getLastName());

		table.addCell("Phone");
		table.addCell(reservation.getPassenger().getPhone());

		return table;

	}
}
