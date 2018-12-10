package toyotaOSB
import static org.assertj.core.api.Assertions.*//Assert that

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.ResponseObject

import internal.GlobalVariable
import qaVinhLe.Library_Method_VinhLe//String2Date



class CommonToyota extends Library_Method_VinhLe {
	/**
	 * VALIDATE INVALID DEALER CODE
	 */
	@Keyword
	boolean validateInvalidDealerCode(ResponseObject response){
		if(!(GlobalVariable.Glb_Dealer_Code == "765")){
			verifyResponseCode_Msg(response, 0, "Authorization has been denied for this request")
			println 'Dealer Code is invalid'
			return true
		}else return false
	}

}
