package no.hvl.dat110.iotsystem;

import no.hvl.dat110.client.Client;
import no.hvl.dat110.common.TODO;

public class TemperatureDevice {

	private static final int COUNT = 10;

	public static void main(String[] args) {

		// simulated / virtual temperature sensor
		TemperatureSensor sn = new TemperatureSensor();

		// TODO - start

		// create a client object and use it to
		Client sensor = new Client("sensor",Common.BROKERHOST, Common.BROKERPORT);

		// - connect to the broker - user "sensor" as the user name
		boolean connected = sensor.connect();
		// - publish the temperature(s)

		if(connected){
			for (int i = 0; i < COUNT; i++){
				int temp = sn.read();
				sensor.publish(Common.TEMPTOPIC,String.valueOf(temp));

				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					System.err.println("Thread interrupted: " + e.getMessage());
				}
			}
			// - disconnect from the broker

			sensor.disconnect();

			System.out.println("Temperature device stopping ... ");


		} else {
			System.out.println("Temperature device stopping ... ");
		}

	}
}
