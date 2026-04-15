package com.tugas.deploy.controller;

import com.tugas.deploy.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    // Penyimpanan data sementara (Temporary) sesuai instruksi tugas [cite: 74]
    private static List<User> daftarMahasiswa = new ArrayList<>();
    private String myNim = "20230140215"; // Ganti dengan NIM asli kamu [cite: 70, 75]

    @GetMapping("/")
    public String index() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        // Logika login: username admin & password adalah NIM [cite: 70]
        if ("admin".equals(username) && myNim.equals(password)) {
            return "redirect:/home";
        }
        model.addAttribute("error", "Username atau Password salah!");
        return "login";
    }

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("listMhs", daftarMahasiswa);
        model.addAttribute("nimSaya", myNim); // Untuk identitas di footer/header [cite: 75, 106]
        return "home";
    }

    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("user", new User());
        return "form";
    }

    @PostMapping("/save")
    public String saveTarget(@ModelAttribute User user) {
        daftarMahasiswa.add(user);
        return "redirect:/home";
    }

    @GetMapping("/logout")
    public String logout() {
        return "redirect:/";
    }
}