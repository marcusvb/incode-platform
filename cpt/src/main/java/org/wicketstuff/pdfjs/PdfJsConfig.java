package org.wicketstuff.pdfjs;

import org.apache.wicket.util.lang.Args;

import de.agilecoders.wicket.jquery.AbstractConfig;
import de.agilecoders.wicket.jquery.IKey;
import de.agilecoders.wicket.jquery.Key;

/**
 *
 */
public class PdfJsConfig extends AbstractConfig {

    private static final IKey<Integer> INITIAL_PAGE = new Key<>("initialPage", 1);
    private static final IKey<Double> INITIAL_SCALE = new Key<>("initialScale", 1.0d);
    private static final IKey<Integer> INITIAL_HEIGHT = new Key<>("initialHeight", 800);
    private static final IKey<Boolean> WORKER_DISABLED = new Key<>("workerDisabled", false);
    private static final IKey<CharSequence> PDF_DOCUMENT_URL = new Key<>("documentUrl", null);
    private static final IKey<CharSequence> WORKER_URL = new Key<>("workerUrl", null);
    private static final IKey<CharSequence> CANVAS_ID = new Key<>("canvasId", null);

    public PdfJsConfig withInitialPage(int initialPage) {
        if (initialPage < 1) {
            initialPage = 1;
        }
        put(INITIAL_PAGE, initialPage);
        return this;
    }

    public int getInitialPage() {
        return get(INITIAL_PAGE);
    }

    public PdfJsConfig withInitialHeight(final int initialHeight) {
        Args.isTrue(initialHeight >= 400 && initialHeight <= 1400,
                "'initialHeight' must be between 400 and 1400");
        put(INITIAL_HEIGHT, initialHeight);
        return this;
    }

    public int getInitialHeight() {
        return get(INITIAL_HEIGHT);
    }

    public PdfJsConfig withInitialScale(final double initialScale) {
        Args.isTrue(initialScale > 0d && initialScale <= 1.0d,
                    "'initialScale' must be between 0.001 and 1.0");
        put(INITIAL_SCALE, initialScale);
        return this;
    }

    public double getInitialScale() {
        return get(INITIAL_SCALE);
    }

    public PdfJsConfig disableWorker(final boolean disable) {
        put(WORKER_DISABLED, disable);
        return this;
    }

    public boolean isWorkerDisabled() {
        return get(WORKER_DISABLED);
    }

    public PdfJsConfig withDocumentUrl(final CharSequence url) {
        put(PDF_DOCUMENT_URL, url);
        return this;
    }

    public CharSequence getDocumentUrl() {
        return get(PDF_DOCUMENT_URL);
    }

    public PdfJsConfig withWorkerUrl(final String url) {
        put(WORKER_URL, url);
        return this;
    }

    public CharSequence getWorkerUrl() {
        return get(WORKER_URL);
    }

    public PdfJsConfig withCanvasId(final String url) {
        put(CANVAS_ID, url);
        return this;
    }

    public CharSequence getCanvasId() {
        return get(CANVAS_ID);
    }
}
