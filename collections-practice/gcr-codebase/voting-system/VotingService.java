import java.util.*;
public class VotingService {
    private HashMap<String, CandidateVote> voteMap = new HashMap<>();
    private LinkedHashMap<String, CandidateVote> voteOrderMap = new LinkedHashMap<>();
    public void castVote(String candidateName) {
        if (voteMap.containsKey(candidateName)) {
            voteMap.get(candidateName).addVote();
        } else {
            CandidateVote cv = new CandidateVote(candidateName, 1);
            voteMap.put(candidateName, cv);
            voteOrderMap.put(candidateName, cv);
        }
        System.out.println("Vote cast successfully.");
    }
    public void displayVoteOrder() {
        if (voteOrderMap.isEmpty()) {
            System.out.println("No votes cast yet.");
            return;
        }
        System.out.println("\nVotes in order of casting:");
        for (CandidateVote vote : voteOrderMap.values()) {
            System.out.println(vote);
        }
    }
    public void displaySortedResults() {
        if (voteMap.isEmpty()) {
            System.out.println("No votes to display.");
            return;
        }
        TreeMap<String, CandidateVote> sortedMap = new TreeMap<>(voteMap);
        System.out.println("\nElection Results (Sorted by Candidate Name):");
        for (CandidateVote vote : sortedMap.values()) {
            System.out.println(vote);
        }
    }
}
