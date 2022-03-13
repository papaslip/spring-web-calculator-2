package by.tms.controller;

import by.tms.dao.OperationListHandler;
import by.tms.entity.Calculator;
import by.tms.entity.Operation;
import by.tms.entity.OperationDTO;
import by.tms.entity.User;
import by.tms.servise.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/calc")
public class CalcController {
	@Autowired
	private Calculator calculator;

	@Autowired
	private CalculatorService calculatorService;

	@Autowired
	private OperationListHandler operationListHandler;
	static int historyHandlerLimit = 5;

	@GetMapping
	public String calculator(@ModelAttribute("operation") Operation operation, Model model) {
		return "calculator";
	}

	@PostMapping
	public String calculatorPost(@ModelAttribute("operation") @Valid Operation operation, BindingResult bindingResult, HttpSession httpSession, Model model) {
		if(bindingResult.hasErrors()){
			return "calculator";
		}
		operation.setResult(calculator.executeOperation(operation));
		User user = (User)httpSession.getAttribute("user");
		operation.setUsername(user.getUsername());
		calculatorService.saveOperation(operation);
		model.addAttribute("calculatorMessage", operation.getResult());
		return "calculator";
	}

	@GetMapping("/history")
	public String showHistory(@ModelAttribute("operation") Operation operation,HttpSession httpSession,Model model){
		User user = (User)httpSession.getAttribute("user");
		model.addAttribute("operationList",operationListHandler.getCurrentElements(historyHandlerLimit,user.getUsername()));
		return "history";
	}
	@PostMapping("/history/delete")
	public String deleteOperationById(@ModelAttribute("operationdto") OperationDTO operationdto, Model model){
		calculatorService.deleteOperationById(operationdto.getId());
		return "redirect:/calc/history";
	}

	@GetMapping("/history/next")
	public String showNextHistory(@ModelAttribute("operation") Operation operation,HttpSession httpSession,Model model){
		User user = (User)httpSession.getAttribute("user");
		model.addAttribute("operationList",operationListHandler.getNextElements(historyHandlerLimit,user.getUsername()));
		return "history";
	}

	@GetMapping("/history/prev")
	public String showPrevHistory(@ModelAttribute("operation") Operation operation,HttpSession httpSession,Model model){
		User user = (User)httpSession.getAttribute("user");
		model.addAttribute("operationList",operationListHandler.getPreviousElements(historyHandlerLimit,user.getUsername()));
		return "history";
	}


}
