package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepositoty;
import hello.core.member.MemoryMemberRepositoty;

public class OrderServiceImpl implements OrderService {

    private final MemberRepositoty memberRepositoty = new MemoryMemberRepositoty();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order creteOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepositoty.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
