package streamsAPI;

import java.util.List;

public class HowManyAdminInList {

    public static void main(String[] args) {

        List<String> roles = List.of("Admin", "User", "Editor", "Admin", "Guest", "Admin");

        long adminCount = roles.stream()
                .filter(text -> text.equalsIgnoreCase("Admin"))
                .count();

        System.out.println(adminCount);
    }
}
