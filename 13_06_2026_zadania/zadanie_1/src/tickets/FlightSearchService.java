package tickets;

import java.util.*;
import java.util.stream.Collectors;

public class FlightSearchService {

    // Lista wszystkich zarejestrowanych adapterów (UA, BA, LOT, Ryanair...)
    // Używamy interfejsu FlightAdapter – nie wiemy co jest pod spodem
    private List<FlightAdapter> adapters = new ArrayList<>();

    // Rejestrujemy nowy adapter (nową linię lotniczą)
    public void addAdapter(FlightAdapter adapter) {
        adapters.add(adapter);
    }

    // Główna metoda wyszukiwania: pyta KAŻDĄ linię i łączy wyniki
    public List<FlightTicket> search(String from, String to, Date date) {
        List<FlightTicket> all = new ArrayList<>();
        for (FlightAdapter adapter : adapters) {
            // Każdy adapter zwraca List<FlightTicket> – ten sam typ
            all.addAll(adapter.search(from, to, date));
        }
        return all;
    }

    // --- SORTOWANIE ---

    // Sortowanie po cenie rosnąco (najtańszy pierwszy)
    public List<FlightTicket> sortByPrice(List<FlightTicket> list) {
        return list.stream()
                .sorted(Comparator.comparingDouble(FlightTicket::getPrice))
                .collect(Collectors.toList());
    }

    // Sortowanie po czasie lotu (najkrótszy pierwszy)
    public List<FlightTicket> sortByDuration(List<FlightTicket> list) {
        return list.stream()
                .sorted(Comparator.comparingInt(FlightTicket::getDurationMinutes))
                .collect(Collectors.toList());
    }

    // Sortowanie po liczbie przesiadek (najmniej przesiadek = lepiej)
    public List<FlightTicket> sortByStops(List<FlightTicket> list) {
        return list.stream()
                .sorted(Comparator.comparingInt(FlightTicket::getStops))
                .collect(Collectors.toList());
    }

    // --- FILTROWANIE ---

    // Zostaw tylko bilety tańsze niż maxPrice
    public List<FlightTicket> filterByMaxPrice(List<FlightTicket> list, double maxPrice) {
        return list.stream()
                .filter(t -> t.getPrice() <= maxPrice)
                .collect(Collectors.toList());
    }

    // Zostaw tylko loty z co najwyżej maxStops przesiadkami
    public List<FlightTicket> filterByMaxStops(List<FlightTicket> list, int maxStops) {
        return list.stream()
                .filter(t -> t.getStops() <= maxStops)
                .collect(Collectors.toList());
    }

    // Zostaw tylko loty krótsze niż maxMin minut
    public List<FlightTicket> filterByMaxDuration(List<FlightTicket> list, int maxMin) {
        return list.stream()
                .filter(t -> t.getDurationMinutes() <= maxMin)
                .collect(Collectors.toList());
    }
}

