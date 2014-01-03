package teb;

import httl.Engine;
import httl.Template;

import java.io.OutputStream;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import teb.model.Stock;

public class Httl extends Bench {

	private Engine engine;
	private String templateFile = "/stocks.httl.html";
	private HashMap params;
	private Template template;

	public Httl() throws Exception {
	}

	@Override
	public void init() {
		Properties prop = new Properties();
		prop.setProperty("import.packages", "teb.model,java.util");
		prop.setProperty("filter", "null");
		prop.setProperty("logger", "null");
		engine = Engine.getEngine(prop);
	}

	/*
	@Override
	public void execute(final Writer w0, final Writer w1, int ntimes,
			final List<Stock> items) throws Exception {
		Map<String, Object> params = new HashMap();
		params.put("items", items);
		while (--ntimes >= 0) {
			Template template = engine.getTemplate(templateFile);

			if (ntimes == 0) {
				template.render(params, w1);
				w1.close();
			} else
				template.render(params, w0);
		}
	}

	@Override
	public void execute(final OutputStream o0, final OutputStream o1,
			int ntimes, final List<Stock> items) throws Exception {
		while (--ntimes >= 0) {

			if (ntimes == 0) {
				template.render(params, o1);
				o1.close();
			} else
				template.render(params, o0);
		}
	}
	*/
	@Override
	protected void initParameters(final List<Stock> items) throws Exception {
		params = new HashMap();
		params.put("items", items);
		template = engine.getTemplate(templateFile);
	}

	@Override
	protected boolean hasStringImplementation() {
		return false;
	}

	@Override
	protected void renderToStream(final List<Stock> items,
			final OutputStream output) throws Exception {
		template.render(params, output);
	}

	@Override
	protected void renderToWriter(final List<Stock> items, final Writer writer)
			throws Exception {
		template.render(params, writer);
	}

	public static void main(final String[] args) throws Exception {
		new Httl().run();
	}

}
