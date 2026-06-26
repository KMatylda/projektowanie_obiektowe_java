package tickets;

import java.util.*;

public class BAAdapter implements FlightAdapter {

    private BATicketService baService;

    public BAAdapter(BATicketService baService) {
        this.baService = baService;
    }

    @Override
    public List<FlightTicket> search(String from, String to, Date date) {

        // Krok 1: BA wymaga obiektów Airport, nie Stringów
        // Tworzymy Airport z kodów IATA które dostaliśmy jako String
        Airport airFrom = new Airport(from); // "WAW" → new Airport("WAW")
        Airport airTo   = new Airport(to);   // "LHR" → new Airport("LHR")

        // Krok 2: pytamy BA ich metodą (Airport from, Airport to)
        List<BATicket> raw = baService.getTicketInfo(airFrom, airTo, date);

        // Krok 3: zamieniamy każdy BATicket na nasz FlightTicket
        List<FlightTicket> result = new ArrayList<>();
        for (BATicket t : raw) {
            result.add(new FlightTicket(
                    from,
                    to,
                    t.departureTime.getTime(), // DateTime → long (konwersja w adapterze)
                    t.ticketPrice,               // BA: "ticketPrice", UA mialo "price"
                    0,                           // BA nie daje stops – domyślnie 0
                    0,                           // BA nie daje durationMinutes – domyślnie 0
                    "British Airways"
            ));
        }
        return result;
    }
}


