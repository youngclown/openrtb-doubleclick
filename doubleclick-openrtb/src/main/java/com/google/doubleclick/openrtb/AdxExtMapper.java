/*
 * Copyright 2016 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.doubleclick.openrtb;

import com.google.doubleclick.AdxExt;
import com.google.openrtb.OpenRtb.BidRequest;
import com.google.openrtb.OpenRtb.BidResponse.SeatBid.Bid;
import com.google.protos.adx.NetworkBid.BidResponse.Ad;

/**
 * Extension mapper for AdX/OpenRTB extensions.
 */
public class AdxExtMapper extends ExtMapper {
  public static final ExtMapper INSTANCE = new AdxExtMapper();

  private AdxExtMapper() {
  }

  @Override
  public boolean toDoubleClickAd(BidRequest request, Bid bid, Ad.Builder dcAd) {
    if (bid.hasExtension(AdxExt.bid)) {
      AdxExt.BidExt bidExt = bid.getExtension(AdxExt.bid);
      dcAd.addAllImpressionTrackingUrl(bidExt.getImpressionTrackingUrlList());
      return true;
    } else {
      return false;
    }
  }
}