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

import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Stats {
  private static final Logger logger = LogManager.getLogger(Stats.class);

  private SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd.HH.mm.ss");

  private long numTotalItems = 0;
  private long numGrandTotalItems = 0;
  private long numTotalItemsAffected = 0;
  private long numTotalAttachments = 0;
  private long numGrandTotalAttachments = 0;
  private long numTotalAttachmentsIgnored = 0;
  private long numTotalAttachmentsMissing = 0;
  private long startTime;
  private long endTime;
  private int numOfQueriesRan = 0;
  private long totalQueriesDur = 0;

  public long getNumTotalItems() {
    return numTotalItems;
  }

  public void incNumTotalItems() {
    this.numTotalItems++;
    logger.info(getStatSnapshot());
  }

  public long getNumGrandTotalItems() {
    return numGrandTotalItems;
  }

  public void incNumGrandTotalItems(int num) {
    this.numGrandTotalItems += num;
  }

  public long getNumTotalItemsAffected() {
    return numTotalItemsAffected;
  }

  public void incNumTotalItemsAffected() {
    this.numTotalItemsAffected++;
    logger.info(getStatSnapshot());
  }

  public long getNumTotalAttachments() {
    return numTotalAttachments;
  }

  public void incNumTotalAttachments() {
    this.numTotalAttachments++;
    logger.info(getStatSnapshot());
  }

  public long getNumGrandTotalAttachments() {
    return numGrandTotalAttachments;
  }

  public void incNumGrandTotalAttachments(int num) {
    this.numGrandTotalAttachments += num;
  }

  public long getNumTotalAttachmentsIgnored() {
    return numTotalAttachmentsIgnored;
  }

  public void incNumTotalAttachmentsIgnored() {
    this.numTotalAttachmentsIgnored++;
  }

  public long getNumTotalAttachmentsMissing() {
    return numTotalAttachmentsMissing;
  }

  public void incNumTotalAttachmentsMissing() {
    this.numTotalAttachmentsMissing++;
    logger.info(getStatSnapshot());
  }

  public long getStartTime() {
    return startTime;
  }

  public String getStartTimeStr() {
    return sim.format(new Date(startTime));
  }

  public void setReportStartTime() {
    this.startTime = System.currentTimeMillis();
  }

  public long getEndTime() {
    return endTime;
  }

  public String getEndTimeStr() {
    return sim.format(new Date(endTime));
  }

  public void setReportEndTime() {
    this.endTime = System.currentTimeMillis();
  }

  public long getDuration() {
    return (endTime - startTime) / 1000;
  }

  public void queryRan(long dur) {
    numOfQueriesRan++;
    totalQueriesDur += dur;
  }

  public int getNumOfQueriesRan() {
    return numOfQueriesRan;
  }

  public long getTotalDurationOfQueriesRan() {
    return totalQueriesDur;
  }

  public long getAverageDurationOfQueriesRan() {
    return totalQueriesDur / numOfQueriesRan;
  }

  private String getStatSnapshot() {
    return "Current Stats: It=["
        + numGrandTotalItems
        + "],Ip=["
        + numTotalItems
        + "],Ix=["
        + numTotalItemsAffected
        + "],At=["
        + numGrandTotalAttachments
        + "],Ap=["
        + numTotalAttachments
        + "],Ax=["
        + numTotalAttachmentsMissing
        + "]";
  }
}
