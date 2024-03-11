package com.snsclicksystem.main.adapter.in.charge;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.snsclicksystem.main.adapter.in.charge.dto.RequestCharge;
import com.snsclicksystem.main.adapter.in.charge.dto.ResponseCharge;
import com.snsclicksystem.main.adapter.in.common.NoSearchException;
import com.snsclicksystem.main.application.port.in.charge.ChargeUseCase;
import com.snsclicksystem.main.domain.charge.Charge;
import com.snsclicksystem.main.util.modelmapper.ObjectMapper;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

//@RestController
//@RequestMapping("/charge")
@RequiredArgsConstructor
@Controller
@Slf4j
public class ChargeController {

	private final ChargeUseCase chargeUseCase;
	private final ObjectMapper objectMapper;

	@RequestMapping("/")
	public String test(HttpServletResponse response) {
		return "checkout";
	}

	/*
	 * 결제 요청
	 */
	@PostMapping("/requestCharge")
	@ResponseBody
	public ResponseEntity<ResponseCharge> requestTossPayment(@RequestBody @Valid RequestCharge charge) {
		Charge requestCharge = chargeUseCase.requestCharge(charge);
		
		ResponseCharge responseCharge = new ResponseCharge();
		responseCharge.setPayType(requestCharge.getChargeType());
		responseCharge.setAmount(requestCharge.getRealAmountPaid());
		responseCharge.setOrderId(requestCharge.getId());
		responseCharge.setOrderName("포인트 충전");
		responseCharge.setCustomerName(requestCharge.getMemberEmail());
		responseCharge.setSuccessUrl(requestCharge.getSuccessUrl());
		responseCharge.setFailUrl(requestCharge.getFailUrl());
		responseCharge.setFailReason(requestCharge.getFailReason());
		responseCharge.setCancelYN(requestCharge.getIsCancel());
		responseCharge.setCancelReason(requestCharge.getCancelReason());
		responseCharge.setCreatedAt(requestCharge.getCreatedAt());
		
		return new ResponseEntity<>(responseCharge, HttpStatus.OK);
	}

	/*
	 * 결제 성공 로직
	 */
	public ResponseEntity<ResponseCharge> tossPaymentSuccess() {
		return null;
	}

	/*
	 * 결제 실패 로직
	 */
	public ResponseEntity<ResponseCharge> tossPaymentFail() {
		return null;
	}

	/*
	 * 결제 취소
	 */
	public ResponseEntity<ResponseCharge> tossPaymentCancel() {
		return null;
	}

	/*
	 * 결제 내역 조회
	 */
	public ResponseEntity<ResponseCharge> getChargeList() {
		return null;
	}

}
