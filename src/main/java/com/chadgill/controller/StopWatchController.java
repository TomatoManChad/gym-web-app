package com.chadgill.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StopWatchController {

@GetMapping("/stopwatch")
public String getStopwatchPage() {
	return "stop-watch";
}
}
