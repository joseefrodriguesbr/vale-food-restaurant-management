package br.inatel.pos.dm111.vfr.api.promo;

public record PromotionalProductResponse(String productId, float promotionalPrice, String category, String productName) {
}