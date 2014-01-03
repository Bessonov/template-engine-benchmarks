package teb;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.stringtemplate.v4.ST;

import teb.model.Stock;

public class StringTemplate extends Bench {

	private ST st = null;

	public StringTemplate() {

	}

	@Override
	protected void init() {
		String template;
		try {
			template = readFile("./templates/stocks.stringtemplate.html");
			st = new ST(template, '$', '$');
		} catch (IOException e) {
			throw new RuntimeException("Cannot read file", e);
		}

	}

	private String readFile(final String filePath) throws IOException {
		FileInputStream input = new FileInputStream(filePath);

		byte[] fileData = new byte[input.available()];

		input.read(fileData);
		input.close();

		return new String(fileData, "UTF-8");
	}

	@Override
	protected void initParameters(final List<Stock> items) {
		st.add("name", "CARL");
		st.add("items", items);
	}

	@Override
	protected String renderToString(final List<Stock> items) {

		return st.render();
	}

	public static void main(final String[] args) {
		new StringTemplate().run();
	}

}
