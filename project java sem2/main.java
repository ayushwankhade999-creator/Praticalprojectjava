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

public class main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Candidate c1 = new Candidate("Alice");
        Candidate c2 = new Candidate("Bob");

        HashSet<Integer> voters = new HashSet<>();

        

        int choice;

        do {
            System.out.println("\n1. Vote\n2. Results\n3. Exit");
            choice = sc.nextInt();

            switch(choice) {

                case 1:
                    System.out.print("Enter Voter ID: ");
                    int id = sc.nextInt();

                    if (voters.contains(id)) {
                        System.out.println("You already voted!");
                        break;
                    }

                    System.out.println("1. Alice\n2. Bob");
                    int vote = sc.nextInt();

                    if (vote == 1) {
                        c1.vote();
                        voters.add(id);
                    } 
                    else if (vote == 2) {
                        c2.vote();
                        voters.add(id);
                    }
                    break;

                case 2:
                    System.out.println("Alice: " + c1.votes);
                    System.out.println("Bob: " + c2.votes);

                    if (c1.votes > c2.votes)
                        System.out.println("Winner: Alice");
                    else if (c2.votes > c1.votes)
                        System.out.println("Winner: Bob");
                    else
                        System.out.println("Tie!");
                    break;
            }

        } while (choice != 3);

        sc.close();
    }
}
