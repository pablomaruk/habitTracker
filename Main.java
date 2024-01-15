import java.util.ArrayList;
import java.util.Scanner;

class Habit {
    private String name;
    private int streak;

    public Habit(String name) {
        this.name = name;
        this.streak = 0;
    }

    public String getName() {
        return name;
    }

    public int getStreak() {
        return streak;
    }

    public void incrementStreak() {
        streak++;
    }

    public void resetStreak() {
        streak = 0;
    }

    @Override
    public String toString() {
        return "Habit: " + name + " | Streak: " + streak;
    }
}

class HabitTracker {
    private ArrayList<Habit> habits;

    public HabitTracker() {
        this.habits = new ArrayList<>();
    }

    public void addHabit(Habit habit) {
        habits.add(habit);
    }

    public void displayHabits() {
        System.out.println("----- Habits -----");
        for (Habit habit : habits) {
            System.out.println(habit);
        }
        System.out.println("------------------");
    }

    public void markHabitCompleted(int index) {
        if (index >= 0 && index < habits.size()) {
            habits.get(index).incrementStreak();
            System.out.println("Habit marked as completed: " + habits.get(index).getName());
        } else {
            System.out.println("Invalid index.");
        }
    }

    public void resetHabitStreak(int index) {
        if (index >= 0 && index < habits.size()) {
            habits.get(index).resetStreak();
            System.out.println("Streak reset for habit: " + habits.get(index).getName());
        } else {
            System.out.println("Invalid index.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HabitTracker habitTracker = new HabitTracker();

        while (true) {
            System.out.println("1. Add Habit");
            System.out.println("2. Display Habits");
            System.out.println("3. Mark Habit as Completed");
            System.out.println("4. Reset Habit Streak");
            System.out.println("5. Exit");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter habit name: ");
                    String habitName = scanner.nextLine();
                    Habit newHabit = new Habit(habitName);
                    habitTracker.addHabit(newHabit);
                    System.out.println("Habit added: " + newHabit.getName());
                    break;

                case 2:
                    habitTracker.displayHabits();
                    break;

                case 3:
                    System.out.print("Enter the index of the habit to mark as completed: ");
                    int indexComplete = scanner.nextInt();
                    habitTracker.markHabitCompleted(indexComplete);
                    break;

                case 4:
                    System.out.print("Enter the index of the habit to reset streak: ");
                    int indexReset = scanner.nextInt();
                    habitTracker.resetHabitStreak(indexReset);
                    break;

                case 5:
                    System.out.println("Exiting Habit Tracker. Goodbye!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
