package collectNChill.collectnchill.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import collectNChill.collectnchill.entity.FunkoPop;
import collectNChill.collectnchill.repository.FunkoPopRepository;

@Service
public class funkoPopService {

		@Autowired
		private FunkoPopRepository repo;
		
		public FunkoPop createFunkoPop(FunkoPop funkoPop){
			return repo.save(funkoPop);
		}
}
