package com.example.accessing_data_mysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ViewController {

	@Autowired 
	private UserRepository userRepository;

    @GetMapping("/top")
	public String bye(@RequestParam(name="name", required=false, defaultValue="さようなら") String name, Model model) {
		model.addAttribute("name", name);
		return "top";
	}

	@GetMapping("/users")
	public String index(Model model) {
		Iterable<User> users = userRepository.findAll();
		model.addAttribute("users", users);
		return "users";
	}

	//ユーザー追加処理
	@PostMapping(path="/user/add")
	public String addNewUser (@ModelAttribute User user) {
		userRepository.save(user);
		return "redirect:/users"; // Redirect to the page that lists all users
	}

	//ユーザー追加フォーム画面表示
	@GetMapping("/user/add-view")
	public String add(Model model) {
		model.addAttribute("user", new User());
		return "add-form";
	}

}