import java.util.*;

class Solution {
     public static int[] solution(int N, int[] stages) {
        int[] stageCount = new int[N + 2];
        for (int stage : stages) {
            stageCount[stage]++;
        }

        int totalPlayers = stages.length;
        List<Stage> stageList = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (totalPlayers == 0) {
                stageList.add(new Stage(i, 0));
            } else {
                double failureRate = (double) stageCount[i] / totalPlayers;
                stageList.add(new Stage(i, failureRate));
                totalPlayers -= stageCount[i];
            }
        }

        stageList.sort((a, b) -> {
            if (b.failureRate == a.failureRate) {
                return a.stage - b.stage;
            } else {
                return Double.compare(b.failureRate, a.failureRate);
            }
        });

        return stageList.stream().mapToInt(stage -> stage.stage).toArray();
    }

    static class Stage {
        int stage;
        double failureRate;

        Stage(int stage, double failureRate) {
            this.stage = stage;
            this.failureRate = failureRate;
        }
    }
}