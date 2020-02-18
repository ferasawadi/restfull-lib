package dev.yafatek.annotations;import java.lang.annotation.Retention;import java.lang.annotation.Target;import static java.lang.annotation.ElementType.METHOD;import static java.lang.annotation.RetentionPolicy.RUNTIME;/** * Helper annotation to pass the Api parameters to the implementation at run time. * * @author Feras E Alawadi * @see dev.yafatek.networking.ApiClient */@Target(METHOD)@Retention(RUNTIME)public @interface ApiAttributes {	/**	 * Method to hold the api url sent by the user to the ApiService Object.	 * <p>	 * this method will call the api to make the call to the End point.	 *	 * @return String represents the api url.	 */	String url() default "http://localhost:8080/";}