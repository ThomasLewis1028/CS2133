/**
 * Thomas Lewis
 * Computer Science II - CS2133
 * Christopher Crick
 * Commands.java
 * 	Hold the commands to actually do things for the robot sim.
 */

public class Commands {
	String op = "publish";
	String topic;
	private Msg msg;

	public Commands(){
	}

	//Take in just the topic, used for takeoff and landing
	public Commands(String topic) {
		this.topic = topic;
	}

	//Take just the linear values and call the main constructor with an az of 0.0
	public Commands(double lx, double ly, double lz) {
		this(lx, ly, lz, 0.0);
	}

	//Take just the angular z and send 0.0 for the linear values
	public Commands(double az){
		this(0.0, 0.0, 0.0, az);
	}

	//Take all of the values passed in from the other constructors and set the messages and values.
	public Commands(double lx, double ly, double lz, double az) {
		this("/cmd_vel");
		this.setMsg(new Msg());
		this.getMsg().getLinear().setX(lx);
		this.getMsg().getLinear().setY(ly);
		this.getMsg().getLinear().setZ(lz);
		this.getMsg().getAngular().setZ(az);
	}

	public Msg getMsg() {
		return msg;
	}

	public void setMsg(Msg msg) {
		this.msg = msg;
	}

	class Msg {
		private Linear linear = new Linear();
		private Angular angular = new Angular();

		public Linear getLinear() {
			return linear;
		}

		public Angular getAngular() {
			return angular;
		}

		class Linear {
			double x = 0;
			double y = 0;
			double z = 0;

			public double getX() {
				return x;
			}

			public void setX(double x) {
				this.x = x;
			}

			public double getY() {
				return y;
			}

			public void setY(double y) {
				this.y = y;
			}

			public double getZ() {
				return z;
			}

			public void setZ(double z) {
				this.z = z;
			}
		}

		class Angular {
			double x = 0;
			double y = 0;
			double z = 0;

			public double getX() {
				return x;
			}

			public double getY() {
				return y;
			}

			public double getZ() {
				return z;
			}

			public void setZ(double z) {
				this.z = z;
			}
		}
	}

	//A custom version ot toString but titled in a way that made it clearer
	public String toJSON() {
		String jsonValue;
		if (getMsg() == null) {	//The command to send when not sending movements
			jsonValue = "{\"op\":\"" + op + "\",\"topic\":\"" + topic + "\",\"msg\":{" +
					"}}";
		} else {	//Movement commands
			jsonValue = "{\"op\":\"" + op + "\",\"topic\":\"" + topic + "\",\"msg\":{" +
					"\"linear\":{" +
					"\"x\":" + getMsg().getLinear().getX() +
					",\"y\":" + getMsg().getLinear().getY() +
					",\"z\":" + getMsg().getLinear().getZ() + "}," +
					"\"angular\":{" +
					"\"x\":" + getMsg().getAngular().getX() +
					",\"y\":" + getMsg().getAngular().getY() +
					",\"z\":" + getMsg().getAngular().getZ() + "}}}";
		}
		return jsonValue;
	}
}