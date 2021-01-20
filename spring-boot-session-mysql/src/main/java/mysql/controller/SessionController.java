package mysql.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class SessionController {

    private static final String MY_SESSION_NOTES_CONSTANT = "MY_SESSION_NOTES";

    @GetMapping(value = "/index")
    public String home(final Model model, final HttpSession session) {
        final List<String> notes = (List<String>) session.getAttribute(MY_SESSION_NOTES_CONSTANT);
        model.addAttribute("sessionNotes", !CollectionUtils.isEmpty(notes) ? notes : new ArrayList<>());
        return "home";
    }

    @PostMapping(value = "/save/note")
    public String saveNote(@RequestParam("note") final String note, final HttpServletRequest request) {
        // Get the notes from request session.
        List<String> notes = (List<String>) request.getSession().getAttribute(MY_SESSION_NOTES_CONSTANT);

        // Check if notes is present in session or not.
        if (CollectionUtils.isEmpty(notes)) {
            notes = new ArrayList<>();
        }

        notes.add(note);
        request.getSession().setAttribute(MY_SESSION_NOTES_CONSTANT, notes);
        return "redirect:/index";
    }

    @PostMapping(value = "/destroy/session")
    public String destroySession(final HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/index";
    }
}
