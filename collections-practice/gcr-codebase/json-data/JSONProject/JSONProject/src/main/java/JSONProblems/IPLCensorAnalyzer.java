package JSONProblems;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import java.io.*;
import java.util.Iterator;
public class IPLCensorAnalyzer {
    private static String maskTeamName(String teamName) {
        if (teamName == null || teamName.isEmpty()) return "";
        String[] parts = teamName.split(" ");
        return parts[0] + " ***";
    }
    private static JSONObject censorMatchJson(JSONObject match) {
        if (match.has("team1")) match.put("team1", maskTeamName(match.getString("team1")));
        if (match.has("team2")) match.put("team2", maskTeamName(match.getString("team2")));
        if (match.has("winner")) match.put("winner", maskTeamName(match.getString("winner")));
        if (match.has("player_of_match")) match.put("player_of_match", "REDACTED");
        if (match.has("score")) {
            JSONObject scoreObj = match.getJSONObject("score");
            JSONObject newScoreObj = new JSONObject();
            Iterator<String> keys = scoreObj.keys();
            while (keys.hasNext()) {
                String team = keys.next();
                newScoreObj.put(maskTeamName(team), scoreObj.getInt(team));
            }
            match.put("score", newScoreObj);
        }

        return match;
    }
    public static void processJson(String inputFile) {
        String outputFile = inputFile.replace(".json", "_censored.json");
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
            JSONArray jsonArray = new JSONArray(new JSONTokener(br));
            JSONArray censoredArray = new JSONArray();
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject match = jsonArray.getJSONObject(i);
                censoredArray.put(censorMatchJson(match));
            }
            bw.write(censoredArray.toString(4));
            System.out.println("Censored JSON saved to: " + outputFile);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void processCsv(String inputFile) {
        String outputFile = inputFile.replace(".csv", "_censored.csv");
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
            String headerLine = br.readLine();
            if (headerLine == null) return;
            bw.write(headerLine);
            bw.newLine();
            String[] headers = headerLine.split(",");
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",", -1);
                for (int i = 0; i < values.length; i++) {
                    switch (headers[i]) {
                        case "team1":
                        case "team2":
                        case "winner":
                            values[i] = maskTeamName(values[i]);
                            break;
                        case "player_of_match":
                            values[i] = "REDACTED";
                            break;
                    }
                }
                bw.write(String.join(",", values));
                bw.newLine();
            }

            System.out.println("Censored CSV saved to: " + outputFile);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        processJson("src/main/java/JSONProblems/ipl_data.json");
        processCsv("src/main/java/JSONProblems/ipl_data.csv");
    }
}
