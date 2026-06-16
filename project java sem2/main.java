import java.util.*;

class Candidate {
    String name;
    int votes = 0;

    Candidate(String name) {
        this.name = name;
    }

    void vote() {
        votes++;
    }
}

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Candidate c1 = new Candidate("Alice");
        Candidate c2 = new Candidate("Bob");

        int[] voters = new int[100];
        int voterCount = 0;

        int choice;

        do {
            System.out.println("\n1. Vote");
            System.out.println("2. Results");
            System.out.println("3. Exit");
            System.out.print("Enter Choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Voter ID: ");
                    int id = sc.nextInt();

                    boolean alreadyVoted = false;

                    for (int i = 0; i < voterCount; i++) {
                        if (voters[i] == id) {
                            alreadyVoted = true;
                            break;
                        }
                    }

                    if (alreadyVoted) {
                        System.out.println("You already voted!");
                        break;
                    }

                    System.out.println("1. Alice");
                    System.out.println("2. Bob");
                    System.out.print("Enter your vote: ");
                    int vote = sc.nextInt();

                    if (vote == 1) {
                        c1.vote();
                        voters[voterCount] = id;
                        voterCount++;
                    } 
                    else if (vote == 2) {
                        c2.vote();
                        voters[voterCount] = id;
                        voterCount++;
                    } 
                    else {
                        System.out.println("Invalid Vote!");
                    }
                    break;

                case 2:
                    System.out.println("\nResults:");
                    System.out.println("Alice: " + c1.votes);
                    System.out.println("Bob: " + c2.votes);

                    if (c1.votes > c2.votes)
                        System.out.println("Winner: Alice");
                    else if (c2.votes > c1.votes)
                        System.out.println("Winner: Bob");
                    else
                        System.out.println("Tie!");
                    break;

                case 3:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 3);

        sc.close();
    }
}
