/*
 * $Copyright: copyright(c) 2007-2011 kuwata-lab.com all rights reserved. $
 * $License: Creative Commons Attribution (CC BY) $
 */
package teb;

import java.util.List;

import teb.model.Stock;
import cn.bran.japid.compiler.OpMode;
import cn.bran.japid.template.JapidRenderer;

public class Japid extends Bench {

	private String template = "japid";

	public Japid() {

	}

	@Override
	protected void init() {
		cn.bran.japid.util.JapidFlags.verbose = false;
		JapidRenderer.init(OpMode.prod, "templates", 1, null);
	}

	@Override
	protected String renderToString(final List<Stock> items) {
		String output = JapidRenderer.renderWith(template, items);
		return output;
	}

	public static void main(final String[] args) {
		new Japid().run();
	}

}
