package tickets;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        UATicketService uaService = new UATicketService() {
            @Override
            public List<UATicketInfo> getTicketInfo(String from, String to, Date when) {
                UATicketInfo t1 = new UATicketInfo();
                t1.from = from;
                t1.to = to;
                t1.dateTimeMs = when.getTime() + 3_600_000L;
                t1.price = 450.00;

                UATicketInfo t2 = new UATicketInfo();
                t2.from = from;
                t2.to = to;
                t2.dateTimeMs = when.getTime() + 7_200_000L;
                t2.price = 299.00;

                return Arrays.asList(t1, t2);
            }
        };

        BATicketService baService = new BATicketService() {
            @Override
            public List<BATicket> getTicketInfo(Airport from, Airport to, Date when) {
                BATicket t1 = new BATicket();
                t1.departureTime = new Date(when.getTime() + 5_400_000L);
                t1.ticketPrice = 380.00;

                BATicket t2 = new BATicket();
                t2.departureTime = new Date(when.getTime() + 9_000_000L);
                t2.ticketPrice = 199.00;

                return Arrays.asList(t1, t2);
            }
        };

        FlightAdapter uaAdapter = new UAAdapter(uaService);
        FlightAdapter baAdapter = new BAAdapter(baService);

        FlightSearchService search = new FlightSearchService();
        search.addAdapter(uaAdapter);
        search.addAdapter(baAdapter);

        List<FlightTicket> wyniki = search.search("WAW", "LHR", new Date());

        System.out.println("=== WSZYSTKIE WYNIKI ===");
        wyniki.forEach(System.out::println);

        System.out.println("\n=== POSORTOWANE PO CENIE ===");
        search.sortByPrice(wyniki).forEach(System.out::println);

        System.out.println("\n=== TYLKO LOTY BEZPOSREDNIE ===");
        search.filterByMaxStops(wyniki, 0).forEach(System.out::println);

        System.out.println("\n=== TYLKO PONIZEJ 400 PLN ===");
        search.filterByMaxPrice(wyniki, 400.0).forEach(System.out::println);
    }
}