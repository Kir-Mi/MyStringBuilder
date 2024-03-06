import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;

public class MyStringBuilder {
    private List<Character> value;
    private final Deque<List<Character>> snapshotStack;

    public MyStringBuilder() {
        this.value = new ArrayList<>();
        this.snapshotStack = new ArrayDeque<>();
    }

    public MyStringBuilder(String str) {
        this.value = new ArrayList<>(str.length());
        for (char c : str.toCharArray()) {
            value.add(c);
        }
        this.snapshotStack = new ArrayDeque<>();
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
        if(!snapshotStack.isEmpty()) {
            value = snapshotStack.removeLast();
        }
        return this;
    }

    public void save() {
        snapshotStack.addLast(new ArrayList<>(value));
    }

    public String toString() {
        return value.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
    }
}
