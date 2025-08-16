package br.inatel.pos.dm111.vfr.publisher;

import java.util.List;

public record RestaurantEvent(String id, String name, String address, String userId, List<String> categories, List<ProductEvent> products)
{
}
