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
package com.alipay.sofa.registry.common.model;

import com.alipay.sofa.registry.common.model.dataserver.DatumSummary;
import com.alipay.sofa.registry.common.model.store.Publisher;
import com.google.common.collect.Maps;

import java.util.*;

/**
 * @author xiaojian.xj
 * @version $Id: PublisherUtils.java, v 0.1 2020年11月12日 16:53 xiaojian.xj Exp $
 */
public final class PublisherUtils {
    private PublisherUtils() {
    }

    /**
     * change publisher word cache
     *
     * @param publisher
     * @return
     */
    public static Publisher internPublisher(Publisher publisher) {
        publisher.setRegisterId(publisher.getRegisterId());
        publisher.setDataInfoId(publisher.getDataInfoId());
        publisher.setInstanceId(publisher.getInstanceId());
        publisher.setGroup(publisher.getGroup());
        publisher.setDataId(publisher.getDataId());
        publisher.setClientId(publisher.getClientId());
        publisher.setCell(publisher.getCell());
        publisher.setProcessId(publisher.getProcessId());
        publisher.setAppName(publisher.getAppName());
        return publisher;
    }

    public static Map<String, DatumSummary> getDatumSummary(Map<String, Map<String, Publisher>> publisherMap) {
        Map<String, DatumSummary> sourceSummaryMap = Maps.newHashMapWithExpectedSize(publisherMap
            .size());
        for (Map.Entry<String, Map<String, Publisher>> e : publisherMap.entrySet()) {
            sourceSummaryMap.put(e.getKey(), DatumSummary.of(e.getKey(), e.getValue()));
        }
        return sourceSummaryMap;
    }
}