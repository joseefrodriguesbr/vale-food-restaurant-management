package br.inatel.pos.dm111.vfr.publisher;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import br.inatel.pos.dm111.vfr.persistence.restaurant.Restaurant;

@Profile("test")
@Component
public class UserHttpPublisher implements AppPublisher
{
	@Value("${vale-food.promo.url}")
	private String promoUrl;

	private final RestTemplate restTemplate;

	public UserHttpPublisher(RestTemplate restTemplate)
	{
		this.restTemplate = restTemplate;
	}

	@Override
	public boolean publishCreated(Restaurant restaurant)
	{
		var event = buildEvent(restaurant, Event.EventType.ADDED);
		restTemplate.postForObject(promoUrl, event.event(), RestaurantEvent.class);
		return true;
	}
}
