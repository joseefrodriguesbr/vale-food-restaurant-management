package br.inatel.pos.dm111.vfr.publisher;

import java.util.ArrayList;
import java.util.List;

import br.inatel.pos.dm111.vfr.persistence.restaurant.Product;
import br.inatel.pos.dm111.vfr.persistence.restaurant.Restaurant;

public interface AppPublisher
{
	default Event buildEvent(Restaurant restaurant, Event.EventType eventType)
	{
		var restaurantEvent = buildRestaurantEvent(restaurant);
		return new Event(eventType, restaurantEvent);
	}

	default RestaurantEvent buildRestaurantEvent(Restaurant restaurant)
	{
		List<ProductEvent> listaProductEvent = buildProductEvent(restaurant);
		return new RestaurantEvent(restaurant.id(), restaurant.name(), restaurant.address(), restaurant.userId(), restaurant.categories(), listaProductEvent);
	}

	boolean publishCreated(Restaurant restaurant);

	private List<ProductEvent> buildProductEvent(Restaurant restaurant)
	{
		List<ProductEvent> listaProductEvent = new ArrayList<ProductEvent>();
		for (Product product : restaurant.products())
		{
			ProductEvent productEvent = new ProductEvent(product.id(), product.name(), product.description(), product.category(), product.price());
			listaProductEvent.add(productEvent);
		}
		return listaProductEvent;
	}
}
