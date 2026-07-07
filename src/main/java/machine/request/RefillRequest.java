package machine.request;

public record RefillRequest(
        int water,
        int milch,
        int coffee,
        int cups
) { }
