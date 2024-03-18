package com.snsclicksystem.main.adapter.out.api.order.realsite;

import com.snsclicksystem.main.adapter.out.api.order.realsite.dto.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * real site에 실제 주문을 하는 클라이언트
 */
@FeignClient(name = "real-site", url = "${real-site.url}")
public interface RealSiteClient {
    //TODO need to test about these api
    @PostMapping("/api/v2")
    Long orderDefault(DefaultOrderDto defaultOrderDto);

    @PostMapping("/api/v2")
    Long orderCustomComment(CustomCommentOrderDto customCommentOrderDto);

    @PostMapping("/api/v2")
    Long orderMentionsCustomList(MentionsCustomListOrderDto mentionsCustomListOrderDto);

    @PostMapping("/api/v2")
    Long orderMentionsMediaLikers(MentionsMediaLikersOrderDto mentionsMediaLikersOrderDto);

    @PostMapping("/api/v2")
    Long orderMentionsUserFollowers(MentionsUserFollowersOrderDto mentionsUserFollowersOrderDto);

    @PostMapping("/api/v2")
    Long MentionsWithHashtags(MentionsWithHashtagsOrderDto mentionsWithHashtagsOrderDto);

    @PostMapping("/api/v2")
    Long orderPackage(PackageOrderDto packageOrderDto);

    @PostMapping("/api/v2")
    Long orderSubscription(SubscriptionsOrderDto subscribersOrderDto);
}
