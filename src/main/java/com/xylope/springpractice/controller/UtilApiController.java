package com.xylope.springpractice.controller;

import com.xylope.springpractice.dto.AccountDto;
import com.xylope.springpractice.dto.UserRequestDto;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping("/api")
public class UtilApiController {
    @GetMapping("ping")
    public String pong() {
        return "pong";
    }

    @GetMapping("/random100")
    public String random100() {
        return String.valueOf(new Random().nextInt(100));
    }

    @GetMapping("/random-n/{bound}")
    public String randomN(@PathVariable String bound) {
        int boundInt = 0;
        try {
            boundInt = Integer.parseInt(bound);
        } catch (NumberFormatException e) {
            return "error";
        }
        return String.valueOf(new Random().nextInt(boundInt));
    }

    @GetMapping("/print-query-param")
    public String printQueryParam(@RequestParam Map<String, String> queryParam) {
        StringBuilder sb = new StringBuilder();
        queryParam.forEach((k, v) -> {
            sb.append("\n").append(k).append(" : ").append(v);
        });
        return sb.toString();
    }

    @GetMapping("/print-formatted-query-param")
    public String printFormattedQueryParam(UserRequestDto dto) {
            return dto.toString();
    }

    @PostMapping("/print-request-data")
    public String printRequestData(@RequestBody AccountDto requestAccount) {
        return requestAccount.toString();
    }

    @PostMapping("/send-request-data")
    public void sendRequestData(@RequestBody AccountDto requestAccount) {
        System.out.println(requestAccount);
    }

    @DeleteMapping("/delete/{userId}")
    public void deleteUser(@PathVariable String userId, @RequestParam String account) {
        System.out.println(userId + "\n" + account);
    }
}
