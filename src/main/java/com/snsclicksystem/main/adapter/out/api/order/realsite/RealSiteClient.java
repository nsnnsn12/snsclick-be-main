package com.snsclicksystem.main.adapter.out.api.order.realsite;

import com.snsclicksystem.main.adapter.out.api.order.realsite.dto.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * real site에 실제 주문을 하는 클라이언트
 */
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
