public class Main {
    public static void main(String[] args) {
        MyStringBuilder builder = new MyStringBuilder();
        builder.append("OHello");
        System.out.println(builder);
        builder.deleteCharAt(0);
        System.out.println(builder);
        builder.save();
        builder.append(" and bye");
        System.out.println(builder);
        builder.undo();
        System.out.println(builder);
        builder.append(", world");
        System.out.println(builder);
    }
}