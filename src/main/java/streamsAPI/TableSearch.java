package streamsAPI;

import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Optional;

public class TableSearch {
    /*
    * The "Table Search"
    This is the most common use case in automated testing.
    You need to find a specific row in a table to interact with it.

    The Setup: You have a List<WebElement> rows. Each row contains text like:
    "Row 1: User_ID_01, Status: Active"
    "Row 2: User_ID_99, Status: Inactive"
    "Row 3: User_ID_45, Status: Active"

    * The Goal: Find the first row that contains "ID_99".
    * */
    List<WebElement> rows;
/*
    WebElement row = rows
            .stream()
            .map(row -> row.getText().contains("ID_99"))
            .findFirst()
            .orElse(null);
*/

}
