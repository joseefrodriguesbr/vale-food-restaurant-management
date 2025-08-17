package br.inatel.pos.dm111.vfr.api.promo;

public record PromotionRequest(String id, String name, String description, String restaurantId, PromotionalProductRequest product)
{
}