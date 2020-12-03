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
package com.alipay.sofa.registry.server.meta.resource;

import com.alipay.sofa.registry.common.model.console.PersistenceData;
import com.alipay.sofa.registry.common.model.constants.ValueConstants;
import com.alipay.sofa.registry.log.Logger;
import com.alipay.sofa.registry.log.LoggerFactory;
import com.alipay.sofa.registry.store.api.DBResponse;
import com.alipay.sofa.registry.store.api.DBService;
import com.alipay.sofa.registry.store.api.annotation.RaftReference;
import com.alipay.sofa.registry.task.listener.TaskListenerManager;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author shangyu.wh
 * @version $Id: RenewSwitchResource.java, v 0.1 2018-07-25 11:40 shangyu.wh Exp $
 */
@Path("slotSync")
public class SlotSyncResource {

    private static final Logger DB_LOGGER   = LoggerFactory.getLogger(SlotSyncResource.class,
                                                "[DBService]");

    private static final Logger TASK_LOGGER = LoggerFactory.getLogger(SlotSyncResource.class,
                                                "[Task]");

    @RaftReference
    private DBService           persistenceDataDBService;

    /**
     * get
     */
    @GET
    @Path("get")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> getSlotSync() throws Exception {
        Map<String, Object> resultMap = new HashMap<>(2);
        DBResponse syncSessionIntervalSec = persistenceDataDBService
            .get(ValueConstants.DATA_DATUM_SYNC_SESSION_INTERVAL_SEC);
        DBResponse dataDatumExpire = persistenceDataDBService
            .get(ValueConstants.DATA_DATUM_EXPIRE_SEC);

        resultMap.put("syncSessionIntervalSec", getEntityData(syncSessionIntervalSec));
        resultMap.put("dataDatumExpire", getEntityData(dataDatumExpire));
        return resultMap;
    }

    private static String getEntityData(DBResponse resp) {
        return resp != null && resp.getEntity() != null ? ((PersistenceData) resp.getEntity())
            .getData() : "null";
    }

}