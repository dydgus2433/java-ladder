package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {
    private List<LadderLine> ladderLines;

    private Ladder(List<LadderLine> ladderLines) {
        this.ladderLines = ladderLines;
    }

    public static Ladder of(int size, int height) {
        List<LadderLine> ladderLines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            ladderLines.add(LadderLine.init(size));
        }
        return new Ladder(ladderLines);
    }

    public static Ladder ofList(List<LadderLine> ladderLines) {
        return new Ladder(ladderLines);
    }

    public int getFinalPosition(int index) {
        for (int i = 0; i < ladderLines.size(); i++) {
            index = ladderLines.get(i).move(index);
        }
        return index;
    }

    //출력용
    public List<LadderLine> getLadderMap() {
        return Collections.unmodifiableList(ladderLines);
    }
}
