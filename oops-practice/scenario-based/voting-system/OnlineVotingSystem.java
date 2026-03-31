import java.util.*;

public class OnlineVotingSystem extends ElectionService {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Voter> voters = new ArrayList<>();
    static ArrayList<Candidate> candidates = new ArrayList<>();
    static ArrayList<Vote> votes = new ArrayList<>();

    public static void main(String[] args) {

        OnlineVotingSystem system = new OnlineVotingSystem();

        while (true) {
            System.out.println("\n--- Online Voting Menu ---");
            System.out.println("1. Register Voter");
            System.out.println("2. Add Candidate");
            System.out.println("3. Cast Vote");
            System.out.println("4. Declare Result");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> system.registerVoterInput();
                case 2 -> system.addCandidateInput();
                case 3 -> system.castVoteInput();
                case 4 -> system.declareResult();
                case 5 -> {
                    System.out.println("Election Ended");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    // ---------- USER INPUT METHODS ----------

    void registerVoterInput() {
        System.out.print("Enter Voter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Voter Name: ");
        String name = sc.nextLine();

        registerVoter(new Voter(id, name));
        System.out.println("Voter registered successfully");
    }

    void addCandidateInput() {
        System.out.print("Enter Candidate ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Candidate Name: ");
        String name = sc.nextLine();

        addCandidate(new Candidate(id, name));
        System.out.println("Candidate added successfully");
    }

    void castVoteInput() {
        try {
            if (voters.isEmpty() || candidates.isEmpty()) {
                System.out.println("Register voters and candidates first");
                return;
            }

            System.out.println("Voters:");
            for (Voter v : voters)
                System.out.println(v.voterId + " - " + v.name);

            System.out.print("Enter Voter ID: ");
            int voterId = sc.nextInt();

            System.out.println("Candidates:");
            for (Candidate c : candidates)
                System.out.println(c.candidateId + " - " + c.name);

            System.out.print("Enter Candidate ID: ");
            int candidateId = sc.nextInt();

            castVote(voterId, candidateId);
            System.out.println("Vote cast successfully");

        } catch (DuplicateVoteException e) {
            System.out.println(e.getMessage());
        }
    }

    // ---------- ABSTRACT METHOD IMPLEMENTATION ----------

    @Override
    void registerVoter(Voter voter) {
        voters.add(voter);
    }

    @Override
    void addCandidate(Candidate candidate) {
        candidates.add(candidate);
    }

    @Override
    void castVote(int voterId, int candidateId)
            throws DuplicateVoteException {

        Voter voter = null;
        for (Voter v : voters) {
            if (v.voterId == voterId)
                voter = v;
        }

        if (voter == null) {
            System.out.println("Voter not found");
            return;
        }

        if (voter.hasVoted)
            throw new DuplicateVoteException("Duplicate vote not allowed!");

        Candidate candidate = null;
        for (Candidate c : candidates) {
            if (c.candidateId == candidateId)
                candidate = c;
        }

        if (candidate == null) {
            System.out.println("Candidate not found");
            return;
        }

        voter.hasVoted = true;
        candidate.voteCount++;
        votes.add(new Vote(voterId, candidateId));
    }

    @Override
    void declareResult() {
        System.out.println("\n--- Election Result ---");
        for (Candidate c : candidates) {
            System.out.println(c.name + " : " + c.voteCount + " votes");
        }
    }
}
