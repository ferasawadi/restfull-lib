package dev.yafatek.microservices;import java.util.List;/** * Interface to Create a Microservice using the abstract Factory pattern. * * @param <T> * @author Feras Emad Alawadi * @email:ferasawady@gmail.com */public interface MicroService<T> {	/**	 * Perform a Get request  to get the Data from Microservice	 */	T getFromMicroService();	/**	 * get From MicroService With query params	 *	 * @param params query parameters	 * @return Object of the Microservice	 */	T getFromMicroService(Object params);	/**	 * Perform a Post request to  MicroService.	 *	 * @param params object Holds the Data to a MicroService	 * @return response	 */	T postToMicroService(Object params);	/**	 * Perform Post request with Object and receive List on the Same Object.	 *	 * @param param Object to Post to MicroService	 * @return List of Objects Type T	 */	List<T> postToMicroServiceRespToList(Object param);	/**	 * Perform Delete request for a specific resource.	 *	 * @param params {resourceId}	 * @return Object of response T	 */	T deleteFromMicroService(Object params);	/**	 * Perform Update request to update resource	 *	 * @param params {resourceId}	 * @return response Objct	 */	T updateInMicroService(Object params);}