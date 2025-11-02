import java.util.*;

public class LabAct2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("type 'exit' to quit\nInput:  ");
            String input = sc.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Program terminated.");
                break;
            }

            if (isAccepted(input)) {
                System.out.println("Output: Accepted\n");
            } else {
                System.out.println("Output: Rejected\n");
            }
        }

        sc.close();
    }

    public static boolean isAccepted(String input) {
        Set<Integer> currentStates = new HashSet<>();
        currentStates.add(0);

        for (char symbol : input.toCharArray()) {
            Set<Integer> nextStates = new HashSet<>();

            for (int state : currentStates) {
                switch (state) {
                    case 0:
                        if (symbol == 'a') nextStates.add(1);
                        if (symbol == 'b') nextStates.add(0);
                        break;
                    case 1:
                        if (symbol == 'a') nextStates.add(1);
                        if (symbol == 'b') nextStates.add(2);
                        break;
                    case 2:
                        nextStates.add(2);
                        break;
                }
            }

            currentStates = nextStates;
        }

        return currentStates.contains(2);
    }
}
