package org.webconsole.ui.bootstrap;

import org.apache.wicket.Component;
import org.apache.wicket.RuntimeConfigurationType;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptReferenceHeaderItem;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.resource.PackageResourceReference;
import org.apache.wicket.request.resource.ResourceReference;

public class BootstrapResources extends Behavior {

    private static final long serialVersionUID = 1L;

    @Override
    public void renderHead(Component component, IHeaderResponse response) {
        ResourceReference jquery = WebApplication.get().getJavaScriptLibrarySettings().getJQueryReference();

        response.render(CssHeaderItem.forReference(reference("css/bootstrap", "css")));
        response.render(CssHeaderItem.forReference(reference("css/bootstrap-theme", "css")));
        response.render(JavaScriptReferenceHeaderItem.forReference(jquery));
        response.render(JavaScriptReferenceHeaderItem.forReference(reference("js/bootstrap", "js")));
    }

    private ResourceReference reference(String path, String ext) {
        boolean production = WebApplication.get().getConfigurationType() == RuntimeConfigurationType.DEPLOYMENT;

        return new PackageResourceReference(BootstrapResources.class, path + (production ? "-min." : ".") + ext);
    }

}
