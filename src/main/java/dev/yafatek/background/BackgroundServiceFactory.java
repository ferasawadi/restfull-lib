package dev.yafatek.background;/** * interface to Create the End Point Objects * * @author Feras Emad Alawadi * * @email:ferasawady@gmail.com */public interface BackgroundServiceFactory {	/**	 * method to Create the Final Object of the implementation class witch extends {@code BackgroundService}	 *	 * @return Object of the Class that extends BackgroundService	 */	BackgroundService createServices();}