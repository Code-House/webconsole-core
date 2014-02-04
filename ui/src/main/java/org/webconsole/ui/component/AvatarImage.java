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
package org.webconsole.ui.component;

import org.apache.wicket.markup.html.image.Image;
import org.apache.wicket.request.resource.ByteArrayResource;
import org.apache.wicket.request.resource.PackageResourceReference;
import org.webconsole.api.PreferencesProvider;

/**
 * Avatar image which displays picture from preference store.
 */
public class AvatarImage extends Image {

    private static final long serialVersionUID = 1L;

    public AvatarImage(String id, PreferencesProvider preferences) {
        super(id);

        byte[] avatar = (byte[]) preferences.getPreferences().get("avatar");

        if (avatar != null && avatar.length > 0) {
            String contentType = (String) preferences.getPreferences().get("avatar-mime-type");
            if (contentType == null) {
                contentType = "image/jpg";
            }
            ByteArrayResource resource = new ByteArrayResource(contentType, avatar);
            setImageResource(resource);
            return;
        }

        setImageResourceReference(new PackageResourceReference(AvatarImage.class, "apache-avatar.png"));
    }

}
