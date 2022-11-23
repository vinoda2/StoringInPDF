package NewsPaper;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.text.PDFTextStripper;

public class NewsData {

	String newsInfo="This is very importent news keep reading";
	File file = new File("NewsData.pdf");
	//method to create pdf
	public void createPDF() throws IOException {
		//creating a empty pdf
		PDDocument doc=new PDDocument();
		
		for(int i=0;i<=1;i++) {
			PDPage blankPage = new PDPage();
			doc.addPage( blankPage );
		}
		 
		doc.save(file);
		doc.close();
		System.out.println("PDF created succussfully");
	}
	
	public void saveData() throws IOException {
		PDDocument doc=PDDocument.load(file);
		PDPage page=doc.getPage(0);
		PDPageContentStream stream = new PDPageContentStream(doc, page, PDPageContentStream.AppendMode.APPEND,true,true);
		stream.beginText();
		stream.setFont(PDType1Font.TIMES_ROMAN, 12);
		stream.newLineAtOffset(1, 100);
		stream.showText(newsInfo);
		stream.endText();
		stream.close();
		doc.save(file);
		System.out.println("News data stored successfully");
		doc.close();
	}
	
	public void readData()throws IOException{
		PDDocument doc=PDDocument.load(file);
		PDFTextStripper pdfstriper=new PDFTextStripper();
		String text=pdfstriper.getText(doc);
		System.out.println(text);
		System.out.println("succussfully displayed the pdf content");
		doc.close();
	}
	
	public void pdfDescription()throws IOException{
		PDDocument doc=new PDDocument();
		PDDocumentInformation pdd = doc.getDocumentInformation();

		pdd.setAuthor("Vinoda");
		pdd.setCreator("Java");
		pdd.setSubject("Data Manipulation");
		pdd.setTitle("Data Handling");
		//Setting the created date of the document 
	      Calendar date = new GregorianCalendar();
	      date.set(2022, 23, 11); 
	      pdd.setCreationDate(date);
	      doc.save(file);
	      doc.close();
	      System.out.println("pdf description added succussfully");
	}
}
