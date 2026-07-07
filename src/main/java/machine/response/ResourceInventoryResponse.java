package machine.response;

public record ResourceInventoryResponse(
        int water,
        int milk,
        int coffee,
        int cups,
        int money
) { }
