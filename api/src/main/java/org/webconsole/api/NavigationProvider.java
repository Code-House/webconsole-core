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
package org.webconsole.api;

import java.util.List;

import org.apache.wicket.Page;
import org.apache.wicket.markup.html.link.Link;

/**
 * Base extension point in console. Allow suppliers to ship new navigation
 * elements which points to new wicket pages.
 */
public interface NavigationProvider {

    /**
     * Return list of links to pages to add in navigation. 
     * @param componentId Identifier of the link.
     * @param labelId Identifier of link label.
     * 
     * @return Pages to add in navigation.
     */
    List<Link<Page>> getItems(String componentId, String labelId);

}
