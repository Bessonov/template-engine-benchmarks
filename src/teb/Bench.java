package teb;

import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.StringWriter;
import java.io.Writer;
import java.util.List;

import teb.model.Stock;

public abstract class Bench extends _BenchBase {

	private boolean initialized = false;

	protected void init() {

	}

	protected void initParameters(final List<Stock> items) throws Exception {

	}

	protected void doInitParameters(final List<Stock> items) throws Exception {
		if (initialized)
			return;
		initParameters(items);
		initialized = true;
	}

	@Override
	public void run() {
		init();
		super.run();
	}

	@Override
	public void execute(final Writer w0, final Writer w1, int ntimes,
			final List<Stock> items) throws Exception {
		doInitParameters(items);
		while (--ntimes >= 0) {
			if (ntimes == 0) {
				renderToWriter(items, w1);
				w1.close();
			} else {
				renderToWriter(items, w0);
			}
		}

	}

	@Override
	public void execute(final OutputStream o0, final OutputStream o1,
			int ntimes, final List<Stock> items) throws Exception {
		doInitParameters(items);
		while (--ntimes >= 0) {
			if (ntimes == 0) {
				renderToStream(items, o1);
				o1.close();
			} else {
				renderToStream(items, o0);
			}
		}

	}

	@Override
	protected String execute(final int ntimes, final List<Stock> items)
			throws Exception {
		if (hasStringImplementation())
			return executeSimple(ntimes, items);

		return executeWithStreams(ntimes, items);
	}

	protected boolean hasStringImplementation() {
		return true;
	}

	protected String executeWithStreams(int ntimes, final List<Stock> items)
			throws Exception {
		doInitParameters(items);
		Writer w0 = new StringWriter();
		Writer w1 = new StringWriter(1024 * 10);
		if (_BenchBase.bufferMode.get()) {
			w0 = new BufferedWriter(w0);
			w1 = new BufferedWriter(w1);
		}
		while (--ntimes >= 0) {

			if (ntimes == 0) {
				renderToWriter(items, w1);
				w1.close();
			} else
				renderToWriter(items, w0);
		}
		return w1.toString();
	}

	protected String executeSimple(int ntimes, final List<Stock> items)
			throws Exception {
		doInitParameters(items);
		String result = null;
		while (--ntimes >= 0) {
			result = renderToString(items);
		}
		return result;
	}

	protected String renderToString(final List<Stock> items) {
		return null;
	}

	protected void renderToStream(final List<Stock> items,
			final OutputStream output) throws Exception {
		String result = renderToString(items);
		output.write(result.getBytes("UTF-8"));
	}

	protected void renderToWriter(final List<Stock> items, final Writer writer)
			throws Exception {
		String result = renderToString(items);
		writer.append(result);
	}

}
