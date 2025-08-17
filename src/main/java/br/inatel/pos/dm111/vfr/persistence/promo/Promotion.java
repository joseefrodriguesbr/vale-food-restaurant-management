package br.inatel.pos.dm111.vfr.persistence.promo;

public record Promotion(String id, String name, String description, String restaurantId, PromotionalProduct product)
{
}
