package dev.yafatek.restfull;import dev.yafatek.microservices.MicroService;import dev.yafatek.microservices.MicroServiceFactory;import org.junit.Test;public class ApiTests {	private MicroService microService;	private MicroServicesProducerImpl producer;	private MicroServiceFactory factory;	@Test	public void TestApi() {		factory = producer.createMicroService("test");		microService = factory.createEndMicroService();		microService.getFromMicroService();//		System.out.println(result);	}}