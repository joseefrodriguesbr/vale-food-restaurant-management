package br.inatel.pos.dm111.vfr.persistence.promo;

import java.util.List;
import java.util.concurrent.ExecutionException;

import br.inatel.pos.dm111.vfr.persistence.ValeFoodRepository;

public interface PromotionRepository extends ValeFoodRepository<Promotion>
{
	List<Promotion> findByRestaurantId(String restaurantId) throws ExecutionException, InterruptedException;
}
