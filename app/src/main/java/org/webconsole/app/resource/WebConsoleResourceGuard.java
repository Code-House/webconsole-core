package org.webconsole.app.resource;

import org.apache.wicket.markup.html.SecurePackageResourceGuard;

public class WebConsoleResourceGuard extends SecurePackageResourceGuard {

    public WebConsoleResourceGuard() {
        addPattern("+*.map");
        addPattern("+*.eot");
        addPattern("+*.svg");
        addPattern("+*.ttf");
        addPattern("+*.woff");
    }

}
