package com.snsclicksystem.main.adapter.in.charge;

import com.snsclicksystem.main.adapter.in.charge.factory.TossPaymentChargeFactory;
import com.snsclicksystem.main.domain.charge.dto.ChargedInfo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.snsclicksystem.main.adapter.in.charge.dto.RequestCharge;
import com.snsclicksystem.main.adapter.in.charge.dto.ResponseCharge;
import com.snsclicksystem.main.adapter.in.common.NoCreateException;
import com.snsclicksystem.main.domain.charge.exception.ChargeRequestFailException;
import com.snsclicksystem.main.application.port.in.charge.ChargeUseCase;

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

	// TODO : DELETE Test Code
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
		try {
			ChargedInfo chargedInfo = chargeUseCase.requestCharge(new TossPaymentChargeFactory(charge));
			ResponseCharge responseCharge = new ResponseCharge(chargedInfo);
			return new ResponseEntity<>(responseCharge, HttpStatus.OK);
		} catch (ChargeRequestFailException e) {
            throw new NoCreateException(e.getMessage());
		}
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
