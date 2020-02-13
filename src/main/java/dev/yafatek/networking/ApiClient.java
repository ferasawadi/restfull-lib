package dev.yafatek.networking;import com.squareup.moshi.JsonAdapter;import com.squareup.moshi.Moshi;import dev.yafatek.App;import dev.yafatek.annotations.Url;import dev.yafatek.models.ApiClientResponse;import okhttp3.OkHttpClient;import okhttp3.Request;import okhttp3.Response;import java.io.IOException;import java.lang.reflect.Method;import java.util.Objects;import java.util.logging.Logger;public final class ApiClient implements ApiClientBuilder {	private static final Logger logger = Logger.getLogger(ApiClient.class.getName());	private static final OkHttpClient httpClient = new OkHttpClient();	private static Request request;	private final Moshi moshi = new Moshi.Builder().build();	private final JsonAdapter<ApiClientResponse> gistJsonAdapter = moshi.adapter(ApiClientResponse.class);	private ApiClientResponse clientResponse;	// api url that the user wants to call	private String url;	/**	 * Static methods only	 */	private ApiClient() {		logger.info(":::::::::: Api Client Constructor ::::::::::");	}	public static ApiClient apiClientBuilder() {		return new ApiClient();	}	/*	Class annotatedClass = FamilyMember.class;				Method[] methods = annotatedClass.getMethods();	for (Method method : methods) {					if (method.isAnnotationPresent(FamilyBudget.class)) {						FamilyBudget family = method.getAnnotation(FamilyBudget.class);						String userRole = family.userRole();                        int budgetLimit = family.getBudgetLimit();						if (userRole.equals(role)) {                                if(spend <= budgetLimit){								method.invoke(FamilyMember.class.newInstance(),										budgetLimit, spend);							}else{								System.out.println("Budget Limit Over");							}						}					}				}	* */	@Override	public ApiClientBuilder url() {		logger.info("url...");		// class that hosts the annotations.		Class<?> annotation = App.class;		Method[] methods = annotation.getDeclaredMethods();		for (Method method : methods) {			if (method.isAnnotationPresent(Url.class)) {				Url url = method.getAnnotation(Url.class);				this.url = url.url();			}		}		return this;	}	@Override	public ApiClientBuilder inti() {		logger.info(":::::::::: Api Client -> init() ::::::::::");		httpClient.newBuilder().build();		request = new Request.Builder()				.url(this.url)				.build();		return this;	}	@Override	public ApiClientBuilder perform() {		logger.info(":::::::::: Api Client -> perform() ::::::::::");		try (Response response = httpClient.newCall(request).execute()) {			clientResponse = gistJsonAdapter.fromJson(Objects.requireNonNull(response.body()).source());		} catch (IOException e) {			e.printStackTrace();		}		return this;	}	@Override	public ApiClientResponse retrieve() {		logger.info(":::::::::: Api Client -> retrieve() ::::::::::");		return clientResponse;	}}