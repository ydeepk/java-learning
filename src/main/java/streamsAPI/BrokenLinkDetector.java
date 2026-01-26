package streamsAPI;

import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

public class BrokenLinkDetector {

    private static final Logger log = LoggerFactory.getLogger(BrokenLinkDetector.class);

    public static void main(String[] args) {
        /*
        * Exercise 2: The "Broken Link" Detector

Scenario: You find all <a> tags on a page. You want to extract ]
* the href attribute, but only for the links that actually have a URL (not null and not empty).*/

        List<String> allLinks = List.of("href=https://www.gmailMain.com","href=https://www.gmail.com","href=null","href=");

        List<String> validURLs = allLinks
                .stream()
                .map(link -> link.replace("href=",""))
                .filter(link -> !link.isEmpty() && !link.isBlank() && !link.contains("null"))
                .collect(Collectors.toList());

        System.out.println(validURLs);

    }
}
