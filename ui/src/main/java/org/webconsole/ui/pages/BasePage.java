/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.webconsole.ui.pages;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.panel.EmptyPanel;
import org.apache.wicket.markup.html.panel.Panel;
import org.webconsole.api.BrandProvider;

/**
 * Base page for resource loading and keeping same look and feel in extensions.
 */
public class BasePage extends WebPage {

    private static final long serialVersionUID = 1L;

    /**
     * Brand provider responsible for l&f customization.
     */
    @Inject @Named("brandProvider")
    protected BrandProvider brandProvider;

    public BasePage() {
        add(brandProvider.getHeader("header"));

        add(brandProvider.getFooter("footer"));

        for (Behavior behavior : brandProvider.getBehaviors()) {
            add(behavior);
        }
    }

    protected Panel createTopPanel(String id) {
        return new EmptyPanel(id);// LanguageTopPanel(id);
    }

    @Override
    protected void onConfigure() {
        brandProvider.modify(this);

        super.onConfigure();
    }

}
