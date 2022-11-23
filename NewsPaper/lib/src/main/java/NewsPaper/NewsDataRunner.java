package NewsPaper;

import java.io.IOException;

public class NewsDataRunner {

	public static void main(String[] args) throws IOException {
		NewsData nd = new NewsData();
		nd.createPDF();
		nd.saveData();
		nd.readData();
		nd.pdfDescription();
	}

}
