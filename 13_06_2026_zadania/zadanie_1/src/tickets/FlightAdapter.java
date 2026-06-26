package tickets;

import java.util.Date;
import java.util.List;

// Interfejs
// Każda klasa która go implementuje MUSI mieć metodę search()
public interface FlightAdapter {

    // Szukaj lotów z "from" do "to" na datę "date"
    // Zwraca listę FlightTicket – zawsze ten sam typ, niezależnie od linii
    List<FlightTicket> search(String from, String to, Date date);

}
