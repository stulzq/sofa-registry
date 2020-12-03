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
package com.alipay.sofa.registry.common.model.dataserver;

import com.alipay.sofa.registry.common.model.ConnectId;
import com.alipay.sofa.registry.common.model.ProcessId;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * request to remove data of specific clients immediately
 *
 * @author qian.lqlq
 * @version $Id: ClientOffRequest.java, v 0.1 2017-12-01 15:48 qian.lqlq Exp $
 */
public class ClientOffRequest extends AbstractSlotRequest {

    private static final long     serialVersionUID = -3547806571058756207L;

    private final List<ConnectId> connectIds;

    private final long            gmtOccur;

    /**
     * constructor
     */
    public ClientOffRequest(ProcessId sessionProcessId, Collection<ConnectId> connectIds,
                            long gmtOccur) {
        super(sessionProcessId);
        this.connectIds = Collections.unmodifiableList(new ArrayList<>(connectIds));
        this.gmtOccur = gmtOccur;
    }

    /**
     * Getter method for property <tt>connectIds</tt>.
     *
     * @return property value of connectIds
     */
    public List<ConnectId> getConnectIds() {
        return connectIds;
    }

    /**
     * Getter method for property <tt>gmtOccur</tt>.
     *
     * @return property value of gmtOccur
     */
    public long getGmtOccur() {
        return gmtOccur;
    }

    @Override
    public String toString() {
        return new StringBuilder("[ClientOffRequest] connectIds=").append(this.connectIds)
            .append(", gmtOccur=").append(gmtOccur).toString();
    }
}
