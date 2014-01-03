/*
 * $Copyright: copyright(c) 2007-2011 kuwata-lab.com all rights reserved. $
 * $License: Creative Commons Attribution (CC BY) $
 */
package teb;

import java.io.OutputStream;
import java.io.Writer;
import java.util.List;
import java.util.Properties;

import org.rythmengine.RythmEngine;

import teb.model.Stock;

public class NewRythm extends Bench {

	RythmEngine engine;
	private String template = "templates/stocks.newrythm.html";

	public NewRythm() {

	}

	@Override
	protected void init() {
		Properties p = new Properties();
		p.put("log.enabled", false);
		p.put("feature.smart_escape.enabled", false);
		p.put("feature.transform.enabled", false);
		engine = new RythmEngine(p);
	}

	@Override
	protected void shutdown() {
		engine.shutdown();
	}

	/*
		@Override
		public void execute(final Writer w0, final Writer w1, int ntimes,
				final List<Stock> items) throws Exception {
			String tmpl = template;
			boolean newAPI = Boolean.parseBoolean(System.getProperty("rythm.new",
					"true"));
			if (newAPI) {
				while (--ntimes >= 0) {
					if (ntimes == 0) {
						engine.render(w1, tmpl, items);
						w1.close();
					} else {
						engine.render(w0, tmpl, items);
					}
				}
			} else {
				String output;
				while (--ntimes >= 0) {
					output = engine.render(tmpl, items);
					if (ntimes == 0) {
						w1.write(output);
						w1.close();
					} else {
						w0.write(output);
					}
				}
			}
		}

		/*
			@Override
			public void execute(final OutputStream o0, final OutputStream o1,
					int ntimes, final List<Stock> items) throws Exception {
				String tmpl = template;
				boolean newAPI = Boolean.parseBoolean(System.getProperty("rythm.new",
						"true"));
				if (newAPI) {
					while (--ntimes >= 0) {
						if (ntimes == 0) {
							engine.render(o1, tmpl, items);
							o1.close();
						} else {
							engine.render(o0, tmpl, items);
						}
					}
				} else {
					String output;
					Writer w0 = new OutputStreamWriter(o0);
					Writer w1 = new OutputStreamWriter(o1);
					if (_BenchBase.bufferMode.get()) {
						w0 = new BufferedWriter(w0);
						w1 = new BufferedWriter(w1);
					}
					while (--ntimes >= 0) {
						output = engine.render(tmpl, items);
						if (ntimes == 0) {
							w1.write(output);
							w1.close();
						} else {
							w0.write(output);
						}
					}
				}
			}

			@Override
			protected String execute(int ntimes, final List<Stock> items)
					throws Exception {
				String tmpl = template;
				String output = null;
				while (--ntimes >= 0) {
					output = engine.render(tmpl, items);
				}
				return output;
			}
		*/
	@Override
	protected void renderToStream(final List<Stock> items,
			final OutputStream output) throws Exception {
		engine.render(output, template, items);
	}

	@Override
	protected void renderToWriter(final List<Stock> items, final Writer writer)
			throws Exception {
		engine.render(writer, template, items);
	}

	@Override
	protected String renderToString(final List<Stock> items) {
		String output = engine.render(template, items);
		return output;
	}

	public static void main(final String[] args) {
		new NewRythm().run();
	}

}
