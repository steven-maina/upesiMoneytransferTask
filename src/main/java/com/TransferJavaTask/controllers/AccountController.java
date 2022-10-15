package com.TransferJavaTask.controllers;

import com.TransferJavaTask.helpers.GenAccountNumber;
import com.TransferJavaTask.models.User;
import com.TransferJavaTask.repository.AccountRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/account")
public class AccountController {


    private AccountRepository accountRepository;

    @PostMapping("/create_account")
    public String createAccount(@RequestParam("account_name")String accountName,
                                @RequestParam("account_type")String accountType,
                                RedirectAttributes redirectAttributes,
                                HttpSession session){

        // TODO: CHECK FOR EMPTY STRINGS:
        if(accountName.isEmpty() || accountType.isEmpty()){
            redirectAttributes.addFlashAttribute("error", "Account Name and Type Cannot be Empty!");
            return "redirect:/app/dashboard";
        }
        User user = (User)session.getAttribute("user");
        int setAccountNumber = GenAccountNumber.generateAccountNumber();
        String bankAccountNumber = Integer.toString(setAccountNumber);
        // TODO: CREATE ACCOUNT:
        accountRepository.createBankAccount(user.getUser_id(), bankAccountNumber, accountName, accountType );
        System.out.println("............................. ");
        // Set Success message:
        redirectAttributes.addFlashAttribute("success", "Account Created Successfully!");
        return "redirect:/app/dashboard";

    }
}
