/*
 * Licensed to The Apereo Foundation under one or more contributor license
 * agreements. See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 *
 * The Apereo Foundation licenses this file to you under the Apache License,
 * Version 2.0, (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apereo.openequella.tools.toolbox.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EmailState {
  private static Logger LOGGER = LogManager.getLogger(EmailState.class);

  private String lastRawType;
  private String lastRawToAddresses;
  private String lastSubject;

  private String lastBody;
  private boolean lastSuccess;

  public EmailState(String rawType, String rawToAddresses, String subject, String body) {
    this.lastRawType = rawType;
    this.lastRawToAddresses = rawToAddresses;
    this.lastSubject = subject;
    this.lastBody = body;
  }

  public void setSuccess(boolean b) {
    lastSuccess = b;
  }

  public String getLastRawType() {
    return lastRawType;
  }

  public String getLastRawToAddresses() {
    return lastRawToAddresses;
  }

  public String getLastSubject() {
    return lastSubject;
  }

  public String getLastBody() {
    return lastBody;
  }

  public boolean isLastSuccess() {
    return lastSuccess;
  }

  public String toString() {
    return "EmailState - status=["
        + isLastSuccess()
        + "], type=["
        + getLastRawType()
        + "], toAddresses=["
        + getLastRawToAddresses()
        + "], subject=["
        + getLastSubject()
        + "], body=[ "
        + getLastBody()
        + "]";
  }
}
