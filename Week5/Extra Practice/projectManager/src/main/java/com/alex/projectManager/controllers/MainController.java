package com.alex.projectManager.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.alex.projectManager.models.LoginUser;
import com.alex.projectManager.models.Project;
import com.alex.projectManager.models.Task;
import com.alex.projectManager.models.User;
import com.alex.projectManager.services.ProjectService;
import com.alex.projectManager.services.TaskService;
import com.alex.projectManager.services.UserService;

@Controller
public class MainController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private TaskService taskService;
	
	@GetMapping("/")
	public String index(
			@ModelAttribute("newUser") User user,
			@ModelAttribute("newLogin") LoginUser loginUser ) {
		
		return "index.jsp";
	}
	
//****** REGISTER USER ******//
	
	@PostMapping("/register")
	public String register(
			@Valid @ModelAttribute("newUser") User user,
			BindingResult result,
			HttpSession session,
			@ModelAttribute("newLogin") LoginUser loginUser) {
		
		// validate user
		userService.validate(user, result);
		if(result.hasErrors()) {
			return "index.jsp";
		}
		
		// register user
		userService.registerUser(user);
		
		// put user in session
		session.setAttribute("loggedInUser", user);
		return "redirect:/dashboard";
		
	}

//****** LOGIN USER ******//
	
	@PostMapping("/login")
	public String login(
			@Valid @ModelAttribute("newLogin") LoginUser loginUser,
			BindingResult result,
			HttpSession session,
			@ModelAttribute("newUser") User user) {
		
		// authenticate user
		userService.authenticateUser(loginUser, result);
		if(result.hasErrors()) {
			return "index.jsp";
		}
		
		User loggedInUser = userService.findByEmail(loginUser.getUserEmail());
		
		// put user in session
		session.setAttribute("loggedInUser", loggedInUser);
		return "redirect:/dashboard";
	}
	
//****** LOGOUT ******//
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		
		session.invalidate();
		return "redirect:/";
	}

//****** DASHBOARD ******//
	
	@GetMapping("/dashboard")
	public String dashboard(
			HttpSession session) {
			
		if(session.getAttribute("loggedInUser") != null) {
				
			return "redirect:/projects";
		} 
		
		return "redirect:/";
		
	}
	
	@GetMapping("/projects")
	public String allProjects(
			Model viewModel,
			HttpSession session) {
		
		if(session.getAttribute("loggedInUser") != null) {
			User user = (User) session.getAttribute("loggedInUser");
			User userLoggedIn = userService.findById(user.getId());
			
			viewModel.addAttribute("userLoggedIn", userLoggedIn);
			viewModel.addAttribute("projects", projectService.getAllProjects());
		
			return "dashboard.jsp";

		}
		
		return "redirect:/";
	}
	
/***** CREATE PROJECT ******/
	
	@GetMapping("/projects/new")
	public String newProject(
			@ModelAttribute("newProject") Project project,
			HttpSession session) {
		
		if(session.getAttribute("loggedInUser") != null) {
			
			return "newProject.jsp";
		}
		
		return "redirect:/";
	}
	
	@PostMapping("/projects/create")
	public String createProject(
			@Valid @ModelAttribute("newProject") Project project,
			BindingResult result,
			HttpSession session) {
		
		if(result.hasErrors()) {
			return "newProject.jsp";
		}
		
		projectService.createProject(project);
		return "redirect:/dashboard";
	}
	
/****** DISPLAY PROJECT ******/
	
	@GetMapping("/projects/{id}")
	public String showProject(
	@PathVariable("id") Long id,
	Model viewModel,
	HttpSession session) {
		
		if(session.getAttribute("loggedInUser") != null) {
			
			User user = (User) session.getAttribute("loggedInUser");
			User userLoggedIn = userService.findById(user.getId());
			
			Project project = projectService.showOne(id);
			
			viewModel.addAttribute("project", project);
			viewModel.addAttribute("userLoggedIn", userLoggedIn);
			
			
			return "showProject.jsp";
		}
		
		return "redirect:/dashboard";
	}

/****** EDIT PROJECT ******/
	
	@GetMapping("/projects/{id}/edit")
	public String editProject(
			@PathVariable("id") Long id,
			Model viewModel,
			HttpSession session) {
		
		if(session.getAttribute("loggedInUser") != null) {
			
			Project project = projectService.showOne(id);
			viewModel.addAttribute("editProject", project);
			
			return "editProject.jsp";
		}
		
		return "redirect:/dashboard";
	}
	
/****** UPDATE PROJECT ******/
	
	@PutMapping("/projects/{id}/update")
	public String updateProject(
			@PathVariable("id") Long id,
			@Valid @ModelAttribute("editProject") Project project,
			BindingResult result,
			Model viewModel) {
		
		if(result.hasErrors()) {
			
			return "editProject.jsp";
		}
		
		projectService.updateProject(project);
		return "redirect:/dashboard";
	}
	
/****** DELETE PROJECT ******/
	
	@DeleteMapping("/projects/{id}/delete")
	public String deleteProject(
			@PathVariable("id") Long id) {
		
		projectService.deleteProject(id);
		return "redirect:/dashboard";
	}
	
/****** JOIN/LEAVE PROJECT ******/
	
	@GetMapping("/projects/{id}/join")
	public String joinProject(
			@PathVariable("id") Long id,
			HttpSession session) {
	
		User user = (User) session.getAttribute("loggedInUser");
		User projectJoiner = userService.findById(user.getId());
		
		Project project = projectService.showOne(id);
		projectService.joinProject(project, projectJoiner);
		
		return "redirect:/projects";
	
	}
	
	@GetMapping("/projects/{id}/leave")
	public String leaveProject (
			@PathVariable("id") Long id,
			HttpSession session) {
		
		User user = (User) session.getAttribute("loggedInUser");
		User projectLeaver = userService.findById(user.getId());
		
		Project project = projectService.showOne(id);
		projectService.leaveProject(project, projectLeaver);
		
		return "redirect:/projects";
		
	}
	
/****** ADD TASK TO PROJECT ******/
	
	@GetMapping("/projects/{id}/tasks")
	public String newTask(
			@PathVariable("id") Long id,
			@ModelAttribute("newTask") Task task,
			Model viewModel,
			HttpSession session) {
		
		
		if(session.getAttribute("loggedInUser") != null) {
			
			User user = (User) session.getAttribute("loggedInUser");
			User taskCreator = userService.findById(user.getId());
			viewModel.addAttribute("taskCreator", taskCreator);
			
			Project project = projectService.showOne(id);
			viewModel.addAttribute("project", project);
			viewModel.addAttribute("tasks", project.getTasks());
			
			return "projectTasks.jsp";
		}
		
		return "redirect:/projects";
	}
	
	
	
	@PostMapping("/projects/{id}/tasks/create")
	public String createTask(
			@PathVariable("id") Long id,
			@Valid @ModelAttribute("newTask") Task task,
			BindingResult result) {
		
		if(result.hasErrors()) {
			return "projectTasks.jsp";
		}
		
		taskService.createTask(task);
		return "redirect:/projects/{id}/tasks";
		
	}
	
/****** COMPLETE TASK ******/
	
	@DeleteMapping("/projects/{project_id}/tasks/{task_id}/delete")
	public String deleteTask(
			@PathVariable("project_id") Long id,
			@PathVariable("task_id") Long id2) {
		
		
		taskService.deleteTask(id2);
		return "redirect:/projects/{project_id}/tasks";
	}
	
}
	
		
	
	


