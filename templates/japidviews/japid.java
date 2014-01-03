package japidviews;
import java.util.*;
import java.io.*;
import cn.bran.japid.tags.Each;
import java.util.List;
import teb.model.Stock;
//
// NOTE: This file was generated from: japidviews/japid.html
// Change to this file will be lost next time the template file is compiled.
//
public class japid extends cn.bran.japid.template.JapidTemplateBaseWithoutPlay
{
	public static final String sourceTemplate = "japidviews/japid.html";
	public japid() {
		super(null);
	}
	public japid(StringBuilder out) {
		super(out);
	}
/* based on https://github.com/branaway/Japid/issues/12
 */
	public static final String[] argNames = new String[] {/* args of the template*/"items",  };
	public static final String[] argTypes = new String[] {/* arg types of the template*/"List<Stock>",  };
	public static final Object[] argDefaults= new Object[] {null, };
	public static java.lang.reflect.Method renderMethod = getRenderMethod(japidviews.japid.class);

	{
		setRenderMethod(renderMethod);
		setArgNames(argNames);
		setArgTypes(argTypes);
		setArgDefaults(argDefaults);
		setSourceTemplate(sourceTemplate);
	}
////// end of named args stuff

	private List<Stock> items; // line 4, japidviews/japid.html
	public String render(List<Stock> items) {
		this.items = items;
		long __t = -1;
		try {super.layout();} catch (RuntimeException e) { super.handleException(e);} // line 4, japidviews/japid.html
		 if (__t != -1) System.out.println("[japid] rendering time: " + __t);
		return getOut().toString();
	}

	public static String apply(List<Stock> items) {
		return new japid().render(items);
	}

	@Override protected void doLayout() {
		beginDoLayout(sourceTemplate);
//------
;// line 1, japidviews\japid.html

p("\n" + 
"<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + 
"<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\"\n" + 
"          \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" + 
"<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"en\" lang=\"en\">\n" + 
" <head>\n" + 
"  <title>Stock Prices - Rythm</title>\n" + 
"  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\n" + 
"  <meta http-equiv=\"Content-Style-Type\" content=\"text/css\" />\n" + 
"  <meta http-equiv=\"Content-Script-Type\" content=\"text/javascript\" />\n" + 
"  <link rel=\"shortcut icon\" href=\"/images/favicon.ico\" />\n" + 
"  <link rel=\"stylesheet\" type=\"text/css\" href=\"/css/style.css\" media=\"all\" />\n" + 
"  <script type=\"text/javascript\" src=\"/js/util.js\"></script>\n" + 
"  <style type=\"text/css\">\n" + 
"  /*<![CDATA[*/\n" + 
"\n" + 
"body {\n" + 
"    color: #333333;\n" + 
"    line-height: 150%;\n" + 
"}\n" + 
"\n" + 
"thead {\n" + 
"    font-weight: bold;\n" + 
"    background-color: #CCCCCC;\n" + 
"}\n" + 
"\n" + 
".odd {\n" + 
"    background-color: #FFCCCC;\n" + 
"}\n" + 
"\n" + 
".even {\n" + 
"    background-color: #CCCCFF;\n" + 
"}\n" + 
"\n" + 
".minus {\n" + 
"    color: #FF0000;\n" + 
"}\n" + 
"\n" + 
"  /*]]>*/\n" + 
"  </style>\n" + 
"\n" + 
" </head>\n" + 
"\n" + 
" <body>\n" + 
"\n" + 
"  <h1>Stock Prices- Japid</h1>\n" + 
"\n" + 
"  <table>\n" + 
"   <thead>\n" + 
"    <tr>\n" + 
"     <th>#</th><th>symbol</th><th>name</th><th>price</th><th>change</th><th>ratio</th>\n" + 
"    </tr>\n" + 
"   </thead>\n" + 
"   <tbody>\n" + 
"\n" + 
"	");// line 4, japidviews\japid.html
		final Each _Each0 = new Each(getOut()); _Each0.setOut(getOut()); _Each0.render(// line 60, japidviews\japid.html
items, new Each.DoBody<Stock>(){ // line 60, japidviews\japid.html
public void render(final Stock item, final int _size, final int _index, final boolean _isOdd, final String _parity, final boolean _isFirst, final boolean _isLast) { // line 60, japidviews\japid.html
// line 60, japidviews\japid.html
           String item_parity = _isOdd ? "odd" : "even" ;// line 61, japidviews\japid.html
	
           String symbol = item.getSymbol(); // line 63, japidviews\japid.html
           double change = item.getChange();// line 64, japidviews\japid.html
		p("        <tr class=\"");// line 64, japidviews\japid.html
		p(item_parity);// line 65, japidviews\japid.html
		p("\">\n" + 
"\n" + 
"         <td style=\"text-align: center\">");// line 65, japidviews\japid.html
		p(_index);// line 67, japidviews\japid.html
		p("</td>\n" + 
"         <td>\n" + 
"          <a href=\"/stocks/");// line 67, japidviews\japid.html
		p(symbol);// line 69, japidviews\japid.html
		p("\">");// line 69, japidviews\japid.html
		p(symbol);// line 69, japidviews\japid.html
		p("</a>\n" + 
"         </td>\n" + 
"         <td>\n" + 
"          <a href=\"");// line 69, japidviews\japid.html
		p(item.getUrl());// line 72, japidviews\japid.html
		p("\">");// line 72, japidviews\japid.html
		p(item.getName());// line 72, japidviews\japid.html
		p("</a>\n" + 
"         </td>\n" + 
"         <td>\n" + 
"          <strong>");// line 72, japidviews\japid.html
		p(item.getPrice());// line 75, japidviews\japid.html
		p("</strong>\n" + 
"         </td>\n" + 
"         ");// line 75, japidviews\japid.html
		if (change < 0.0) {// line 77, japidviews\japid.html
		p("         <td class=\"minus\">");// line 77, japidviews\japid.html
		p(change);// line 78, japidviews\japid.html
		p("</td>\n" + 
"         <td class=\"minus\">");// line 78, japidviews\japid.html
		p(item.getRatio());// line 79, japidviews\japid.html
		p("</td>\n" + 
"         ");// line 79, japidviews\japid.html
		} else {// line 80, japidviews\japid.html
		p("         <td>");// line 80, japidviews\japid.html
		p(change);// line 81, japidviews\japid.html
		p("</td>\n" + 
"         <td>");// line 81, japidviews\japid.html
		p(item.getRatio());// line 82, japidviews\japid.html
		p("</td>\n" + 
"         ");// line 82, japidviews\japid.html
		}// line 83, japidviews\japid.html
		p("        </tr>\n" + 
"	");// line 83, japidviews\japid.html
		
}

StringBuilder oriBuffer;
@Override
public void setBuffer(StringBuilder sb) {
	oriBuffer = getOut();
	setOut(sb);
}

@Override
public void resetBuffer() {
	setOut(oriBuffer);
}

}
);// line 60, japidviews\japid.html
		p("   </tbody>\n" + 
"  </table>\n" + 
"\n" + 
" </body>\n" + 
"</html>");// line 85, japidviews\japid.html
		
		endDoLayout(sourceTemplate);
	}

}