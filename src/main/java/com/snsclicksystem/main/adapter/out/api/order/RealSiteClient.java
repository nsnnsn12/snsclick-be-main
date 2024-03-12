package com.snsclicksystem.main.adapter.out.api.order;

import com.snsclicksystem.main.adapter.out.api.order.dto.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "real-site", url = "${external.real-site.url}")
public interface RealSiteClient {
    //TODO need to test about these api
    @PostMapping("/api/v2")
    Integer orderDefault(DefaultOrderDto defaultOrderDto);

    @PostMapping("/api/v2")
    Integer orderCustomComment(CustomCommentOrderDto customCommentOrderDto);

    @PostMapping("/api/v2")
    Integer orderMentionsCustomList(MentionsCustomListOrderDto mentionsCustomListOrderDto);

    @PostMapping("/api/v2")
    Integer orderMentionsMediaLikers(MentionsMediaLikersOrderDto mentionsMediaLikersOrderDto);

    @PostMapping("/api/v2")
    Integer orderMentionsUserFollowers(MentionsUserFollowersOrderDto mentionsUserFollowersOrderDto);

    @PostMapping("/api/v2")
    Integer MentionsWithHashtags(MentionsWithHashtagsOrderDto mentionsWithHashtagsOrderDto);

    @PostMapping("/api/v2")
    Integer orderPackage(PackageOrderDto packageOrderDto);

    @PostMapping("/api/v2")
    Integer orderSubscription(SubscriptionsOrderDto subscribersOrderDto);




}
