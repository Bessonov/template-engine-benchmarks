/*
 * $Copyright: copyright(c) 2007-2011 kuwata-lab.com all rights reserved. $
 * $License: Creative Commons Attribution (CC BY) $
 */
package teb;

import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.List;

import teb.model.Stock;

import com.googlecode.jatl.Html;

public class Jatl extends _BenchBase {
	static class JatlTemplate {
		public static Html render(Writer writer, List<Stock> items) {
			Html html = new Html(writer);
			html.raw("<?xml version=\"1.0\" encoding=\"UTF-8\"?>")
			.raw("<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"en\" lang=\"en\">")
			.head()
				.title("Stock Prices - Jatl")
				.meta().httpEquiv("Content-Type").content("text/html; charset=UTF-8").end()
				.meta().httpEquiv("Content-Style-Type").content("text/css").end()
				.meta().httpEquiv("Content-Script-Type").content("text/javascript").end()
				.link().rel("shortcut icon").href("/images/favicon.ico").end()
				.link().rel("stylesheet").href("/css/style.css").media("all").end()
				.script().type("text/javascript").src("/js/util.js").end()
				.style().type("text/css")
					.raw("/*<![CDATA[*/")
					.raw("body {")
						.raw("color: #333333;")
						.raw("line-height: 150%;")
					.raw("}\\n")
					.raw("thead {")
						.raw("font-weight: bold;")
						.raw("background-color: #CCCCCC;")
					.raw("}\\n")
					.raw(".odd {")
						.raw("background-color: #FFCCCC;")
					.raw("}\\n")
					.raw(".even {")
						.raw("background-color: #CCCCFF;")
					.raw("}\\n")
					.raw(".minus {")
						.raw("color: #FF0000;")
					.raw("}\\n")
					.raw("/*]]>*/")
					.end()
				.end()
				.body()
					.h1().raw("Stock Prices - HTTL").end()
					.table()
						.thead()
							.tr()
								.th().raw("#").end()
								.th().raw("symbol").end()
								.th().raw("name").end()
								.th().raw("price").end()
								.th().raw("change").end()
								.th().raw("ratio").end()
							.end()
						.end()
						.tbody();
						for (int i = 0; i < items.size(); i++) {
							Stock item = items.get(i);
							html.tr().classAttr(i % 2 == 1 ? "even" : "odd")
								.td().style("text-align: center").raw("" + i + 1).end()
								.td()
									.a().href("/stocks/").raw(item.getSymbol()).end()
								.end()
								.td()
									.a().href(item.getUrl()).raw(item.getName()).end()
								.end()
								.td()
									.strong().raw("" + item.getPrice()).end()
								.end();
							if (item.change < 0.0) {
								html.td().classAttr("minus").raw("" + item.getChange()).end()
									.td().classAttr("minus").raw("" + item.getRatio()).end();
							} else {
								html.td().raw("" + item.getChange()).end()
									.td().raw("" + item.getRatio()).end();
							}
							html.end();
						}
						//html.endAll();
						html.done();
			;
			return html;
		}
	}

    public Jatl() throws Exception {
    }

    @Override
    public void execute(Writer w0, Writer w1, int ntimes, List<Stock> items) throws Exception {
        while (--ntimes >= 0) {
            if (ntimes == 0) {
            	JatlTemplate.render(w1, items);
                w1.close();
            }
            else JatlTemplate.render(w0, items);
        }
    }

    @Override
    public void execute(OutputStream o0, OutputStream o1, int ntimes, List<Stock> items) throws Exception {
    	Writer w0 = new OutputStreamWriter(o0);
    	Writer w1 = new OutputStreamWriter(o1);
        while (--ntimes >= 0) {
            if (ntimes == 0) {
                JatlTemplate.render(w1, items);
                o1.close();
            }
            else JatlTemplate.render(w0, items);
        }
    }

    @Override
    protected String execute(int ntimes, List<Stock> items) throws Exception {
        Writer w0 = new StringWriter();
        Writer w1 = new StringWriter(1024 * 10);
        if (_BenchBase.bufferMode.get()) {
            w0 = new BufferedWriter(w0);
            w1 = new BufferedWriter(w1);
        }
        while (--ntimes >= 0) {
            if (ntimes == 0) {
            	JatlTemplate.render(w1, items);
                w1.close();
            }
            else JatlTemplate.render(w0, items);
        }
        return w1.toString();
    }

    public static void main(String[] args) throws Exception {
        new Jatl().run();
    }

}
