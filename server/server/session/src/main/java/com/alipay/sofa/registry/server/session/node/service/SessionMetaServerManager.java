/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alipay.sofa.registry.server.session.node.service;

import com.alipay.sofa.registry.server.session.bootstrap.SessionServerConfig;
import com.alipay.sofa.registry.server.shared.meta.AbstractMetaServerManager;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

/**
 * @author chen.zhu
 * <p>
 * Mar 15, 2021
 */
public class SessionMetaServerManager extends AbstractMetaServerManager {

    @Autowired
    private SessionServerConfig sessionServerConfig;

    @Override
    protected Collection<String> getConfiguredMetaServerDomains() {
        return sessionServerConfig.getMetaServerAddresses();
    }

    @Override
    public int getRpcTimeoutMillis() {
        return sessionServerConfig.getMetaNodeExchangeTimeoutMillis();
    }

    @Override
    public int getServerPort() {
        return sessionServerConfig.getMetaServerPort();
    }
}