import java.util.ArrayList;
import java.util.Scanner;

class Task {
    private String description;
    private boolean isCompleted;

    public Task(String description) {
        this.description = description;
        this.isCompleted = false;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void toggleComplete() {
        isCompleted = !isCompleted;
    }

    @Override
    public String toString() {
        return (isCompleted ? "[X] " : "[ ] ") + description;
    }
}

class ToDoList {
    private ArrayList<Task> tasks;

    public ToDoList() {
        tasks = new ArrayList<>();
    }

    public void addTask(String description) {
        tasks.add(new Task(description));
        System.out.println("Task added successfully!");
    }

    public void removeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
            System.out.println("Task removed successfully!");
        } else {
            System.out.println("Invalid task index!");
        }
    }

    public void toggleTaskComplete(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).toggleComplete();
            System.out.println("Task status toggled!");
        } else {
            System.out.println("Invalid task index!");
        }
    }

    public void displayTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks in the list!");
            return;
        }
        System.out.println("\nToDo List:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ToDoList todoList = new ToDoList();
        
        while (true) {
            System.out.println("\n=== ToDo List Application ===");
            System.out.println("1. Add Task");
            System.out.println("2. Remove Task");
            System.out.println("3. Toggle Task Complete");
            System.out.println("4. Display Tasks");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            switch (choice) {
                case 1:
                    System.out.print("Enter task description: ");
                    String description = scanner.nextLine();
                    todoList.addTask(description);
                    break;
                    
                case 2:
                    todoList.displayTasks();
                    System.out.print("Enter task number to remove: ");
                    int removeIndex = scanner.nextInt() - 1;
                    todoList.removeTask(removeIndex);
                    break;
                    
                case 3:
                    todoList.displayTasks();
                    System.out.print("Enter task number to toggle: ");
                    int toggleIndex = scanner.nextInt() - 1;
                    todoList.toggleTaskComplete(toggleIndex);
                    break;
                    
                case 4:
                    todoList.displayTasks();
                    break;
                    
                case 5:
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;
                    
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
