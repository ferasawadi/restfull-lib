# Java Restfull-MicroService Library#### WARNING ⚠️⚠️⚠️> ⚠️ Please Don't use the Library Now 🥺 ☹️ , it still under Development, Bugs 🐞 may happened and the  Algorithm is not ready Yet 😰## IntroductionWe're going to use this Library to build MicroServices and restfull apis* how to Create Object* how to Call the Service* how to Create MicroService processes.### Test the Api#### perform an Api Call```java@ApiAttributes(url = "https://misafir.app/api/v1/users/show_users/")	private static void doApiConnection(){		ApiClientResponse response= ApiClient.apiClientBuilder()				.url()				.inti()				.perform()				.retrieve();		System.out.println(response.getMessage());	}```> you Can implement the Api Client using the Following method.* create an Object of the Api Interface like so:```javaApiClientBuilder builder = ApiClientBuilder.buildWithDefaults();```two ways are available, either call the Default implementation using the embedded method```javaApiClientBuilder.buildWithDefaults();```or create your own instance and implementation using:```javaApiClientBuilder.builder(ApiClient.class);```passing the implementation Class name to the Method.### usage```javabuilder.inti()	   .perform()	   .retrieve();```### getting the response```javeApiClientBuilder builder = ApiClientBuilder.buildWithDefaults();		ApiClientResponse clientResponse =builder.inti()				.perform()				.retrieve();		System.out.println(clientResponse.isStatus());```### Create the Object#### MicroServices.```javapublic class className{        private MicroService<String> microService;    	private MicroServicesProducerImpl producer;    	private MicroServiceFactory factory;    public void method{        producer = new MicroServicesProducerImpl();        factory = producer.callMicroService("microseriveName");        microService = factory.createMicroServiceMethods();        microService.getFromMicroService();    }}```#### Call the Mehtods:> Service Object```javaservices.getFromMicroService();```#### Contribution:Contribution is Always Welcomed, Please contact : ferasawady@gmail.com#### notes> stay Tuned, a lot is Coming  🤤 👽 💪## License-------2020 YafaTek® Solutions. https://yafatek.dev , https://misafir.app