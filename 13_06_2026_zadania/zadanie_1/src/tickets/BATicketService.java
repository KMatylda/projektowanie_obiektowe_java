package tickets;
import java.util.Date;
import java.util.List;

// Różnica: BA używa obiektów Airport zamiast prostych Stringów!
public interface BATicketService {
    List<BATicket> getTicketInfo(Airport from, Airport to, Date when);
}

