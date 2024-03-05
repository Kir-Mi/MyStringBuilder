import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MyStringBuilder {
    private List<Character> value;
    private final List<List<Character>> snapshots;
    private int snapshotCounter;

    public MyStringBuilder() {
        this.value = new ArrayList<>();
        this.snapshots = new ArrayList<>();
        this.snapshotCounter = -1;
    }

    public MyStringBuilder(String str) {
        this.value = new ArrayList<>(str.length());
        for (char c : str.toCharArray()) {
            value.add(c);
        }
        this.snapshots = new ArrayList<>();
        this.snapshotCounter = -1;
    }

    public MyStringBuilder append(String str) {
        for (char c : str.toCharArray()) {
            value.add(c);
        }
        return this;
    }

    public MyStringBuilder deleteCharAt(int index) {
        value.remove(index);
        return this;
    }

    public MyStringBuilder undo() {
        if(snapshotCounter >= 0) {
            value = snapshots.get(snapshotCounter);
            snapshots.remove(snapshotCounter);
            --snapshotCounter;
        }
        return this;
    }

    public void save() {
        snapshots.add(new ArrayList<>(value));
        ++snapshotCounter;
    }

    public String toString() {
        return value.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
    }
}
