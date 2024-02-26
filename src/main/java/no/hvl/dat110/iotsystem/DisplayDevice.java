package no.hvl.dat110.iotsystem;

import no.hvl.dat110.broker.ClientSession;
import no.hvl.dat110.broker.Storage;
import no.hvl.dat110.client.Client;
import no.hvl.dat110.messages.Message;
import no.hvl.dat110.messages.PublishMsg;
import no.hvl.dat110.common.TODO;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class DisplayDevice {
	
	private static final int COUNT = 10;
		
	public static void main (String[] args) {
		
		System.out.println("Display starting ...");
		
		// TODO - START
				
		// create a client object and use it to
		Client display = new Client("display",Common.BROKERHOST, Common.BROKERPORT);

		
		// - connect to the broker - use "display" as the username
		boolean connected = display.connect();


		if(connected) {
			// - create the temperature topic on the broker
			display.createTopic(Common.TEMPTOPIC);
			// - subscribe to the topic
			display.subscribe(Common.TEMPTOPIC);
			// - receive messages on the topic
			for(int i =0; i < COUNT; i++) {
				Message recievedM = display.receive();
			}

			display.unsubscribe(Common.TEMPTOPIC);

			display.disconnect();

		}
		// - unsubscribe from the topic
		// - disconnect from the broker
		
		// TODO - END
		
		System.out.println("Display stopping ... ");
		

	}
}
