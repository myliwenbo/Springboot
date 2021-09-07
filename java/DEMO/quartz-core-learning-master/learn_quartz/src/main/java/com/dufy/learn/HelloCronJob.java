/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy
 * of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 *
 */

package com.dufy.learn;

import java.util.Date;
import java.util.List;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * This is just a simple job that says "Hello" to the world.
 * </p>
 *
 * @author Bill Kratzer
 */
public class HelloCronJob implements Job {

    private static Logger _log = LoggerFactory.getLogger(HelloCronJob.class);

    private static List<String> list = null;

    public void execute(JobExecutionContext context) throws JobExecutionException {

        _log.info("Hello Cron Trigger World! - " + new Date());
        try {
            int size = list.size();
        } catch (NullPointerException e) {
            e.printStackTrace();
            _log.info("Hello Cron size --- ! - " + e.getMessage());
        }

        _log.info("Hello Cron end ! - ");

    }

}
