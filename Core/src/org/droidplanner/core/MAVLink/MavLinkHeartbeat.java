package org.droidplanner.core.MAVLink;

import org.droidplanner.core.drone.Drone;

import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.ardupilotmega.msg_heartbeat;
import com.MAVLink.Messages.enums.MAV_AUTOPILOT;
import com.MAVLink.Messages.enums.MAV_TYPE;

/**
 * This class contains logic used to send an heartbeat to a
 * {@link org.droidplanner.core.drone.Drone}.
 */
public class MavLinkHeartbeat {

	/**
	 * This is the msg heartbeat used to check the drone is present, and
	 * responding.
	 */
	private static final msg_heartbeat sMsg = new msg_heartbeat();
	static {
		sMsg.type = MAV_TYPE.MAV_TYPE_GCS;
		sMsg.autopilot = MAV_AUTOPILOT.MAV_AUTOPILOT_GENERIC;
	}

	/**
	 * This is the mavlink packet obtained from the msg heartbeat, and used for
	 * actual communication.
	 */
	private static final MAVLinkPacket sMsgPacket = sMsg.pack();

	/**
	 * Sends the heartbeat to the {@link org.droidplanner.core.drone.Drone}
	 * object.
	 * 
	 * @param drone
	 *            drone to send the heartbeat to
	 */
	public static void sendMavHeartbeat(Drone drone) {
		if (drone != null)
			drone.MavClient.sendMavPacket(sMsgPacket);
	}

}
