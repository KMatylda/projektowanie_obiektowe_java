package tickets;

import java.util.*;

// UAAdapter JEST FlightAdapter (implements) ...
// ... ale UŻYWA UATicketService (wewnątrz)
// To właśnie jest wzorzec Adapter: implementujesz jeden interfejs, używasz drugiego
public class UAAdapter implements FlightAdapter {

    // Przechowujemy referencję do oryginalnego serwisu UA
    private UATicketService uaService;

    // Konstruktor przyjmuje serwis UA – "wstrzykujemy" go z zewnątrz
    public UAAdapter(UATicketService uaService) {
        this.uaService = uaService;
    }

    // Ta metoda jest wymagana przez interfejs FlightAdapter
    @Override
    public List<FlightTicket> search(String from, String to, Date date) {

        // Krok 1: pytamy UA ich metodą (String from, String to)
        List<UATicketInfo> raw = uaService.getTicketInfo(from, to, date);

        // Krok 2: zamieniamy każdy UATicketInfo na nasz FlightTicket
        List<FlightTicket> result = new ArrayList<>();
        for (UATicketInfo info : raw) {
            result.add(new FlightTicket(
                    info.from,
                    info.to,
                    info.dateTimeMs,
                    info.price,
                    0,                   // UA nie daje stops – przyjmujemy domyślnie 0
                    0,                   // UA nie daje durationMinutes – przyjmujemy 0
                    "United Airlines"
            ));
        }
        return result;
    }
}

