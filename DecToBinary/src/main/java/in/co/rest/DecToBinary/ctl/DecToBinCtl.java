package in.co.rest.DecToBinary.ctl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "Num")
public class DecToBinCtl {

	@GetMapping("get/{num}")
	public Map<String, Object> Display(@PathVariable int num, ModelMap model) {
		Map<String, Object> response = new HashMap<String, Object>();
		System.out.println("This is Test");
		String outputOut = decimalToBinaryMethod(num);
		System.out.println("The output is: " + outputOut);
		response.put("Input", "Decimal Value : "+num);
		response.put("Output", "Binary Value : "+outputOut);
		return response;
	}

	public static String decimalToBinaryMethod(int valueIn) {

		int remainder, i = 0;
		String binaryNum = "";
		while (valueIn != 0) {
			remainder = valueIn % 2;
			valueIn /= 2;
			binaryNum = remainder + binaryNum;
		}
		return binaryNum;
	}
}
