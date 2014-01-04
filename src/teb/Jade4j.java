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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import teb.model.Stock;
import de.neuland.jade4j.JadeConfiguration;
import de.neuland.jade4j.template.JadeTemplate;

public class Jade4j extends _BenchBase {
	private JadeConfiguration config;
	private JadeTemplate template;

    public Jade4j() throws Exception {
    	config = new JadeConfiguration();
    	config.setPrettyPrint(true);
    	template = config.getTemplate("templates/stocks.jade.html");
    }

    @Override
    public void execute(Writer w0, Writer w1, int ntimes, List<Stock> items) throws Exception {
    	Map<String, Object> model = new HashMap<String, Object>();
    	model.put("items", items);
        while (--ntimes >= 0) {
            if (ntimes == 0) {
            	config.renderTemplate(template, model, w1);
                w1.close();
            }
            else config.renderTemplate(template, model, w0);
        }
    }

    @Override
    public void execute(OutputStream o0, OutputStream o1, int ntimes, List<Stock> items) throws Exception {
    	Writer w0 = new OutputStreamWriter(o0);
    	Writer w1 = new OutputStreamWriter(o1);
    	Map<String, Object> model = new HashMap<String, Object>();
    	model.put("items", items);
        while (--ntimes >= 0) {
            if (ntimes == 0) {
                config.renderTemplate(template, model, w1);
                o1.close();
            }
            else config.renderTemplate(template, model, w0);
        }
    }

    @Override
    protected String execute(int ntimes, List<Stock> items) throws Exception {
        Writer w0 = new StringWriter();
        Writer w1 = new StringWriter(1024 * 10);
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("items", items);
        if (_BenchBase.bufferMode.get()) {
            w0 = new BufferedWriter(w0);
            w1 = new BufferedWriter(w1);
        }
        while (--ntimes >= 0) {
            if (ntimes == 0) {
            	config.renderTemplate(template, model, w1);
                w1.close();
            }
            else config.renderTemplate(template, model, w0);
        }
        return w1.toString();
    }

    public static void main(String[] args) throws Exception {
        new Jade4j().run();
    }

}
