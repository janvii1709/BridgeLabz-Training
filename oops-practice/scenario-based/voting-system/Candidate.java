public class Candidate {
    int candidateId;
    String name;
    int voteCount = 0;

    public Candidate(int candidateId, String name) {
        this.candidateId = candidateId;
        this.name = name;
    }
}
