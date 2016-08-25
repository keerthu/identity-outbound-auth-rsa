/*
 *  Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  WSO2 Inc. licenses this file to you under the Apache License,
 *  Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 *
 */
package org.wso2.carbon.extension.identity.authenticator.internal;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.osgi.service.component.ComponentContext;
import org.wso2.carbon.extension.identity.authenticator.RSASecurIdAuthenticator;
import org.wso2.carbon.identity.application.authentication.framework.ApplicationAuthenticator;

/**
 * @scr.component name="identity.application.authenticator.RSASecurId.component" immediate="true"
 */
public class RSASecurIdAuthenticatorServiceComponent {
    private static Log log = LogFactory.getLog(RSASecurIdAuthenticatorServiceComponent.class);

    protected void activate(ComponentContext ctxt) {
        try {
            RSASecurIdAuthenticator authenticator = new RSASecurIdAuthenticator();
            ctxt.getBundleContext().registerService(ApplicationAuthenticator.class.getName(),
                    authenticator, null);
            if (log.isDebugEnabled()) {
                log.debug("RSASecurId authenticator is activated");
            }
        } catch (Throwable e) {
            log.fatal("Error while activating the RSASecurId authenticator ", e);
        }
    }

    protected void deactivate(ComponentContext ctxt) {
        if (log.isDebugEnabled()) {
            log.debug("RSASecurId authenticator is deactivated");
        }
    }
}