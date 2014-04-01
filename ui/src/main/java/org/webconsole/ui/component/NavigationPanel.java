package org.webconsole.ui.component;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.wicket.Component;
import org.apache.wicket.Page;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.webconsole.api.ConsoleTabProvider;

public class NavigationPanel extends Panel {

    private static final long serialVersionUID = 1L;

    /**
     * Console tabs.
     */
    @Inject @Named("tabProviders")
    protected List<ConsoleTabProvider> tabProviders;

    public NavigationPanel(String id) {
        super(id);

        add(createTabList("moduleLinks", tabProviders));
    }

    protected Component createTabList(String id, List<ConsoleTabProvider> tabs) {
        return new ListView<ConsoleTabProvider>(id, tabs) {

            private static final long serialVersionUID = 1L;

            @Override
            protected void populateItem(ListItem<ConsoleTabProvider> item) {
                Link<Page> link = item.getModelObject().getModuleLink("link", "label");
                item.add(link);
            }
        };
    }
}
