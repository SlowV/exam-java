package view;

import controller.ControllerStudent;

import java.util.Scanner;

public class ViewStudent {
    public void menu() {
        ControllerStudent controllerStudent = new ControllerStudent();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1.Add new student");
            System.out.println("2.save");
            System.out.println("3.Display all student");
            System.out.println("4.Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    controllerStudent.Add();
                    break;
                case 2:
                    controllerStudent.Save();

                    break;
                case 3:
                    controllerStudent.Display();
                    break;

                case 4:
                    System.exit(1);
                    break;


            }

        }

    }
}
