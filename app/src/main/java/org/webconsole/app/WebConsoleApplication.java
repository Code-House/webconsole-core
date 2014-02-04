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
package org.webconsole.app;

import org.apache.wicket.authroles.authentication.AuthenticatedWebApplication;
import org.webconsole.app.resource.WebConsoleResourceGuard;

/**
 * Root class for wicket.
 */
public abstract class WebConsoleApplication extends AuthenticatedWebApplication {

    @Override
    protected void init() {
        super.init();

        // avoid exceptions when can't find label in property files
        getResourceSettings().setThrowExceptionOnMissingResource(false);
        getResourceSettings().setUseDefaultOnMissingResource(true);
        getResourceSettings().setPackageResourceGuard(new WebConsoleResourceGuard());

//        getSecuritySettings().setAuthorizationStrategy(new RoleAuthorizationStrategy(new HierarchicalRoleCheckingStrategy()));
        getMarkupSettings().setStripWicketTags(true);
    }


}
