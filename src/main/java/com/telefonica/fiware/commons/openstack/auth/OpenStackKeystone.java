/**
 * Copyright 2014 Telefonica Investigación y Desarrollo, S.A.U <br>
 * This file is part of FI-WARE project.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License.
 * </p>
 * <p>
 * You may obtain a copy of the License at:<br>
 * <br>
 * http://www.apache.org/licenses/LICENSE-2.0
 * </p>
 * <p>
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * </p>
 * <p>
 * See the License for the specific language governing permissions and limitations under the License.
 * </p>
 * <p>
 * For those usages not covered by the Apache version 2.0 License please contact with opensource@tid.es
 * </p>
 */
package com.telefonica.fiware.commons.openstack.auth;

import java.util.List;

import javax.ws.rs.core.Response;

import net.sf.json.JSONObject;

import com.telefonica.fiware.commons.openstack.auth.exception.OpenStackException;

public interface OpenStackKeystone {

    /**
     * HTTP CODE
     */
    final static int CODE_200 = 200;

    /**
     * HTTP CODE
     */
    final static int CODE_401 = 401;

    /**
     * @return
     */
    String getVersion();

    /**
     * @param baseUrl
     * @return
     */
    String getKeystoneURL(String baseUrl);

    /**
     * @param user
     * @param password
     * @param tenant
     * @return
     */
    String getPayload(String user, String password, String tenant);

    /**
     * Parse response after request token to keystone.
     * 
     * @param openStackAccess
     * @param response
     * @param jsonObjectResponse
     */
    void parseResponse(OpenStackAccess openStackAccess, Response response, JSONObject jsonObjectResponse);

    /**
     * Parse endpoints url after request to keystone.
     * 
     * @param jsonObject
     * @param type
     * @param regionName
     * @return
     * @throws OpenStackException
     */
    String parseEndpoint(JSONObject jsonObject, String type, String regionName) throws OpenStackException;

    /**
     * Obtains a list with all region names for a service.
     * 
     * @param jsonObject
     * @param serviceName
     * @return
     */
    List<String> parseRegionNames(JSONObject jsonObject, String serviceName);

    /**
     * Check if token is valid for a tenant.
     * 
     * @param token
     * @param tenantId
     * @param response
     * @return array with strings: {username,tenantName}
     */
    String[] checkToken(String token, String tenantId, Response response);
}
